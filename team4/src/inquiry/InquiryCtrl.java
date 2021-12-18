package inquiry;

import account.AccountCtrl;

public class InquiryCtrl {
	public String id;
	
	String[][] information2 = new String[10][3];		// 계정 정보를 받아올 2차원 배열 선언
	
	AccountCtrl accountctrl = new AccountCtrl();
	
	public InquiryCtrl(String id) {	// 현재 로그인된 id 받아오기 위한 생성자
		this.id = id;
		accountctrl.id = this.id;
	}
	
	public String[][] checkUserInfo() {					// AccountCtrl 클래스의 AccountInquiry()에서 계정 정보를 받아
		information2 = accountctrl.AccountInquiry();
		return information2;							// 리턴한다.
	}
}
