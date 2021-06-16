(function () {
	VueSelect.VueSelect.props.components.default = () => ({
		OpenIndicator: {
			render: createElement => createElement("b-icon-caret-down-fill"),
		},
	});

	Vue.component('v-select', VueSelect.VueSelect);

	new Vue({
		el: "#app",
		data: {
			instanceId: "",
			installId: "",
			eventId: "",
			loading: 0,
			success: false,
			form: {
				eventType: "",
				eventId: "",
				fieldMappings: [{
					zoom: {
						name: "Email",
						internalName: "user_email",
						valid: null
					},
					eloqua: {
						name: "Email Address",
						internalName: "C_EmailAddress",
						valid: null
					}
				}],
				syncConfiguration: {
					frequency: "",
					startDate: "",
					startTime: "",
					endDate: "",
					endTime: "",
					timeZone: ""
				}
			},
			validation: {
				eventType: null,
				eventId: null,
				fieldMappings: null,
				syncConfiguration: {
					frequency: null,
					startDate: null,
					startTime: null,
					endDate: null,
					endTime: null,
					timeZone: null
				}
			},
			lists: {
				eloquaFields: [],
				zoomFields: [],
				syncFrequencies: [],
				timeZones: []
			}
		},
		computed: {
			filteredZoomFields() {
				return this.lists.zoomFields.filter((field) => {
					return this.form.fieldMappings.findIndex((mapping) => {
						return mapping.zoom.internalName === field.internalName;
					}) === -1;
				});
			},
			showSyncEndDateTime() {
				return this.form.syncConfiguration.frequency && this.form.syncConfiguration.frequency !== "once";
			},
			showAddMappingLink() {
				return this.form.fieldMappings.length < this.lists.zoomFields.length;
			},
			minSyncDate() {
				var now = new Date();
				return new Date(now.getFullYear(), now.getMonth(), now.getDate());
			}
		},
		methods: {
			addMapping() {
				this.form.fieldMappings.push({
					zoom: {
						name: "",
						internalName: "",
						valid: null
					},
					eloqua: {
						name: "",
						internalName: "",
						valid: null
					}
				});
			},
			deleteMapping: function (index) {
				this.form.fieldMappings.splice(index, 1);
			},
			save: function () {
				this.resetValidationStatus();
				if (!this.isFormValid()) {
					return;
				}
				axios.post("save", JSON.stringify(this.form),{
						params: {
							Type: this.form.eventType,
							Id: this.form.eventId,
							InstanceId: this.instanceId,
							InstallId: this.installId
						},
						headers: {
							'Content-Type': 'application/json'
						}
					})
					.then((response) => {
						if (response.data === "Valid") {
							this.success = true;
							this.resetValidationStatus();
							window.setTimeout(() => {
								this.success = false;
							}, 3000);
						} else {
							this.validation.eventId = false;
						}
					})
					.catch(() => {
						this.validation.eventId = false;
					});
			},
			isFormValid: function () {
				var noErrors = true;
				if (!this.form.eventType) {
					this.validation.eventType = false;
					noErrors = false;
				}
				if (!this.form.eventId) {
					this.validation.eventId = false;
					noErrors = false;
				}
				if (this.form.fieldMappings.length === 0) {
					this.validation.fieldMappings = false;
					noErrors = false;
				}
				this.form.fieldMappings.forEach((mapping) => {
					if (!mapping.zoom.internalName) {
						mapping.zoom.valid = false;
						noErrors = false;
					}
					if (!mapping.eloqua.internalName) {
						mapping.eloqua.valid = false;
						noErrors = false;
					}
				});
				if (!this.form.syncConfiguration.frequency) {
					this.validation.syncConfiguration.frequency = false;
					noErrors = false;
				}
				if (!this.form.syncConfiguration.startDate) {
					this.validation.syncConfiguration.startDate = false;
					noErrors = false;
				}
				if (!this.form.syncConfiguration.startTime) {
					this.validation.syncConfiguration.startTime = false;
					noErrors = false;
				}
				if (this.showSyncEndDateTime && !this.form.syncConfiguration.endDate) {
					this.validation.syncConfiguration.endDate = false;
					noErrors = false;
				}
				if (this.showSyncEndDateTime && !this.form.syncConfiguration.endTime) {
					this.validation.syncConfiguration.endTime = false;
					noErrors = false;
				}
				if (!this.form.syncConfiguration.timeZone) {
					this.validation.syncConfiguration.timeZone = false;
					noErrors = false;
				}
				return noErrors;
			},
			resetValidationStatus: function () {
				this.validation.eventType = null;
				this.validation.eventId = null;
				this.validation.fieldMappings = null;
				this.form.fieldMappings.forEach((mapping) => {
					mapping.zoom.valid = null;
					mapping.eloqua.valid = null;
				});
				this.validation.syncConfiguration.frequency = null;
				this.validation.syncConfiguration.startDate = null;
				this.validation.syncConfiguration.startTime = null;
				this.validation.syncConfiguration.endDate = null;
				this.validation.syncConfiguration.endTime = null;
				this.validation.syncConfiguration.timeZone = null;
			}
		},
		directives: {
			numeric: (element) => {
				var event = new Event("input", {
					bubbles: true
				});
				element.value = element.value.replace(/[^\d]+/g, '');
				element.dispatchEvent(event);
			}
		},
		mounted: function () {
			axios.interceptors.request.use((config) => {
				this.loading = this.loading + 1;
				return config;
			}, (error) => {
				this.loading = this.loading - 1;
				return Promise.reject(error);
			});
			axios.interceptors.response.use((response) => {
				this.loading = this.loading - 1;
				return response;
			}, (error) => {
				this.loading = this.loading - 1;
				return Promise.reject(error);
			})

			this.instanceId = getParameterByName("instanceId");
			this.installId = getParameterByName("installId");
			axios.get("getConfiguration", {
					params: {
						InstanceId: this.instanceId,
						InstallId: this.installId
					}
				})
				.then((response) => {
					if (response.data) {
						this.form = response.data;
					}
				});
			axios.get("getContactFields")
				.then((response) => {
					this.lists.eloquaFields = response.data.elements
						.filter(el => el.isReadOnly === "false")	
						.sort((e1, e2) => sort(e1.name, e2.name));
				});
			axios.get("getZoomFields")
				.then((response) => {
					this.lists.zoomFields = response.data.elements.sort((e1, e2) => sort(e1.label, e2.label));
				});
			axios.get("/zoomIntegrationService/feeder/resources/syncFrequencies.json")
				.then((response) => {
					this.lists.syncFrequencies = response.data.elements;
				});
			axios.get("/zoomIntegrationService/feeder/resources/timeZones.json")
				.then((response) => {
					this.lists.timeZones = response.data.elements;
				});
		}
	});

	function getParameterByName(name, purl) {
		var url = purl || window.location.href;
		var regex = new RegExp(`[?&]${name.replace(/[[\]]/g, "\\$&")}(=([^&#]*)|&|#|$)`, "i");
		var results = regex.exec(url);

		if (!results || !results[2]) {
			return "";
		}
		return decodeURIComponent(results[2].replace(/\+/g, " "));
	}

	function sort(e1, e2) {
		if (e1 < e2) {
			return -1;
		}
		if (e1 > e2) {
			return 1;
		}
		return 0;
	}
})();