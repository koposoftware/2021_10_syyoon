<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
        <meta charset="utf-8">
        <title>HomeOneHana</title>
    </head>
	<body data-spy="scroll" data-target=".navbar" data-offset="51">
        <!-- Nav Bar Start -->
        <jsp:include page="include/topMenu.jsp" />
        <!-- Nav Bar End -->

        <!-- Hero Start -->
        <div class="hero" id="home">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-sm-12 col-md-6">
                        <div class="hero-content">
                            <div class="hero-text">
                            	<c:if test="${ empty sessionScope.loginVO }">
	                                <p>전국 모든 임대주택을 한 눈에!</p>
	                                <h1>Home One Hana</h1>                            	
                            	</c:if>
                            	<c:if test="${ not empty sessionScope.loginVO }">
                            		<p>전국 모든 임대주택을 한 눈에!</p>
	                                <h1><c:out value="${ sessionScope.loginVO.name }님 환영합니다!"/></h1> 
                            	</c:if>
                                <h2></h2>
                                <div class="typed-text">행복주택, 공공임대, 매입임대, 전세임대, 국민임대</div>
                            </div>
                            <div class="hero-btn">
                            	<c:if test="${ empty sessionScope.loginVO }">
                                <a class="btn" href="${ pageContext.request.contextPath }/login">Log In</a>
                                <a class="btn" href="${ pageContext.request.contextPath }/signup">Join</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6 d-none d-md-block">
                        <div class="hero-image" style="width:421px; height:600px;">
                            <!-- <img src="img/hero.png" alt="Hero Image"> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->


		<!-- Latest Announcement Start -->
        <div class="portfolio" id="portfolio">
            <div class="container">
                <div class="section-header text-center wow zoomIn" data-wow-delay="0.1s">
                    <p>Announcement</p>
                    <h2>Today's News</h2>
                </div>
                <div class="row">
                    <div class="col-12">
                        <ul id="portfolio-filter">
                            <li data-filter="*" class="filter-active">전체</li>
                            <li data-filter=".filter-1">행복주택</li>
                            <li data-filter=".filter-2">매입임대</li>
                            <li data-filter=".filter-3">국민임대</li>
                            <li data-filter=".filter-4">전세임대</li>
                        </ul>
                    </div>
                </div>
                <div class="row portfolio-container">
                    <div class="col-lg-4 col-md-6 col-sm-12 portfolio-item filter-1 wow fadeInUp" data-wow-delay="0.0s">
                        <div class="portfolio-wrap">
                            <div class="portfolio-img">
                                <img src="${ pageContext.request.contextPath }/resources/img/home/portfolio-1.jpg" alt="Image">
                            </div>
                            <div class="portfolio-text">
                                <h3>eCommerce Website</h3>
                                <a class="btn" href="${ pageContext.request.contextPath }/resources/img/home/portfolio-1.jpg" data-lightbox="portfolio">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 portfolio-item filter-2 wow fadeInUp" data-wow-delay="0.2s">
                        <div class="portfolio-wrap">
                            <div class="portfolio-img">
                                <img src="${ pageContext.request.contextPath }/resources/img/home/portfolio-2.jpg" alt="Image">
                            </div>
                            <div class="portfolio-text">
                                <h3>Product Landing Page</h3>
                                <a class="btn" href="${ pageContext.request.contextPath }/resources/img/home/portfolio-2.jpg" data-lightbox="portfolio">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 portfolio-item filter-3 wow fadeInUp" data-wow-delay="0.4s">
                        <div class="portfolio-wrap">
                            <div class="portfolio-img">
                                <img src="${ pageContext.request.contextPath }/resources/img/home/portfolio-3.jpg" alt="Image">
                            </div>
                            <div class="portfolio-text">
                                <h3>JavaScript quiz game</h3>
                                <a class="btn" href="${ pageContext.request.contextPath }/resources/img/home/portfolio-3.jpg" data-lightbox="portfolio">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 portfolio-item filter-1 wow fadeInUp" data-wow-delay="0.6s">
                        <div class="portfolio-wrap">
                            <div class="portfolio-img">
                                <img src="${ pageContext.request.contextPath }/resources/img/home/portfolio-4.jpg" alt="Image">
                            </div>
                            <div class="portfolio-text">
                                <h3>JavaScript drawing</h3>
                                <a class="btn" href="${ pageContext.request.contextPath }/resources/img/home/portfolio-4.jpg" data-lightbox="portfolio">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 portfolio-item filter-2 wow fadeInUp" data-wow-delay="0.8s">
                        <div class="portfolio-wrap">
                            <div class="portfolio-img">
                                <img src="${ pageContext.request.contextPath }/resources/img/home/portfolio-5.jpg" alt="Image">
                            </div>
                            <div class="portfolio-text">
                                <h3>Social Mobile Apps</h3>
                                <a class="btn" href="${ pageContext.request.contextPath }/resources/img/home/portfolio-5.jpg" data-lightbox="portfolio">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 portfolio-item filter-4 wow fadeInUp" data-wow-delay="1s">
                        <div class="portfolio-wrap">
                            <div class="portfolio-img">
                                <img src="${ pageContext.request.contextPath }/resources/img/home/portfolio-6.jpg" alt="Image">
                            </div>
                            <div class="portfolio-text">
                                <h3>Company Website</h3>
                                <a class="btn" href="${ pageContext.request.contextPath }/resources/img/home/portfolio-6.jpg" data-lightbox="portfolio">+</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Latest Announcement End -->
        
       


        <!-- Footer Start -->
        <jsp:include page="include/bottomMenu.jsp" />
        
        
    </body>
</html>
