(function() {
	'use strict';
	angular.module('account').config(configureRouters);
	function configureRouters($stateProvider) {
		$stateProvider
				.state(
						'report',
						{
							url : '/report',
							templateUrl : 'components/account/report/views/account-report.html'
						})
				.state(
						'payment',
						{
							url : '/payment',
							templateUrl : 'components/account/payment/views/account-payment.html'

						});
	}

})();