public class QueenBoard{

    private int[][]board;

    private int solutionCount;

    private int[] queenDiagonals;

    

    public QueenBoard(int size){
	board = new int[size][size];
        queenDiagonals = new int[size];
	for(int i = 0; i < size; i++){
	    queenDiagonals[i] = -1;
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	return solveH(0,0);
    }

    private boolean solveH(int col,int row){
	return false;
    }
    private boolean addQueen
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.

     *The board should be reset after this is run.    

     */

    public int getSolutionCount(){
    	return -1;
    }
    public void countSolutions(){
    }
    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String result = "";
	for(int c = 0;c < board.size();c++){
	    for(int r = 0;r < board.size();r++){
		if(board[c][r] < 2){
		    result += '- ';
		}
		else{
		    board[c][r] += 'Q';
		}
	    }
	    result += '\n';
	}
    	return "";
    }
}
