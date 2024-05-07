package bubblebubble.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubblebubble.BubbleFrame;
import bubblebubble.interfaces.Movealbe;
import bubblebubble.service.BackgroundBubbleService;

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
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);

			// 만약 왼쪽 벽에 부딪혔다면 -- > up() method
			if (backgroundBubbleService.leftWall()) {
				break;
			}

			// 현재 버블의 XY 좌표를 앎.
			// 적군의 XY 좌표를 앎.
			
			System.out.println("적군 X 좌표 :" + mContext.getEnemy().getX());
			System.out.println("적군 Y 좌표 :" + mContext.getEnemy().getY());
			
			// X의 절댓값을 확인하자
			
			int absX = Math.abs(x - mContext.getEnemy().getX());
			System.out.println("절댓값 X : " + absX);
			int absY= Math.abs(y - mContext.getEnemy().getY());
			System.out.println("절댓값 Y : " + absY);
			
			if( absX < 10 && absY < 30) {
				// 단 적군이 1 (Alive) 상태일때
				if(mContext.getEnemy().getStatus() == 0) { // enemy 의 state 0 상태는 살아있는 상태 | state 1 상태는 갇힌 상태
					crash();
				}
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
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if (backgroundBubbleService.rightWall()) {
				break;
			}
			int absX = Math.abs(x - mContext.getEnemy().getX());
			System.out.println("절댓값 X : " + absX);
			int absY= Math.abs(y - mContext.getEnemy().getY());
			System.out.println("절댓값 Y : " + absY);
			
			if( absX < 10 && absY < 50) {
				// 단 적군이 1 (Alive) 상태일때
				if(mContext.getEnemy().getStatus() == 0) { // enemy 의 state 0 상태는 살아있는 상태 | state 1 상태는 갇힌 상태
					crash();
				}
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
		while (true) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleService.topWall()) {
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
			// TODO test
//			mContext.repaint();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// hit Enemy Observe
	private void crash() {
		mContext.getEnemy().setStatus(1);
		state = 1;
		setIcon(bubbled);
		
//		mContext.getEnemy().setIcon(null);
		mContext.remove(mContext.getEnemy());
		mContext.repaint();
//		mContext.getEnemy(); GC의 제거 대상이 된다
		
		// 적군이 살아있는 상태에서 버블에 갇힌 상태로 변경

		// 1, 버블에 이미지를 변경 처리

	}

}
