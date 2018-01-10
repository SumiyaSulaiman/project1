<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<div class="row">
      <form id="Product" action="updateProduct" method="post" role="form" style="display: block;" enctype="multipart/form-data" >
      <input type="hidden" name="id" value="${p.productid}"/>
			<div class="form-group">
				<input type="text" name="productname" id="productname" tabindex="2" class="form-control" placeholder="Enter product name" value="${p.productname }">
			</div>

			<div class="form-group">
				<input type="text" name="productdescription" id="productDescription" tabindex="2" class="form-control" placeholder="About the product  " value="${p.productdescription }">
			</div>

			<div class="form-group">
				<input type="number" name="stock" id="quantity" tabindex="2" class="form-control" placeholder="enter stock " value="${p.stock }">
			</div>

			<div class="form-group">
				<input type="number" name="price" id="price" tabindex="2" class="form-control" placeholder="enter price" value="${p.price }">
			</div>
			

			<div class="form-group">
				    Choose Category: 
     			<select name="catid">
                    <option>SELECT CATEGORY</option>
        			<c:forEach items="${clist }" var="c">
     						 <option value="${c.catid}">${c.catname}</option>
         			 </c:forEach>
                 </select>

               </div>
               
				<div class="form-group">
				    Choose Supplier: 
     			<select name="supid">
                    <option>SELECT SUPPLIER</option>
        			<c:forEach items="${slist }" var="s">
     						 <option value="${s.supid}">${s.supname}</option>
         			 </c:forEach>
                 </select>

               </div>
            <div class="form-group">
					PRODUCT Image
					<input type="file" name="img">
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