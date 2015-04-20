(function() {
	'use strict';
	angular.module('account').controller(
			'PaymentController',
			function($scope, $state, PaymentService) {
				$scope.cancel = function(data) {
					$scope.account = {};
					$state.go("home");
				}
				$scope.save = function(data) {
					if (data) {
						PaymentService.savePayment(data).success(
								function(data) {
									showSuccessGrowl(data);
									$scope.account = {};
								}).error(function(data) {
							alert(data);
						});
					}
				}
			});
	function showSuccessGrowl(data) {
		$.growl.notice({
			location : 'tc',
			title : 'واریزی به کارت خودرو',
			message : data.amount
		});
	}
})();