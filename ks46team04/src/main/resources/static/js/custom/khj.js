/* 취소 버튼 */ 
$(document).ready(function() {
  $('.cancelBtn').click(function() {
    window.history.back();
  });
});


/* 수정버튼 */
$('#modifyBtn').click(function(){
	preventDefault();
	$("#modifyFundingForm").submit();
});

/* 확인버튼 */ 
$(document).ready(function() {
  $('#confirmBtn').click(function() {
    location.href='/admin/funding/payments'
  });
});

/* 검색 결과 초기화 */
$("#searchReset").click(function(){	
	location.reload();
});


/* manage 페이지 검색 기능 */
function doSearchFunding(){	
	alert("검색 결과를 조회합니다.");
	
	const searchInfo = {}; // 비어 있는 객체 searchInfo 선언 
	// 1. 검색 조건
	const search1 = $('select[name="filter"]').val(); //jQuery를 사용. name="keyword"인 셀렉트 요소의 값을 반환해, "search1"에 대입한다.
	searchInfo[search1] = $('input[name="keyword"]').val();	//input 요소의 값을 searchInfo객체의 search1프로퍼티에 대입
	// 2. 검색 조건
	const search2 = $('select[name="searchDateCate"]').val();
	searchInfo[search2] = $(`input[name="${search2}"]`).val();
	// 3. 검색조건
	const $searchCheck = $('form[name="fdSearchForm"] input:checked'); //form 요소에서 checked 상태인 모든 input 요소를 선택해 변수 $searchCheck에 대입. 
	let cheackKey = $searchCheck.attr('name');
	let cheackValue = $searchCheck.val();
	searchInfo[cheackKey] = cheackValue;
	
	console.table(JSON.stringify(searchInfo));
	
	$.ajax({
		type: 'post',
		url : "/funding/getSearchFundingList",
	    contentType: "application/json;charset=UTF-8",
		data : JSON.stringify(searchInfo),
		dataType : "json",
		success:function(data){
			const dataTableTbody = $('#dataTable tbody');
			dataTableTbody.html('');
			let html = '';
			if(data != null){
				const searchList = data;
				for(const searchInfo of searchList){
					html += '<tr>';
					html += `	<td><input type="radio" name="chk" class="chk"></td>`;
					html += '	<td><a href="/funding/modifyFunding?fundingCode=' + searchInfo.fundingCode + '">' + searchInfo.fundingCode + '</a></td>';
					html += `	<td>${searchInfo.fundingName}</td>`;
					html += `	<td>${searchInfo.fundingFoundation}</td>`;
					html += `	<td>${searchInfo.goodsCode}</td>`;
					html += `	<td>${searchInfo.fundingGoalAmount}</td>`;
					html += `	<td>${searchInfo.fundingStartDate}</td>`;
					html += `	<td>${searchInfo.fundingEndDate}</td>`;
					html += `	<td>${searchInfo.fundingProgress}</td>`;
					html += '</tr>';					
				}
			}else{
				html = '<tr><td colspan="9">검색내용이 없습니다.</td></tr>'
			}
			dataTableTbody.html(html);
			$('#dataTable').DataTable();
		},
		error :function(){
			console.log("실패함");
		}
	});	
}
   	
  	
/**
 * 체크박스 전체 선택
 */
$('#allCheck').click(function () {
	$('.chk').prop('checked', $(this).prop('checked'));
});
$('.chk').click(function () {
	let length = $('.chk').length;
	let checkedLength = $('.chk:checked').length;
	if (length == checkedLength) {
		$('#allCheck').prop('checked', true);
	} else {
		$('#allCheck').prop('checked', false);
	}
});




/* 펀딩 등록 */		
$('#fregistBtn').click(function(){ 
	let isSubmit = true; 		
	if(isSubmit) $('#registFundingForm').submit(); 		
});

/* 기간 설정 버튼, 클릭 버튼 컬러 활성화*/
function addDateListeners() {
  const todayBtn = document.getElementById('todayBtn');
  const monthBtn = document.getElementById('monthBtn');
  const threeMonthBtn = document.getElementById('threeMonthBtn');
  const startDateInput = document.getElementById('startDateInput');
  const endDateInput = document.getElementById('endDateInput');

  todayBtn.addEventListener('click', () => {
    setDateInputs(new Date(), new Date());
    setActiveBtn(todayBtn);
  });

  monthBtn.addEventListener('click', () => {
    const today = new Date();
    const oneMonthLater = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
    setDateInputs(today, oneMonthLater);
    setActiveBtn(monthBtn);
  });

  threeMonthBtn.addEventListener('click', () => {
    const today = new Date();
    const threeMonthsLater = new Date(today.getFullYear(), today.getMonth() + 3, today.getDate());
    setDateInputs(today, threeMonthsLater);
    setActiveBtn(threeMonthBtn);
  });

  function setDateInputs(startDate, endDate) {
    startDateInput.value = formatDate(startDate);
    if (endDate) {
      endDateInput.value = formatDate(endDate);
    } else {
      endDateInput.value = '';
    }
  }

  function formatDate(date) {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }
}

function handleClick(event) {
  setActiveBtn(event.target);
  addDateListeners()[event.target.id].click();
}

function setActiveBtn(btn) {
	const activeBtn = document.querySelector('.btn.active');
	if (activeBtn) {
		activeBtn.classList.remove('active');
	}
	btn.classList.add('active');
}

addDateListeners();

const todayBtn = document.getElementById('todayBtn');
const monthBtn = document.getElementById('monthBtn');
const threeMonthBtn = document.getElementById('threeMonthBtn');

todayBtn.addEventListener('click', handleClick);
monthBtn.addEventListener('click', handleClick);
threeMonthBtn.addEventListener('click', handleClick);



/**
*클릭 버튼 컬러 변경
*/
const agendaButtons = document.querySelectorAll('.agenda');

function handleClick(event) {
  console.log(event.target);
  console.log(event.target.classList);

  const clickedClass = 'btn-success';

  if (event.target.classList.contains(clickedClass)) {
    event.target.classList.remove(clickedClass);
  } else {
    for (let i = 0; i < agendaButtons.length; i++) {
      agendaButtons[i].classList.remove(clickedClass);
    }
    event.target.classList.add(clickedClass);
  }
}
function init() {
  for (let i = 0; i < agendaButtons.length; i++) {
    agendaButtons[i].addEventListener('click', handleClick);
  }
}
init();