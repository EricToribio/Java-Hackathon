// package com.hackathon.dekofcards;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
	//constructor
    private ArrayList<Card> hand;
    public Dealer() {
        this.hand = new ArrayList<Card>();
    }
    //methods 

        // assess the hand and decide whether or not to hit or stay
        public String dealerHitOrStay(){
            //get totalRank of hand:
                ArrayList<Card> currentHand = getHand();
                int totalRank= 0;
                for(Card card: currentHand){
                    totalRank +=card.getRank();
                }
            //if dealer totalRank is <17 dealer must hit
            if (totalRank < 17){
            return "hit";
            }
            else{
                return "stand";
            }
        }
        public void viewHand() {
            System.out.println("Dealer Hand");
            for (Card card: this.getHand()) {
                card.showCard();
            }
        }

        public int TotalRank(){
            int totalRank = 0;
            for (Card card: this.getHand()) {
                totalRank +=card.getRank();
            }
        return totalRank; 
        }
        

    //GETTERS AND SETTERS
        public void setHand(ArrayList<Card> cards){
            for(Card card : cards){
                this.hand.add(card);
            }
        }

        public void setHand(Card card){
            this.hand.add(card);
        }

        public ArrayList<Card> getHand(){
        return this.hand;
    }
}
