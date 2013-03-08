// OthelloAI.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #2: Black and White
//
// Your AI should be implemented in a class that implements this OthelloAI
// interface.  Remember that your AI class needs to follow a specific
// naming convention.  It should be called "OthelloAI[yourID#]".  So, if
// your student ID# is 12345678, your AI class should be called
// "OthelloAI12345678".  Naturally, you should write that class in a file
// called "OthelloAI12345678.java".


public interface OthelloAI
{
	// getName() returns the name of your AI, which will be displayed in
	// tournament results.  Two rules about your AI's name:
	//
	// * It must be no longer than 40 characters
	// * It must not be something that is likely to be offensive to others,
	//   so leave out profanity, slurs, etc.
	public String getName();
	
	
	// chooseMove() takes an OthelloGameState and chooses the best move,
	// returning an OthelloMove that indicates what the move is.  For
	// example, if the appropriate move is to place a tile in row 0 column 3,
	// you'd return a new OthelloMove with row 0 and column 3.
	public OthelloMove chooseMove(OthelloGameState state);
}
