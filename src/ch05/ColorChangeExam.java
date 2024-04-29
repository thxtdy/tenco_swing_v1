package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeExam extends JFrame implements ActionListener{
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel panel;
	private JPanel panel1;
	
	public ColorChangeExam() {
		initData();
		setDataLayout();
		addActionEvent();
	}
	private void initData() {
		setTitle("버튼 누를때마다 색 변경");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel1 = new JPanel();
		panel.setBackground(Color.white);
		panel1.setBackground(Color.black);
		
		
		button1 = new JButton("Green");
		button2 = new JButton("Yellow");
		button3 = new JButton("Pink");
		button4 = new JButton("Home");
	}
	private void setDataLayout() {
		//add(button1,"South");
		//add(button2,"South");
		//add(button3,"South");
		add(panel, BorderLayout.CENTER);
		add(panel1, BorderLayout.SOUTH);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel.add(button4);
		setVisible(true);
	}
	private void addActionEvent() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton select = (JButton)e.getSource();
		
		if(select == this.button1) {
			panel.setBackground(Color.green);
		}else if(select == this.button2) {
			panel.setBackground(Color.yellow);
		}else if(select == this.button3) {
			panel.setBackground(Color.pink);
		}else if (select == this.button4){
			panel.setBackground(Color.white); 
		}
		
	}
	public static void main(String[] args) {
		new ColorChangeExam();
	}
}
