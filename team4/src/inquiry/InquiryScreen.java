package inquiry;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import team4.MainScreen;


public class InquiryScreen extends JFrame {
	private String id;		// 데이터베이스에서 자신의 계정들을 찾기 위한 변수
	
	String[][] information2 = new String[10][3];			// 2차원 배열로 자신의 계정을 여러 개 불러 올 수 있음.
	

	private void screen() {
		InquiryCtrl inquiryctrl = new InquiryCtrl(id);		// "xyz0000"에 현재 로그인된 계정 아이디를 받아와서 넣어주면 됨.
		information2 = inquiryctrl.checkUserInfo();				// InquiryCtrl 클래스의 checkUserInfo에서 계정 정보를 받아온다.
	}
	
	
	// 자바 GUI 설계 코드
	
	private Container pane = getContentPane();
	private JLabel state;
	private String colName[] = {"사이트명", "아이디", "아이피"};
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	private JTable table = new JTable(model);		// 받아온 정보를 개시하기 위한 테이블
	private JButton backBtn = new JButton("<");		// 뒤로가기 버튼
	
	public InquiryScreen(String id) {
		this.id = id;
		screen();
		
		setTitle("조회 페이지");								// 화면 설계
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//JPanel Btn_panel = new JPanel(); 
		//JPanel panel = new JPanel();
		//Btn_panel.setLayout(new FlowLayout()); 
		//panel.setLayout(new FlowLayout());

		state = new JLabel();
		state.setText("내 계정 조회");
		add(state, BorderLayout.NORTH);
		add(new JScrollPane(table), BorderLayout.CENTER);
		//add(Btn_panel, BorderLayout.EAST);
		//add(panel, BorderLayout.WEST);
		add(backBtn, BorderLayout.SOUTH);
		setListener();
		for(int i = 0; i < 10 ; i++) {			// 계정들을 차례차례 model 테이블 스윙에 넣는다.
			model.addRow(information2[i]);	
		}
		setLocation(100,100);
		setSize(500, 500);	// 사이즈는 500x500
		setVisible(true);
	}
	private void setListener() {	
    	// 뒤로가기버튼에 이벤트가 발생하였을시 실행되는 함수
    	backBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new MainScreen(false, id);
    			setVisible(false);
    		}
    	});
    }
}
