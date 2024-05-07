package bubblebubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubblebubble.components.Enemy;

/**
 * 현재 메인 스레드는 너~무 바쁨 백그라운드에서 계속 Player 의 움직임을 관찰할 예정
 */
public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enemy;
//	private Player down;
//	private Bubble bubble;
	
	// 생성자 의존 주입 DI
	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;

		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (true) {

			// 색상 확인 TODO (보정값 필요)
			Color leftColor = new Color(image.getRGB(enemy.getX() + 10, enemy.getY() + 25));
			Color rightColor = new Color(image.getRGB(enemy.getX() + 50, enemy.getY() + 25));
			
			// 흰색이면 바닥 RGB = 255 * 3;
			// 바닥인 경우 == 255 0 0 (바닥이라고 판단 가능)
			// 바닥인 경우 == 0 0 255 (바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(enemy.getX() + 20, enemy.getY()+ 50 + 5);
			int bottomColorRight = image.getRGB(enemy.getX() + 50 - 10, enemy.getY()+ 50 + 5);
			
			// 하얀색 == int value = -1
			
			
				
			


			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

}
