package ch01;

import java.awt.BorderLayout;

// ctrl + shift + o = 쓰레기 처리
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx1 extends JFrame {
	
	JButton[] buttons;
	
	String[] directions = {BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH,
			BorderLayout.SOUTH, BorderLayout.CENTER};
	
	String[] kDirect = {"동", "서", "남", "북", "중앙"};
	
	public BorderLayoutEx1() {

		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 "X"를 누르면 닫히도록 해줌.
		buttons = new JButton[5];
		kDirect = new String[5];
		
		
		
	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout -- 컴포넌트들을 동서남북 가운데로 배치시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		
		for (int i = 0; i < buttons.length; i++) {
				add(new JButton(directions[i]), kDirect[i]);
			}
		}
		
		
		
		

	

	// 코드 테스트
	public static void main(String[] args) {
		new BorderLayoutEx1();

	}// end of main

}
