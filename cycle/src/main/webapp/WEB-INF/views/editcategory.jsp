<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>

	
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
  <div class="row">
		<form id="category" action="updateCategory" method="post" role="form" style="display: block;">
		<input type="hidden" name="id" value="${c.catid}"/>
			<div class="form-group">
				<input type="text" name="catname" id="catname" tabindex="2" class="form-control" placeholder="enter category name" value="${c.catname }" required>
			</div>
			<div class="form-group">
				<input type="text" name="catdescription" id="catdescription" tabindex="2" class="form-control" placeholder="about category" value="${c.catdescription }" required>
			</div>

			<div class="col-sm-4 col-sm-offset-3">
				<input type="submit" name="submit" id="submit" tabindex="4" class="form-control btn btn-submit" value="SUBMIT">
			</div>
		</form>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>