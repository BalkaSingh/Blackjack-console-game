public class Card{
	//Fields
	private Value value;
	private Suit suit;
	
	//Constructor : Takes as input 2 enums (value and suit) and intializes the field to those inputs
	public Card(Value value, Suit suit){
		this.value = value;
		this.suit = suit;
	}
	
	//get methods
	//Returns the value of the card
	public Value getValue(){
		return this.value;
	}
	//Returns the suit of the card
	public Suit getSuit(){
		return this.suit;
	}
	
	//toString method : Represent one card in a string and returns it
	public String toString(){
		return this.value+" "+this.suit;
	}

}