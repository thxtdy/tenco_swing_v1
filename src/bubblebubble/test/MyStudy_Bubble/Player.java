package bubblebubble.test.MyStudy_Bubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Movealbe {

	private int x;
	private int y;
	private ImageIcon playerL, playerR;

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean setbubble;
	
	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	
	// Get in blue wall
	private boolean centerWallCrash;
	
	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 4;
	
	// enum 타입의 활용
	PlayerWay playerWay;

	
	//setter
	
	
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public void setBubble(boolean setbubble) {
		this.setbubble = setbubble;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ImageIcon getPlayerL() {
		return playerL;
	}
	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}
	public ImageIcon getPlayerR() {
		return playerR;
	}
	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isBubble() {
		return setbubble;
	}
	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}
	public boolean isRightWallCrash() {
		return rightWallCrash;
	}
	public boolean isUpWallCrash() {
		return upWallCrash;
	}
	public boolean isCenterWallCrash() {
		return centerWallCrash;
	}
	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}
	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}
	public void setUpWallCrash(boolean upWallCrash) {
		this.upWallCrash = upWallCrash;
	}
	public void setcenterWallCrash(boolean centerWallCrash) {
		this.centerWallCrash = centerWallCrash;
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
	public int getSPEED() {
		return SPEED;
	}
	public int getJUMPSPEED() {
		return JUMPSPEED;
	}
	public Player() {
		initData();
		setInitLayout();

	}

	private void initData() {
		playerL = new ImageIcon("img/playerL.png");
		playerR = new ImageIcon("img/playerR.png");

		// 처음 실행 시 초기값 세팅
		x = 450;
		y = 535;

		// 플레이어가 멈춤
		left = false;
		right = false;
		up = false;
		down = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
		upWallCrash = false;
		
		playerWay = PlayerWay.RIGHT;
		
	}

	private void setInitLayout() {
		this.setIcon(playerR); // JLabel 의 기능
		this.setLocation(x, y);
		this.setSize(50, 50);

	}

	@Override
	public void left() {
		playerWay = PlayerWay.LEFT;
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
		playerWay = PlayerWay.RIGHT;
		right = true;
		setIcon(playerR);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(right) {
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
				for (int i = 0; i <35; i++) {
					y -= JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(upWallCrash = true) {
					up = false;
				}
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
				while(down) {
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
		
//		new Thread(() -> {
//			while(down) {
//				
//				y += SPEED;
//				setLocation(x, y);
//				
//				try {
//					Thread.sleep(3);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			down = false;
//		}).start();            람다식 찍먹
//		
		
		
		
//		// 코드 수정
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for(int i = 0; i < 120 / JUMPSPEED; i++) {
//					y += JUMPSPEED;
//					setLocation(x, y);
//					
//					try {
//						Thread.sleep(3);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		}).start();
//		// 상태값 처리를 확실히 하자.
//		down = false;
	}
	
		
	

}
