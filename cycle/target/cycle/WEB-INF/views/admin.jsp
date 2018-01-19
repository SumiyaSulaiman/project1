<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
.btn-pref .btn {
    -webkit-border-radius:0 !important;
}
.custab{
    border: 1px solid #ccc;
    padding: 5px;
    margin: 5% 0;
    box-shadow: 3px 3px 2px #ccc;
    transition: 0.5s;
    }
.custab:hover{
    box-shadow: 3px 3px 0px transparent;
    transition: 0.5s;
    }
   .custab:table{
    margin:auto;
}

</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2 align="center">ADMIN LIST</h2>
<div  class="container">


    <div  class="tab-header">
    <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" id="stars" class="btn btn-primary" href="#tab1" data-toggle="tab">
                <div class="hidden-xs">CATEGORY</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="favorites" class="btn btn-default" href="#tab2" data-toggle="tab">
                <div class="hidden-xs">SUPPLIER</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="following" class="btn btn-default" href="#tab3" data-toggle="tab">
                <div class="hidden-xs">PRODUCT</div>
            </button>
        </div>
    </div>

        <div class="well">
      <div class="tab-content">
        <div class="tab-pane fade in active" id="tab1">
          
          <br/>
       <div class="row">
		<form id="category" action="${pageContext.request.contextPath}/admin/saveCategory" method="post" role="form" style="display: block;">
			<div class="form-group">
				<input type="text" name="catname" id="catName" tabindex="2" class="form-control" placeholder="enter category name" required>
			</div>
			<div class="form-group">
				<input type="text" name="catdescription" id="catdescription" tabindex="2" class="form-control" placeholder="about category" required>
			</div>

			<div class="col-sm-4 col-sm-offset-3">
				<input type="submit" name="submit" id="submit" tabindex="4" class="form-control btn btn-submit" value="SUBMIT">
			</div>
		</form>
		<div class="container">
    <div class="row col-md-8 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>DESCRIPTION</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
            
               <c:forEach items="${clist }" var="c">
				<tr class="active">
					<td>${c.catid}</td>
					<td>${c.catname}</td>
					<td>${c.catdescription }</td>
					<td class="text-center"><a class='btn btn-info btn-xs' href="${pageContext.request.contextPath}/admin/editCat?id=${c.catid }"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="${pageContext.request.contextPath}/admin/deleteCat?id=${c.catid }" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
			</c:forEach>
               
    </table>
    </div>
</div>
		
        </div>
        </div>
      
        <div class="tab-pane fade in" id="tab2">
       
    
    <br/>
	<div class="row">
    <form id="Supplier" action="${pageContext.request.contextPath}/admin/saveSupplier" method="post" role="form" style="display: block;" >
		<div class="form-group">
			<input type="text" name="supname" id="SupName" tabindex="2" class="form-control" placeholder="Enter supplier name" required>
		</div>
		<div class="form-group">
			<input type="text" name="supaddress" id="SupAddress" tabindex="2" class="form-control" placeholder="Enter Address" required>
		</div>
		<div class="col-sm-4 col-sm-offset-3">
			<input  type="submit" name="submit" id="submit" tabindex="4" class="form-control btn btn-submit" value="SUBMIT">
		</div>
	</form>
	
	<div class="container">
    <div class="row col-md-8 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>ADDRESS</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
            
                <c:forEach items="${slist }" var="s">
				<tr class="active">
					<td>${s.supid}</td>
					<td>${s.supname}</td>
					<td>${s.supaddress }</td>
					<td class="text-center"><a class='btn btn-info btn-xs' href="${pageContext.request.contextPath}/admin/editSup?id=${s.supid }"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="${pageContext.request.contextPath}/admin/deleteSup?id=${s.supid}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
            </c:forEach>
    </table>
    </div>
</div>
	</div>
	
        </div>
       
        <div class="tab-pane fade in" id="tab3">
         <br/>
      <div class="row">
      <form id="Product" action="${pageContext.request.contextPath}/admin/saveProduct" method="post" role="form" style="display: block;" enctype="multipart/form-data" >
			<div class="form-group">
				<input type="text" name="productname" id="productname" tabindex="2" class="form-control" placeholder="Enter product name">
			</div>

			<div class="form-group">
				<input type="text" name="productdescription" id="productDescription" tabindex="2" class="form-control" placeholder="About the product  ">
			</div>

			<div class="form-group">
				<input type="number" name="stock" id="quantity" tabindex="2" class="form-control" placeholder="enter quantity">
			</div>

			<div class="form-group">
				<input type="number" name="price" id="price" tabindex="2" class="form-control" placeholder="enter price">
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
		<div class="container">
     <div class="row col-md-8 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>DESCRIPTION</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
            
               <c:forEach items="${plist }" var="p">
				<tr class="active">
					<td>${p.productid}</td>
					<td>${p.productname}</td>
					<td>${p.productdescription }</td>
					<td class="text-center"><a class='btn btn-info btn-xs' href="${pageContext.request.contextPath}/admin/editProduct?id=${p.productid }"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="${pageContext.request.contextPath}/admin/deleteProduct?id=${p.productid}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
			</c:forEach>
               
    </table>
    </div>
</div>
				
        </div>
      </div>
    </div>
    
    </div>
    </div>
            
  <script type="text/javascript">
  $(document).ready(function() {
	  $(".btn-pref .btn").click(function () {
	      $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
	      // $(".tab").addClass("active"); // instead of this do the below 
	      $(this).removeClass("btn-default").addClass("btn-primary");   
	  });
	  });
  
  </script> 
  <jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>