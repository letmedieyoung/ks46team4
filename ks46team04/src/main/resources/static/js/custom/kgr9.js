/**
 * totalSearchBtn 전체검색 버튼
 */
$('#totalSearchBtn').click(function(){
	 location.reload();
});

/**
 * resetBtn 입력취소 버튼
 */
$('#resetBtn').click(function(){
	 location.reload();
});

/**
 * addGoodsBtn 상품등록 버튼
 */
$('#addGoodsBtn').click(function(){
	 location.href = '/admin/goods/add_goods';
});

/**
 * select value 값 -> input value로 넣기
 */
function func(category) {
	const selectInput = document.querySelector('#goodsCategory');
	selectInput.value = category;
};

/**
 * 세션에서 id값 가져오기
 */

/**
 * add_goods.html submitBtn 버튼
 */
$(function(){
	function validationCheck(ele){
		let data = $(ele).val();
		let isValid = true;
		if(typeof data == 'undefined' || data == null || data == ''){
			let msg = $(ele).parents('tr').find('label').text();
			alert(`${msg} 필수 항목입니다.`)
			$(ele).focus();
			isValid = false;	
		}
		return isValid;
	};
	
	
	$('#submitBtn').click(function(){
		let formId = $('form').getAttribute('id');
		console.log(formId)
		const $inputEles = [];
		switch(formId){
			case addGoodsForm:
				$inputEles = $('#addGoodsForm input');
				break;
			case modifyGoodsForm:
				$inputEles = $('#modifyGoodsForm input');
				break;
			case removeGoodsForm:
				$inputEles = $('#removeGoodsForm input');
				break;
		}		
		let isSubmit = true;
		$inputEles.each(function(idx, item){
			isSubmit = validationCheck(item);
			return isSubmit;
		});
		
		let $formEle = document.getElementById(formId);
		if(isSubmit) $formEle.submit();
		
	});
});