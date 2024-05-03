package bubblebubble.test.ex05;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 현재 메인 스레드는 너~무 바쁨 백그라운드에서 계속 Player 의 움직임을 관찰할 예정
 */
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private Player down;
	
	
	
	// 생성자 의존 주입 DI
	public BackgroundPlayerService(Player player) {
		this.player = player;

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
			Color leftColor = new Color(image.getRGB(player.getX() + 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			
			// 왼쪽에 충돌함

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함.");
				player.setLeftWallCrash(true);
				player.setLeft(false);

			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함.");
				player.setRightWallCrash(true);
				player.setRight(false);
				
			}  else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
				player.setUpWallCrash(false);
			}
			
			
			if (leftColor.getRed() == 0 && leftColor.getGreen() == 0 && leftColor.getBlue() == 255) {
				System.out.println("In blue");
				
				player.setDown(false);
				player.setcenterWallCrash(false);
				
			} else {
				//player.setcenterWallCrash(false);
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

}
