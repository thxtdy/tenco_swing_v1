package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame3 extends JFrame {

	private JLabel jPlayer;
	private JLabel backgroundMap;
	private int jPlayerX =100;
	private int jPlayerY =100;
	private final int MOVE_DISTANCE = 50;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 200;
	
	private final String PLAYER_NAME = "Aatrox";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;
	

	public MiniGame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("미니 게임을 만들어 볼까요웃");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		backgroundMap.setSize(1000, 600);
		backgroundMap.setLocation(0, 0);
		
		jPlayer = new JLabel(PLAYER_NAME);
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
	}

	private void setInitLayout() {
		// 좌표 기반으로 배치 관리자 변경 --> 사이즈와 위치 (int x1, int y1) 설정 필수
		setLayout(null);
		add(backgroundMap);
		add(jPlayer);
		jPlayer.setLocation(jPlayerX, jPlayerY);
		setVisible(true);
	}

	private void addEventListener() {
		// jPlayer 객체에게서만
		// keyListener 동작을 시키고자 한다면
		// 익명 구현 클래스로 KeyListener 인터페이스를 재정의 할 수 있드앙.
//		jPlayer.addKeyListener(this);  <-- 안됨 클래스 자체에 KeyListener 을 안 불러왔기 때문.

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jPlayerY -= MOVE_DISTANCE;

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVE_DISTANCE;

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVE_DISTANCE;

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVE_DISTANCE;
				}
				jPlayer.setLocation(jPlayerX, jPlayerY);

				// default 100, 100
			}
		});

	}

	// Code Test
	public static void main(String[] args) {
		new MiniGame3();
	}
}
