package ch07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoFrame extends JFrame implements ActionListener{
				
	private JButton button1;
	private LottoRandomNumber Lotto;
	private boolean isStart = true;
	private int NUMBER_DISTANCE = 80;
	
	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("Lotto Game");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("Game Start");
		Lotto = new LottoRandomNumber();
		
	}
	private void setInitLayout() {
		add(button1, BorderLayout.NORTH);
		setVisible(true);
		
	}
	private void addEventListener() {
		button1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Paint");
		// 이벤트가 일어나면 그림을 다시 그려라
		
		
		isStart = false;
		repaint(); // 다시 그림을 그려라 요청하는 명령어// F5와 같은 개념
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Font f = new Font("SansSerif", Font.BOLD, 40);
		g.setFont(f);
		
		if(isStart) {
		g.drawString("로또번호를 클릭", 140, 200);
		
		} else {
			int[] getNumbers = Lotto.createNumber();
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString(getNumbers[i] + " ", 80 + i*NUMBER_DISTANCE, 180);
			}
//		g.drawString(getNumbers[0] + "", 100, 300);
//		g.drawString(getNumbers[1] + " ", 180, 300);
//		g.drawString(getNumbers[2] + " ", 250, 300);
//		g.drawString(getNumbers[3] + " ", 320, 300);
//		g.drawString(getNumbers[4] + " ", 390, 300);
//		g.drawString(getNumbers[5] + " ", 460, 300);
		}
		
//		g.drawString("15", 180, 300);
//		g.drawString("30", 250, 300);
//		g.drawString("33", 320, 300);
//		g.drawString("43", 390, 300);
//		g.drawString("45", 460, 300);
//		
		
		
		
	}
	
	// Main Method
	public static void main(String[] args) {
		new LottoFrame();
	} // end of main
	
} // end of class
