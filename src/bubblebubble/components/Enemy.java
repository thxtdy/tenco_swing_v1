package bubblebubble.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubblebubble.BubbleFrame;
import bubblebubble.interfaces.Movealbe;
import bubblebubble.state.EnemyWay;

public class Enemy extends JLabel implements Movealbe {

	BubbleFrame mContext;
	// Alive == 0, BubbleST == 1;
	private int state = 0; // 값 미지정 시 0으로

	// 적군의 좌표값 위치 상태

	private int x;
	private int y;
	private ImageIcon enemyL, enemyR;

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean setbubble;
	
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	

	// Enemy 속도 상태
	private final int SPEED = 3;
	private final int JUMPSPEED = 1;
	
	// enum 타입의 활용
	EnemyWay enemyWay;
	
	

	public Enemy(BubbleFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
		
		left();
		

	}
	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}
	public boolean isRightWallCrash() {
		return rightWallCrash;
	}
	public void setLeftWallCrash(boolean leftWallCrash){
		this.leftWallCrash = leftWallCrash;
	}
	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isLeft() {
		return left;
	}
	public boolean isRight() {
		return right;
	}
	public boolean isUp() {
		return up;
	}
	public boolean isDown() {
		return down;
	}
	
	public int getStatus() {
		return state;
	}
	public void setStatus(int state) {
		this.state = state;
	}

	private void initData() {
		enemyL = new ImageIcon("img/enemyL.png");
		enemyR = new ImageIcon("img/enemyR.png");
		
		state = 0;

		// 처음 실행 시 초기값 세팅
		x = 720;
		y = 230;

		// 적군 방향 상태
		left = false;
		right = false;
		up = false;
		down = false;

		enemyWay = EnemyWay.LEFT;

	}

	// 생성자
	private void setInitLayout() {
		this.setIcon(enemyL); // JLabel 의 기능
		this.setLocation(x, y);
		this.setSize(50, 50);

	}

	@Override
	public void left() {
		enemyWay = EnemyWay.LEFT;
		left = true;
		setIcon(enemyL);

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

	} // end of left

	@Override
	public void right() {
		enemyWay = EnemyWay.RIGHT;
		right = true;
		setIcon(enemyR);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
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
		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 35; i++) {
					y -= JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//				if(upWallCrash = true) {
//					up = false;
//				}
				up = false;
				down();

			}

		}).start();
		// 객체의 상태값을 잘 조절해야 한다.

	}

	@Override
	public void down() {
		System.out.println("징동따운~");
		down = true;

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					y += SPEED;
					setLocation(x, y);

					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				down = false;

			}
		}).start();
	}

}
