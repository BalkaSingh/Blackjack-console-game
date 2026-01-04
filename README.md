# Blackjack (Console) - winter2022Blackjack

Simple console Blackjack game implemented in Java for a class project.

## Overview
This repository contains a text-based Blackjack game that runs in the terminal. The player and dealer each start with two random cards; the player may `Hit` or `Hold`, then a betting round occurs and the dealer automatically draws until reaching 17 or higher. The game uses a simple "candies" betting system.

## Features
- Console-based Blackjack rules (Ace = 1, face cards = 10).
- Random deck drawing with cards removed after drawn.
- Simple betting: player starts with 10 candies; dealer automatically bets 5.

## Files
- `Blackjack.java` - Main game logic and user interaction (game flow, rules, printing).
- `Deck.java` - Creates the deck and provides `drawRandomCard()`.
- `Card.java` - Card object (value + suit) and `toString()`.
- `CardPile.java` - Simple dynamic array to store piles/hands.
- `Player.java` - Player state (hand, sum, candies) and helper methods.
- `Value.java` - Enum of card values and points.
- `Suit.java` - Enum of suits (prints suit symbols).

## Requirements
- Java JDK (8 or newer). The project was tested using JDK 21 but any modern JDK should work.

## Build & Run
Open a terminal in the project folder and compile all Java files, then run the `Blackjack` class:

```bash
javac *.java
java Blackjack
```

The game runs in the terminal and will prompt you for `Hit` or `Hold` and then for a bet amount (0–10 candies).

## How to Play (summary shown by the program)
- You and the dealer each receive 2 random cards; one of the dealer's cards is hidden.
- Choose `Hit` to draw another card, or `Hold` to stop drawing.
- After the player's turn, you place a bet (0–10 candies). Dealer automatically bets 5.
- Dealer draws until reaching a sum of 17 or more.
- Win: have a sum closer to 21 than the dealer (or dealer busts). Winning awards double your bet plus dealer's 5 candies.
- Lose or Draw: you lose the candies you bet; in a draw both lose their bets.

## Notes & Possible Improvements
- Aces are always counted as 1 (no soft-ace logic).
- Game is single-round per run; you can extend it to play multiple rounds and persist candy totals.

## Author
Class project by Balkaran Singh Khosa.