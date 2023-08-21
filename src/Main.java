import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String trueNum = "";
		String name = "";
		Library library1 = new Library("New Milford Library", 3, 15000);
		// Buy books and add them to the library catalog:
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/eclipse-workspace/Library/src/bookList.txt"));
			int numOfBooks = Integer.parseInt(br.readLine());
			String info = "";
			for(int i = 0; i < numOfBooks; i++) {
				info = br.readLine();
				String[] bookInfo = info.split(", ");
				Book book = new Book(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2]), "placeholder");
				library1.addToCatalog(book);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Welcome to the " + library1.getName() + "! Please enter your library card number: ");
		String libraryCardNum = scan.nextLine();
		try {
			BufferedReader r = new BufferedReader(new FileReader("C:/eclipse-workspace/Library/src/cardNumber.txt"));
			trueNum = r.readLine();
			name = r.readLine();
			r.close();
			if(!trueNum.equals(libraryCardNum)) {
				System.out.println("Sorry, that's not the correct number!");
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user = new User(name, libraryCardNum);
		// Initiate a user object; otherwise, you will call all methods from the main, not from the user. If you add more users, how do you manage?
		System.out.println("\nHello " + user.getName() + "! If you would like to check out a book, then "
					+ "please type \"Borrow [Call number]\".\nForgot your card number? "
					+ "Then type \"card number\" below. To see the library catalog, type \"catalog\"."
					+ "\nFor information on the library, type \"library\". "
					+ "To see the list of available books, type \"available books\""
					+ "\nTo return a book, type \"Return [Call number]\". "
					+ "To see a list of the books you borrowed, type \"books borrowed\""
					+ "\nIf you would like to leave the library, type \"exit\".");
		String input = "";
		
		int i = 0;
		while(!input.equalsIgnoreCase("exit")) {
			i++;
			input = scan.nextLine();
			if(i >= 50) {
				System.out.println("You've been to the help desk "+ i + " times today! Go home!");
			}
			switch(input.toUpperCase()) {
				case "LIBRARY":
					library1.getLibraryInfo();
					break;
				case "CATALOG":
					library1.getCatalog();
					break;
				case "AVAILABLE BOOKS":
					library1.printAvailableBooks();
					break;
				case "CARD NUMBER":
					System.out.println(user.getCardNumber());
					break;
				case "BOOKS BORROWED":
					user.printBooksBorrowed();
					break;
				default:
					if(input.toUpperCase().contains("BORROW")) {
						String[] splitInput = input.split("Borrow ");
						String callNumber = splitInput[1];
						// Allow user to send request to library, but let library handle all the requests:
						if(library1.borrowedBook(callNumber)) {
							user.borrowBook(callNumber);
						}
					}
					else if(input.toUpperCase().contains("RETURN")) {
						String[] splitInput = input.split("Return ");
						String callNumber = splitInput[1];
						// Allow user to send request to library, but let library handle all the requests:
						if(library1.returnedBook(callNumber)) {
							user.returnBook(callNumber);
						}
					}
			}
		}
		if(i >= 100) {
			System.out.println("Did you really have to go the library help desk more than a hundred times today?!");
		}
		scan.close();
	}
}
