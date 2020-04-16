<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<sql:query var="rs" dataSource="jdbc/springwork">
select * from profiles
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
    first name: ${row.firstName} last name: ${row.lastName}<br/>
</c:forEach>

  </body>
</html>