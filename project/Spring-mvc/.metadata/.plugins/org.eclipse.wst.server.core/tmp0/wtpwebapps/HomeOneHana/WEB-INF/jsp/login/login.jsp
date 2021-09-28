<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
  <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
   
   <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/login/kakaoLogin.js"></script>
  <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/login/login.css">
  
  

  
</head>
<body>
  <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
      <div class="card login-card">
        <div class="row no-gutters">
          <div class="col-md-5">
            <img src="${ pageContext.request.contextPath }/resources/img/login/login.jpg" alt="login" class="login-card-img">
          </div>
          <div class="col-md-7">
            <div class="card-body">
              <div class="brand-wrapper">
                <a href="${ pageContext.request.contextPath }/" alt="logo" class="logo">HomeOneHana</a>
              </div>
              <p class="login-card-description">Sign into your account</p>
              	<form id="subfrm" action="#" method="post" name="loginForm">
	                  <div class="form-group">
	                    <label for="id" class="sr-only">ID</label>
	                    <input type="text" name="id" id="id" class="form-control" placeholder="아이디">
	                  </div>
	                  <div class="form-group mb-4">
	                    <label for="password" class="sr-only">Password</label>
	                    <input type="password" name="password" id="password" class="form-control" placeholder="***********">
	                  </div>
	                  <input name="login" id="login" class="btn btn-block login-btn mb-4" type="submit" value="Login">
                </form>
                <a href="#!" class="forgot-password-link">비밀번호를 잊으셨나요?</a>
                <p class="login-card-footer-text">계정이 없으신가요? <a href="#!" class="text-reset">회원가입</a></p>
                <nav class="login-card-footer-nav">
                  <button class="log-btn kakao" onclick="kakaoLogin();">
                  		<span href="javascript:void(0)" >
	                  	<i class="fas fa-comment"></i> 카카오톡으로 로그인                  	                  		
                  		</span>
                  	</button>	
                  
                </nav>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
  

</body>
</html>
