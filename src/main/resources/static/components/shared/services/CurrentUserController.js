(function() {
	'user strict';
	angular.module('app.shared').controller('CurrentUserController',
			[ '$scope', '$resource', CurrentUserController ]);

	function CurrentUserController(scope, resource) {
		var User = resource('/security/current');
		scope.username = User.get();

	}

})();