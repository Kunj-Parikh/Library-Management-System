import java.util.ArrayList;
import java.util.HashSet;

// Ideas: Add a budget. A library can only buy as many books as it's budget allows.

public class Library {
	private String name;
	private int floors;
	private String size;
	private int maxCapacity;
	private HashSet<Book> catalog = new HashSet<Book>();
	private ArrayList<Book> availableBooks = new ArrayList<Book>();
	private int bookNumber = 1;
	
	Library(String name, int floors, int maxCapacity) {
		this.setName(name);
		this.setFloors(floors);
		this.setMaxCapacity(maxCapacity);
		if(this.maxCapacity > 20000) {
			this.setSize("Large");
		}
		else if(this.maxCapacity > 10000) {
			this.setSize("Medium");
		}
		else {
			this.setSize("Small");
		}
		this.setCatalog(catalog);
		this.setAvailableBooks(availableBooks);
	}
	private int getMaxCapacity() {
		return maxCapacity;
	}
	private void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public void getLibraryInfo() {
		System.out.println("Library name: " + this.getName());
		System.out.println("Number of floors: " + this.getFloors());
		System.out.println("Size of library: " + this.getSize());
		System.out.println("Maximum number of books: " + this.getMaxCapacity());
	}
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	
	private int getFloors() {
		return floors;
	}
	private void setFloors(int floors) {
		this.floors = floors;
	}
	
	private String getSize() {
		return size;
	}
	private void setSize(String size) {
		this.size = size;
	}
	
	public void getCatalog() {
		for(Book book : catalog) {
			System.out.println("Book title: " + book.getTitle() + " Call number: " + book.getCallNumber());
		}
	}
	private void setCatalog(HashSet<Book> catalog) {
		this.catalog = catalog;
	}
	public void addToCatalog(Book book) {
		book.setCallNumber("Book #"+bookNumber);
		catalog.add(book);
		availableBooks.add(book);
		bookNumber++;
	}
	public void removeFromCatalog(Book book) {
		catalog.remove(book);
		availableBooks.remove(book);
	}
	public ArrayList<Book> getAvailableBooks() {
		return availableBooks;
	}
	public void printAvailableBooks() {
		for(Book book : availableBooks) {
			System.out.println("Book title: " + book.getTitle() + " Call number: " + book.getCallNumber());
		}
	}
	private void setAvailableBooks(ArrayList<Book> availableBooks) {
		this.availableBooks = availableBooks;
	}
	public boolean borrowedBook(String callNumber) {
		for(Book bookInCatalog : catalog) {
			if(bookInCatalog.getCallNumber().equalsIgnoreCase(callNumber)) {
				for(Book availableBook : availableBooks) {
					if(availableBook.getCallNumber().equalsIgnoreCase(callNumber)) {
						availableBooks.remove(availableBook);
						System.out.println("Here is your book, with the call number \""+ availableBook.getCallNumber() +"\".");
						return true;
					}
				}
				System.out.println("Sorry, looks like this book has already been checked out.");
				return false;
			}
		}
		System.out.println("Sorry, looks like we don't have the book you're looking for.");
		return false;
	}
	
	public boolean returnedBook(String callNumber) {
		for(Book bookInCatalog : catalog) {
			if(bookInCatalog.getCallNumber().equalsIgnoreCase(callNumber)) {
				for(Book availableBook : availableBooks) {
					if(availableBook.getCallNumber().equalsIgnoreCase(callNumber)) {
						System.out.println("We already have the book you are trying to return.");
						return false;
					}
				}
				System.out.println("The book with the call number \"" + bookInCatalog.getCallNumber() + "\" was successfully returned.");
				return true;
			}
		}
		System.out.println("That book was never ours to begin with.");
		return false;
		/*if(availableBooks.contains(book)) {
			System.out.println("We already have this book you are trying to return.");
		}
		else {
			availableBooks.add(book);
			System.out.println("The book with the call number "+ book.getCallNumber() +" was successfully returned.");
		}*/
		
	}
	
}
