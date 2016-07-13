<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>page list</title>
</head>

<body>
  <table>
    <tr>
      <td>ID</td>
      <td>NAME</td>
      <td>AGE</td>
      <td>CREATE TIME</td>
      <td>UPDATE TIME</td>
    </tr>
    <c:forEach items="${studentList}" var="student">
      <tr>
        <td>${student['id']}</td>
        <td>${student['name']}</td>
        <td>${student['age']}</td>
        <td>${student['createTime']}</td>
        <td>${student['updateTime']}</td>
      </tr>
    </c:forEach>
  </table>
  上一页: ${studentListPaginator.prePage}
  当前页: ${studentListPaginator.page}
  下一页: ${studentListPaginator.nextPage}
  总页数: ${studentListPaginator.totalPages}
  总条数: ${studentListPaginator.totalCount}
</body>
</html>
