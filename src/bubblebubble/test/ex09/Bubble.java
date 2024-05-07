package bubblebubble.test.ex09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Movealbe {
	
	private BubbleFrame mContext;
	
	private Player player;
	private BackgroundBubbleService backgroundBubbleService;

	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// hit enemy
	private int state; // 0.(기본 슝) 1.(적을 가둔 상태)

	private ImageIcon bubble; // 기본
	private ImageIcon bubbled; // 적을 가둔
	private ImageIcon bomb; // 터진

	private int bubbleX;
	private int bubbleY;

	// 연관 관계, 의존성 컴포지션 관계, 생성자 의존 주입 (DI)
	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		

		initData();
		setInitLayout();
		
	}
	// get,set

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	public int getBubbleX() {
		return bubbleX;
	}

	public void setBubbleX(int bubbleX) {
		this.bubbleX = bubbleX;
	}

	public int getBubbleY() {
		return bubbleY;
	}

	public void setBubbleY(int bubbleY) {
		this.bubbleY = bubbleY;
	}

	private void initData() {

		bubble = new ImageIcon("img/bubble.png"); // 기본값
		bubbled = new ImageIcon("img/bubbled.png"); // 가둔
		bomb = new ImageIcon("img/bomb.png"); // 터진
		backgroundBubbleService = new BackgroundBubbleService(this);

		left = false;
		right = false;
		state = 0;

	}

	private void setInitLayout() {

		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
	}


	
	@Override
	public void left() {
		left = true;
		for(int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			
			// 만약 왼쪽 벽에 부딪혔다면 -- > up() method
			if(backgroundBubbleService.leftWall()) {
				break;
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for(int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if(backgroundBubbleService.rightWall()) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		up();
	}

	@Override
	public void up() {
		up = true;
		while(true) {
			y--;
			setLocation(x, y);
			if(backgroundBubbleService.topWall()) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		clearBubble();
		
	}
	
	// 외부 호출 안될 메소드 (버블의 메소드)
	private void clearBubble() {
	  // 3sec --> bomb
		try {
			Thread.sleep(3000);
			setIcon(bomb);
			// 메모리에서 해제 처리
			
			// JFrame 안에 remove 라는 메소드가 존재
			Thread.sleep(500);
			setIcon(null);
			mContext.remove(this);
//			mContext.repaint();
			
		} catch (InterruptedException e) {
			e.printStackTrace();   
 		}
			
		
	}

}
