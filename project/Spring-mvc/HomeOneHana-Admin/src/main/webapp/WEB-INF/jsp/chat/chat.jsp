<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>HomeOneHana::관리자모드</title>
	
    
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
              채팅페이지다
            </h2>
            <!-- CTA -->
            
          </div>
        </main>
      </div>
    </div>
  </body>
</html>