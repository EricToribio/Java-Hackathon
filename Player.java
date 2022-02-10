import java.util.ArrayList;

public class Player{

    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.setName(name);
        this.hand = new ArrayList<Card>();
    }
    
    public int TotalRank(){
        int totalRank = 0;
        for (Card card: this.getHand()) {
            totalRank +=card.getRank();
        }return totalRank; 
    }
    public void reset(){
        
    }

    public void viewHand() {
        int totalRank = 0;
        System.out.println("Player Hand");
        for (Card card: this.getHand()) {
			card.showCard();
            totalRank +=card.getRank();   
		}
        System.out.println("Total Rank: " + totalRank);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public void setHand(ArrayList<Card> cards){
        for(Card card : cards){
            this.hand.add(card);
        }
    }
    public void setHand(Card card){
        this.hand.add(card);
    }
    

}