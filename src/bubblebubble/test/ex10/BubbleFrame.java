package bubblebubble.test.ex10;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	
	// 컨텍스트를 생성하는 방법(셀프 참조)
	BubbleFrame mContext = this; // context == 개발자들이 주로 쓰는
	
	private JLabel backgroundMap;
	// 포함 관계 - 컴포지션
	private Player player;
	private Enemy enemy1;
	
	public BubbleFrame() {
		initData(); // 순서 중요 : 생성 -> 동
		setInitLayout();
		addEventListener();
		
		// Player 백그라운드 서비스 시작
//		new BackgroundPlayerService(player);
		
		
	}

	private void initData() {
		// TODO 이미지 변경
//		backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root panel
		setContentPane(backgroundMap);
		setSize(1000, 640);
		
		// mContext --> 참조 타입 () --> 주소값의 크기는 기본 4byte.
		player = new Player(mContext);
		enemy1 = new Enemy(mContext);

	}

	private void setInitLayout() {
		// 좌표 값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가
		setLocationRelativeTo(null); // JFrame을 우리 모니터 가운데 자동 배치!
		setVisible(true);
		add(player);
		add(enemy1);
	}

	private void addEventListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 구현
					
					// 왼쪽으로 방향키 누르고 있다면
					// keyEvent 가 계속 실행됨
					// 왼쪽 상태가 아니라면
					// 왼쪽 벽에 충돌한게 아니라면
					if(!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				default:
					break;

				case KeyEvent.VK_RIGHT:
					if(!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
					

				case KeyEvent.VK_UP:
					if(!player.isUp() && !player.isUpWallCrash()) {
						player.up();
						
					}
					break;
			
				case KeyEvent.VK_SPACE:
					player.attack();
					// 프레임에 컴포넌트를 add 동작은 누구의 몫? JFrame --> add() Methods
					// 버블 실행 시에 끊김 현상이 발생하는 이유는 왤까.
					break;
				}

			} // end of keyPressed

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 구현
					
					
					player.setLeft(false);
					break;
				default:
					break;

				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
			
					
				case KeyEvent.VK_UP:
					if(player.isUp() || player.isUpWallCrash()) {
						player.setUp(false);
						
					}
					break;
				
				}

			} // end of KeyReleased
		});

	}
	public Player getPlayer() {
		return player;
	}
	public Enemy getEnemy() {
		return enemy1;
	}

	public static void main(String[] args) {
		// main method 를 가진 클래스는 하위에 생성된 모든 객체들의 주소값을 알고 있음. 중요합니다ㅏㅏㅏㅏㅏㅏㅏㅏ
		new BubbleFrame();
		
	} // end of main

}
