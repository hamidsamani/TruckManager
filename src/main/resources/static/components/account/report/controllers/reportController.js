(function() {
	'use strict';
	angular.module('app.account').controller('ReportController', ReportController);

	function ReportController(DTOptionsBuilder, DTColumnBuilder) {
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
				DTColumnBuilder.newColumn('id').withTitle('شناسه'),
				DTColumnBuilder.newColumn('type').withTitle('نوع').renderWith(
						function(data, type, row) {
							if (data === 'DEPOSIT')
								return 'واریزی';
							if (data === 'WITHDRAW')
								return 'برداشت';
							return data;

						}),
				DTColumnBuilder.newColumn('amount').withTitle('مبلغ'),
				DTColumnBuilder.newColumn('payer.name')
						.withTitle('واریز کننده'),
				DTColumnBuilder.newColumn('createdDate').withTitle('تاریخ')
						.renderWith(
								function(data, type, row) {
									// 
									if (data !== null) {
										return moment(data,
												'YYYY/MM/DD HH:mm:ss').format(
												'jYYYY/jMM/jDD HH:mm:ss');
									}
									return data;
								}) ];

	}

})();