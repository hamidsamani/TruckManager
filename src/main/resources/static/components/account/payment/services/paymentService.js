(function() {
	'use strict';
	angular.module('account').service('PaymentService', function($http) {
		this.savePayment = function(data) {
			return $http.post('/accounts', data);
		};
	});
})();