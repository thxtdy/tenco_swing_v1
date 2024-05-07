package bubblebubble.test.MyStudy_Bubble;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundBubbleService implements Runnable{

	private BufferedImage image;
	private Bubble bubble;
	
	public BackgroundBubbleService(Bubble bubble) {
		this.bubble = bubble;
		
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(true) {
			Color upColor = new Color(image.getRGB(bubble.getX() + 25, bubble.getY() + 25));
//			Color leftColor = new Color(image.getRGB(bubble.getX() + 25, bubble.getY() + 25));
//			Color rightColor = new Color(image.getRGB(bubble.getX() + 25, bubble.getY() + 25));
			
			if(upColor.getRed() == 255 && upColor.getGreen() == 0 && upColor.getBlue() == 0) {
				if(bubble.isLeft()) {
					System.out.println("SIIIIIIIIIIIIIIIIIUUUUUUUUUUUUUUUUU");
					bubble.setLeft(false);
					
				} else if (bubble.isRight()) {
					System.out.println(")))))))))))))))))))))))))))))))))))))))");
					bubble.setRight(false);
					
				}
			}
			
//			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
//				System.out.println("eee");
//					bubble.setLeft(false);
//			}else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
//				System.out.println("ererer");
//				bubble.setRight(false);
//			}else {
//				System.out.println("위에 if가 안 먹히고 뚫림");
//				bubble.setLeft(true);
//				bubble.setRight(true);
//			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
