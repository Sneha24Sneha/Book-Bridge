<%-- 
    Document   : detail
    Created on : Apr 27, 2023, 12:20:39 PM
    Author     : hp
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.entity.bookdtl"%>
<%@page import="com.DAO.bookdao"%>
<%@page import="com.DB.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
         <%@include file="allcomponents/allcss.jsp" %>
        <%@include file="navbar.jsp" %>
        <%@page isELIgnored="false" %>
 <%@page  errorPage="404.jsp"%>
    </head>
    <body>
        <%
String BookId = request.getParameter("id");
int bookIdInt = 0;
if (BookId != null && BookId.matches("\\d+")) {
    bookIdInt = Integer.parseInt(BookId);
}
bookdao dao = new bookdao(DBConnect.getConnection());
bookdtl b = dao.getBooksByID(bookIdInt);
 
    
%>


<body>
 <%   
      user us =(user)session.getAttribute("CurrentUser");
      
     %>
<!-- app -->
<div id="app">
    
    <div class="page-detail" style="padding-top: 180px;">
        <div class="container">
            <!-- Product-Detail -->
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <!-- Product-zoom-area -->
                    <div class="zoom-area">
                        <img id="zoom-pro" class="img-fluid" src="book/<%=b.getBookpath()%>" data-zoom-image="images/product/product@4x.jpg" alt="Zoom Image" style="height:400px; width:500px;">
                        
                    </div>
                        <div class="color u-s-m-b-11" >

                            <h6 class="information-heading u-s-m-b-8">Location:</h6>
                            <span><%=b.getLocation()%>:</span>
                            <h6 class="information-heading u-s-m-b-8">Contact No.:</h6>
                            <span><%=b.getContact()%>:</span>
                            <h6 class="information-heading u-s-m-b-8">Email:</h6>
                            <span><%=b.getEmail()%>:</span>
                            </div>
                        <div class="touch-wrapper">
                        <div class="row">
                         <form action="https://mail.google.com/mail/u/0/?view=cm&to=<%=b.getEmail()%>" method="post">

                           
                            <div class="u-s-m-b-30">
                                <button type="submit" class="button button-outline-secondary">Send Email</button>
                                </div>
                                </form>
                          <% if(us==null){%>
                         <form action="login.jsp" method="post">

                           
                            <div class="u-s-m-b-30">
                                <button type="submit" class="button button-outline-secondary">Wish List</button>
                                </div>
                                </form>
                          <% }  else{%>
                          <form action="AddToWishlistServlet?useremail=<%=us.getEmailid()%> &bookId=<%= b.getBookId() %>" method="post">

                           
                            <div class="u-s-m-b-30">
                                <button type="submit" class="button button-outline-secondary">Wish List</button>
                                </div>
                                </form>
                               
                                                <%}%>
                                
                            
                        
                    </div>
                        </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <!-- Product-details -->
                    <div class="all-information-wrapper">
                        <div class="section-1-title-breadcrumb-rating">
                            <div class="product-title">
                                <h1>
                                    <a href="single-product.html"><%=b.getBookName()%></a>
                                </h1>
                            </div>
                            

                        </div>
                        <div class="section-2-short-description u-s-p-y-14">
                            <h6 class="information-heading u-s-m-b-8">Description:</h6>
                            <p><%=b.getDescription()%>
                            </p>
                        </div>
                           
                        <div class="section-3-price-original-discount u-s-p-y-14">
                            <div class="price">
                                <h4><%=b.getPrice()%></h4>
                            </div>
                            <div class="original-price">
                                <span>Original Price:</span>
                                <span><%=b.getBookMRP()%></span>
                            </div>
<!--                            <div class="discount-price">
                                <span>Discount:</span>
                                <span>8%</span>
                            </div>
                            <div class="total-save">
                                <span>Save:</span>
                                <span></span>
                            </div>-->
                        </div>
                            <div class="section-4-sku-information u-s-p-y-14">
                            <h6 class="information-heading u-s-m-b-8">Book Category:</h6>
                            <div class="availability">
                                <span>Category:</span>
                                <span><%=b.getBookCategiries()%></span>
                            </div>
                            <div class="left">
                                <span>Sub Category:</span>
                                <span><%=b.getSubCategiries()%></span>
                            </div>
                        </div>
                        <div class="section-4-sku-information u-s-p-y-14">
                            <h6 class="information-heading u-s-m-b-8">Book Detail:</h6>
                            <div class="availability">
                                <span>Author Name:</span>
                                <span><%=b.getAuthorName()%></span>
                            </div>
                            <div class="left">
                                <span>Addition Year:</span>
                                <span><%=b.getAdditionYear()%></span>
                            </div>
                        </div>
                        <div class="section-5-product-variants u-s-p-y-14">
                            
                            <h6 class="information-heading u-s-m-b-8">Deal Type:</h6>
                            <div class="color u-s-m-b-11">
                                <span><%=b.getDealType()%>:</span>
                            </div>
                           
                            <div class="color u-s-m-b-11">

                            <h6 class="information-heading u-s-m-b-8">Quantity:</h6>
                            <span><%=b.getBookMRP()%>:</span>
                            </div>
                                </div>
                            </div>
                        </div>
                                                       
                                </div>
                               
                            </form>
                        </div>
                    </div>
                    <!-- Product-details /- -->
                </div>
            </div>
            <!-- Product-Detail /- -->
            <!-- Detail-Tabs -->
           <%@include file="Footer.jsp" %>

<noscript>
    <div class="app-issue">
        <div class="vertical-center">
            <div class="text-center">
                <h1>JavaScript is disabled in your browser.</h1>
                <span>Please enable JavaScript in your browser or upgrade to a JavaScript-capable browser to register for Groover.</span>
            </div>
        </div>
    </div>
    <style>
    #app {
        display: none;
    }
    </style>
</noscript>
<!-- Google Analytics: change UA-XXXXX-Y to be your site's ID. -->
<script>
window.ga = function() {
    ga.q.push(arguments)
};
ga.q = [];
ga.l = +new Date;
ga('create', 'UA-XXXXX-Y', 'auto');
ga('send', 'pageview')
</script>
<script src="https://www.google-analytics.com/analytics.js" async defer></script>
<!-- Modernizr-JS -->
<script type="text/javascript" src="js/vendor/modernizr-custom.min.js"></script>
<!-- NProgress -->
<script type="text/javascript" src="js/nprogress.min.js"></script>
<!-- jQuery -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- Bootstrap JS -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- Popper -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- ScrollUp -->
<script type="text/javascript" src="js/jquery.scrollUp.min.js"></script>
<!-- Elevate Zoom -->
<script type="text/javascript" src="js/jquery.elevatezoom.min.js"></script>
<!-- jquery-ui-range-slider -->
<script type="text/javascript" src="js/jquery-ui.range-slider.min.js"></script>
<!-- jQuery Slim-Scroll -->
<script type="text/javascript" src="js/jquery.slimscroll.min.js"></script>
<!-- jQuery Resize-Select -->
<script type="text/javascript" src="js/jquery.resize-select.min.js"></script>
<!-- jQuery Custom Mega Menu -->
<script type="text/javascript" src="js/jquery.custom-megamenu.min.js"></script>
<!-- jQuery Countdown -->
<script type="text/javascript" src="js/jquery.custom-countdown.min.js"></script>
<!-- Owl Carousel -->
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
<!-- Main -->
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>

   