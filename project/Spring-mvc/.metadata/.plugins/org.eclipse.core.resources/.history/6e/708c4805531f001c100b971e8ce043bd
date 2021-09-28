package kr.co.hana.loan.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.hana.loan.Service.LoanService;
import kr.co.hana.loan.vo.EnrollLoanVO;
import kr.co.hana.loan.vo.ReviewFileVO;
import kr.co.hana.login.vo.LoginVO;
import kr.co.hana.mypage.service.MypageService;
import kr.co.hana.mypage.vo.AccountVO;

@Controller
public class LoanController {
	
	@Autowired
	private LoanService loanservice;
	
	@Autowired
	private MypageService mypageservice;
	
	
	
	private static final String SAVE_PATH = "D:/homeOneHanaFile/";
	
	
	@GetMapping("/loan")
	public String loanMain() {
		System.out.println("대출볼래?");
		return "loan/loan";
	}
	
	@GetMapping("/loan/review")
	public String loanReview(EnrollLoanVO enroll, Model model){
		System.out.println("대출심사파일업로드");
		System.out.println(enroll.toString());
		model.addAttribute("enrollVO", enroll);
		
		return "loan/reviewfile";
	}
	
	@PostMapping("/loan/file/result")
	public String loanReviewFileuploadResult(MultipartHttpServletRequest mhsq,EnrollLoanVO enroll) throws IllegalStateException,IOException {
		System.out.println("데이터 넘기기 ");
		/*?chkAll=on
		 * &chkEtc1=on
		 * &chkEtc2=on
		 * &contractpaper=210915-예시페이지.pptx
		 * &receipt=HANAPAY_DA2.zip
		 * &residentcerti=kopoOpenBankPj02.zip
		 * &familycerti=아이디어.txt
		
		*/
		System.out.println(enroll.toString());
		int contractcode = loanservice.contractLogProcedure(enroll);
		Iterator<String> iter = mhsq.getFileNames();
		List<ReviewFileVO> rfvoList = new ArrayList<ReviewFileVO>();
		while(iter.hasNext()) {
			
			String formFileName = iter.next();
			
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile mFile = mhsq.getFile(formFileName);
			
			// 원본 파일명
			String oriFileName = mFile.getOriginalFilename();
			System.out.println("원본 파일명 : " + oriFileName);
			
			
			
			if(oriFileName != null && !oriFileName.equals("")) {
			
				// 확장자 처리
				String ext = "";
				// 뒤쪽에 있는 . 의 위치 
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
				}
				
				// 파일 사이즈
				long fileSize = mFile.getSize();
				//System.out.println("파일 사이즈 : " + fileSize);
				
				// 고유한 파일명 만들기	
				String saveFileName = "hana-" + UUID.randomUUID().toString() + ext; // 확장자 붙이기
				//System.out.println("저장할 파일명 : " + saveFileName);
				
				// 임시저장된 파일을 원하는 경로에 저장
				mFile.transferTo(new File(SAVE_PATH + saveFileName));
				
				ReviewFileVO rfvo = new ReviewFileVO();
				rfvo.setContractcode(contractcode);
				rfvo.setFile_ori_name(oriFileName);
				rfvo.setFile_save_name(saveFileName);
				rfvo.setFilesize(fileSize);
				rfvoList.add(rfvo);
			} 
		} 
		loanservice.uploadFile(rfvoList);
		
		return "loan/fileresult";
	}
	
	
	@GetMapping("/loan/contract")
	public String loanContract(int contractcode, HttpSession session, Model model) {
		System.out.println("계약서작성해볼래");
		
		model.addAttribute("contractcode", contractcode);
		LoginVO log = (LoginVO) session.getAttribute("loginVO");
		//계좌정보
		List<AccountVO> accounts = mypageservice.getAccount(log.getId());
		model.addAttribute("accountList", accounts);
		
		// 계약상품 정보
		EnrollLoanVO contractinfo = mypageservice.getContractInfo(contractcode);
		model.addAttribute("contractinfo", contractinfo);

		return "loan/loancontract";
	}
}
