'use strict';
angular.module(
		'truck-app',
		[ 'truck.static.content', 'truck.account.manager', 'ui.router',
				'account.report']).config(
		function($stateProvider) {
			$stateProvider.state('home', {
				url : '',
				templateUrl : 'views/home.html'
			})
		});