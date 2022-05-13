//Enum that represents the suits of cards 
public enum Suit{
	//toString method for each : returns the string that represents the suit
	HEART{
		public String toString(){
			return "♥";//alt + 3
		}
	},
	SPADE{
		public String toString(){
			return "♠";//alt + 6
		}
	},
	CLUB{
		public String toString(){
			return "♣";//alt + 5
		}
	},
	DIAMOND{
		public String toString(){
			return "♦";//alt + 4
		}
	}
}