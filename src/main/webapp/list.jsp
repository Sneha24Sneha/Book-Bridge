<%-- 
    Document   : booklist
    Created on : Apr 26, 2023, 10:11:20 PM
    Author     : hp
--%>

<%@page import="java.util.List"%>
<%@page import="com.entity.bookdtl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="allcomponents/allcss.jsp" %>
        <%@page isELIgnored="false" %>
 <%@page  errorPage="404.jsp"%>
         <%@page import="com.DB.DBConnect"%>
    </head>
    <body>
<%@include file="navbar.jsp" %>
   <style>.card-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 1rem; /* optional, adds space between cards */
}

.card {
  background-color: #f2f2f2;
  padding: 1rem;
}
</style>
  <%   
      user us =(user)session.getAttribute("CurrentUser");
      
     %>

      <div class="hero">
    
    
    
       <form action="SearchServlet" method="get" CLASS="form-box">
          <h1 style="color:white;">FIND BOOKS NEAR YOU</h1>
    <div class="form-box">
        <input type="text" class="search-field business" placeholder="What are you looking for...." name="bookName">
         <select id="categories"  class="search-field business" name="category"  required>
                                           <!-- Options will be dynamically populated using JavaScript -->
                                           '<option value="">Select Category</option>' +
                           '<option value="school">School Books</option>' +
                           '<option value="Academic Books">Academic Books</option>' +
                           '<option value="Competitive">Competitive Exams Books</option>'+
                            '<option value="Magazines">Magazines</option>';
         </select>
              
        <input type="text" class="search-field location" placeholder="Location..." name="location">
        <button class="search-btn" type="submit">Search</button>
    </div>
</form>
     
    </div>
        <section id="search-results">
     <% if (request.getAttribute("books") != null && ((List<bookdtl>) request.getAttribute("books")).size() > 0) { %>
     <h2 style="color:slateblue;"><center>Search Results</center></h2>
     <div id="fixed-products" class="container">
  <div class="row">
            <% for (bookdtl book : (List<bookdtl>) request.getAttribute("books")) { %>
                          
             <div class="col-md-3">
             <div class="item" >
                                        <div class="image-container">
                                            <a class="item-img-wrapper-link" href="single-product.html">
                                                <img class="img-fluid" src="book/<%=book.getBookpath()%>" alt="Product" style="height:200px; width:300px;">
                                            </a>
                                            <div class="item-action-behaviors" >
                                                <ul style="list-style: none; color:black;">
                                                    <li ><a data-toggle="modal" href="detail.jsp?id=<%=book.getBookId()%>" style=" color:#ffffff;"><img class="img-fluid" src="img/search.png" alt="Product" style="height:20px; width:20px;">Quick Look
                                                        </a></li>
                                                        <li>
                                               <% if(us==null){%>
                                                   <a href="login.jsp" style=" color:#ffffff;"><img class="img-fluid" src="img/wish.png" alt="Product" style="height:20px; width:20px;"> Wishlist</a>

                                                    <% }  else{%>
                                                  
                                                   <a href="AddToWishlistServlet?useremail=<%=us.getEmailid()%> &bookId=<%= book.getBookId() %>" style=" color:#ffffff;"><img class="img-fluid" src="img/wish.png" alt="Product" style="height:20px; width:20px;"> Wishlist</a>

                                                <%}%>
                                                        </li> </ul>
                                            </div>
                                                      <!-- add wishlist button below the image -->
                                            </div>
                                        
                 <div class="item-content">
                                            <div class="what-product-is">
                                                <ul class="bread-crumb">
                                                    <li class="has-separator">
                                                       <%=book.getBookCategiries()%>
                                                    </li>
                                                    <li class="has-separator">
                                                        <%=book.getSubCategiries()%>
                                                    </li>
                                                    <li>
                                                        <%=book.getAuthorName()%>
                                                    </li>
                                                     <li>
                                                        <%=book.getAdditionYear()%>
                                                    </li>
                                                </ul>
                                                <h4 class="item-title">
                                                    <%=book.getBookName()%>
                                                </h4>
                                                <h7 class="item-title">
                                                    <%=book.getLocation()%>
                                                </h7>
                                                
                                                <div class="item-stars">
                                                    <div class='star' title="0 out of 5 - based on 0 Reviews">
                                                        <span style='width:0'></span>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                            <div class="price-template">
                                                <div class="item-new-price">
                                                   <%=book.getBookMRP()%>
                                                </div>
                                                <div class="item-old-price">
                                                   <%=book.getPrice()%>
                                                </div>
                                            </div>
                                        </div>
                                                <div class="tag new" style="color:red; background-color:yellow;">
                                            <span><%=book.getDealType()%></span>
                                        </div>
                                         </div></div>
            <% } %>
            </div></div>
        
<% } else { %>
    <p>No results found.</p>
<% } %>

</section>
<%@include file="Footer.jsp" %>
    </body>
</html>
