# Capitaly-Game
<b>Project Description:</b>\
Simulate a simplified Capitaly game. There are some players with different strategies, and a
cyclical board with several fields. Players can move around the board, by moving forward with
the amount they rolled with a dice. A field can be a property, service, or lucky field. A property
can be bought for 1000, and stepping on it the next time the player can build a house on it for
4000. If a player steps on a property field which is owned by somebody else, the player should
pay to the owner 500, if there is no house on the field, or 2000, if there is a house on it.
Stepping on a service field, the player should pay to the bank (the amount of money is a
parameter of the field). Stepping on a lucky field, the player gets some money (the amount is
defined as a parameter of the field). There are three different kind of strategies exist. Initially,
every player has 10000. Greedy player: If he steps on an unowned property, or his own
property without a house, he starts buying it, if he has enough money for it. Careful player: he
buys in a round only for at most half the amount of his money. Tactical player: he skips each
second chance when he could buy. If a player has to pay, but he runs out of money because of
this, he loses. In this case, his properties are lost, and become free to buy.
Read the parameters of the game from a text file. This file defines the number of fields, and
then defines them. We know about all fields: the type. If a field is a service or lucky field, the
cost of it is also defined. After the these parameters, the file tells the number of the players,
and then enumerates the players with their names and strategies. In order to prepare the
program for testing, make it possible to the program to read the roll dices from the file.
<b>Print out what we know about each player after a given number of rounds (balance, owned
properties).</b>
