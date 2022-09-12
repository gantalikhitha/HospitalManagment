function validateForm(){
	var x=document.forms["myForm"]["doctorname"];
	var y=document.forms["myForm"]["mobileno"].value;
	var email=document.forms["myForm"]["email"];
	var specialization=document.forms["myForm"]["specialization"];
	
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
		
		if(email.value == "" || email.value == null ||(!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)))
                {
	                document.getElementById('div2').innerHTML="Enter the correct email address";
                 document.getElementById('div2').style.color="Red";
                    
                    return false;
                }
                 else
                {
                    document.getElementById('div2').innerHTML="";
                 
		}
		
		if(specialization.value==""||specialization.value==null){
			document.getElementById('errorspecialization').innerHTML="select specialization option";
			document.getElementById('errorspecialization').style.color="Red";
			specialization.focus();
			return false;
		}
		else{
			document.getElementById('errorspecialization').innerHTML="";
		}
		}
	
    /*var x=document.form.doctorname.value;
	var num=document.form.mobileno.value;
	var email=document.form.email.value;
	var atposition=email.indexOf("@");  
    var dotposition=email.lastIndexOf("."); 
    
     
   if(x==null || x==""){
		invalidname;
		console.log(x);
		return false;
	}
	
	if(num.value==null && num.length != 10){
		alert("enter mobile number");
		console.log(num);
	    return false;
	}
	
	
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){  
  alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
  return false;  
  }  
  }
  
  */
