<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<%-- 
we need to add taglibs then only we can use JSTL tags  
Here we have added the core tag
taglib is similar to import in java

--%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Demo</title>
</head>
<body>

<c:set var="name" value = "Riju"></c:set>
<%-- to display the variable we use out, we need to use expression to get the value , remove will remove variable from memory --%>
<c:out value= "${name}"></c:out>
<c:remove var="name"/>
<c:out value= "${name}"></c:out>
${name}
${param.msg}

<%-- if we use remove it will not print name otherwise print twice --%>
<%-- 

Expression language is set of expression which help to speed up our work, eg if we want to read variable we can use ${name}
it will also read a parameter if available to us

 --%>




</body>
</html>