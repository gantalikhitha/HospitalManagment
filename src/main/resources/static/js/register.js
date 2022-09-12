function formvalidation(){
	var name=document.forms["myForm"]["name"];
	var address=document.forms["myForm"]["address"].value;
	var email=document.forms["myForm"]["email"];
	var psw=document.forms["myForm"]["password"];
	
	if(name =="" || name==null ||(!name.value.match(/^[a-zA-Z]+$/))){
		document.getElementById('error-name').innerHTML="enter a  valid name";
		document.getElementById('error-name').style.color="Red";
                    
		name.focus();
		return false;
		}
		else{
			document.getElementById('error-name').innerHTML="";
		}
		
		if(address =="" || address==null){
			document.getElementById('erroraddress').innerHTML="enter valid address";
			document.getElementById('erroraddress').style.color="Red";
			return false;
		}
		else{
			document.getElementById('erroraddress').innerHTML="";
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
		if(psw.value==""||psw.value==null||(!psw.value.match(/^[a-zA-Z0-9!@#\$%\^\&*_=+-]{6,12}$/g))){
			document.getElementById('errorpsw').innerHTML="Enter valid password";
			document.getElementById('errorpsw').style.color="Red";
			psw.focus();
			return false;
		}
		else{
			document.getElementById('errorpsw').innerHTML="";
		}
		
		}
		
		
		function validations(){
			var email=document.forms["myForm"]["email"];
			var psw=document.forms["myForm"]["password"];
	
			
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
		if(psw.value==""||psw.value==null||(!psw.value.match(/^[a-zA-Z0-9!@#\$%\^\&*_=+-]{6,12}$/g))){
			document.getElementById('errorpsw').innerHTML="Enter valid password";
			document.getElementById('errorpsw').style.color="Red";
			psw.focus();
			return false;
		}
		else{
			document.getElementById('errorpsw').innerHTML="";
		}
		}
		function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
		
		
		