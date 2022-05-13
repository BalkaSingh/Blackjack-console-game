//Enum that represents the value of cards
public enum Value{
	//toString method for each : returns the string that represents the value
	ACE(1){
		public String toString(){
			return "Ace";
		}
	},
	TWO(2){
		public String toString(){
			return "2";
		}
	},
	THREE(3){
		public String toString(){
			return "3";
		}
	},
	FOUR(4){
		public String toString(){
			return "4";
		}
	},
	FIVE(5){
		public String toString(){
			return "5";
		}
	},
	SIX(6){
		public String toString(){
			return "6";
		}
	},
	SEVEN(7){
		public String toString(){
			return "7";
		}
	},
	EIGHT(8){
		public String toString(){
			return "8";
		}
	},
	NINE(9){
		public String toString(){
			return "9";
		}
	},
	TEN(10){
		public String toString(){
			return "10";
		}
	},
	JACK(10){
		public String toString(){
			return "Jack";
		}
	},
	QUEEN(10){
		public String toString(){
			return "Queen";
		}
	},
	KING(10){
		public String toString(){
			return "King";
		}
	};
	
	//Field for the points of the Enum Value
	private final int points;
	
	//Constructor : Takes as input the points field and intialize it  
	private Value(final int points){
		this.points = points;
	}
	
	//getPoints method  : returns the points for the Enum Value
	public int getPoints(){
		return this.points;
	}
}