package bubblebubble.test.ex04;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	// 포함 관계 - 컴포지션
	private Player player;

	public BubbleFrame() {
		initData(); // 순서 중요 : 생성 -> 동
		setInitLayout();
		addEventListener();
		
		// Player 백그라운드 서비스 시작
//		new BackgroundPlayerService(player);
		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initData() {
		// TODO 이미지 변경
//		backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root panel
		setContentPane(backgroundMap);
		setSize(1000, 640);

		player = new Player();

	}

	private void setInitLayout() {
		// 좌표 값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가
		setLocationRelativeTo(null); // JFrame을 우리 모니터 가운데 자동 배치!
		setVisible(true);
		add(player);

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
				case KeyEvent.VK_DOWN:
					if(!player.isDown() && !player.isCenterWallCrash()) {
						player.down();
					}
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

	public static void main(String[] args) {
		new BubbleFrame();
		
		String smile = null;
		System.out.println(smile.toString();
	} // end of main

}
