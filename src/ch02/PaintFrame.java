package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame{
	
	MyAmazingDrawHAHA hahaha;
	
	public PaintFrame() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("집을 슉슉 확확 그려보아요");
		setSize(1000, 1000);
		
		hahaha = new MyAmazingDrawHAHA();
	}
	private void setInitLayout() {
		add(hahaha);
		setVisible(true);
		
	}
	
	class MyAmazingDrawHAHA extends JPanel{
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			// 지붕 /\ -
			g.drawLine(400, 100, 250, 220);
			g.drawLine(400, 100, 550, 220);
			g.drawLine(250, 220, 550, 220);
			// 집 기둥 ||
			g.drawLine(300, 220, 300, 350);
			g.drawLine(500, 220, 500, 350);
			// 집 바닥 ㅡ
			g.drawLine(300, 350, 500, 350);
			// 굴뚝
			g.drawLine(475, 160, 475, 85);
			g.drawLine(525, 85, 525, 200);
			g.drawLine(475, 85, 525, 85);
			
			g.drawString("🛕", 350, 350);
			
			
			
		}
		
	}
}
