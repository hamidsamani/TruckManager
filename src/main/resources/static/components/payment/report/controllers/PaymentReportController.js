(function() {
	'use strict';
	angular.module('app.payment').controller('PaymentReportController',
			PaymentReportController);

	function PaymentReportController(DTOptionsBuilder, DTColumnBuilder) {
		var vm = this;
		vm.dtOptions = DTOptionsBuilder.fromSource('/payments').withLanguage({
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
				DTColumnBuilder.newColumn('id').withTitle('شناسه').notVisible(),
				DTColumnBuilder.newColumn('createdDate').withTitle('تاریخ ثبت')
						.renderWith(
								function(data, type, row) {

									if (data !== null) {
										return moment(data,
												'YYYY/MM/DD HH:mm:ss').format(
												'jYYYY/jMM/jDD');
									}
									return data;
								}),
				DTColumnBuilder.newColumn('date').withTitle('تاریخ واریزی')
						.renderWith(
								function(data, type, row) {

									if (data !== null) {
										return moment(data,
												'YYYY/MM/DD HH:mm:ss').format(
												'jYYYY/jMM/jDD');
									}
									return data;
								}),
				DTColumnBuilder.newColumn('amount').withTitle('مبلغ'),
				DTColumnBuilder.newColumn('title').withTitle('عنوان').notSortable(),
				DTColumnBuilder.newColumn('payer.name').withTitle(
						'پرداخت کننده').notSortable(),
				DTColumnBuilder.newColumn('recipient.name').withTitle('گیرنده')
						.notSortable(),
				DTColumnBuilder.newColumn('description').withTitle('ملاحضات')
						.notSortable() ];

	}

})();