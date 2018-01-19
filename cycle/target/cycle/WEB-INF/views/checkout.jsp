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
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<div class='container'>
	<form id="saveOrder" action="saveOrder" method="post" role="form" style="display: block;">
    <div class='row' style='padding-top:25px; padding-bottom:25px;'>
        <div class='col-md-12'>
            <div id='mainContentWrapper'>
                <div class="col-md-10 col-md-offset-1">
                    <h2 style="text-align: center;">
                        Review Your Order & Complete Checkout
                    </h2>
                    <hr/>
                    <a href="#" class="btn btn-info" style="width: 100%;">Add More Products & Services</a>
                    <hr/>
                    		<c:set var="gtot" value="0"></c:set>
							 <c:forEach var="c" items="${Cart}">
						     <c:set var="gtot" value="${gtot+c.product.price*c.cartquantity}"></c:set>
							</c:forEach>
							<input type="hidden" name="total" value="${gtot}"/>	
                    <div class="shopping_cart">
                        <form class="form-horizontal" role="form" action="" method="post" id="payment-form">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Review
                                                Your Order</a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <div class="items">
                                                <div class="col-md-15">
                                                    
                                                                   
								
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
															<%-- <td class="actions" data-th="">
																<c:set var="sum" value="${sum+ (ct.product.price*ct.cartquantity)}"/>
																
								                         	      		
															</td> --%>
														</tr>
														 </c:forEach>
														 
													 	
													</tbody>
                                                     <tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total ${gtot}</strong></td>
						</tr>
						<tr> 
							<td></td>
							<td colspan="2" class="hidden-xs"></td>
								
							<td class="hidden-xs text-center"><strong>Total ${gtot}</strong></td>
							
						</tr>
						
					</tfoot>
				</table>
                                                </div>
                                                <div class="col-md-3">
                                                    <div style="text-align: center;">
                                                        <h3>Order Total</h3>
                                                        <h3><span style="color:green;">Total ${gtot}</span></h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                           
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <div style="text-align: center; width:100%;"><a style="width:100%;"
                                                                                        data-toggle="collapse"
                                                                                        data-parent="#accordion"
                                                                                        href="#collapseTwo"
                                                                                        class=" btn btn-success"
                                                                                        onclick="$(this).fadeOut(); $('#payInfo').fadeIn();">Continue
                                            to Billing Information»</a></div>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Contact
                                            and Billing Information</a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <b>Help us keep your account safe and secure, please verify your billing
                                            information.</b>
                                        <br/><br/>
                                        <table class="table table-striped" style="font-weight: bold;">
                                            
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_email">Email:</label></td>
                                                <td>
                                                    <input class="form-control" id="id_email" name="email"
                                                           required="required" value="${u.mail}" type="text"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_first_name">Name:</label></td>
                                                <td>
                                                    <input class="form-control" id="id_first_name" name="name"
                                                           required="required"  value="${u.name}" type="text"/>
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_address_line_1">Address:</label></td> 
                                                <td>
                                                    <input class="form-control" id="id_address_line_1"
                                                           name="address" required="required"  value="${u.address}" type="text"/>
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_city">City:</label></td>
                                                <td>
                                                    <input class="form-control" id="id_city" name="city"
                                                           required="required" type="text"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_country">Country:</label></td>
                                                <td>
                                                    <input class="form-control" id="id_country" name="country"
                                                           required="required" type="text"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_state">State:</label></td>
                                                <td>
                                                    
                                                     <input class="form-control" id="id_state" name="state"
                                                           required="required" type="text"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_postalcode">Postalcode:</label></td>
                                                <td>
                                                    <input class="form-control" id="id_postalcode" name="postalcode"
                                                           required="required" type="text"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="width: 175px;">
                                                    <label for="id_phone">Phone:</label></td>
                                                <td>
                                                    <input class="form-control" id="id_phone" name="phone"  value="${u.phoneno}"type="text"/>
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                </div>
                            </div>
                            </div>
                          
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <div style="text-align: center;"><a data-toggle="collapse"
                                                                            data-parent="#accordion"
                                                                            href="#collapseThree"
                                                                            class=" btn   btn-success" id="payInfo"
                                                                            style="width:100%;display: none;" onclick="$(this).fadeOut();  
                   document.getElementById('collapseThree').scrollIntoView()">Enter Payment Information »</a>
                                        </div>
                                    </h4>
                                </div>
                          
                             </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                            <b>Payment Information</b>
                                        </a>
                                    </h4>
                                </div>
                                  </div>
                                <div id="collapseThree" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <span class='payment-errors'></span>
                                        <fieldset>
                                            <legend>What method would you like to pay with today?</legend>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label" for="card-holder-name">Name on
                                                    Card</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" stripe-data="name"
                                                           id="name-on-card" placeholder="Card Holder's Name">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label" for="card-number">Card
                                                    Number</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" stripe-data="number"
                                                           id="card-number" placeholder="Debit/Credit Card Number">
                                                    <br/>
                                                    <div><img class="pull-right"
                                                              src="https://s3.amazonaws.com/hiresnetwork/imgs/cc.png"
                                                              style="max-width: 250px; padding-bottom: 20px;">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="expiry-month">Expiration
                                                        Date</label>
                                                    <div class="col-sm-9">
                                                        <div class="row">
                                                            <div class="col-xs-3">
                                                                <select class="form-control col-sm-2"
                                                                        data-stripe="exp-month" id="card-exp-month"
                                                                        style="margin-left:5px;">
                                                                    <option>Month</option>
                                                                    <option value="01">Jan (01)</option>
                                                                    <option value="02">Feb (02)</option>
                                                                    <option value="03">Mar (03)</option>
                                                                    <option value="04">Apr (04)</option>
                                                                    <option value="05">May (05)</option>
                                                                    <option value="06">June (06)</option>
                                                                    <option value="07">July (07)</option>
                                                                    <option value="08">Aug (08)</option>
                                                                    <option value="09">Sep (09)</option>
                                                                    <option value="10">Oct (10)</option>
                                                                    <option value="11">Nov (11)</option>
                                                                    <option value="12">Dec (12)</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-xs-3">
                                                                <select class="form-control" data-stripe="exp-year"
                                                                        id="card-exp-year">
                                                                    <option value="2016">2016</option>
                                                                    <option value="2017">2017</option>
                                                                    <option value="2018">2018</option>
                                                                    <option value="2019">2019</option>
                                                                    <option value="2020">2020</option>
                                                                    <option value="2021">2021</option>
                                                                    <option value="2022">2022</option>
                                                                    <option value="2023">2023</option>
                                                                    <option value="2024">2024</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="cvv">Card CVC</label>
                                                    <div class="col-sm-3">
                                                        <input type="text" class="form-control" stripe-data="cvc"
                                                               id="card-cvc" placeholder="Security Code">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-offset-3 col-sm-9">
                                                    </div>
                                                </div>
                                        </fieldset>
                                        <input type="hidden" name="total" value="${gtot}"/>	
                                        <button type="submit" class="btn btn-success btn-lg" style="width:100%;">Confirm
                                           Order
                                        </button> </form>
                                        <br/>
                                        <div style="text-align: left;"><br/>
                                            By submiting this order you are agreeing to our <a href="/legal/billing/">universal
                                                billing agreement</a>, and <a href="/legal/terms/">terms of service</a>.
                                            If you have any questions about our products or services please contact us
                                            before placing this order.
                                        </div>
                                   
                                    
                                </div>
                            </div>
                    </div>
                </div>
               
            </div>
        
   
 
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>