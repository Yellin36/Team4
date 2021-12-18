package login;

import member.MemberCtrl;

/***********************************************************
 * LoginCtrl : �α��� ��Ʈ�� ��ü
/***********************************************************/
public class LoginCtrl {
	private String id;				// ���̵�
    private String pwd;				// ��й�ȣ
    private MemberCtrl memberObj;	// �����Ʈ�� ��ü
    
    /***********************************************************
     * ������ : �����Ʈ�� ��ü ���� �� �ʱ�ȭ
    /***********************************************************/
    LoginCtrl(String id, String pwd) {
    	this.id = id;
    	this.pwd = pwd;
    	memberObj = new MemberCtrl();
    }
    // ���̵�-��й�ȣ Ȯ��
    /***********************************************************
     * String checkIdPassword : ���̵�, ��й�ȣ ��ȿ�� �˻�
     * @param boolean autochk   �ڵ��˻� üũ
     * @return 					���̵�, ��й�ȣ �˻�(��ġ: String, ����ġ: null)
    /***********************************************************/
    public String checkIdPassword(boolean autochk) {
    	return memberObj.check(autochk, id, pwd);
    }
}
