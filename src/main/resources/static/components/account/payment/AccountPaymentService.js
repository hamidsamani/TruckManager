'use strict';
angular.module('truck.account.manager').service('AccountPaymentService',
		function($http) {
			this.savePayment = function(data) {
				return $http.post('/accounts', data);
			};
		});