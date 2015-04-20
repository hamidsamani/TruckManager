(function() {
	'use strict';
	angular.module('truck-app',
			[ 'truck.static.content', 'ui.router', 'account' ]).config(
			function($stateProvider) {
				$stateProvider.state('home', {
					url : '',
					templateUrl : 'views/home.html',
				});
			});
})();
