(function() {
	'use strict';

	angular.module('app.shared').filter('toShDate', function() {
		return function(input) {
			return moment(input).format('jYYYY/jMM/jDD');
		}
	})

})();