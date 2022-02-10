import java.util.ArrayList;

// package com.hackathon.dekofcards;

public class TestDeck {

	public static void main(String[] args) {
	

		Deck myDeck = new Deck();
		boolean nextRound = true;
		Player player = new Player("bob");
		Dealer house = new Dealer();
		while(nextRound){
			myDeck.shuffleDeck( myDeck.getCards());
			
			boolean playerturn = true;
			Boolean dealerTurn = true;
			ArrayList<Card> intialDeal = myDeck.roundStart();
			ArrayList<Card> playerHand = new ArrayList<Card>();
			ArrayList<Card> dealerHand = new ArrayList<Card>();
			playerHand.add(intialDeal.get(0));
			dealerHand.add(intialDeal.get(1));
			playerHand.add(intialDeal.get(2));
			dealerHand.add(intialDeal.get(3));
			player.setHand(playerHand);
			house.setHand(dealerHand);
			while(playerturn){
				player.viewHand();
				if(player.TotalRank() == 21){
					playerturn = false;
					System.out.println("Winner Winner Chicken Dinner");
					break;
				}else if(player.TotalRank() > 21){
					playerturn = false;
					dealerTurn = false;
					System.out.println("Bust");
					break;
				}
				System.out.println("Do you want to hit it or quit it");
				System.out.println("Enter hit or stand");
				String response = System.console().readLine();
				if(response.toLowerCase().equals("hit")){
					player.setHand(myDeck.hit());

				}else if(response.toLowerCase().equals("stand")){
					playerturn = false;
				}

			}
			
			while(dealerTurn){
				house.viewHand();
				if(house.TotalRank() == 21){
					dealerTurn = false;
					break;
				}else if(player.TotalRank() > 21){
					dealerTurn = false;
					System.out.println("Bust");
					break;
				}
			String dealerResponse = house.dealerHitOrStay();
			if(dealerResponse.equals("hit")){
				house.setHand(myDeck.hit());
			}else{
				dealerTurn= false;
			}
		}
			if( !playerturn && !dealerTurn){
				if(house.TotalRank() > player.TotalRank()){
					System.out.println("You loose");
				} else if(house.TotalRank() < player.TotalRank()){
					System.out.println("you win");
				}else{
					System.out.println("Draw");
				}
			}
			System.out.println(player.getName() + "Would you like to play another round?  Y/N");
				String newRound = System.console().readLine();
				if(newRound.toLowerCase().equals("n")){
					nextRound = false;
				}
				
		}
	}
}
