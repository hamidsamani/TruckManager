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
										'selectReport',
										{
											url : '/payments/select-report',
											templateUrl : 'components/payment/report/views/select-report.html'
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
										})
								.state(
										'invoice-register',
										{
											url : '/invoice/register',
											templateUrl : 'components/invoice/views/invoice.html'
										})
								.state(
										'invoice-report-search',
										{
											url : '/invoice/report/search',
											templateUrl : 'components/invoice/views/invoice-report-search.html'
										});
					});
})();
