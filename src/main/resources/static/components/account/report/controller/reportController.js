(function() {
	'use strict';
	angular.module('account.report').controller('ReportAjaxController',
			reportAjaxController);

	function reportAjaxController(DTOptionsBuilder, DTColumnBuilder) {
		var vm = this;
		vm.dtOptions = DTOptionsBuilder.fromSource('/accounts').withLanguage({
			"sProcessing" : "درحال پردازش...",
			"sLengthMenu" : "نمایش محتویات _MENU_",
			"sZeroRecords" : "موردی یافت نشد",
			"sInfo" : "نمایش _START_ تا _END_ از مجموع _TOTAL_ مورد",
			"sInfoEmpty" : "تهی",
			"sInfoFiltered" : "(فیلتر شده از مجموع _MAX_ مورد)",
			"sInfoPostFix" : "",
			"sSearch" : "جستجو:",
			"sUrl" : "",
			"oPaginate" : {
				"sFirst" : "ابتدا",
				"sPrevious" : "قبلی",
				"sNext" : "بعدی",
				"sLast" : "انتها"
			}

		}).withDisplayLength(25);
		vm.dtColumns = [
				DTColumnBuilder.newColumn('type').withTitle('نوع'),
				DTColumnBuilder.newColumn('amount').withTitle('مبلغ'),
				DTColumnBuilder.newColumn('payer.name')
						.withTitle('واریز کننده') ];

	}

})();