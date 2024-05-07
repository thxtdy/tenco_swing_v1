package bubblebubble.test.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ch06.bubblebubble;

/**
 * 현재 메인 스레드는 너~무 바쁨 백그라운드에서 계속 Player 의 움직임을 관찰할 예정
 */
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private Player down;
	private Bubble bubble;
	
	
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
			// PlayerGetColor
			Color leftColor = new Color(image.getRGB(player.getX() + 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			
			// BubbleGetColor
			Color BLColor = new Color(image.getRGB(bubble.getX() + 10, bubble.getY() + 25 ));
			Color BRColor = new Color(image.getRGB(bubble.getX() + 60, bubble.getY() + 25));
			
			// Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
			
			// 흰색이면 바닥 RGB = 255 * 3;
			// 바닥인 경우 == 255 0 0 (바닥이라고 판단 가능)
			// 바닥인 경우 == 0 0 255 (바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(player.getX() + 20, player.getY()+ 50 + 5);
			int bottomColorRight = image.getRGB(player.getX() + 50 - 10, player.getY()+ 50 + 5);
			
			// 하얀색 == int value = -1
			
			if(bottomColorLeft + bottomColorRight != -2) { // 하얀색이 아닐때
				// 여기는 멈춰야 됨(바닥 Red or Blue)
				player.setDown(false);
			} else { // 하얀색일때
				
				// 플레이어가 올라가는 상태가 아니라면
				// 플레이어가 내려가는 상태가 아니라면
				if(!player.isUp() && !player.isDown()) {
					player.down();
				} 
					
			
				
			} 
			
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
			
			
//			if (leftColor.getRed() == 0 && leftColor.getGreen() == 0 && leftColor.getBlue() == 255) {
//				System.out.println("In blue");
//				
//				player.setDown(false);
//				player.setcenterWallCrash(false);
//				
//			} else {
//				//player.setcenterWallCrash(false);
//			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

}
