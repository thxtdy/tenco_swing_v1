package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 중첩 클래스 --> 외부, 내부 클래스로 내부 클래스로 --> 인스턴스 클래스 , static 클래스
 */
public class MyImageFrame extends JFrame {
	
	private MyImagePanel myImagePanel;

	public MyImageFrame() {

		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("이미지 활용 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myImagePanel = new MyImagePanel();
		
	}

	public void setInitLayout() {
		add(myImagePanel);
		setVisible(true);
	}
	
	// 내부 클래스 --> static 키워드 활용
	// 정적(static) 내부 클래스라고 한다.
	static class MyImagePanel extends JPanel {
		private Image image;
		private Image image1;
		private Image image2;

		public MyImagePanel() {
			
			// ImageIcon 데이터 타입 -> getImage() 메소드를 호출하면
			// image 데이터 타입을 만들어낼 수 있다.
			image = new ImageIcon("1.png").getImage();
			image1 = new ImageIcon("barbatos.png").getImage();
			image2 = new ImageIcon("Barbbbaatos.png").getImage();
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 100, 100, 100, 100, null);
							// x1    y1   width height
			g.drawImage(image1, 400, 400, 450, 600, null);
			
			g.drawImage(image2, 80, 400, 450, 600, null);
		}
		
		
	}
}
