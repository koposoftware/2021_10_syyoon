<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeOneHana::회원가입</title>
<link
	href="${ pageContext.request.contextPath }/resources/css/top/menubg.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath }/resources/css/join/joinForm.css">
	
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<!-- kakao 우편번호 -->
<script 
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/join/joinForm-postcode.js"></script>

<script 
	src="${ pageContext.request.contextPath }/resources/js/join/joinForm.js"></script>


</head>
<body>
	<header>
		<div class="limiter">
			<div>
				<div>
					<jsp:include page="../include/topMenu.jsp" />
				</div>
			</div>
		</div>

	</header>
	<section>


		<div class="limiter">
			<div class="container-login100">
				<div class="wrap-login100">
					<div class="login100-form-title">
						<span class="login100-form-title-1"> 회원가입 </span>
					</div>
					<form class="login100-form validate-form" action="#" method="post">

						<!-- ID -->
						<div class="wrap-input100 validate-input m-b-26 input65"
							data-validate="아이디를 입력하세요!">
							<span class="label-input100">아이디</span> <input class="input100"
								type="text" name="id" id="id" placeholder="아이디"> <span
								class="focus-input100"></span>
						</div>
						<button type="button" id="idchkBtn" class="ckbtn" data-toggle="modal" data-target="#exampleModal">중복확인</button>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">ID중복확인</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        ...
						      </div>
						      <div class="modal-footer">
						        <button type="button" id="closeBtn" class="clsbtn" data-dismiss="modal">닫기</button>
						        <button type="button" id="useBtn" class="btn btn-primary" data-dismiss="modal">사용</button>
						      </div>
						    </div>
						  </div>
						</div>


						<!-- 비밀번호 -->
						<div class="wrap-input100 validate-input m-b-18"
							data-validate="비밀번호를 입력하세요!">
							<span class="label-input100">비밀번호</span> <input id="password"
								class="input100" type="password" name="password"
								placeholder="***********"> <span class="focus-input100"></span>
						</div>
						<!-- 비번확인 -->
						<div class="wrap-input100 validate-input m-b-18 input65"
							data-validate="비밀번호를 입력하세요!">
							<span class="label-input100">비밀번호확인</span> <input id="ckpassword"
								class="input100" type="password" name="ckpassword"
								placeholder="***********"> <span class="focus-input100"></span>
						</div>
						<span class="pwerrmsg" id="errpwd" style="color:#E90061;">일치하지 않습니다.</span>
						<span class="pwerrmsg" id="corpwd" style="color:#008485;">일치합니다.</span>


						<!-- 이름 -->
						<div class="wrap-input100 validate-input m-b-26"
							data-validate="이름을 입력하세요!">
							<span class="label-input100">이름</span> <input class="input100"
								type="text" name="name" placeholder="이름"> <span
								class="focus-input100"></span>
						</div>

						<!-- 주민번호 -->
						<div class="wrap-input100 validate-input m-b-18 input45"
							data-validate="주민번호를 입력하세요!">
							<span class="label-input100">주민등록번호</span> <input
								class="input100" type="text" name="rescode1" size="6"
								maxlength="6" class="focus-input100"><span
								class="focus-input100"></span>
						</div>
						<span style="margin-top: 13px;">-</span>
						<div class="wrap-input100 validate-input m-b-18 input45"
							data-validate="주민번호를 입력하세요!">
							<input class="input100" type="password" name="rescode2" size="7"
								maxlength="7" placeholder="*******"><span
								class="focus-input100"></span>
						</div>


						
						<!-- 휴대전화 확인 -->
						<div class="wrap-input100 validate-input m-b-18 input65">
							<span class="label-input100">휴대전화</span> <input id="tel"
								class="input100" type="text" name="phoneNumber"
								placeholder="-는 제외하고 입력하세요."> <span class="focus-input100"></span>
						</div>
					
						
						<button type="button" id="phoneckBtn" class="ckbtn" data-toggle="modal" data-target="#exampleModal2">인증메시지보내기</button>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">전화번호 인증하기</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body" style="display:flex;">
						        <div class="wrap-input100 validate-input m-b-18 input65">

										<input id="tel"
											class="input100" type="text" name="phonecertificate"
											placeholder="인증번호를 입력하세요"> <span class="focus-input100"></span>
								</div>
								<div class="pwerrmsg">
										<span id="errtel" style="color:#E90061; ">인증번호가 일치하지 않습니다.</span>
										<span id="cortel" style="color:#008485;">인증번호가 일치합니다.</span>
								</div>
						      </div>
						      <div class="modal-footer">
						        <button type="button" id="phonecloseBtn" class="clsbtn" data-dismiss="modal">닫기</button>
						        <button type="button" id="phoneckOkBtn" class="btn btn-primary" data-dismiss="modal">인증</button>
						      </div>
						    </div>
						  </div>
						</div>



						<!-- 이메일 -->
						<div class="wrap-input100 validate-input m-b-18 input45"
							data-validate="!">
							<span class="label-input100">이메일</span> <input type="text"
								name="eid" class="input100" placeholder="이메일 아이디"> <span
								class="focus-input100"></span>
						</div>
						<span style="margin-top: 13px;">@</span>

						<div class="wrap-input100 validate-input m-b-18 input45">
							<select name="domain" class="input100 selectoption">
								<option value="naver.com">naver.com</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.net">daum.net</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="kopomail.com">student.kopo.ac.kr</option>
							</select> <span class="focus-input100"></span>
						</div>


						<!-- 주소  -->
						<div class="wrap-input100 validate-input m-b-26 input65">
							<span class="label-input100">우편번호</span> <input class="input100"
								type="text" id="post" name="post" placeholder="우편번호"
								data-validate="!"> <span class="focus-input100"></span>
						</div>
						<input type="button" class="ckbtn" onclick="execDaumPostcode()"
							value="우편번호찾기" data-validate="!">

						<div class="wrap-input100 validate-input m-b-26">
							<span class="label-input100">주소</span> <input class="input100"
								type="text" id="addr1" name="addr1" placeholder="주소(시,군,구,동)"
								data-validate="!"> <span class="focus-input100"></span>
						</div>
						<div class="wrap-input100 validate-input m-b-26">
							<span class="label-input100">상세주소</span> <input class="input100"
								type="text" id="addr2" name="addr2" placeholder="상세주소">
							<span class="focus-input100"></span>
						</div>

						<div id="btnsection">
							<input id="submitBtn" type="submit" class="login100-form-btn"
								value="가입하기">
						</div>
					</form>
				</div>
			</div>
		</div>

	</section>
	<footer>
		<jsp:include page="../include/bottomMenu.jsp" />
	</footer>
</body>
</html>