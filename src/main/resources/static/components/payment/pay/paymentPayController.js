(function() {
	'use strict'
	angular.module('app.payment').controller('PaymentPayController',
			[ 'Payments', '$state', '$scope', PaymentPayController ]);

	function PaymentPayController(Payments, $state, $scope) {
		$scope.submit = function(isValid) {
			if (isValid) {
				Payments.save($scope.payment);
				$.growl.notice({
					title : 'واریزی مبلغ',
					message : JSON.stringify($scope.payment)
				});
				$scope.payment = {};
			} else {
				$.growl.error({
					title : 'خطا',
					message : 'خطاهای کنترلی را رفع کنید'
				});
				$scope.submitted = true;
			}
		}
		$scope.cancel = function() {
			$state.go('home');
		}
	}
})();