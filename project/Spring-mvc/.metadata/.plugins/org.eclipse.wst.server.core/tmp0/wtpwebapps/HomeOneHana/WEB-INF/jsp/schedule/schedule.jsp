<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeOneHana::모집일정</title>
<link href="${ pageContext.request.contextPath }/resources/css/top/menubg.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${ pageContext.request.contextPath }/resources/css/schedule/schedule.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<header>
		<div class="limiter">
			<div class="container-login100">
				<div class="wrap-login100">
					<jsp:include page="../include/topMenu.jsp" />
				</div>
			</div>
		</div>
	</header>
	
	<section class="ftco-section">
		<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section"></h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
					<table class="table table-bordered text-center">
             <thead>
               <tr>
                 <th style="color:#e90061;">Sunday</th>
                 <th>Monday</th>
                 <th>Tuesday</th>
                 <th>Wednesday</th>
                 <th>Thursday</th>
                 <th>Friday</th>
                 <th style="color:#008485;">Saturday</th>
               </tr>
             </thead>
             <tbody class="dates">
             </tbody>
             <tfoot>
               <tr>
                 <th><button href="#" id="beforeMonth" class="calbtn beforeMonth" onclick="prevMonth()"></button></th>
                 <th></th>
                 <th></th>
                 <th><button href="#" id="thisMonth" class="calbtn" onclick="goToday()">Today</button></th>
                 <th></th>
                 <th></th>
                 
                 <th><button href="#" id="afterMonth" class="calbtn afterMonth" onclick="nextMonth()"></button></th>
               </tr>
             </tfoot>
           </table>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered  modal-lg" role="document">

	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle" style="font-weight:700;">모집공고</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	      </div>
	    </div>

	  </div>
	</div>
	
	<script src="${ pageContext.request.contextPath }/resources/js/schedule/schedule.js"></script>
	<footer>
		<jsp:include page="../include/bottomMenu.jsp" />
	</footer>
</body>
</html>

