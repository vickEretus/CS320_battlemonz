package edu.ycp.cs320.booksdb.persist;

import java.util.List;

import edu.ycp.cs320.booksdb.model.Attack;
import edu.ycp.cs320.booksdb.model.Card;
import edu.ycp.cs320.booksdb.model.Pair;

public interface IDatabase {
	public Card findCardByCardId(int cardId);
	public Integer findAccountByUsernameAndPassword( String username, String password  );
	public Integer insertNewAccountByUsernameAndPassword(String username, String password);
	public List<Card> findAllCards();
}
