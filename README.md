# Library-Management-System
A Java program that functions as a library.

Capabilities:
- At the start of main.java, the library reads the text file "bookList.txt", and adds the books in the text file to the catalog. Changing bookList.txt changes the books the library has.
- A user can login by entering the correct card number; this number is checked against the card number in the text file "cardNumber.txt".
- Once logged in, the user can check the library info(name, number of books, size), along with how many books they have borrowed. Since this project does not use a database, the books the user has borrowed are not stored anywhere, but instead reset everytime "Main.java" is run.
- The user can also check the catalog(all books the library has) and the available books(list of books that the user can currently borrow).
- The user can borrow books and return books, along with respective changes to the available books list.

Read comments in "Main.java" to understand how to use the interface.
