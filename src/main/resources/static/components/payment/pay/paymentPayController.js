(function() {
	'use strict'
	angular.module('app.payment').controller('PaymentPayController',
			[ 'Payments', '$state', '$scope', PaymentPayController ]);

	function PaymentPayController(Payments, $state, $scope) {
		$scope.submit = function(isValid) {
			if (isValid) {
				Payments.save($scope.payment);
				$scope.payment = {};
			} else {
				$scope.submitted = true;
			}
		}
		$scope.cancel = function() {
			$state.go('home');
		}
	}
})();