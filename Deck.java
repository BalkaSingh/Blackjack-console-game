import java.util.Random;
public class Deck{
	//Fields
	private CardPile deck;
	private Random r;
	
	//Constructor  : Initializes the field(by creating the objects). Creates a deck of cards, with all the possibilities of (enums)values and suits 
	public Deck(){
		this.deck = new CardPile();
		for(Value v : Value.values()){
			for(Suit s : Suit.values()){
					this.deck.add(new Card(v,s));
			}
		}
		this.r = new Random();		
	}
	
	//toString method : Calls the toString of CardPile and returns it for this object
	public String toString(){
		return this.deck.toString();
	}
	
	//drawRandomCard() : It takes a random card from the deck and removes it by calling the remove method from the CardPile class, then return that card 
	public Card drawRandomCard(){
		int randomNum = r.nextInt(this.deck.length());
		Card pickedCard = (this.deck.get(randomNum));
		this.deck.remove(randomNum);
		return pickedCard;
	}
}