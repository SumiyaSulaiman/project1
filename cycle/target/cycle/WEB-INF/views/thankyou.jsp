<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<div class="jumbotron text-xs-center">
  <h1 class="display-3">Thank For shopping!</h1>
  <p class="lead"><strong>Your Order is placed.</strong> for further shopping please visit our website</p>
  <hr>
  <p>
    Having trouble? <a href="">Contact us</a>
  </p>
  <p class="lead">
    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/" role="button">Continue to homepage</a>
  </p>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>