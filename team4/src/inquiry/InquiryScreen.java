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
	private String id;		// �����ͺ��̽����� �ڽ��� �������� ã�� ���� ����
	
	String[][] information2 = new String[10][3];			// 2���� �迭�� �ڽ��� ������ ���� �� �ҷ� �� �� ����.
	

	private void screen() {
		InquiryCtrl inquiryctrl = new InquiryCtrl(id);		// "xyz0000"�� ���� �α��ε� ���� ���̵� �޾ƿͼ� �־��ָ� ��.
		information2 = inquiryctrl.checkUserInfo();				// InquiryCtrl Ŭ������ checkUserInfo���� ���� ������ �޾ƿ´�.
	}
	
	
	// �ڹ� GUI ���� �ڵ�
	
	private Container pane = getContentPane();
	private JLabel state;
	private String colName[] = {"����Ʈ��", "���̵�", "������"};
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	private JTable table = new JTable(model);		// �޾ƿ� ������ �����ϱ� ���� ���̺�
	private JButton backBtn = new JButton("<");		// �ڷΰ��� ��ư
	
	public InquiryScreen(String id) {
		this.id = id;
		screen();
		
		setTitle("��ȸ ������");								// ȭ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//JPanel Btn_panel = new JPanel(); 
		//JPanel panel = new JPanel();
		//Btn_panel.setLayout(new FlowLayout()); 
		//panel.setLayout(new FlowLayout());

		state = new JLabel();
		state.setText("�� ���� ��ȸ");
		add(state, BorderLayout.NORTH);
		add(new JScrollPane(table), BorderLayout.CENTER);
		//add(Btn_panel, BorderLayout.EAST);
		//add(panel, BorderLayout.WEST);
		add(backBtn, BorderLayout.SOUTH);
		setListener();
		for(int i = 0; i < 10 ; i++) {			// �������� �������� model ���̺� ������ �ִ´�.
			model.addRow(information2[i]);	
		}
		setLocation(100,100);
		setSize(500, 500);	// ������� 500x500
		setVisible(true);
	}
	private void setListener() {	
    	// �ڷΰ����ư�� �̺�Ʈ�� �߻��Ͽ����� ����Ǵ� �Լ�
    	backBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new MainScreen(false, id);
    			setVisible(false);
    		}
    	});
    }
}
