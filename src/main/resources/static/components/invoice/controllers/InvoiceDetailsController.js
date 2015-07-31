(function() {
	'use strict';
	angular.module('app.invoice').controller('InvoiceDetailsController',
			[ '$scope', '$resource', InvoiceDetailsController ]);

	function InvoiceDetailsController(scope, resource) {
		var invoice = resource('/invoice/id/:id');
		invoice.get({
			id : scope.id
		}, function(value) {
			scope.invoice = value;
		});

	}

})();