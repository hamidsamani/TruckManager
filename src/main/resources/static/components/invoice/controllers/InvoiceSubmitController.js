(function() {
	'use strict';
	angular.module('app.invoice').controller('InvoiceSubmitController',
			[ '$scope', '$resource', InvoiceSubmitController ]);

	function InvoiceSubmitController(scope, resource) {
		var invoice = {};
		scope.items = [];

		scope.addItem = function() {
			scope.items.push(angular.copy(scope.item));
			scope.item = {};
		};
		scope.removeItem = function(item) {
			var index = scope.items.indexOf(item);
			scope.items.splice(index, 1);
		};

		scope.submit = function() {
			invoice.date = angular.copy(scope.date);
			invoice.milage = angular.copy(scope.milage);
			invoice.title = angular.copy(scope.title);
			invoice.tell = angular.copy(scope.tell);
			invoice.address = angular.copy(scope.address);

			invoice.items = angular.copy(scope.items);

			resource('/invoice').save(invoice);
			alert('با موفقیت ثبت شد');
		}
	}
})();