(function() {
	'use strict'
	angular.module('app.payment').controller('PaymentPayController',
			[ 'Payments', '$scope', PaymentPayController ]);

	function PaymentPayController(Payments, scope) {
		scope.submit = function(isValid) {
			if (isValid) {
				Payments.save(scope.payment, onSuccess);
				scope.payment = {};
			} else {
				validationHasError();
				scope.submitted = true;
			}
		}
		scope.today = function(date) {
			date = "hamid";
		}
	}

	function onSuccess(data, responseHeader) {
		$.growl.notice({
			title : 'ثبت واریزی',
			message : 'واریزی مبلغ با شناسه' + data.id + 'با موفقیت انجام شد',
			location : 'tc'
		});
	}

	function validationHasError() {
		$.growl.error({
			title : 'خطا',
			message : 'خطاهای کنترلی را رفع کنید',
			location : 'tc',
			size : 'large'
		});
	}
})();