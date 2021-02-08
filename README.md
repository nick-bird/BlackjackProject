## Blackjack Project
This project is a game of Blackjack played on the command line. Upon starting, a dealer will deal cards from a shuffled deck, and allow the player to hit or stay based on their hand. After the player has finished their turn, the dealer flips his 2nd card, and proceeds to hit or stay in accordance with the rules of Blackjack. The player can chose to play again which will re-shuffle a new deck and start over, or quit.

### Technologies Used
This project utilizes object oriented design. There are unique classes representing cards, a deck, and a hand of cards, so that they can be re-used in other games. These classes are inherited and used by another set of unique classes which implement changes to fit the rules of the game. There is a 'game table' class, where the 'player', 'dealer', and 'deck of cards' live, and the game logic is executed.

###Lessons Learned
This project provided valuable lessons in the value of properly planning and designing code before starting to write it. Since this project involves a class hierarchy with multiple moving parts, it was necessary to plan out where and how data will be stored, and how methods will be organized and implemented. After creating a UML diagram for my application, it was possible to write all of the code much more quickly.
