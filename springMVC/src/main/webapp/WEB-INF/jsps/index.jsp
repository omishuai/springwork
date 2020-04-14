<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language ="java" contentType = "text/html; charset-ISO-8859-1" pageEncoding = "ISO-8859-1" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Hello World!</h2>

<h3>
Session:<%= session.getAttribute("name")%> <p/>
Request:<%= request.getAttribute("name")%> <p/>
Request using EL: ${name} <p/>
<c:out value ="${name}"></c:out> <p/>
</h3>
</body>
</html>


