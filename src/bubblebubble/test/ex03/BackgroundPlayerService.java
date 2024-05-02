package bubblebubble.test.ex03;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 현재 메인 스레드는 너~무 바쁨
 * 백그라운드에서 계속 Player 의 움직임을 관찰할 예정
 */
public class BackgroundPlayerService implements Runnable{

	private BufferedImage image;
	private Player player;
	
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
		
		while(true) {
			
			// 색상 확인 TODO (보정값 필요)
			Color leftColor = new Color(image.getRGB(player.getX() + 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			
			// 왼쪽에 충돌함
			
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함.");
			} else if(rightColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함.");
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
