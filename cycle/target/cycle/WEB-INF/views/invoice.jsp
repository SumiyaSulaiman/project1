<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	
body {
    margin-top: 20px;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>${User.name }</strong>
                        <br>
                       ${User.mail }
                        <br>
                        ${User.address }
                        <br>
                        <abbr title="Phone">P:</abbr>${User.phoneno }
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em>Order Date:<%=new Date()%></em>
                    </p>
                    <p>
                        <em>Receipt #: 34522677W</em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
                </span>
               <table id="cart" class="table table-hover table-condensed">
								    				<thead>
														<tr>
															<th style="width:25%">Product</th>
															<th style="width:10%">Price</th>
															<th style="width:8%">Quantity</th>
															<th style="width:20%" class="text-center">Subtotal</th>
															
														</tr>
													</thead>
													<tbody>
														 <c:forEach var="ct" items="${Cart}">
														<tr>
															<td data-th="Product">
																<div class="row">
																	
																		<div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/resources/images/${ct.product.productid}.jpg" alt="..." class="img-responsive"/></div>
																		<div class="col-sm-10">
																		<h4 class="nomargin">${ct.product.productname}</h4>
																		<p>${ct.product.productdescription}</p>
																	</div>
																	
																	
																</div>
															</td>
															<td data-th="Price"><h4 class="nomargin">${ct.product.price}</td></h4>
															
															<td data-th="Quantity">
																
																<h4 class="nomargin">${ct.cartquantity}</h4>
												
															</td>
															<td data-th="Subtotal" class="text-center">${ct.product.price*ct.cartquantity}</td>
															
																<c:set var="sum" value="${sum+ (ct.product.price*ct.cartquantity)}"/>
																
								                         	
														</tr>
														 </c:forEach>
														 
													 	
													</tbody>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right">
                            <p>
                                <strong>Subtotal: </strong>
                            </p>
                            <p>
                                <strong>Tax(2%): </strong>
                            </p></td>
                            <td class="text-center">
                            <p>
                                <strong>${sum}</strong>
                            </p>
                            <p>
                                <strong>${sum*.02 }</strong>
                            </p></td>
                       
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><h4><strong>Total: </strong></h4></td>
                            <td class="text-center text-danger"><h4><strong>${sum+(sum*.02)}</strong></h4></td>
                        </tr>
                    </tbody>
                </table>
             
              <center>
                <button class="btn btn-primary btn-submit-fix" onclick="myFunction()">Print this page</button>

               <a href="${pageContext.request.contextPath}/user/thankyou">
                <button type="button" class="btn btn-primary btn-submit-fix">
                    Pay Now   
                </button></a></center>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>

<script>
function myFunction() {
    window.print();
}
</script>             
                
</body>
</html>