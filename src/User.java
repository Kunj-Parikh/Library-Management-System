import java.util.HashSet;

public class User {
	private HashSet<String> booksBorrowed = new HashSet<String>();
	private String name;
	private String cardNumber;
	
	User(String name, String cardNumber) {
		this.setName(name);
		this.setCardNumber(cardNumber);
		this.setBooksBorrowed(booksBorrowed);
	}

	public void printBooksBorrowed() {
		for(String callNumber : booksBorrowed) {
			System.out.println(callNumber);
		}
	}
	public HashSet<String> getBooksBorrowed() {
		return booksBorrowed;
	}
	void borrowBook(String callNumber) {
		booksBorrowed.add(callNumber);
	}
	void returnBook(String callNumber) {
		booksBorrowed.remove(callNumber);
	}

	public void setBooksBorrowed(HashSet<String> booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}

	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	private void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
}
