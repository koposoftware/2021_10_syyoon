package hana.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })
public class TestJava {
	
	@Ignore
	@Test
	public void Test1(){
		String se = "부산";
		List<String> lst = new ArrayList<String>();
		lst.add("경기도");
		lst.add("부산");
		lst.add("부산");
		lst.add("서울");
		lst.add("서울");
		lst.add("부산");
		
		for(int i=0; i<9; i++) {
			String ad1 = lst.get(i);
			String ad2 = lst.get(i+1);
			if(se.equals(ad1)) {
				System.out.println("찾았다 : "+ad1);
				if(ad1.equals(ad2) == false) {
					System.out.println("달라 : "+ad2);
					break;
				}
			}
		}
	}
	
	
	@Test
	public void TestToday() {
		SimpleDateFormat df = new SimpleDateFormat ( "yyyy.MM.dd");
		Calendar start = Calendar.getInstance();
		start.setTime(new Date());
		start.add(Calendar.DATE, -30);
		String st = df.format(start.getTime());
		
		Calendar end = Calendar.getInstance();
		end.setTime(new Date());
		end.add(Calendar.DATE, 30);
		String en = df.format(end.getTime());
		
		
		Date time = new Date();
		String today = df.format(time); // 오늘
		System.out.println(st + ", "+ today + ", "+ en);
		
	}

}
