public class Player{
	//Fields
	private CardPile hand;
	private int sum;
	private int candy;
	
	//Constructor : Initializes the fields(Create an object CardPile for the hand field), sum field to 0 and candy field to 10 
	public Player(){
		this.hand = new CardPile();
		this.sum = 0;
		this.candy = 10;
	}
	
	//get methods 
	//Returns the int value of sum
	public int getSum(){
		return this.sum;
	}
	//Returns the hand( which is a CardPile object)
	public CardPile getHand(){
		return this.hand;
	}
	//Returns an int, amount of Candy
	public int getCandy(){
		return this.candy;
	}
	
	//toString method : Calls the toString of CardPile and returns it for this object
	public String toString(){
		return this.hand.toString();
	}
	
	//addValues method : Takes as input a Card and calls the add method from the CardPile, then gets the value of the card(get method from Card) and adds it to sum field 
	public void addValues(Card c){
		this.hand.add(c);
		Value v1 = c.getValue();
		this.sum += v1.getPoints();
	}
	
	//getCard method : Takes as input an integer and returns the card at that position 
	public Card getCard(int i){
		return this.hand.get(i);
	}
	
	//remove candies method : Takes as input an integer and removes that amount of candies from the candy field
	public void removeCandy(int i){
		//Checks if it is less than 0 and bigger than 10, then throws an exception
		if( i < 0 || i > 10 ){
			throw new IllegalArgumentException("The number of candies you tried to bet is not in the range of candies that you have !!!");
		}
		this.candy -= i;
	}
	
	//add candies method : Takes as input an integer and adds that amount of candies to the candy field
	public void addCandy(int i){
		this.candy += i;
	}
}