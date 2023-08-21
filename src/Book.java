
public class Book {
	private String title;
	private String author;
	private int pages;
	private String callNumber = "";
//	private int dueDate;
	
//	String returnDate;
//	String borrowDate;
	
	Book (String title, String author, int pages, String callNumber) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setPages(pages);
		this.setCallNumber(callNumber);
	}
	
//	public int getDueDate() {
//		return dueDate;
//	}
//	public void setDueDate(int dueDate) {
//		this.dueDate = dueDate;
//	}
	
	public String getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPages() {
		return pages;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
}
