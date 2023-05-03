/**
 * returnBtn 뒤로가기 버튼
 */
$('#returnBtn').click(function(){
	 history.go(-1);
});

/**
 * 세션에서 id값 가져오기
 */

/**
 * 기간 조회

$(function() {
  $('.datepicker').datepicker({dateFormat: 'yy-mm-dd'});
})

// 날짜 포맷("yyyy-MM-dd") 형식으로 반환
dateFormatter = function(newDay, today) {
  let year = newDay.getFullYear()
  let month = newDay.getMonth()+1
  let date = newDay.getDate()

  // 기존 날짜와 새로운 날짜가 다를 경우 
  if(today) {
    let todayDate = today.getDate()

    if(date != todayDate) {
      if(month == 0) year-=1
      month = (month + 11) % 12
      date = new Date(year, month, 0).getDate()	// 해당 달의 마지막 날짜를 반환
    }
  }

  month = ("0"+month).slice(-2)
  date = ("0"+date).slice(-2)

  return year+"-"+month+"-"+date
}

document.getElementsByName("filterDate").forEach(e=> {
  e.addEventListener('click', function() {  
	
  let endDate = new Date($("#endDate").val())
  let newDate = new Date($("#endDate").val())

  switch(this.value) {
      case '1':
        console.log("일주일")
        newDate.setDate(newDate.getDate())
        newDate = dateFormatter(newDate)
        break;
      case '2':
        newDate.setMonth(newDate.getMonth() - 1)
        newDate = dateFormatter(newDate, endDate)
        console.log("1개월")
        break;
      case '3':
        newDate.setFullYear(newDate.getFullYear() - 1)
        newDate = dateFormatter(newDate, endDate)
        console.log("1년")
        break;
      case '4':
        newDate.setFullYear(newDate.getFullYear() - 1)
        newDate = dateFormatter(newDate, endDate)
        console.log("1년")
        break;
  }
  $("#startDate").val(newDate)
    
  })
})
 */