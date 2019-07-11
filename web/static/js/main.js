jQuery(document).ready(function($) {

	//顶部导航的3D效果展示

	$('.cd-3d-nav-trigger').on('click', function() {
		toggle3dBlock(!$('.cd-header').hasClass('nav-is-visible'));
	});
	$('.cd-3d-nav2 a').on('click', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		updateSelectedNav('close');
	});
	$('.cd-3d-nav3 a').on('click', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		updateSelectedNav('close');
	});
	$('.cd-3d-nav4 a').on('click', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		updateSelectedNav('close');
	});
	$('.cd-3d-nav5 a').on('click', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		updateSelectedNav('close');
	});

	//select a new item from the 3d navigation
	$('.cd-3d-nav3 a').on('mouseover', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		var selectedItem = $('.cd-selected'),
			selectedItemPosition = selectedItem.index() + 1,
			leftPosition = selectedItem.offset().left,
			backgroundColor = selectedItem.data('color');
		$('.cd-marker3').show();
		$('.cd-marker3').removeClassPrefix('color').addClass('color-' + selectedItemPosition).css({
			'left': leftPosition,
		});


		// updateSelectedNav('close');
	});
	$('.cd-3d-nav2 a').on('mouseover', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		var selectedItem = $('.cd-selected'),
			selectedItemPosition = selectedItem.index() + 1,
			leftPosition = selectedItem.offset().left,
			backgroundColor = selectedItem.data('color');
		$('.cd-marker2').show();
		$('.cd-marker2').removeClassPrefix('color').addClass('color-' + selectedItemPosition).css({
			'left': leftPosition,
		});
	});
	$('.cd-3d-nav5 a').on('mouseover', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		var selectedItem = $('.cd-selected'),
			selectedItemPosition = selectedItem.index() + 1,
			leftPosition = selectedItem.offset().left,
			backgroundColor = selectedItem.data('color');
		$('.cd-marker5').show();
		$('.cd-marker5').removeClassPrefix('color').addClass('color-' + selectedItemPosition).css({
			'left': leftPosition,
		});
	});
	$('.cd-3d-nav4 a').on('mouseover', function() {
		var selected = $(this);
		selected.parent('li').addClass('cd-selected').siblings('li').removeClass('cd-selected');
		var selectedItem = $('.cd-selected'),
			selectedItemPosition = selectedItem.index() + 1,
			leftPosition = selectedItem.offset().left,
			backgroundColor = selectedItem.data('color');
		$('.cd-marker4').show();
		$('.cd-marker4').removeClassPrefix('color').addClass('color-' + selectedItemPosition).css({
			'left': leftPosition,
		});
	});



	$(window).on('resize', function() {
		window.requestAnimationFrame(updateSelectedNav);
	});

	function toggle3dBlock(addOrRemove) {
		if (typeof(addOrRemove) === 'undefined') addOrRemove = true;
		$('.cd-header').toggleClass('nav-is-visible', addOrRemove);
		$('main').toggleClass('nav-is-visible', addOrRemove);
		$('.cd-3d-nav-container').toggleClass('nav-is-visible', addOrRemove);
	}

	//this function update the .cd-marker position
	function updateSelectedNav(type) {
		if (type == 'close') {
			$('.cd-marker2').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function() {
				toggle3dBlock(false);
			});
			$('.cd-marker3').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function() {
				toggle3dBlock(false);
			});
			$('.cd-marker4').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function() {
				toggle3dBlock(false);
			});
			$('.cd-marker5').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function() {
				toggle3dBlock(false);
			});
		}
	}

	$.fn.removeClassPrefix = function(prefix) {
		this.each(function(i, el) {
			var classes = el.className.split(" ").filter(function(c) {
				return c.lastIndexOf(prefix, 0) !== 0;
			});
			el.className = $.trim(classes.join(" "));
		});
		return this;
	};

	// 登录界面的显示隐藏

	$('#g-login').on('click', function() {
		$('#r-display').css("display", "block");
		$('#v-form').css("display", "block");
	});
	$('#exit-btn').on('click', function() {
		$('#r-display').css("display", "none");
		$('#v-form').css("display", "none");
	});

	// 填写日常内容btn的显示隐藏  
	$('.fill-btn').on('click', function() {
		var a = $('.fill-btn').index(this);
		$('.fill-form').eq(a).toggle(); // eq()获取第几个class    toggle()显示则隐藏 ，隐藏则显示
		$('.fill-form').eq(a).siblings('.fill-form').hide();
		$('.form-val').eq(a).on('input', function() {
			var con = $('.form-val').eq(a).val();
			if (con.length >= 5 && con.length <= 20) {
				$('.btn-sub').eq(a).show();
				$('.btn-res').eq(a).hide();
			} else {
				$('.btn-sub').eq(a).hide();
				$('.btn-res').eq(a).show();
			}
		});

	});
	$('.exit-btn').on('click', function() {
		var a = $('.exit-btn').index(this);
		$('.fill-form').eq(a).hide(); // eq()获取第几个class
	});
	// 总结字数的提示
	$('.summary-con').on('input', function() {
		var summarycon = $('.summary-con').val();
		if (summarycon.length >= 100) {
			$('.btn-summary-sub').show();
			$('.btn-summary-res').hide();
		} else {
			$('.btn-summary-sub').hide();
			$('.btn-summary-res').show();
		}
		if (summarycon.length >= 160) {
			$('.summary-con-count').show();
			$('.summary-con-count').html("字数：" + summarycon.length + "   非常棒!");
		} else {
			$('.summary-con-count').show();
			$('.summary-con-count').html("字数：" + summarycon.length);
		}
	});



	// 已发金额和未发金额的提示

	$('.paid-btn').on('click', function() {
		$('.paid-wages').show();
		$('.unpaid-wages').hide();
	});
	$('.unpaid-btn').on('click', function() {
		$('.unpaid-wages').show();
		$('.paid-wages').hide();
	});

	// 个人信息修改的显示隐藏
	$('.btn-perinfo-res').on('click', function() {
		$('.perinfo-res').show();
		$('.perinfo-upd').hide();
	});
	$('.btn-perinfo-sub').on('click', function() {
		$('.perinfo-upd').show();
		$('.perinfo-res').hide();
	});


	// 修改金额的提示
	$('.val-upd').on('input', function() {
		var c = $('.val-upd').index(this);
		var salary = $('.val-upd').eq(c).val();
		if (salary != '') {
			$('.btn-upd-war').eq(c).show();
			$('.btn-upd-res').eq(c).hide();
		} else {
			$('.btn-upd-war').eq(c).hide();
			$('.btn-upd-res').eq(c).show();
		}
	});

	// 登录界面的显示与隐藏
	$('.student-login-btn button').on('click', function() {
		$('.box-login').show();
		$('.student-logininterface').show();

	});
	$('.admin-login-btn button').on('click', function() {
		$('.box-login').show();
		$('.admin-logininterface').show();
	});
	$('.logininterface-exit').on('click', function() {
		$('.box-login').hide();
		$('.student-logininterface').hide();
		$('.admin-logininterface').hide();
	});


	// 侧边栏的操作
	
	/*获取项目名  realPath = http://localhost:8080/wssp-nuc*/	
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPaht=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var realPath=localhostPaht+projectName;
	$("#open-sb").on('click', function() {
		if ($("#sidebar").offset().left == -200) {			
			$("#sidebar").css('left', '0');
			$(".menu-button-asid").css('background-image', "url("+realPath+"/static/img/leftarrow.png)");

		} else {
			$("#sidebar").css('left', '-200px');
			$(".menu-button-asid").css('background-image', "url("+realPath+"/static/img/rightarrow.png)");

		}
	});
	$("#open-sb").on('click', function() {
		if ($("#sidebar").offset().left == 0) {
			$("#sidebar").css('left', '-200px');
			$(".menu-button-asid").css('background-image', "url("+realPath+"/static/img/rightarrow.png)");

		}
	});
	
	
	// 划分最近区域操作

	var arrInput = [];
	
	// 区分手机不能双击选择

	$("#list6").change(function() {
		var index = $(this).get(0).selectedIndex;
		$('.list').hide().eq(index).show();
		var arrInput = [];
		if ($(document.body).width() <= 1024) {

			$('.list').eq(index).click(function() { //绑定双击事件
				//获取全部的选项,删除并追加给对方
				console.log("1");
				var opcon = $("option:selected", this).val();
				if (arrInput.indexOf(opcon) == -1) {
					arrInput.push(opcon); //追加给对方
				} else {
					alert("请不要重复添加最近区域！");
				}

				$("#area-input").val(arrInput);

			});
		} else {

			$('.list').eq(index).dblclick(function() { //绑定双击事件
				//获取全部的选项,删除并追加给对方
				console.log("1");
				var opcon = $("option:selected", this).val();
				if (arrInput.indexOf(opcon) == -1) {
					arrInput.push(opcon); //追加给对方
				} else {
					alert("请不要重复添加最近区域！");
				}

				$("#area-input").val(arrInput);

			});
		}
	});
	
	
	// 个人信息上岗记录展示
	$('#timeline-open').on('click', function() {
		$('#timeline-container').css('z-index','1');
		$('#timeline-container').css('opacity','1');
	});
	$('.timeline-exit').on('click', function() {
		$('#timeline-container').css('z-index','-1');
		$('#timeline-container').css('opacity','0');
	});

	
});
