<%-- 
    Document   : AllBooks
    Created on : May 7, 2023, 1:55:52 PM
    Author     : hp
--%>

<%@page import="com.entity.user"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.bookdao"%>
<%@page import="com.entity.bookdtl"%>
<%@page import="com.DB.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Books</title>
        <%@include file="allcomponents/allcss.jsp" %>
        <%@page isELIgnored="false" %>
 <%@page  errorPage="404.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <%   
      user us =(user)session.getAttribute("CurrentUser");
      
     %>
     <section id="all-products" class="section-maker">
        <div class="container">
            <div class="sec-maker-header text-center">
                <h3 class="sec-maker-h3">OLD BOOKS</h3>
                <ul class="nav tab-nav-style-1-a justify-content-center">
                    <li class="nav-item">
                        <a href="AllBooks.jsp?Cat=All#fixed-products">All</a>
                    </li>
                    <li class="nav-item">
                        <a href="AllBooks.jsp?Cat=Fixed#fixed-products">Fixed Rate</a>
                    </li>
                    <li class="nav-item">
                        <a href="AllBooks.jsp?Cat=Negotiabile#fixed-products">Negotiable</a>
                    </li>
                    
                </ul>
            </div>
        </div>
        <div id="fixed-products" class="container">
  <div class="row">
    
         <%
    String cat = request.getParameter("Cat");
    bookdao dao = new bookdao(DBConnect.getConnection());
    List<bookdtl> list = null;

    if (cat != null && cat.trim().equals("Fixed")) {
        list = dao.getBooksByFixed();
    } else if(cat != null && cat.trim().equals("Negotiabile")){
         list = dao.getBooksByNegotiabile();
    }
    else{
    list = dao.getAllProducts();
             }
             int limit = 2;
int i=1;
    for (bookdtl b : list) {
     
   
    
%> 
<!-- code to display book details goes here -->


                      
             <div class="col-md-3">
             <div class="item" >
                                        <div class="image-container">
                                            <a class="item-img-wrapper-link" href="single-product.html">
                                                <img class="img-fluid" src="book/<%=b.getBookpath()%>" alt="Product" style="height:200px; width:300px;">
                                            </a>
                                            <div class="item-action-behaviors" >
                                                <ul style="list-style: none; color:black;">
                                                    <li ><a data-toggle="modal" href="detail.jsp?id=<%=b.getBookId()%>" style=" color:#ffffff;"><img class="img-fluid" src="img/search.png" alt="Product" style="height:20px; width:20px;">Quick Look
                                                        </a></li>
                                                        <li>
                                               <% if(us==null){%>
                                                   <a href="login.jsp" style=" color:#ffffff;"><img class="img-fluid" src="img/wish.png" alt="Product" style="height:20px; width:20px;"> Wishlist</a>

                                                    <% }  else{%>
                                                  
                                                   <a href="AddToWishlistServlet?useremail=<%=us.getEmailid()%> &bookId=<%= b.getBookId() %>" style=" color:#ffffff;"><img class="img-fluid" src="img/wish.png" alt="Product" style="height:20px; width:20px;"> Wishlist</a>

                                                <%}%>
                                                        </li> </ul>
                                            </div>
                                                      <!-- add wishlist button below the image -->
                                            </div>
                                        
                 <div class="item-content">
                                            <div class="what-product-is">
                                                <ul class="bread-crumb">
                                                    <li class="has-separator">
                                                       <%=b.getBookCategiries()%>
                                                    </li>
                                                    <li class="has-separator">
                                                        <%=b.getSubCategiries()%>
                                                    </li>
                                                    <li>
                                                        <%=b.getAuthorName()%>
                                                    </li>
                                                     <li>
                                                        <%=b.getAdditionYear()%>
                                                    </li>
                                                </ul>
                                                <h4 class="item-title">
                                                    <%=b.getBookName()%>
                                                </h4>
                                                <h7 class="item-title">
                                                    <%=b.getLocation()%>
                                                </h7>
                                                
                                                <div class="item-stars">
                                                    <div class='star' title="0 out of 5 - based on 0 Reviews">
                                                        <span style='width:0'></span>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                            <div class="price-template">
                                                <div class="item-new-price">
                                                   <%=b.getBookMRP()%>
                                                </div>
                                                <div class="item-old-price">
                                                   <%=b.getPrice()%>
                                                </div>
                                            </div>
                                        </div>
                                                <div class="tag new" style="color:red; background-color:yellow;">
                                            <span><%=b.getDealType()%></span>
                                        </div>
                                         </div></div>
                                         
                                                       <% 
                                                        }%>
   
             </div></div>
                                    </section>
                                                             

<%@include file="Footer.jsp" %>

                                                       </section>
  <script src="https://www.google-analytics.com/analytics.js" async defer></script>

<script  src="allcomponents/SellformStyle.js"></script>


</body>
</html>
