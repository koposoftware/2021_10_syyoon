<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeOneHana::</title>
<link href="${ pageContext.request.contextPath }/resources/css/top/menubg.css" rel="stylesheet">
<link href="${ pageContext.request.contextPath }/resources/css/loan/reviewfile.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/12.1.2/css/intlTelInput.css" rel="stylesheet">
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>

<script src="${ pageContext.request.contextPath }/resources/js/loan/reviewfile.js"></script>
<%--https://codepen.io/emrankhan016/pen/vdNzXm --%>

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
	
	<section>
	<div class="container">
		<div class="multi_step_form">  
		  <form id="msform" action="${ pageContext.request.contextPath }/loan/file/result" method="post"  enctype="multipart/form-data"> 
		    <!-- Tittle -->
		    <div class="tittle">
		      <h2>대출심사파일제출</h2>
		      <p>In order to use this service, you have to complete this verification process</p>
		    </div>
		    <!-- progressbar -->
		    <ul id="progressbar">
		      <li class="active">금융정보 제공 동의</li>  
		      <li>심사서류 제출</li> 
		      <li>제출하기</li>
		    </ul>
		    <!-- fieldsets -->
		    <fieldset>
		      <h3>금융정보 제공 동의를 통해 빠른 대출을 경험해보세요!</h3>
	
		      <div class="form-row"> 
		        <div class="form-group col-md-12">  
		        	<div id="formarea">
						<div id="joinForm">
							<ul class="join_box">
								<li class="checkBox check01">
									<ul class="clearfix">
										<li>아래의 모든 사항을 확인했으며, 모두 동의합니다.</li>
										<li class="checkAllBtn">
											<p>
												<input id="chkAll" type="checkbox" name="chkAll"> <label for="chkAll"></label>
											</p>
										</li>
									</ul>
								</li>
								
								<li class="checkBox check02">
									<textarea> HomeOneHana(홈원하나)는 개인정보보호를 매우 중요시하며 ‘공공기관의 개인정보보호에 관한 법률’을 준수하고 있습니다. 귀하가 수집 및 이용ㆍ제3자 제공에 동의한 개인정보는 다양한 프로그램에 대한 정보제공과 프로그램 참여대상 관리 및 통계분석을 통한 자료로써 활용되며, 사용자의 분포도ㆍ이용행태 등을 분석하는데 이용될 수 있습니다. 
				      			 </textarea>
								</li>
								
								
								<li class="checkBox check02">
									<ul class="clearfix">
										<li>1. 개인정보 수집 및 이용 동의</li>
										<li class="checkBtn">
											<p>
												<input class="chkEtc" id="chkMust1" type="checkbox" name="chkEtc1"> <label for="chkMust1"></label>
											</p>
										</li>
									</ul> 
								</li><li class="checkBox check02">
									<textarea>1) 수집ㆍ이용 목적 - 가족에 대한 서비스 정보 제공 및 건강가정지원센터의 각종 서비스 안내  - 서비스 이용자의 개인 식별, 서비스 이용에 따른 이력관리 및 통계분석 자료  2) 수집 항목 : 성명, 생년월일, 주소, 이메일, 전화번호, 직업  3) 보유ㆍ이용 기간  - 문서 관리 : 해당 서비스 지원 기간동안 보관하고, 서비스 종료 후 개인정보처리 방침에 명시된 문서보관기관 경과 후 파기  - 통합정보시스템 관리 : 준영구  4) 동의 거부 권리 : 위 개인정보 수집 및 이용 동의를 거부하실 수 있음. 다만 이 경우 센터에서 진행되는 프로그램이나 서비스의 가입 및 이용이 거부될 수 있음.  
				      			 </textarea>
				      			</li>

								<li class="checkBox check03">
									<ul class="clearfix">
										<li>위치정보 이용약관 동의(선택)</li>
										<li class="checkBtn">
											<p>
												<input class="chkEtc" id="chkSele1" type="checkbox" name="chkEtc2"> <label for="chkSele1"></label>
											</p>
										</li>
									</ul> 
								</li>
									<li class="checkBox check02"><textarea>여러분을 환영합니다. HomeOneHana 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 HomeOneHana 서비스의 이용과 관련하여 HomeOneHana 서비스를 제공하는 HomeOneHana 주식회사(이하 ‘HomeOneHana’)와 이를 이용하는 HomeOneHana 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 HomeOneHana 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				       				</textarea>
								</li>
				
							</ul>
				        </div>
					</div>			
				</div>
		      </div>  
		      <button type="button" class="action-button previous_button">Back</button>
		      <button type="button" class="next action-button">Continue</button>  
		    </fieldset>
    		<fieldset>
		      <h3>심사 서류를 업로드 하세요</h3>
		      <!-- fileupload -->
		      <div id="fileBox">
		      <div class="upload-block"> 
		        <div class="custom-file">
		          <input type="file" class="custom-file-input" id="contractpaper" name="contractpaper">
		          <label class="custom-file-label" for="contractpaper"><i class="ion-android-cloud-outline"></i>임대차 계약서</label>
			    </div>
			  </div>
			  <div class="upload-block"> 
		        <div class="custom-file">
		          <input type="file" class="custom-file-input" id="receipt" name="receipt">
		          <label class="custom-file-label" for="receipt"><i class="ion-android-cloud-outline"></i>전세 보증금 5%이상 납입영수증</label>
			    </div>
			  </div>
			  <div class="upload-block"> 
		        <div class="custom-file">
		          <input type="file" class="custom-file-input" id="residentcerti" name="residentcerti">
		          <label class="custom-file-label" for="residentcerti"><i class="ion-android-cloud-outline"></i>주민등록등본</label>
			    </div>
			  </div>
			  <div class="upload-block"> 
		        <div class="custom-file">
		          <input type="file" class="custom-file-input" id="familycerti" name="familycerti">
		          <label class="custom-file-label" for="familycerti"><i class="ion-android-cloud-outline"></i>가족관계증명서</label>
			    </div>
			  </div>
			  </div>
			  <!-- fileupload End -->

		      <ul id="fileList" class="file_added">
		        <li>File Added:</li>
		      </ul>
		      <div id="passarea" class="passport">
		        <a href="#" class="don_icon"><i class="ion-android-done"></i></a> 
		      </div>
		      
		      <button type="button" class="action-button previous previous_button">Back</button>
		      <button type="button" class="next action-button">Continue</button>  
		    </fieldset>  
		    <fieldset>
		      <h3>제출하시겠습니까?</h3>

		      <div class="form-group"> 
		        	'제출하기'버튼을 누르면 제출이 완료됩니다!
		        	<input type="hidden" value="${enrollVO.loanname }" name="loanname">
		        	<input type="hidden" value="${enrollVO.userid }" name="userid">
		        	<input type="hidden" value="${enrollVO.managerid }" name="managerid">
		      </div> 
		     
		      <button type="button" class="action-button previous previous_button">Back</button> 
		      <input type="submit" href="#" class="action-button" value="제출하기" data-toggle="modal" data-target="#exampleModalCenter"> 
		    </fieldset>  
		  </form> 
		  </div>
		</div>
	</section>
	
	
	<!-- End Multi step form -->
	<footer>
		<jsp:include page="../include/bottomMenu.jsp" />
	</footer>
</body>
</html>
