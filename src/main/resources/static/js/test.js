function validateForm(){
	
	var x=document.forms["myForm"]["pname"];
	var y=document.forms["myForm"]["mobileno"].value;
	var gender=document.forms["myForm"]["gender"];
	var age=document.forms["myForm"]["age"];
	var email=document.forms["myForm"]["email"]
    
	
	if(x.value == "" || x.value==null ||(!x.value.match(/^[a-zA-Z]+$/))){
		document.getElementById('errorname').innerHTML="enter a  valid name";
		document.getElementById('errorname').style.color="Red";
        x.focus();
		return false;
		}
		else{
			document.getElementById('errorname').innerHTML="";
		}
		
		
		if(y.value==null && y.length!=10){
			document.getElementById('error-mobileno').innerHTML="enter a valid number";
			document.getElementById('error-mobileno').style.color="Red";
			
			return false;
			
		}
		else{
			document.getElementById('error-mobileno').innerHTML="";
		}
		
		if(gender.value==""|| gender.value==null){
			document.getElementById('errorgender').innerHTML="selcet gender";
			document.getElementById('errorgender').style.color="Red";
			gender.focus();
			return false;
		}
		else{
			document.getElementById('errorgender').innerHTML="";
		}
		
		if (age.value==""||age.value==null){
			document.getElementById('errorage').innerHTML="enter valid age";
			document.getElementById('errorage').style.color="Red";
			age.focus();
			return false;
		}
		else{
		document.getElementById('errorage').innerHTML="";
		}
		
		if(email.value=="" ||email.value==null||(!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)))
                {
	             document.getElementById('erroremail').innerHTML="Enter the correct email address";
                 document.getElementById('erroremail').style.color="Red";
                    email.focus();
                    return false;
                }
                 else
                {
                    document.getElementById('erroremail').innerHTML="";
                 
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*var y=document.form.pname.value;
	var num=document.form.mobileno.value;
	
	
	if(y==null || y==""){
		alert("invalid pname");
		return false;
	}
	
	if(num.value==null && num.length != 10){
		alert("enter mobile number");
		console.log(num);
	    return false;
	}
	*/
	  
