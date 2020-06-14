<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>

<%-- trim will remove the extra spaces only one space is allowed --%>
	${fn:trim("     study          easy        .        org") }
	
<h1>EscapeXML Demo</h1>

<%-- when we use EscapeXML tag tags will have no impact they will be printed as it is--%>

${fn:escapeXml("<h1>EscapeXML Demo</h1>") }
	
</body>
</html>








