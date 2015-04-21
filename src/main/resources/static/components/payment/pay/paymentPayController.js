(function() {
	'use strict'
	angular.module('app.payment').controller('PaymentPayController',
			[ 'Payments', '$state', '$scope', PaymentPayController ]);

	function PaymentPayController(Payments, $state, $scope) {
		$scope.submit = function(isValid) {
			alert(JSON.stringify($scope.payment));
			if (isValid) {
				Payments.save($scope.payment);
			}
		}
		$scope.cancel = function() {
			$state.go('home');
		}
	}
})();