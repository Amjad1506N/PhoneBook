<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-image: url(internet-2515611_1920.jpg);
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script>

$(function() {
	  // Initialize form validation on the registration form.
	  // It has the name attribute "registration"
	  $("form[name='contactform']").validate({
	    // Specify validation rules
	    rules: {
	      // The key name on the left side is the name attribute
	      // of an input field. Validation rules are defined
	      // on the right side
	      contactName: "required",
	      contactEmail: {
	        required: true,
	        // Specify that email should be validated
	        // by the built-in "email" rule
	        email: true
	      },
	      contactNumber: {
	        required: true,
	        minlength: 10
	      }
	    },
	    // Specify validation error messages
	    messages: {
	     contactName: "Please enter your firstname",
	      contactNumber: {
	        required: "Please provide a number",
	        minlength: "Your number must be at least 10 digit long"
	      },
	      contactEmail: "Please enter a valid email address"
	    },
	    // Make sure the form is submitted to the destination defined
	    // in the "action" attribute of the form when valid
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
	});
</script>
</head>

<body style="background-color: skyblue"> 
	<h2>Contact Store</h2>
	<p>
		<font color='green'>${successMsg}</font>
	</p>
	<p>
		<font color='red'>${errorMsg}</font>
	</p>

	<form:form  action="saveContact" modelAttribute="contact" name="contactform" method="POST" >
		<table >
			<tr>
			    <form:hidden path="contactId"/>
				<td><form:label path="contactName"></form:label>Contact Name:</td>
				<td><form:input path="contactName"  name="contactName" placeholder="name"/></td>
			</tr>
			<tr>
				<td><form:label path="contactEmail"></form:label>Contact Email:</td>
				<td><form:input path="contactEmail" name="contactEmail" placeholder="email@gmail.com"/></td>
			</tr>
			<tr>
				<td><form:label path="contactNumber"></form:label>Contact Email:</td>
				<td><form:input path="contactNumber"  name="contactNumber" placeholder="1234567890" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContacts">View Contacts</a>
</body>
</html>