public class CardPile{
	//Fields
	private Card[] cards;
	private int next;
	
	//Constructor : Initializes the fields to an array of 100 cards and next at position 0
	public CardPile(){
		this.next = 0;
		this.cards = new Card[100];
	}
	
	//toString method : represents the array of cards in a string and returns it 
	public String toString(){
		String s = ""+this.cards[0];
		for(int i =1; i<this.next;i++){
			s += " , "+this.cards[i];
		}
		return s;
	}
	
	//add method : Takes as input a card and adds the card to the array
	public void add(Card c){
		//IF next is bigger than the length of array, double the length by calling doubleCapacity
		if (this.next >= this.cards.length) {
			doubleCapacity(); 
		}
		this.cards[this.next] = c;
		this.next++;
	}
	
	//doubleCapacity method : Doubles the length of the array of cards
	private void doubleCapacity(){
		Card[] bigger = new Card[this.cards.length*2];
		for(int i =0; i<this.cards.length ; i++){
			bigger[i] = this.cards[i];
		}
		this.cards = bigger;
	}
	
	//get method : Takes as input a integer to represent the position of array and the returns the card at that position
	public Card get(int x){
		return this.cards[x];
	}
	
	//length method : returns the length of how many cards there is in the array
	public int length(){
		return this.next;
	}
	
	//remove method : Takes as input an integer and removes the card at that postion 
	public void remove(int i){
		for(int j = i; j<this.next;j++){
			this.cards[j] = this.cards[j + 1];
		}
		this.cards[this.next-1]=null;
		this.next--;
	}

}