(function(){
    	emailjs.init("user_xOiQpkRaJHmjECSPWnyTX");
	    	var templateParams = {
	    	email: $('input[name=user_email]').val(),
	    	name: $('input[name=user_name]').val(),
	    	title: $('input[name=book_title]').val()};
	    	
	    	emailjs.send('service_x6j9axp', 'template_9eguio9', templateParams,"user_xOiQpkRaJHmjECSPWnyTX").then(
	    			function(response){
	    				console.log('SUCCESS!!', response.status, response.text);
	    				alert('재고 알람 신청이 완료되었습니다.');
	    			}, function(error){
	    				console.log('FAILED...', error);
	    			});
 })();