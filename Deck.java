// package com.hackathon.dekofcards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards;
	
    public Deck() {
        this.cards = new ArrayList<Card>();

        // Populate the cards list -- loop to 52
        for (String name : new String[] {"Hearts", "Clubs", "Diamonds", "Spades"}) {
            for (Integer rank = 1; rank <= 10; rank++) {
                this.cards.add(new Card(name, rank));
            }
        }
    }
    public ArrayList<Card> roundStart(){
        ArrayList<Card> deck = getCards();
       
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(deck.get(0));
        hand.add(deck.get(1));
        hand.add(deck.get(2));
        hand.add(deck.get(3));
        for(int i = 0; i < 4 ; i++){
            deck.remove(0);
        }
        setCards(deck);
        return hand;
    }
    
     public Card hit(){
        ArrayList<Card> deck = getCards();
        Card hiter = deck.get(0);
        deck.remove(0);
        return hiter;
     }
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

    public void shuffleDeck(ArrayList<Card> cards) {
        Collections.shuffle(cards);
    }
    
}
