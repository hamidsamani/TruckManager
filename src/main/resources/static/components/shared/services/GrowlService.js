(function() {
	'use strict';
	angular.module('app.shared').factory('GrowlService', GrowlService);
	function GrowlService() {
		return $.growl;
	}

})();