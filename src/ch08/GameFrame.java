package ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel imagePanel;
	
	int playerSize = 50;

	int player1X = 500;
	int player1Y = 420;

	int enemy1X = 250;
	int enemy1Y = 420;

//	int playerJump = 10;
	int playerMoveMent = 5;

	boolean spaceskill = true;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	// 클래스에 안에 클래스 -> 중첩 클래스 -> 외부 클래스, 내부 클래스
	private class ImagePanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawImage(backgroundImage, 0, 0, 1000, 600, null);

			// TODO player, enemy Image -> get draw
			// Use Thread
			g.drawImage(enemy1, enemy1X, enemy1Y, 50, 50, null);
			g.drawImage(player1, player1X, player1Y, playerSize, playerSize, null);

			
			
			
//			if (player1X != enemy1X && player1Y != enemy1Y) {
//				
//			} else if (player1X == enemy1X) {
//				g.drawImage(player1, player1X, player1Y, 0, 0, null);
//				
//			}

		}

		@Override
		public void run() {

			// true : 왼쪽으로 가는 상황
			// false : 오른쪽으로 가는 상황
			boolean direction = true;

			while (true) {
				System.out.println("진행 중");

				if (spaceskill) {

					if (direction) {
						enemy1X -= 5;

					} else {
						enemy1X += 5;
					}

					// 방향 바꾸는 개념은 적군 x 좌표값이
					if (enemy1X <= 250)
						direction = false;

					if (enemy1X > 700)
						direction = true;
				} else {
					return;
				}

				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				repaint();
			}

		}

	}

	private void initData() {
		setTitle("Thread 활용한 미니 예제");
		setSize(1000, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			// 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerL.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		imagePanel = new ImagePanel();
		// 다른 작업자에게 일을 위임시킨다.
		Thread thread1 = new Thread(imagePanel);
		thread1.start();

	}

	private void setInitLayout() {
		// 배치 관리자를 좌표 기반
//		setLayout(null);
//		setResizable(false); // 프레임 크기 조절 불가 설정
		setVisible(true);

		add(imagePanel);

	}

	private void addEventListener() {
		// 이벤트 리스너 등록 방법 2가지

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();

				if (code == KeyEvent.VK_UP) {
					player1Y -= playerMoveMent;
				} else if (code == KeyEvent.VK_DOWN) {
					player1Y += playerMoveMent;

				} else if (code == KeyEvent.VK_LEFT) {
					player1X -= playerMoveMent;

				} else if (code == KeyEvent.VK_RIGHT) {
					player1X += playerMoveMent;

				} else if (code == KeyEvent.VK_SPACE) {
					// Space 를 눌렀을때 적군을 멈출 수 있도록 코드 수정
					spaceskill = false;
				}
				// player 가 적군과 만났을때 player 그림을 없애주세요.
				if(player1X == enemy1X && player1Y == enemy1Y) {
					
					playerSize = 0;
				} 

				repaint();

			} // end of keyPressed
		});

	}
}
