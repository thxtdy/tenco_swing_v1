package ch02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyComponents extends JFrame{
	
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox checkBox;
	
	public MyComponents() {
		
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("컴포넌트 확인");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton("JButton");
		label = new JLabel("글자를 띄우는 컴포넌트");
		textField = new JTextField("아이디 입력", 20);
		passwordField = new JPasswordField("비밀번호 입력", 20);
		checkBox = new JCheckBox("동의");
		
		
	}
	private void setInitLayout() {
		
		setLayout(new FlowLayout());
		setVisible(true);
		
		add(button);
		add(label);
		add(textField);
		add(passwordField);
		add(checkBox);
		
	}
	public static void main(String[] args) {
		MyComponents components = new MyComponents(); // 객체 주소의 값
		components.textField.setText("안녕");
	}


}
