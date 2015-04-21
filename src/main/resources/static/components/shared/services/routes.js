(function() {
	'use strict';
	angular
			.module('app.shared')
			.config(
					function($stateProvider) {
						$stateProvider

								.state('home', {
									url : '',
									templateUrl : 'views/home.html',
								})

								.state(
										'payment',
										{
											url : '/payments/pay',
											templateUrl : 'components/payment/pay/views/payment.html'
										})
								.state(
										'payment-report',
										{
											url : '/payments/report',
											templateUrl : 'components/payment/report/views/report.html'
										})
								.state(
										'report',
										{
											url : '/report',
											templateUrl : 'components/account/report/views/account-report.html'
										})
								.state(
										'pay',
										{
											url : '/payment',
											templateUrl : 'components/account/payment/views/account-payment.html'
										});
					});
})();
