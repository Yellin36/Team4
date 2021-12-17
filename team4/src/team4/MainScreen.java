package team4;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : 개인정보관리시스템
//  @ File Name : MainScreen.java
//  @ Date : 2021-12-16
//  @ Author : 
//
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



public class MainScreen extends JFrame {
    private JButton SearchBtn = new JButton("조회하기");
    private JButton NotificationViewBtn = new JButton("알림");
    private JButton LoginBtn = new JButton("로그인");
    private JButton SelfAuthenticationBtn = new JButton("본인인증");
    private JButton IDArrangeBtn = new JButton("정리하기");

    MainScreen(boolean chk) {
    	setTitle("개인정보관리시스템");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	setFrame(chk);
    	setListener();
    	
    	setLocation(100,100);
    	setSize(500, 500);
    	setVisible(true);
    }
    private void setFrame(boolean chk) {
    	Container pane = new Container();
    	pane.setLayout(new FlowLayout());
    	
    	JPanel cpane = new JPanel();
    	setContentPane(cpane);
    	cpane.setLayout(null);
    	SearchBtn.setBounds(150, 150, 200, 50);
    	IDArrangeBtn.setBounds(150, 250, 200, 50);
    	pane.setBounds(100,5, 300, 50);
    	if(chk) LoginBtn.setText("로그아웃");
    	else LoginBtn.setText("로그인");
    	
    	pane.add(LoginBtn);
    	pane.add(SelfAuthenticationBtn);
    	pane.add(NotificationViewBtn);
    	
    	cpane.add(pane);
    	cpane.add(SearchBtn);
    	cpane.add(IDArrangeBtn); 
    	
    }
    private void setListener() {
    	SearchBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			//new 조회하기Screen();
    			setVisible(false);
    		}
    	});
    	LoginBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(LoginBtn.getText().equals("로그인")) {
    				new LoginScreen();
    				setVisible(false);
    			}
    			else {
    				LoginBtn.setText("로그인");
    			}
    		}
    	});
    }
    public static void main(String args[]) {
    	 new MainScreen(false);
    }
}