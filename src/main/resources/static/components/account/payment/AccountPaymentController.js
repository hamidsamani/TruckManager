'use strict';
angular.module('truck.account.manager', []).controller(
		'AccountPaymentController', function($scope, AccountPaymentService) {
			$scope.submit = function() {
				var data = {
					'amount' : $scope.account_amount,
					'payer' : $scope.account_payer,
					'type' : 'DEPOSIT',
					'date' : $scope.account_date,
					'recipient' : $scope.account_recipient
				};
				AccountPaymentService.savePayment(data).success(function(data) {
					hideDialog();
					showSuccessGrowl(data);
					resetForm($scope);
				});
			}
			$scope.cancel = function() {
				hideDialog();
				resetForm($scope);
			}
		});
function hideDialog() {
	$('#payment').dialog('close');
}
function showSuccessGrowl(data) {
	$.growl.notice({
		location : 'tc',
		title : 'واریزی به کارت خودرو',
		message : data.amount
	});
}
function resetForm(form) {
	form.account_amount = '';
	form.account_payer = '';
	form.account_date = '';
	form.account_recipient = '';
}