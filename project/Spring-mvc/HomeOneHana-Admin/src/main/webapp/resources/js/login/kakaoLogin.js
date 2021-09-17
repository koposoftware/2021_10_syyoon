/**
 * 카카오로그인
 */

Kakao.init('fdb0fd8047707bf8af7800399c2f657d'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	//카카오로그인
	function kakaoLogin() {
	    Kakao.Auth.login({
	    	
	      success: function (response) {
	        Kakao.API.request({
	          url: '/v2/user/me',
	          success: function (response) {
	        	  //console.log(response)
	        	  
	        	  //alert(JSON.stringify(response));

                  
                  var id = response.id // id
                  var email = response.kakao_account.email //email
                  var name = response.properties['nickname'] //이름
                  
                  
                  console.log(id);

                  console.log(email);

                  console.log(name);

				  if(id !=null && email !=null && name !=null){
					
					
					$('input[name=id]').attr('value',String(id));
					$('input[name=password]').attr('value',String(id));
					$('#login').click()
				
					
				}

	          },
	          fail: function (error) {
	            console.log(error)
	          },
	        })
	      },
	      fail: function (error) {
	        console.log(error)
	      },
	    })
	  }
	//카카오로그아웃  
	function kakaoLogout() {
	    if (Kakao.Auth.getAccessToken()) {
	      Kakao.API.request({
	        url: '/v1/user/unlink',
	        success: function (response) {
	        	console.log(response)
	        },
	        fail: function (error) {
	          console.log(error)
	        },
	      })
	      Kakao.Auth.setAccessToken(undefined)
	    }
	  }