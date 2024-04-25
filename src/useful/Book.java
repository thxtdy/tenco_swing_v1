package useful;

import java.lang.*;
/**
 * Object 클래스는 모든 클래스의 최상위 클래스이다.
 * import java.lang.*; 프로그래밍 시 import 하지 않아도 자동으로 가지고 온다.( * 은 다 가지고 온다.)
 * e x): string,System
 * 자바는 단일 상속만 지원한다. 단,Object 클래스를 제외하고.
 */
public final class Book extends Object{
	
	// class 앞에 final 을 붙이면 상속을 못 받게 한다.
	
	private String title;
	private String author;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	
	}
	// Object -> toString();
	
	@Override
	public String toString() {
		return "[" + title + ", " + author +  "]";
	}
	
	public static void main(String[] args) {
		Book book = new Book("플러터UI실전", "김근호");
		System.out.println(book);
		System.out.println("==========================");
		
		String str1 = new String("안녕");
		System.out.println(str1);
		
	}
	
		
}
