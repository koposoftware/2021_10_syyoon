package kr.co.hana.join.Service;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hana.join.dao.JoinDAO;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class JoinServiceImpl implements JoinService{
	
	
	@Autowired
	private JoinDAO joindao;
	
	public int userIdCheck(String userId) {
		int result = joindao.userIdCheck(userId);
		return result;
	}
	
	public void certifiedPhoneNumber(String phoneNumber, String cerNum) {
		

		String api_key = "NCSFSXJYHOTVHDTD";
		String api_secret = "UNXYLYQQLQ2REK6PVTAJKZJPU5MIDXY3";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phoneNumber);
		params.put("from", "01034127748"); 
		params.put("type", "SMS");
		params.put("text", "HomeOneHana �޴������� �޽��� : ������ȣ��" + "[" + cerNum + "]" + "�Դϴ�.");
		params.put("app_version", "test app 1.2"); // application name and version


	      
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}

	}
	
	

}
