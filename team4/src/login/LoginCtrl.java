package login;

import member.MemberCtrl;

/***********************************************************
 * LoginCtrl : 로그인 컨트롤 객체
/***********************************************************/
public class LoginCtrl {
	private String id;				// 아이디
    private String pwd;				// 비밀번호
    private MemberCtrl memberObj;	// 멤버컨트롤 객체
    
    /***********************************************************
     * 생성자 : 멤버컨트롤 객체 생성 및 초기화
    /***********************************************************/
    LoginCtrl(String id, String pwd) {
    	this.id = id;
    	this.pwd = pwd;
    	memberObj = new MemberCtrl();
    }
    // 아이디-비밀번호 확인
    /***********************************************************
     * String checkIdPassword : 아이디, 비밀번호 유효성 검사
     * @param boolean autochk   자동검사 체크
     * @return 					아이디, 비밀번호 검사(일치: String, 불일치: null)
    /***********************************************************/
    public String checkIdPassword(boolean autochk) {
    	return memberObj.check(autochk, id, pwd);
    }
}
