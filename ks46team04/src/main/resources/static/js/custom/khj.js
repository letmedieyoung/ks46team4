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
					html += `	<td><input type="checkbox" name="chk" class="chk" onclick="chkClicked()" ></td>`;
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
   	
  	
/* 체크박스 전체 선택 클릭 이벤트 */
function allChecked(target){
    //전체 체크박스 버튼
    const checkbox = document.getElementById('allCheckBox');
    //전체 체크박스 버튼 체크 여부
    const is_checked = checkbox.checked;
    //전체 체크박스 제외한 모든 체크박스
    if(is_checked){
    	//체크박스 전체 체크
        chkAllChecked()
    } else {
	     //체크박스 전체 해제
	    chkAllUnChecked()
    }
}
    
      
//자식 체크박스 클릭 이벤트
function chkClicked(){

    //체크박스 전체개수
    const allCount = document.querySelectorAll(".chk").length;

    //체크된 체크박스 전체개수
    const query = 'input[name="chk"]:checked'
    const selectedElements = document.querySelectorAll(query)
    const selectedElementsCnt = selectedElements.length;

    //체크박스 전체개수와 체크된 체크박스 전체개수가 같으면 전체 체크박스 체크
    if(allCount == selectedElementsCnt){
         document.getElementById('allCheckBox').checked = true;
    }

    //같지않으면 전체 체크박스 해제
    else{
        document.getElementById('allCheckBox').checked = false;
    }
}


//체크박스 전체 체크
function chkAllChecked(){
    document.querySelectorAll(".chk").forEach(function(v, i) {
        v.checked = true;
    });
}

//체크박스 전체 체크 해제
function chkAllUnChecked(){
    document.querySelectorAll(".chk").forEach(function(v, i) {
        v.checked = false;
    });
}


/* 펀딩 삭제 */
function fDeleteBtn() {
  // 체크된 체크박스 가져오기
  var checkboxes = document.getElementsByClassName("chk");
  var checkedRows = [];
  for (var i = 0; i < checkboxes.length; i++) {
    if (checkboxes[i].checked) {
      checkedRows.push(checkboxes[i].parentNode.parentNode);
    }
  }
  // 체크된 행 삭제하기
  for (var i = 0; i < checkedRows.length; i++) {
    checkedRows[i].parentNode.removeChild(checkedRows[i]);
  }
}


/* 펀딩 등록 */		
$('#fregistBtn').click(function(){ 
	let isSubmit = true; 		
	if(isSubmit) $('#registFundingForm').submit(); 		
});

	
/* 기간 조회 */
function addDateListeners() {
  const todayBtn = document.getElementById('todayBtn');
  const monthBtn = document.getElementById('monthBtn');
  const threeMonthBtn = document.getElementById('threeMonthBtn');
  const startDateInput = document.getElementById('startDateInput');
  const endDateInput = document.getElementById('endDateInput');

  todayBtn.addEventListener('click', () => {
    setDateInputs(new Date(), new Date());    
  });

  monthBtn.addEventListener('click', () => {
    const today = new Date();
    const oneMonthLater = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
    setDateInputs(today, oneMonthLater);
  });

  threeMonthBtn.addEventListener('click', () => {
    const today = new Date();
    const threeMonthsLater = new Date(today.getFullYear(), today.getMonth() + 3, today.getDate());
    setDateInputs(today, threeMonthsLater);
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

addDateListeners();