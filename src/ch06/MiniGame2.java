package ch06;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame2 extends JFrame {

	private JLabel jPlayer;
	private JLabel backgroundMap;

	private int jPlayerX = 490;
	private int jPlayerY = 510;

	private final int MOVE_DISTANCE = 30;
	private final int MOVE_JUMP = 105;
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 600;

	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;
	
	private Icon Left = new ImageIcon("images/playerL.png");
	private Icon Right = new ImageIcon("images/playerR.png");
	private Icon player;
	
	

	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("미니 게임을 만들어 볼까요웃");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Icon backicon = new ImageIcon("images/backgroundMap.png");
		backgroundMap = new JLabel(backicon);

		backgroundMap.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		backgroundMap.setLocation(0, 0);

		player = Right;
		
		jPlayer = new JLabel(player);
		
		jPlayer.setSize(PLAYER_WIDTH , PLAYER_HEIGHT);
	}

	private void setInitLayout() {
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(jPlayer);
		
		jPlayer.setLocation(jPlayerX, jPlayerY);
		setVisible(true);
	}

	private void addEventListener() {

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
					jPlayerY -= MOVE_JUMP;

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVE_DISTANCE;
					
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayer.setIcon(Left);
					jPlayerX -= MOVE_DISTANCE;
					
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayer.setIcon(Right);
					jPlayerX += MOVE_DISTANCE;
					
//					jPlayer = new JLabel(new ImageIcon("images/playerR"));

				}
				jPlayer.setLocation(jPlayerX, jPlayerY);
				
//				jPlayer = (jPlayerX > 490 || jPlayerX <= 490) ? jPlayer = new JLabel(new ImageIcon("images/playerR")) : jPlayer = new JLabel(new ImageIcon("images/playerL")); 
				
				
				
				// default 100, 100
			}
		});

	}

	// Code Test
	public static void main(String[] args) {
		new MiniGame2();
	}
}
