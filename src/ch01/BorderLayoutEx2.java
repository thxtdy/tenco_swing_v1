package ch01;

import java.awt.BorderLayout;

// ctrl + shift + o = 쓰레기 처리
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx2 extends JFrame {

	public BorderLayoutEx2() {

		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 "X"를 누르면 닫히도록 해줌.
	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout -- 컴포넌트들을 동서남북 가운데로 배치시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		add(new JButton("동"), BorderLayout.EAST);
		add(new JButton("서"), BorderLayout.WEST);
		add(new JButton("남"), BorderLayout.SOUTH);
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("센터"), BorderLayout.CENTER);

	}

	// 코드 테스트
	public static void main(String[] args) {
		new BorderLayoutEx2();

	}// end of main

}
