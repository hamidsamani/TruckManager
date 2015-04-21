(function() {
	angular.module('app.shared', [ 'ui.router' ]).directive('jqCarousel',
			function() {
				return {
					restrict : 'A',
					link : function(scope, element, attr) {
						$(element).carousel({
							interval : 3000
						});
					}
				}
			})
})();