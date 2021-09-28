<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>HomeOneHana::일정관리</title>
	<!-- jquery CDN -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


     <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/schedule/schedule.css"/>

	<!-- fullcalendar CDN -->
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.0/main.min.css">

	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.0/main.min.js"></script>
	<!-- fullcalendar 언어 CDN -->
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.0/locales-all.min.js"></script>
	
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			var content = '<span class="absolute inset-y-0 left-0 w-1 bg-purple-600 rounded-tr-lg rounded-br-lg" aria-hidden="true"></span>'
			$(content).prependTo('#calaenderMenu')    	  
			
		})
	</script>
    
  </head>
  <body>
    <div
      class="flex h-screen bg-gray-50 dark:bg-gray-900"
      :class="{ 'overflow-hidden': isSideMenuOpen }"
    >
		<jsp:include page="../include/sider.jsp" />
      <!-- Backdrop -->
      
      <div class="flex flex-col flex-1 w-full">
      	<jsp:include page="../include/header.jsp" />
      	
      	
        <main class="h-full overflow-y-auto">
          <div class="container px-6 mx-auto grid">
            <h2
              class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200"
            >
              스케쥴관리해봐~
            </h2>
            <!-- CTA -->
            <div class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
            	<div id='calendar-container'>
					<div id='calendar'></div>
				</div>
			</div>

            
          </div>
          
        </main>
      		<script src="${ pageContext.request.contextPath }/resources/js/schedule/schedule.js"></script>
      </div>
    </div>
  </body>
</html>
