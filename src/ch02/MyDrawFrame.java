package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

	
/**
 *  패널에 그림을 그리는 방법
 *  자바 문법 - 중첩 클래스 ( 클래스 안 클래스를 만든 것)
 *  외부 클래스, 내부 클래스, outer class, inner class	
 */
public class MyDrawFrame extends JFrame{
	
	// 내부 클래스를 외부 클래스에 사용하려면
	// 멤버로 가지고 있어야 한다.
//	int x1 = 100;
	MyDrawPanel myDrawpanel;
	
	public MyDrawFrame() {
		initData();
		setInitLayout();
	}
	private void initData() {
		setTitle("내부 클래스를 활용한 그림 그리는 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myDrawpanel = new MyDrawPanel();
	}
	private void setInitLayout() {
		
		add(myDrawpanel);
		setVisible(true);
		
	}
	
	// 내부 클래스 만들어보기
	
	// point --> 좌표값으로 x= 0, y = 0
	// Jpanel 에 있는 기능을 확장해보자.
	
	
	class MyDrawPanel extends JPanel{
		
		// paints ---> 아님
		// print  ---> 아님
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(100, 100, 50, 100);
			g.drawRect(200, 200, 150, 150);
			
			g.drawRoundRect(250,  250, 300, 300, 300, 300);
			
			g.drawLine(200, 200, 700, 700);
			
			g.drawOval(150, 150, 200, 200);
			
			g.drawLine(700, 700, 200, 200);
			
			g.drawString("안늉~", 250, 250);
			g.drawString("😊😊😊😊😊😊😊😊😊😊😊😊😊😊😊😊" , 500,500);
		
	} // end of inner class
	}	
}
