public class OthelloAI78982550 implements OthelloAI
{
	OthelloGameState bestState;
	OthelloMove bestMove;
	int depth = 100;
	long currentTime;


	public OthelloMove chooseMove(OthelloGameState state) 
	{
		int maxMove = -9999;
		int minMove = +9999;
		OthelloMove currentPosition = null;
		long initialTime = java.lang.System.currentTimeMillis();

		//Black's turn
		if(state.isBlackTurn())
		{
			//Goes through the 2d array
			for (int i = 0; i < 8; i++)
			{
				for (int j = 0; j < 8; j++)
				{
					//Checks for the validity of the move
					if(state.isValidMove(i, j))
					{
						//Current position is the best move
						bestMove = new OthelloMove(i,j);

						//Checks move to be under 5 seconds
						if(timer(initialTime))
						{
							if(!(currentPosition == null))
								bestMove = currentPosition;

							return bestMove;
						}
						else
						{
							//Checks if the current move is the best move
							OthelloGameState temp = state.clone();
							temp.makeMove(i, j);

							int tempSearch = search(temp,depth);

							if(tempSearch > maxMove)
							{
								maxMove = tempSearch;
								currentPosition = new OthelloMove(i,j);
							}	
						}

					}

				}				


			}
		}

		//If its White's turn then everything else happens same as the Black turn
		else
		{
			for (int i = 0; i < 8; i++)
			{
				for (int j = 0; j < 8; j++)
				{

					if(state.isValidMove(i, j))
					{
						bestMove = new OthelloMove(i,j);
						if(timer(initialTime))
						{
							if(!(currentPosition == null))
								bestMove = currentPosition;

							return bestMove;
						}
						else
						{
							OthelloGameState temp = state.clone();
							temp.makeMove(i, j);
							int tempSearch = search(temp,depth);

							if(tempSearch < minMove)
							{
								minMove = tempSearch;
								currentPosition = new OthelloMove(i,j);

							}	
						}

					}

				}				


			}	
		}

		if(!(currentPosition == null))
			bestMove = currentPosition;

		return bestMove;
	}


	//Moves are evaluated in this method
	public int eval(OthelloGameState s, int i, int j)
	{
		//		int evalScore = s.getBlackScore() - s.getWhiteScore();
		//		return evalScore;

		int returnScore;

		if(i< 4)
		{
			i= 7 - i;
			returnScore = i*j;
		}
		else
		{
			returnScore = i*j;
		}

		if(j < 4)
		{
			j = 7 - j;
			returnScore = i * j;
		}
		else
		{
			returnScore = i * j;
		}
		
		return returnScore;
	}

	//Time is checked here, time has to be under 5 seconds
	public boolean timer(long initialTime)
	{
		currentTime = java.lang.System.currentTimeMillis();
		long time = currentTime - initialTime;

		if(time > 5000)
			return true;
		else 
			return false;

	}


	//Replica of the sudo code 
	public int search(OthelloGameState s, int depth)
	{
		
		int max = -9999;
		int min= 9999;

		if (depth == 0 || !(s.gameIsOver()))
		{
			return eval(s,0,0);
		}

		else
		{
			if (s.isBlackTurn())
			{
				for (int i = 0; i < 8; i++)
				{
					for (int j = 0; j < 8; j++)
					{

						if(s.isValidMove(i, j))
						{
							max = eval(s,i,j);
							bestMove = new OthelloMove(i,j);
							bestState = s.clone();
							search(s,depth-1);
						}

					}				

					return max;
				}
			}

			else
			{
				for (int i = 0; i < 8; i++)
				{
					for (int j = 0; j < 8; j++)
					{

						if(s.isValidMove(i, j))
						{
							bestState = s.clone();
							min = eval(s,i,j);
							bestMove = new OthelloMove(i,j);
							search(s,depth-1);
						}

					}	

				}
				return min;
			}
		}
		return min;

	}


	public String getName()
	{
		return "Algo Attack!";
	}
}



