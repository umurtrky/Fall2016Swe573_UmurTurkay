<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="static/css/style.css">
	<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script>
		$(function() {
	  	$( "#birthdate" ).datepicker();
		});
	</script>
</head>
 
<body>
    <div class="container">
 
        <div class="well lead">User Registration Form</div>
           <form:form method="POST" modelAttribute="user" class="form-horizontal">
	       <form:input type="hidden" path="id" id="id"/>
	        
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="firstName">First Name</label>
	               <div class="col-md-7">
	                   <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
	                   <div class="has-error">
	                       <form:errors path="firstName" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="lastName">Last Name</label>
	               <div class="col-md-7">
	                   <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
	                   <div class="has-error">
	                       <form:errors path="lastName" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="username">User name</label>
	               <div class="col-md-7">
	                   <c:choose>
	                       <c:when test="${edit}">
	                           <form:input type="text" path="username" id="username" class="form-control input-sm" disabled="true"/>
	                       </c:when>
	                       <c:otherwise>
	                           <form:input type="text" path="username" id="username" class="form-control input-sm" />
	                           <div class="has-error">
	                               <form:errors path="username" class="help-inline"/>
	                           </div>
	                       </c:otherwise>
	                   </c:choose>
	               </div>
	           </div>
	       </div>
	
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="password">Password</label>
	               <div class="col-md-7">
	                   <form:input type="password" path="password" id="password" class="form-control input-sm" />
	                   <div class="has-error">
	                       <form:errors path="password" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="email">Email</label>
	               <div class="col-md-7">
	                   <form:input type="text" path="email" id="email" class="form-control input-sm" />
	                   <div class="has-error">
	                       <form:errors path="email" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	       
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="height">Height</label>
	               <div class="col-md-7">
	                   <form:input type="text" path="height" id="height" class="form-control input-sm" />
	                   <div class="has-error">
	                       <form:errors path="height" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	       
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="height">Weight</label>
	               <div class="col-md-7">
	                   <form:input type="text" path="weight" id="weight" class="form-control input-sm" />
	                   <div class="has-error">
	                       <form:errors path="weight" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	       
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="birthdate">Birthdate</label>
	               <div class="col-md-7">
	                   <form:input type="text" path="birthdate" id="birthdate" class= "date" name = "birthdate" placeholder="dd-mm-yyyy"/>
	                   <div class="has-error">
	                       <form:errors path="birthdate" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	
	       <div class="row">
	           <div class="form-group col-md-12">
	               <label class="col-md-3 control-lable" for="gender">Genders</label>
	               <div class="col-md-7">
	                   <form:input type="text" path="gender" id="gender" class="form-control input-sm" />
	                   <div class="has-error">
	                       <form:errors path="gender" class="help-inline"/>
	                   </div>
	               </div>
	           </div>
	       </div>
	
	       <div class="row">
	           <div class="form-actions floatRight">
	               <c:choose>
	                   <c:when test="${edit}">
	                       <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
	                   </c:when>
	                   <c:otherwise>
	                       <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
	                   </c:otherwise>
	               </c:choose>
	           </div>
	       </div>
	   </form:form>
    </div>
</body>
</html>