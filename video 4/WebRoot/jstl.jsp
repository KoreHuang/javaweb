<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("a") %> || ${a }<br/>
	<%=session.getAttribute("s1") %>|| ${sessionScope.s1 }<br/>
	${1>1?false:true}<br/>
	${dvo.direction }
	<br/>
	${list[0]}${list[1]}${list[2]}${list[3]}${list[60]}
	<hr/>
	<c:forEach items="${list }" var="t">
		${t }
	</c:forEach>
	<c:out value="abc"></c:out>
</body>
</html>