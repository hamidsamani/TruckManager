(function() {
	'use strict';
	angular.module('account.report').config(configureRouters);
	function configureRouters($stateProvider) {
		$stateProvider.state('report', {
			url : '/report',
			templateUrl : 'views/account-report.html'
		});
	}

})();