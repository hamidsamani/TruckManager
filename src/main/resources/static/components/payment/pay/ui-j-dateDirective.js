(function() {
	'use strict';
	angular.module('app.payment').directive('uiJDate', function() {
		return {
			require : 'ngModel',
			link : function(scope, element, attr, ngModel) {
				ngModel.$parsers.push(convertDate);
				return element.persianDatepicker();
			}
		}
	});
	function convertDate(date) {
		return moment(date, 'jYYYY/jMM/jDD').format();
	}
})();