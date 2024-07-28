<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="/partial/Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="home">Home</a></li>
                                 <c:if test="${tag != null }">
	                                 <c:forEach items="${listCC}" var="o">
	                                 	<c:if test="${tag == o.cid}">
	                                 		<li class="breadcrumb-item active" aria-current="#">${o.cname}</li>
	                                 	</c:if>
						            </c:forEach>
					            </c:if>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="/partial/Left.jsp"></jsp:include>

                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach items="${listP}" var="o">
                            <div class="col-12 col-md-6 col-lg-4 pb-4">
                            	<form action="cart?pid=${o.id}" method="post" style="display:inline;">
	                                <div class="card">
	                                    <img class="card-img-top" style="object-fit: cover;height: 250px;"src="${o.image}" alt="Card image cap">
	                                    <div class="card-body">
	                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
	                                        <p class="card-text show_txt">${o.title}</p>
	                                        <div class="row">
	                                            <div class="col">
	                                                <p class="btn btn-danger btn-block">${o.price} $</p>
	                                            </div>
	                                            <div class="col">
	                                            	<input type="submit" class="btn btn-success btn-block" value="Add to cart">
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                        	</form>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>

        <jsp:include page="/partial/Footer.jsp"></jsp:include>
    </body>
</html>

