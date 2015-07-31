(function() {
	'use strict';
	angular.module('app.invoice').controller('InvoiceSubmitController',
			[ '$scope', '$resource', 'GrowlService', InvoiceSubmitController ]);

	function InvoiceSubmitController(scope, resource, growl) {
		var invoice = {};
		scope.items = [];
		scope.rclick = function() {
			alert('daddy');
		}
		scope.test = function() {
			alert('clicked');
		}
		scope.addItem = function() {
			if (scope.item) {
				scope.items.push(angular.copy(scope.item));
				scope.item = {};
			} else {
				growl.error({
					title : 'خطا',
					message : 'مشخصات کالا وارد نشده است.',
					location : 'tc',
					size : 'large'
				});
			}
		};
		scope.removeItem = function(item) {
			var index = scope.items.indexOf(item);
			scope.items.splice(index, 1);
		};

		scope.submit = function(isValid) {
			 if (isValid) {
			 invoice.date = angular.copy(scope.date);
			 invoice.milage = angular.copy(scope.milage);
			 invoice.title = angular.copy(scope.title);
			 invoice.tell = angular.copy(scope.tell);
			 invoice.address = angular.copy(scope.address);
			
			 invoice.items = angular.copy(scope.items);
			
			 resource('/invoice').save(invoice);
			 alert('با موفقیت ثبت شد');
			 } else {
			 growl.error({
			 title : 'خطا',
			 message : 'خطاهای کنترلی را رفع کنید',
			 location : 'tc',
			 size : 'large'
			 });
			 }
		}
	}
})();