(function() {
	'use strict';
	angular.module('app.payment').controller(
			'DateController',
			function($scope, DTOptionsBuilder) {
				DTOptionsBuilder.fromSource()
				$scope.today = moment().format('jYYYY/jMM/jDD');
				$scope.sub_one_month = moment().subtract(30, 'days').format(
						'jYYYY/jMM/jDD');
			})
})();