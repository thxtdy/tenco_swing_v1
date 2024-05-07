package bubblebubble.test.ex09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Player2 extends JLabel implements Movealbe {

	private int x;
	private int y;
	private ImageIcon playerL, playerR;

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;
	
	//setter
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setRight(boolean right) {
		this.right = right;
	}

	public Player2() {
		initData();
		setInitLayout();

	}

	private void initData() {
		playerL = new ImageIcon("img/playerL.png");
		playerR = new ImageIcon("img/playerR.png");

		// 처음 실행 시 초기값 세팅
		x = 55;
		y = 535;

		// 플레이어가 멈춤
		left = false;
		right = false;
		up = false;
		down = false;

		this.setIcon(playerR); // JLabel 의 기능
		this.setLocation(x, y);
		this.setSize(50, 50);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		left = true;
		setIcon(playerL);

		// <- <- 반복

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x -= SPEED;
					setLocation(x, y);
				}

			}
		}).start();
	
		

		// 왼쪽 방향키 이벤트 발생 시
		// 이미지를 왼쪽으로 보는 이미지로 세팅
		// 왼쪽으로 가고 있는 상태

		// 멈춰있는 상태란 개념 필요

	} // end of left

	@Override
	public void right() {
		right = true;
		setIcon(playerR);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(right) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += SPEED;
					setLocation(x, y);
				} 
			}
		}).start();
		

	} // end of right

	@Override
	public void up() {
		System.out.println("쨤푸");

	}

	@Override
	public void down() {
		System.out.println("징동따운~");

	}

}
