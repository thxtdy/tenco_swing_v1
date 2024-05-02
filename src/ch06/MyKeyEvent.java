package ch06;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * 키 이벤트 리스너 사용해보긩긩
 */
public class MyKeyEvent extends JFrame implements KeyListener{
	
	private JTextArea textArea;
	
	public MyKeyEvent() {
		
		initData();
		setInitLayout();
		addEventListener();
		
	}
	
	private void initData() {
		setSize(500, 500);
		setTitle("메모장이랄까입니다.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// 프레임 사이즈 조절 불가
		
		textArea = new JTextArea(); 
		
	}
	private void setInitLayout() {
		// 좌표 기준으로 세팅하고 싶다면 null
		setLayout(new BorderLayout());
		add(textArea);
		setVisible(true);
		
	}
	
	private void addEventListener() {
		// textArea 위에서 사용자가 키보드를 누르면 감지해서
		// 나에게(코드기준) 알려줘
		textArea.addKeyListener(this);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// 응답하라 1111
		System.out.println(e.toString());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 응답하라 2222
//		System.out.println(e.getExtendedKeyCode());
		
//		System.out.println("keyPressed : " + e.getExtendedKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 문제 1
		// 제어문을 활용해서 방향키 위 아래 왼쪽 오른쪽이 눌렀다가 떼면 
		// 콘솔창에 한글로 위 아래 왼쪽 오른쪽 출력
//		System.out.println("위");
		if(e.getExtendedKeyCode() == 37) {
			System.out.println("왼쪽");
		} else if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {  // <-- KeyEvent 클래스에서 자바 개발자들이 설정해놓은 상수를 불러올 수 있다.
			System.out.println("위");
		} else if(e.getExtendedKeyCode() == 39) {
			System.out.println("오른쪽");
		} else if(e.getKeyCode() == 40) {
			System.out.println("아래");
		}
		// 코드의 가독성을 위해 고유 넘버를 상수로 만들 수 있다.
		
	}
}
// e.getExtendedKeyCode 는 내 생각에 키보드 입력값의 고유 넘버를 뜻하는거 같다.
// e.get
