(function() {
	'use strict';
	angular.module('app.account').service('PaymentService', function($http) {
		this.savePayment = function(data) {
			return $http.post('/accounts', data);
		};
	});
})();