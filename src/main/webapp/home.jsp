

<%@page import="com.user.servlet.book"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.bookdtl"%>
<%@page import="com.DAO.bookdao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
         <%@include file="allcomponents/allcss.jsp" %>
          <%@page isELIgnored="false" %>
 <%@page  errorPage="404.jsp"%>
         <%@page import="com.DB.DBConnect"%>
          <link href="favicon.ico" rel="shortcut icon">
    
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
      <section>
        <div class="box-container">
          
            <div class="container-hover effect-border-scaling-gray">
                <div class="text" style="font-family: 'Raleway'">
            <p>Our website allows users to easily buy and sell old books in their local area. 
                <br>Sellers can post 
            their book details along with their location, making it easy for buyers to find the books 
           they're looking for in their area. 
               <br>Buyers can search for books based on their own location, 
            and contact the seller directly to purchase the book. With our platform, you can easily 
            connect with other book enthusiasts in your local area and find the books you've been searching for.</p>
            <p style="color:yellow;"><b>"One person's old book is another person's treasure. Buying and selling used books is a win-win situation for everyone involved.."</b></P>
          </div>
          </div>
        </div>
        </section>


 
    <section id="all-products" class="section-maker">
        <div class="container">
            <div class="sec-maker-header text-center">
                <h3 class="sec-maker-h3">OLD BOOKS</h3>
                <ul class="nav tab-nav-style-1-a justify-content-center">
                    <li class="nav-item">
                        <a href="home.jsp?Cat=All#fixed-products">All</a>
                    </li>
                    <li class="nav-item">
                        <a href="home.jsp?Cat=Fixed#fixed-products">Fixed Rate</a>
                    </li>
                    <li class="nav-item">
                        <a href="home.jsp?Cat=Negotiabile#fixed-products">Negotiable</a>
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
                                       <div class="redirect-link-wrapper text-center u-s-p-t-25 u-s-p-b-80">
                <a class="redirect-link" href="AllBooks.jsp">
                    <span>View all books on site</span>
                </a>
            
                                                       <a class="continue-link" href="AllBooks.jsp" title="View all book on site">
                                                           <center>  <img class="img-fluid" src="img/circles-menu-1.gif" style="height: 5%;width:5%;"/></center>
        </a>
         </div>                                                

<%@include file="Footer.jsp" %>

                                                       </section>
  <script src="https://www.google-analytics.com/analytics.js" async defer></script>

<script  src="allcomponents/SellformStyle.js"></script>


</body>
</html>