package team4;

public class LoginCtrl {
	private String id;
    private String pwd;
    private MemberCtrl memberObj;
    
    // ������-�ʱ�ȭ
    LoginCtrl(String id, String pwd) {
    	this.id = id;
    	this.pwd = pwd;
    	memberObj = new MemberCtrl();
    }
    // ���̵�-��й�ȣ Ȯ��
    public String checkIdPassword(boolean autochk) {
    	return memberObj.check(autochk, id, pwd);
    }
}
