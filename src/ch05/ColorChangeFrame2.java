package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame2 extends JFrame implements ActionListener{

	private JPanel panel;
	private JButton button1;
	private JButton button2;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBackground(Color.GREEN);
		button1 = new JButton("음~~..쓸라이쓰~");
		button2 = new JButton("흐으으음~~쵸오옷!");

	}

	private void setInitLayout() {
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);

	}
	// 이 메소드의 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	@Override // 오버라이드 : 이벤트가 일어나면 호출 되어지는 메소드
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton selected = (JButton)e.getSource();
		if(selected == button1) {
			System.out.println("버튼 1");
		} else if(selected == button2) {
			System.out.println("버튼 2");
		}
		
		panel.setBackground(Color.BLUE);
	}

	public static void main(String[] args) {
		new ColorChangeFrame2();
	} // end of main

}
