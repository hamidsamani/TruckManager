(function() {
	'use strict';
	angular.module('app.invoice').controller('InvoiceController',
			function($scope) {
				var invoice = {};
				$scope.items = [];

				$scope.addItem = function() {
					$scope.items.push(angular.copy($scope.item));
					$scope.item = {};
				};
				$scope.removeItem = function(item) {
					var index = $scope.items.indexOf(item);
					$scope.items.splice(index, 1);
				};

				$scope.submit = function() {
					invoice.items = angular.copy($scope.items);
					invoice.milage = angular.copy($scope.milage);

					invoice.date = $scope.date;
					alert(angular.toJson(invoice));
				}
			});
})();