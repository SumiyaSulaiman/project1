<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <div class="col-xs-3">
    <div class="thumbnail">
      <a href="./resources/woman.png">
        <img src="./resources/woman.png" >
        <div class="caption">
          <p></p><p>Marvel Ultimate Spiderman 20T<br>Rs.5,750/-</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-xs-3">
    <div class="thumbnail" >
      <a href="./resources/woman2.jpg">
        <img src="./resources/woman2.jpg" >
        <div class="caption">
          <p>Captain America 20T<br>Rs.6,625/-</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-xs-3">
    <div class="thumbnail">
      <a href="./resources/woman3.jpeg">
        <img src="./resources/woman3.jpeg">
        <div class="caption">
          <p>Avengers - Age of Ultrons 20T<br>Rs.6,700/-</p>
        </div>
      </a>
    </div>
  </div> 
  
  
</div>



<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>