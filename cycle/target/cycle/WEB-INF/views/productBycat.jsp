<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>

.row.flex{display:inline-flex;  width:100%;}
img{width:50%;height=auto;}

</style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<div class="row" >
  <c:forEach items="${plist }" var="p">
  <div class="col-xs-3">
    <div class="thumbnail">
      <a href="${pageContext.request.contextPath}/productdetails?id=${p.productid}&cmsg=">
        <img src="${pageContext.request.contextPath}/resources/images/${p.productid}.jpg"  alt="" >
        <div class="caption">
          <p></p><p>${p.productname }<br>${p.price }</p>
        </div>
      </a>
    </div>
  </div>
  </c:forEach>
 </div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>