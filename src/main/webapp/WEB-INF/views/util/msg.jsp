<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <head> </head>
  <body>
    <script
      src="https://code.jquery.com/jquery-3.7.1.js"
      integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript">
      var msg = "${msg}";
      if (msg != "") {
        alert(msg);
      }
      location.href = '<c:url value="${url}"/>';
    </script>
  </body>
</html>
