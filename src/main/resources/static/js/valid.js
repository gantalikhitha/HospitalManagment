function validateForm(){
	
	
	var patientname=document.forms["myForm"]["patientname"];
	var x=document.forms["myForm"]["doctorname"];
	var y=document.forms["myForm"]["mobileno"].value;
	var time=document.forms["myForm"]["time"];
	var date=document.forms["myForm"]["date"];
	var email=document.forms["myForm"]["email"]
	
	if(patientname.value == "" || patientname.value==null ||(!patientname.value.match(/^[a-zA-Z]+$/))){
		document.getElementById('errorname').innerHTML="enter a  valid patientname";
		document.getElementById('errorname').style.color="Red";
        patientname.focus();
		return false;
		}
		else{
			document.getElementById('errorname').innerHTML="";
		}
	
	if(x.value == "" || x.value==null ||(!x.value.match(/^[a-zA-Z]+$/))){
		document.getElementById('error-name').innerHTML="enter valid  doctorname";
		document.getElementById('error-name').style.color="Red";
                    
		x.focus();
		return false;
		}
		else{
			document.getElementById('error-name').innerHTML="";
		}
		
		
	if(y.value==null && y.length!=10){
			document.getElementById('error-mobileno').innerHTML="enter a valid number";
			document.getElementById('error-mobileno').style.color="Red";
			
			return false;
			
		}
		else{
			document.getElementById('error-mobileno').innerHTML="";
		}
	
	if(time.value==""||time.value==null||(!time.value.match( /((1[0-2]|0?[1-9]):([0-5][0-9]) ?([AaPp][Mm]))/))){
		document.getElementById('errortime').innerHTML="enter valid time format";
		document.getElementById('errortime').style.color="Red";
		time.focus();
		return false;
	}
	else{
		document.getElementById('errortime').innerHTML="";
	}
	
	if(date.value==""||date.value==null){
		document.getElementById('error-date').innerHTML="enter valid date";
		document.getElementById('error-date').style.color="Red";
		//date.focus();
		return false;
	}
	else{
		document.getElementById('error-date').innerHTML="";
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
	
	/*var y=document.form.patientname.value;
	var x=document.form.doctorname.value;
	var num=document.form.mobileno.value;

	if(y==null || y==""){
		alert("invalid patientname");
		console.log(y);
		return false;
	}
	
	
	if(x==null || x==""){
		alert("invalid doctorname");
		console.log(x);
		return false;
	}
	
	
	
	if(num.value==null && num.length != 10){
		alert("enter mobile number");
		console.log(num);
	    return false;
	}
	}*/