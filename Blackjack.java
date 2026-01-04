import java.util.*;
public class Blackjack{
	//Final Constants
	static final int WINNING_NUMBER = 21;
	static final int DEALER_NUMBER = 17;
	static final int DEALER_BET = 5;
	public static void main(String[] args){
		printGameStart();
		
		//Creating OBJECTS
		Deck myDeck = new Deck();
		Player myPlayer = new Player();
		Player myDealer  = new Player();
		Scanner sc = new Scanner(System.in);
		
		//Giving 2 RANDOM cards to dealer and player each
		for(int i = 1; i<=2; i++){
		myPlayer.addValues(myDeck.drawRandomCard());
		myDealer.addValues(myDeck.drawRandomCard());
		}
		
		//The FIRST 2 cards of player
		System.out.println("^^^^^ YOUR 2 FIRST CARDS !!! ^^^^^\n");
		printPlayer(myPlayer);
		//1 card HIDDEN, 1 card SHOWN for the dealer
		System.out.println("*********** Dealer Hand ***********");
		System.out.println("The hand of the Dealer: "+myDealer.getCard(0)+" , HIDDEN CARD\n");
		
		//PLAYER TURN :  Asking the player, hit or hold and actions to sum 
		System.out.println("^^^^^ PLAYER TURN TO HIT OR HOLD !!! ^^^^^\n");
		int playerCardPosition = 1;    //Start at position 1 since player already has 2 cards
		boolean playerHitCondition = true;   
		
		//Loop to hit or hold
		while(playerHitCondition){
		System.out.println("Would you like to hit or hold ? Type Hit or Hold");
		String decision = sc.nextLine();
		System.out.println();
		decision = decision.replace('h','H');  //Replacing a h to H
		
			//VERIFICATION : To validate if it is the right input needed
			while( !decision.equals("Hit") && !decision.equals("Hold") ){
				System.out.println("Wrong input! Please choose again : Type Hit or Hold");
				decision = sc.nextLine();
				decision = decision.replace('h','H');  //Replacing a h to H
				System.out.println();
			}
		
			//Commands if entered Hit (Pick random card and add to the sum)
			if(decision.equals("Hit")){
				myPlayer.addValues(myDeck.drawRandomCard());
				playerCardPosition ++;
				System.out.println("\n~~~The new card of the player is: "+myPlayer.getCard(playerCardPosition)+" ~~~\n\n");
				printPlayer(myPlayer);
				
				//IF Sum Over 21 automatic stop, no more hit and stop the loop
				if(myPlayer.getSum() > WINNING_NUMBER){
					playerHitCondition = false;
				}
			//When HOLD, show again player hand and stop the loop
			}else{
				playerHitCondition = false;
				printPlayer(myPlayer);
			}
			
		}
		//PLAYER BET : Asking how much candies he wants to bet, validate the input and perform the actions to bet 
		System.out.println("^^^^^ PLAYER BET !!! ^^^^^\n");
		System.out.println("How many candies, would you like to bet ? Enter a number between 0 to 10");
		int playerCandy = 0;
		boolean validBet = false;
		
		//Loop to check if a correct type and correct number of input to bet has been entered for the player
		while(!validBet){
			try{
				playerCandy = Integer.parseInt(sc.nextLine());
				myPlayer.removeCandy(playerCandy);
				System.out.println("\n~~~Player bet : "+playerCandy+" candies !~~~\n");
				validBet = true;
			}catch(NumberFormatException e){
				System.out.println("Wrong Input Type Try Again,please enter a integer! \nEnter a number 0 to 10 for candies to bet !");
			}catch(IllegalArgumentException e){
				System.out.println("");
				System.out.println("Wrong Number Input Try Again! \nEnter a number 0 to 10 for candies to bet !");
			}
		}
		
		//DEALER BET : Automatic bet of 5 candies 
		System.out.println("^^^^^ DEALER BET !!! ^^^^^\n");
		myDealer.removeCandy(DEALER_BET);
		System.out.println("~~~Dealer automatically bet : "+DEALER_BET+" candies !~~~\n\n");
		
		//DEALER TURN :  Dealer automatic hitting until 17 or higher sum
		System.out.println("^^^^^ DEALER TURN OF AUTOMATIC HIT !!! ^^^^^");
		
		//Show the dealer card that was hidden at the start
		System.out.println("\n~~~The hidden card of the dealer is: "+myDealer.getCard(1)+" ~~~\n\n");
		printDealer(myDealer);
		
		int dealerCardPosition = 1;    //Start at position 1 since he already has 2 cards
		boolean dealerHitCondition = true;
		
		//Loop to hit automatically until 17 or higher sum reached for the dealer
		while(dealerHitCondition){
			if(myDealer.getSum() >= DEALER_NUMBER){
				dealerHitCondition = false;
			}else{
			myDealer.addValues(myDeck.drawRandomCard());
			dealerCardPosition ++;
			System.out.println("\n~~~The new card of the dealer is: "+myDealer.getCard(dealerCardPosition)+" ~~~\n\n");
			printDealer(myDealer);
			}
		}
		
		//GAME RESULT : Determining Draw, Win or Loss for player & adding the bet results
		//Stores won candies for the player in variable playerWonCandies (Will be added to Player candies and displayed only if Player wins)
		int playerWonCandies = playerCandy*2+DEALER_BET;
		//DRAW : Both have same sums or over 21
		if( (myDealer.getSum() == myPlayer.getSum()) || (myDealer.getSum() > WINNING_NUMBER && myPlayer.getSum() > WINNING_NUMBER) ){
			printDraw(myPlayer,playerCandy);
		}
		//AUTOMATIC WIN : Dealer sum over 21 and Player sum less or equal 21
		else if(myDealer.getSum() > WINNING_NUMBER && myPlayer.getSum() <= WINNING_NUMBER){
			myPlayer.addCandy(playerWonCandies);
			printPlayerWin(myPlayer,playerWonCandies);
		}
		//AUTOMTIC LOSS: Player sum over 21 and Dealer sum less or equal 21
		else if(myPlayer.getSum() > WINNING_NUMBER && myDealer.getSum() <= WINNING_NUMBER){
			printPlayerLoss(myPlayer, playerCandy);
		}
		//ELSE: Both of them have less or equal sum of 21
		else{
			//IF Player has a sum closer to 21, he wins
			if( WINNING_NUMBER - myDealer.getSum() > WINNING_NUMBER - myPlayer.getSum() ){
				myPlayer.addCandy(playerWonCandies);
				printPlayerWin(myPlayer,playerWonCandies);
			}else{
				//ELSE : Dealer has a sum closer to 21, Player lost
				printPlayerLoss(myPlayer, playerCandy);
			}
		}
		
		//GAME OVER message
		System.out.println("| ~~~~~ GAME OVER ~~~~~ |");
	}
	//HELPER METHOD printPlayer : prints hand and sum of player
	public static void printPlayer(Player p){
		System.out.println("*********** Player Hand ***********");
		System.out.println("The hand of player: "+p);
		System.out.println("The sum of cards for the player: "+p.getSum()+"\n");
	}
	//HELPER METHOD printDealer : prints hand and sum of dealer
	public static void printDealer(Player d){
		System.out.println("*********** Dealer Hand ***********");
		System.out.println("The hand of dealer: "+d);
		System.out.println("The sum of cards for the dealer: "+d.getSum()+"\n");
	}
	//HELPER METHOD printPlayerWin : prints the message when player wins
	public static void printPlayerWin(Player p, int playerWonCandies){
		System.out.println("\n$$$$$ CONGRATS PLAYER YOU WON $$$$$\n$$$$$ YOUR REWARDS : "+playerWonCandies+" candies $$$$$");
		System.out.println("YOU NOW HAVE : "+p.getCandy()+" candies\n\n");
	}
	//HELPER METHOD printPlayerLoss : prints the message when player lost
	public static void printPlayerLoss(Player p, int playerCandy){
		System.out.println("\n:( YOU LOST :(\n:( YOUR LOSS : "+playerCandy+" candies :(");
		System.out.println("YOU NOW HAVE : "+p.getCandy()+" candies\n\n");
	}
	//HELPER METHOD printDraw : prints the message when it is a DRAW
	public static void printDraw(Player p, int playerCandy){
		System.out.println("\n>>>>>>> DRAW <<<<<<<\n>>>>>>> YOU BOTH LOST YOUR CANDIES THAT YOU HAD BET <<<<<<<");
		System.out.println(":( YOUR LOSS : "+playerCandy+" candies :(\nYOU NOW HAVE : "+p.getCandy()+" candies\n\n");
	}
	//HELPER METHOD printGameStart : prints the game start message and explanations for rules, bets and results 
	public static void printGameStart(){
		//Game Start Message
		System.out.println("| ~~~ BLACKJACK GAME ~~~ |\n");
		//GOAL OF GAME
		System.out.println("--GOAL : Beat the Dealer\n");
		//HOW TO PLAY (RULES)
		System.out.println("--HOW TO PLAY : \nAce are 1 and face cards are 10, the rest have their normal values.");
		System.out.println("First, you and the dealer will each receive 2 random cards.");
		System.out.println("Both of your cards and one of the dealer's card will be shown.");
		System.out.println("Then, you will have the choice to HIT or HOLD with the current cards you have.");
		System.out.println("You will choose multiple times, until you choose to HOLD or have a sum more than 21.");
		System.out.println("Then, there will be some betting that will be done, that will be further explained !");
		System.out.println("After, the dealer will automatically hit until he reaches a sum of 17 or more.\n");
		//HOW TO WIN : explanation
		System.out.println("--GAME RESULT : \nTO WIN, You need to have a sum of values closer to 21(OR 21 ITSELF) than the dealer.");
		System.out.println("DRAW : Both have the same sum of values or Both over 21.");
		System.out.println("LOSS : Either you have a sum over 21 and the dealer hasn't OR the dealer has a closer sum to 21 than you.\n");
		//BET EXPLAINED
		System.out.println("--BET : \nYou will have 10 candies to bet and the dealer will also have 10 candies.");
		System.out.println("At the end of your HIT or HOLD play, you can choose to bet from 0 to 10 candies and the dealer will automatically bet 5 candies.");
		System.out.println("When you WIN, you will receive double of your bet amount and the 5 candies of the dealer.");
		System.out.println("When you LOSE or DRAW, you will lose the amount of candies you had bet.\n\n");
	}
}