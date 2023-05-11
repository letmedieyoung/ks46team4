/**
 * returnBtn 뒤로가기 버튼
 */
$(function() {
	$('#returnBtn').click(function(){
		 history.go(-1);
	});
});

/** 
 * dataTable 기능 숨기기
*/
$(".dataTable").DataTable({
	// 표시 건수기능 숨기기
    lengthChange: false,
 	// 정보 표시 숨기기
    info: false,
	// 검색 기능 숨기기
    searching: false,
    // 정렬 기능 숨기기
    ordering: false,
    // 가로 스크롤바
	scrollX: true
});

/**
 * 기간 검색 오늘, 일주일, 1개월 버튼
 */
$(function() {
	 let today = moment();
	 let resetDate = '2023-01-01';
	 
	 function setDateRange(startDate, endDate) {
		 $('#daterange').data('daterangepicker').setStartDate(startDate);
		 $('#daterange').data('daterangepicker').setEndDate(endDate);
	 }
 
	 $('#todayBtn').on('click', function() {
	 	setDateRange(today, today);
	 });
 
	 $('#oneweekBtn').on('click', function() {
	 	setDateRange(today.clone().subtract(1, 'week'), today);
	 });
  
	 $('#oneMonthBtn').on('click', function() {
		setDateRange(today.clone().subtract(1, 'month'), today);
	 });
	 
	 $('#allDateBtn').on('click', function() {
		setDateRange(resetDate, today);
	 });
  
	/**
	* 기간 조회 daterangepicker
	*/
	$('#daterange').daterangepicker({
		locale: {
			"separator": " ~ ",                     // 시작일시와 종료일시 구분자
	        "format": 'YYYY-MM-DD',                 // 일시 노출 포맷
	        "applyLabel": "확인",                    // 확인 버튼 텍스트
	        "cancelLabel": "취소",                   // 취소 버튼 텍스트
	        "daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
	        "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
		},
		applyClass: 'btn-primary btn-sm',
	    cancelClass: 'btn-secondary btn-sm',
	    
	});
	
	$('#daterange').data('daterangepicker').setStartDate(moment(resetDate));
	$('#daterange').data('daterangepicker').setEndDate(moment(today));
});

/**
 * 숫자 3자리마다 콤마 표현
 */
function formatInteger(value, length, separator) {
    value = String(value);
    var reg = new RegExp(`\\B(?=(\\d{${length}})+(?!\\d))`, 'g');
    return value.replace(reg, separator);
}
