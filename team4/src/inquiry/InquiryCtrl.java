package inquiry;

import account.AccountCtrl;

public class InquiryCtrl {
	public String id;
	
	String[][] information2 = new String[10][3];		// ���� ������ �޾ƿ� 2���� �迭 ����
	
	AccountCtrl accountctrl = new AccountCtrl();
	
	public InquiryCtrl(String id) {	// ���� �α��ε� id �޾ƿ��� ���� ������
		this.id = id;
		accountctrl.id = this.id;
	}
	
	public String[][] checkUserInfo() {					// AccountCtrl Ŭ������ AccountInquiry()���� ���� ������ �޾�
		information2 = accountctrl.AccountInquiry();
		return information2;							// �����Ѵ�.
	}
}
