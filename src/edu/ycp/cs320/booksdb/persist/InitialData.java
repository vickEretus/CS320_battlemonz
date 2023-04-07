package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.booksdb.model.Attack;
import edu.ycp.cs320.booksdb.model.Card;
import edu.ycp.cs320.booksdb.model.BookAuthor;

public class InitialData {

	// reads initial Author data from CSV file and returns a List of Authors
	public static List<Attack> getAttacks() throws IOException {
		List<Attack> attackList = new ArrayList<Attack>();
		ReadCSV readAuthors = new ReadCSV("authors.csv"); //                            Change this to card.csv
		try {
			// auto-generated primary key for authors table
			Integer attackId = 1;
			while (true) {
				List<String> tuple = readAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Attack attack = new Attack();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				attack.setAttackId(attackId++);
				//attack.setPower(i.next());
				attack.setType(i.next());
				attackList.add(attack);
				
//				author.setAuthorId(authorId++);				
//				author.setLastname(i.next());
//				author.setFirstname(i.next());
//				authorList.add(author);
			}
			System.out.println("authorList loaded from CSV file");
			return attackList;
		} finally {
			readAuthors.close();
		}
	}
	
	// reads initial Book data from CSV file and returns a List of Books
	public static List<Card> getCards() throws IOException {
		List<Card> cardList = new ArrayList<Card>();
		ReadCSV readCards = new ReadCSV("books.csv"); //changes to cards.csv
		try {
			// auto-generated primary key for table books
			Integer cardId = 1;
			while (true) {
				List<String> tuple = readCards.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Card card = new Card();
				
				// read book ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file
				Integer.parseInt(i.next());
				// auto-generate book ID, instead
				
				card.setCardId(cardId++);
				card.setAttackId(Integer.parseInt(i.next()));
				card.setDefense(Integer.parseInt(i.next()));
				card.setHP(Integer.parseInt(i.next()));
				card.setName(i.next());
				cardList.add(card);
				
				
				
//				book.setBookId(bookId++);				
////				book.setAuthorId(Integer.parseInt(i.next()));  // no longer in books table
//				book.setTitle(i.next());
//				book.setIsbn(i.next());
//				book.setPublished(Integer.parseInt(i.next()));
//				
//				bookList.add(book);
			}
			System.out.println("bookList loaded from CSV file");			
			return cardList;
		} finally {
			readCards.close();
		}
	}
	
	// reads initial BookAuthor data from CSV file and returns a List of BookAuthors
	public static List<BookAuthor> getBookAuthors() throws IOException {
		List<BookAuthor> bookAuthorList = new ArrayList<BookAuthor>();
		ReadCSV readBookAuthors = new ReadCSV("book_authors.csv");
		try {
			while (true) {
				List<String> tuple = readBookAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				BookAuthor bookAuthor = new BookAuthor();
				bookAuthor.setBookId(Integer.parseInt(i.next()));				
				bookAuthor.setAuthorId(Integer.parseInt(i.next()));
				bookAuthorList.add(bookAuthor);
			}
			System.out.println("bookAuthorList loaded from CSV file");			
			return bookAuthorList;
		} finally {
			readBookAuthors.close();
		}
	}
}