$(function(){
	$('.myButton').click(function () {
		 
		 $.ajax({
		        type: "GET",
		        url: "idCheck",
		        data: {
		            "id": $('#user_id').val()
		        },
		        success : function(data) {
		        	 if ($.trim(data) == "YES") {
			                if ($('#user_id').val() != '') {
			                    alert("사용 가능한 아이디 입니다.")
			                }
			            } else {
			                if ($('#user_id').val() != '') {
			                   alert("중복된 아이디입니다!");
			                    $('#user_id').val('');
			                    $('#user_id').focus();
			                }	               
			            }
	           }	           
		    })
	});	
	
	$('#businessNum').blur(function () {
		 $.ajax({
		        type: "GET",
		        url: "bsnCheck",
		        data: {
		            "businessNum": $('#businessNum').val()
		        },
		        success : function(data) {
		        	 if ($.trim(data) == "YES") {
			                if ($('#businessNum').val() != '') {
			                    alert("사용 가능합니다.");
			                }
			            } else {
			                if ($('#businessNum').val() != '') {
			                   alert("중복된 번호 입니다!");
			                    $('#businessNum').val('');
			                    $('#businessNum').focus();
			                }	               
			            }
	           }	           
		    })
		 var regNumber=/^[0-9]*$/;
		 var temp=$("#businessNum").val();
		 if(!regNumber.test(temp)){
			alert("숫자만 입력하세요");
			$('#businessNum').val('');
		}
	});	
	
	$('#phone').blur(function () {
		var regNumber=/^\d{3}-\d{3,4}-\d{4}$/;
		var temp=$("#phone").val();
		
		 $.ajax({
		        type: "GET",
		        url: "phoneCheck",
		        data: {
		            "phone": $('#phone').val()
		        },
		        success : function(data) {
		        	 if ($.trim(data) == "YES") {
			                if ($('#phone').val() != '') {
			                    alert("사용 가능합니다.");
			                }
			            } else {
			                if ($('#phone').val() != '') {
			                   alert("중복된 번호 입니다!");
			                    $('#phone').val('');
			                    $('#phone').focus();
			                }	               
			            }
	           }	           
		    })		
		if(!regNumber.test(temp)){
			alert("알맞은 형태로 입력하세요");
			$('#phone').val('');
		}
	});
	
	$('#repassword').blur(function(){
		var pwd1=$('#password').val();
		var pwd2=$('#repassword').val();
		
		if(pwd1!=''&&pwd2!=''){
			if(pwd1==pwd2){
				$('#password').css('border-color','blue');
				$('#repassword').css('border-color','blue');
				$('#sign').removeAttr("disabled");
			}else{
				alert("비밀번호 불일치 다시 입력해주세요.");
				$('#password').css('border-color','#dc143c');
				$('#repassword').css('border-color','#dc143c');
				$('#sign').attr("disabled","disabled");
			}
			
			
		}
	});
	
	
	if($('#user_id').val()==''||('#password').val()==''||$('#businessNum').val()==''){
		$('#sign').attr("disabled","disabled");
	}else{
		$('#sign').removeAttr("disabled");
	}
});
