package hana.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.hana.loan.vo.EnrollLoanVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })
public class ProcedureTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Test
	public void procedureTest1() {
		EnrollLoanVO enroll = new EnrollLoanVO();
		enroll.setLoanname("하나 전세금안심대출");
		enroll.setManagerid("admin2");
		enroll.setUserid("1817729777");
		enroll.setPrincipal(1324);
		
		
		int enroll2 = sqlSessionTemplate.selectOne("loan.dao.LoanDAO.contractLogProcedure",enroll);
		System.out.println(enroll2);
	}

}
