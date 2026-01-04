//Enum that represents the suits of cards 
public enum Suit{
	//toString method for each : returns the string that represents the suit
	HEART{
		public String toString(){
			return "♥️";
		}
	},
	SPADE{
		public String toString(){
			return "♠️";
		}
	},
	CLUB{
		public String toString(){
			return "♣️";
		}
	},
	DIAMOND{
		public String toString(){
			return "♦️";
		}
	}
}