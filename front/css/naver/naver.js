let id = rolling();

// hover 이벤트를 등록
$('.outer-box').hover(function(){
		// 마우스가 요소 안으로 들어오면
		// 애니메이션이 진행중인 setInterval를 해제 => clearInterval
		clearInterval(id);
	}, function(){
		// 마우스가 요소를 빠져나가면
		// setInterval를 통해 애니매이션이 진행되도록 작업
		id = rolling();
	})
	function rolling(){
		return setInterval(function(){
			if(!$('.inner-box').first().is(':animated')){
				let width = $('.inner-box').innerWidth();
				$('.inner-box').first().animate({
					marginLeft : `-${width}px`
				}, 900, function(){
					$(this).detach().appendTo('.inner-box-container').removeAttr('style');
				});
			}
		}, 2000);
	}

// 버튼 클릭시 이동
$('.right').click(function(){
	// 애니메이션 실행 후, 요소를 때서 붙임
	let width = $('.inner-box').innerWidth();
	if(!$('.inner-box').first().is(':animated')){
		$('.inner-box').first().animate({
			marginLeft : `-${width}px`
		}, 1000, function(){
			$(this).detach().appendTo('.inner-box-container').removeAttr('style');
		});
}
});
//이전 버튼 클릭 이벤트를 등록
$('.left').click(function(){
	// 요소를 때서 붙인 후 애니메이션을 실행
	// => 마지막 요소를 떼서 앞에 붙이고. margin-left를 지정
	// last(), prependTo(), css()
	let width = $('.inner-box').first().innerWidth();
	if(!$('.inner-box').first().is(':animated')){
		$('.inner-box').last().detach().prependTo('.inner-box-container')
		.css('marginLeft', `-${width}px`).animate({
			marginLeft : 0
		}, 1000);
	}
})