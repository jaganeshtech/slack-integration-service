(function () {
	new Vue({
		el: "#app",
		data: {
			loading: false,
			success: false,
			failure: false,
			installId: "",
			userId: "",
			userName: "",
			callbackUrl: "",
			form: {
				clientId: "",
				clientSecret: ""
			},
			validation: {
				clientId: null,
				clientSecret: null
			}
		},
		methods: {
			save: function () {
				this.resetValidationStatus();
				if (!this.isFormValid()) {
					return;
				}
				this.loading = true;
				axios.post("save", JSON.stringify({
							name: "Default",
							clientId: this.form.clientId,
							clientSecret: this.form.clientSecret,
							userId: this.userId,
							userName: this.userName,
							installId: this.installId,
						}), {
							headers: {
								"Content-Type": "application/json"
							}
						})
						.then((response) => {
							var popup = openPopup({
								url: "../../oauth/authorize",
								title: "Zoom OAuth Login",
								w: 800,
								h: 600
							});
							var timer = setInterval(() => {
								if (popup.closed) {
									clearInterval(timer);
									this.loading = false;
									this.verifyCredential();
								}
							}, 1000);
						})
						.catch(() => {
							this.loading = false;
							this.failure = true;
							window.setTimeout(() => {
								this.failure = false;
							}, 10000);
						});
			},
			isFormValid: function () {
				var noErrors = true;
				if (!this.form.clientId) {
					this.validation.clientId = false;
					noErrors = false;
				}
				if (!this.form.clientSecret) {
					this.validation.clientSecret = false;
					noErrors = false;
				}
				return noErrors;
			},
			resetValidationStatus: function () {
				this.validation.clientId = null;
				this.validation.clientSecret = null;
			},
			verifyCredential: function () {
				this.loading = true;
				axios.get("getConfiguration")
						.then((response) => {
							if (response.data && response.data.refreshToken) {
								this.success = true;
								window.setTimeout(() => {
									this.success = false;
									if (this.callbackUrl) {
										window.location.href = this.callbackUrl;
									}
								}, 4000);

							} else {
								this.failure = true;
								window.setTimeout(() => {
									this.failure = false;
								}, 10000);
							}
							this.loading = false;
						})
						.catch(() => {
							this.loading = false;
						});
			}
		},
		mounted: function () {
			this.loading = true;
			this.installId = getParameterByName("InstallId");
			this.userId = getParameterByName("UserId");
			this.userName = getParameterByName(("UserName"));
			this.callbackUrl = getParameterByName("CallbackUrl");
			axios.get("getConfiguration")
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

	function openPopup( {url, title, w, h}) {
		// Fixes dual-screen position                         Most browsers      Firefox  
		var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
		var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;

		width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
		height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

		var left = ((width / 2) - (w / 2)) + dualScreenLeft;
		var top = ((height / 2) - (h / 2)) + dualScreenTop;
		var newWindow = window.open(url, title, `width=${w}, height=${h}, top=${top}, left=${left}`);

		// Puts focus on the newWindow  
		if (window.focus) {
			newWindow.focus();
		}
		return newWindow;
	}
})();