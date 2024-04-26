package useful;

public class EBook {

	private int bookTypeId;
	private String title;
	private String author;

	public EBook(int bookTypeId, String title, String author) {
		super();
		this.bookTypeId = bookTypeId;
		this.title = title;
		this.author = author;
	}

	// Object 클래스에 있는 메소드를 재정의
	@Override
	public String toString() {

		return bookTypeId + ", " + title + ", " + author;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof EBook) {
			// 1. EBook 클래스의 인스턴스가 맞다면
			EBook tbook = (EBook) obj;
			// 2. EBook 의 제목과 저자의 이름이 같다면 true 반환시켜라
			if (this.title.equals(tbook.title)) {
				return true;

			} else {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

		EBook book1 = new EBook(1, "플러터UI실전", "김근호");
		EBook book2 = new EBook(1, "플러터UI실전", "김근호");

		System.out.println("========================================");
		
		boolean result1 = book1 == book2;
		System.out.println("result1 : " + result1);
		
		boolean result2 = book1.equals(book2);
		System.out.println("result2 : " + result2);


	}
}