(function() {
	'use strict';
	angular.module('app.payment').factory('Payments',
			['$resource', PaymentPayService ]);
	function PaymentPayService($resource) {
		return $resource('/payments');
	}
})();