<%@include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><spring:message code="errorPage.title"/></title>
</head>
<body>
    <h1><spring:message code="errorPage.header"/></h1>
    <p><spring:message code="errorPage.message"/></p>
    <spring:message code="errorPage.failedURL"/> ${url}
    <spring:message code="errorPage.exception"/>  ${exception.message}
        <c:forEach items="${exception.stackTrace}" var="ste"> 
           ${ste} 
    	</c:forEach>
</body>
</html>