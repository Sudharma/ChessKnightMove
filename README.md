# Building

Build using ant:

    ant jar
    generating build will create dist/ folder with jar

#Prerequisite to Run the program
  
•	Java 1.8 
•	If Eclipse , LUNA version.
•	Ant version > 1.9.0
•	Junit 4.0

# Running

Running without a Number file, will result in reading number from STDIN:

    java -jar chess-knight-move.jar

for help

     java –jar chess-knight-move.jar –h or --help

# Design overview

Firstly, please refer the doc/chess_knight_moves.xlsx for understanding of the layout of the game.

The collection package contains the objects that represent  the chessboard as well as the various chess-players. If game is extended for moving for any other piece this package will have an additional entities like pawn,bishop ,king etc.. Piece is the abstract class which can be implemented by any specific piece(Knight for us in particular) with respect to rule. All the changes/implementations goes inside one piece making sure the strong behavior.

Each Player is a Runnable thread which takes a Play object and alternatively plays for each object with wait and notify mechanism. Play class methods are synchronized which has separate implementations for each black and white player.

ChessContext is for storing the objects which are needed for application(chess) to use.

# Algorithm used.

Please refer the doc/chess_knight_moves/xlsx. For a player 1 , the destination to reach is (8,1) and for player 2 it is (1,8) , Explaination will be for player 1 since it is similar way for Player 2. At any given position of player 1, calculate all possible moves and get the move which has maximum of x(8) and minimum y(1), this happens via generating a score for each square.In case of equality of the x co-ordinates , calculation on least y is done. Every move done is stored as elapsed move which will make sure that the next possible generated moves are not in a deadlock going only to and fro. So each time a new possible move is found when the knight is not finding a potential move, however note that the move may not be optimized but it may go far from (8,1) and come back again with different approach of steps.

For Player 2 its exactly the reverse like, calculate all possible moves and get the move which has minimum of x(1) and maximum y(8), rest logic is the same. 

The Algorithm to some extent is not optimized but it will definitely make any of the player win. Which is our end goal ofcourse :)






