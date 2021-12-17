package team4;

public class LoginCtrl {
	private String id;
    private String pwd;
    private MemberCtrl memberObj;
    
    // 생성자-초기화
    LoginCtrl(String id, String pwd) {
    	this.id = id;
    	this.pwd = pwd;
    	memberObj = new MemberCtrl();
    }
    // 아이디-비밀번호 확인
    public String checkIdPassword(boolean autochk) {
    	return memberObj.check(autochk, id, pwd);
    }
}
