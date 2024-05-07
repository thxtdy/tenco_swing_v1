package bubblebubble.test.ex09;

public interface Movealbe {

	// public abstract 생략 가능 (추상 클래스)
	public abstract void left();
	void right();
	void up();
	
	// 인터페이스 추가 기능 default 사용해보기
	// 인터페이스의 모든 메소드는 추상 메소드이어야 한다.
	// 단, default 메소드 제외
	default void down() {};
	// 마지막의 default 는 세미콜론(;) 추가해야 한다. (버전마다 다름)
	// 특정 클래스가 인터페이스의 추상 메소드를 사용하지 않는 경우 해당 메소드에 default 를 붙여 미사용 가능(미표기) 
	
}
