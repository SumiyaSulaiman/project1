<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	
.item-photo{display:flex;justify-content:center;align-items:center;border-right:1px solid #f6f6f6;}
.menu-items{list-style-type:none;font-size:11px;display:inline-flex;margin-bottom:0;margin-top:20px}
.btn-success{width:100%;border-radius:0;}
.section{width:100%;margin-left:-15px;padding:2px;padding-left:15px;padding-right:15px;background:#f8f9f9}
.title-price{margin-top:30px;margin-bottom:0;color:black}
.title-attr{margin-top:0;margin-bottom:0;color:black;}
.btn-minus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-right:0;}
.btn-plus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-left:0;}
div.section > div {width:100%;display:inline-flex;}
div.section > div > input {margin:0;padding-left:5px;font-size:10px;padding-right:5px;max-width:18%;text-align:center;}
.attr,.attr2{cursor:pointer;margin-right:5px;height:20px;font-size:10px;padding:2px;border:1px solid gray;border-radius:2px;}
.attr.active,.attr2.active{ border:1px solid orange;}

@media (max-width: 426px) {
    .container {margin-top:0px !important;}
    .container > .row{padding:0 !important;}
    .container > .row > .col-xs-12.col-sm-5{
        padding-right:0 ;    
    }
    .container > .row > .col-xs-12.col-sm-9 > div > p{
        padding-left:0 !important;
        padding-right:0 !important;
    }
    .container > .row > .col-xs-12.col-sm-9 > div > ul{
        padding-left:10px !important;
        
    }            
    .section{width:104%;}
    .menu-items{padding-left:0;}
}
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
		<br><br>
		<br>
		<br>
        <div class="container">
        	<div class="row">
               <div class="col-xs-4 item-photo">
                    <img style="max-width:100%;" src="${pageContext.request.contextPath}/resources/images/${p.productid}.jpg"  />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                   
                     <h1> ${p.productname}</h1>    
                     <h5 style="color:#337ab7"> ${p.productdescription}</h5>
        
                    <!-- Precios -->
                    <!-- <h3 class="title-price">PRICE</h3> -->
                    <br>
                    <h3 style="margin-top:0px;">Rs.${p.price}</h3>
       
                  <!--  
                    <div class="section">
                        <h6 class="title-attr" style="margin-top:15px;" ><small>COLOR</small></h6>                    
                        <div>
                            <div class="attr" background:#5a5a5a;"></div>
                            <div class="attr" style="width:25px;background:white;"></div>
                        </div>
                    </div> -->
                                  
                     
                 		 <h4 class="title-attr" style="margin-top:15px;">Stock</h4>  
                 		 <p></p>              
                        <div class="form" >
                    		
								
								 <div class="attr" style="width:50px";> ${p.stock}</div>
				
							
                   		 </div>  
                       
                    <form action="${pageContext.request.contextPath}/user/addcart" method="POST">
                   
                        <h4 >Quantity</h4>
                       <div class="form" style="width:50px";>
                    		
								
								<input type="number" class="form-control text-center" value="1" min="1" name="qty">
				
							
                   		 </div>  
                     
                     <input type="hidden" value="${p.productid}" name="productid">
                    <br><br>
                    <div class="section" style="padding-bottom:20px;">
                    	<center>
                        <button type="submit" class="btn btn-success"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to cart</button> </form> 
                        </center>
                    </div> 
                                                         
                                        
         	
            </div>
        </div> 
        
    <script>
    $(document).ready(function(){
        //-- Click on detail
        $("ul.menu-items > li").on("click",function(){
            $("ul.menu-items > li").removeClass("active");
            $(this).addClass("active");
        })

        $(".attr,.attr2").on("click",function(){
            var clase = $(this).attr("class");

            $("." + clase).removeClass("active");
            $(this).addClass("active");
        })

        //-- Click on QUANTITY
        $(".btn-minus").on("click",function(){
            var now = $(".section > div > input").val();
            if ($.isNumeric(now)){
                if (parseInt(now) -1 > 0){ now--;}
                $(".section > div > input").val(now);
            }else{
                $(".section > div > input").val("1");
            }
        })            
        $(".btn-plus").on("click",function(){
            var now = $(".section > div > input").val();
            if ($.isNumeric(now)){
                $(".section > div > input").val(parseInt(now)+1);
            }else{
                $(".section > div > input").val("1");
            }
        })                        
    }) 
    </script>
    <jsp:include page="footer.jsp"></jsp:include>       
    </body>
</html>

