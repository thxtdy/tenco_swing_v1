package bubblebubble.test.ex03;

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
					player.left();
					break;

				case KeyEvent.VK_RIGHT:
					player.right();
					break;

				case KeyEvent.VK_UP:
					player.up();
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

				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
					
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				}

			} // end of KeyReleased
		});

	}

	public static void main(String[] args) {
		new BubbleFrame();
	} // end of main

}
