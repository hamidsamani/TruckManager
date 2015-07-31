(function() {
	'use strict'
	angular.module('app.invoice').controller('InvoiceReportController',
			[ '$scope', '$resource', function($scope, $resource) {
				$scope.search = function(invoice) {
					var term = {};
					term.id = invoice.id
					term.date = invoice.date;
					term.title = invoice.title;
					term.detail = invoice.detail;

					var Report = $resource('/invoice/search');
					Report.query(term, function(data) {
						$scope.test = data;
					}, function(error) {
						alert(angular.toJson(error.data.message));
					});

				}
			} ]);

})();