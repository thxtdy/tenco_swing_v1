package bubblebubble.test.ex06;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel{
	
	private Player player;
	
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
	public Bubble(Player player) {
		this.player = player;
		
		initData();
		setInitLayout();
	}
	//get,set
	
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
	private void shootbubble() {
		
		
	}


}
