(function () {
	new Vue({
		el: "#app",
		data: {
			instanceId: "",
			installId: "",
			loading: false,
			success: false,
			form: {
				eventType: "",
				eventId: ""
			},
			validation: {
				eventType: null,
				eventId: null
			}
		},
		methods: {
			save: function () {
				this.resetValidationStatus();
				if (!this.isFormValid()) {
					return;
				}
				this.loading = true;
				axios.post("save", JSON.stringify(this.form), {
						params: {
							InstanceId: this.instanceId,
							InstallId: this.installId
						},
						headers: {
							"Content-Type": "application/json"
						}
					})
					.then((response) => {
						if (response.data === "Valid") {
							this.success = true;
							this.validation.eventId = null;
							window.setTimeout(() => {
								this.success = false;
							}, 3000);
						} else {
							this.validation.eventId = false;
						}
						this.loading = false;
					})
					.catch(() => {
						this.loading = false;
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
				return noErrors;
			},
			resetValidationStatus: function () {
				this.validation.eventType = null;
				this.validation.eventId = null;
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
			this.instanceId = getParameterByName("instanceId");
			this.installId = getParameterByName("installId");
			this.loading = true;
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
					this.loading = false;
				})
				.catch(() => {
					this.loading = false;
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
})();