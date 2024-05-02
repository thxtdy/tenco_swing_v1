package bubblebubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Movealbe {

	private int x;
	private int y;
	private ImageIcon playerL, playerR;

	public Player() {
		initData();
		setInitLayout();

	}

	private void initData() {
		playerL = new ImageIcon("img/playerL.png");
		playerR = new ImageIcon("img/playerR.png");

		// 처음 실행 시 초기값 세팅
		x = 55;
		y = 535;

		this.setIcon(playerR); // JLabel 의 기능
		this.setLocation(x, y);
		this.setSize(50, 50);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		// 왼쪽 방향키 이벤트 발생 시
		// 이미지를 왼쪽으로 보는 이미지로 세팅
		setIcon(playerL);
		x -= 10;
		setLocation(x, y);

	}

	@Override
	public void right() {
		setIcon(playerR);
		x += 10;
		setLocation(x, y);

	}

	@Override
	public void up() {
		System.out.println("쨤푸");

	}

	@Override
	public void down() {
		System.out.println("징동따운~");

	}

}
