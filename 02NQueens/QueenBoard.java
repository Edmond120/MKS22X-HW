public class QueenBoard{

    private int[][]board;

    private int solutionCount = 0;

    private boolean once = false;

    private boolean solved = false;

    private boolean temp;

    private int[] queens1;
    public QueenBoard(int size){
	board = new int[size][size];
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
	int[] queens = new int[board.length * 2];
	for(int i = 0; i < board.length * 2; i++){
	    queens[i] = -1;
	}
	once = true;
	solveH(queens,0,0,0);
    }
    private int[] addQueen(int[]queens,int queenNum,int col,int row){
	if(check(queens,queenNum,col,row)){
	    queenNum = queenNum - 1;
	    queens[queenNum * 2] = col;
	    queens[(queenNum * 2) + 1] = row;
	    temp = true;
	}
	else{
	    temp = false;
	}
	return queens;
    }
    private boolean check(int[] queens,int queenNum,int col,int row){
	for(int i = 0; i < queenNum - 1; i++){
	    if(queens[i * 2] == col || queens[(i * 2) + 1] == row || queens[i * 2] - queens[(i * 2) + 1] == col - row){
		return false;
	    }
	}
	return true;
    }
    
    private void solveH(int[] queens,int queenNum,int col,int row){
	if(solved == true){
	    return;
	}
	if(queenNum == board.length){
	    if(once){
		solved = true;
		queens1 = queens;
		return;
	    }
	    else{
		solutionCount++;
		queens1 = queens;
		return;
	    }
	}
	if(row == board.length){
	    return;
	}
	queens = addQueen(queens,queenNum + 1,col,row);
	if(col < board.length){
	    col++;
	}
	else{
	    col = 0;
	    row++;
	}
	if(temp = true){
	    solveH(queens,queenNum + 1,col,row);
	}
	solveH(queens,queenNum,col,row);
	
    }
    public void countSolutions(){
	once = false;
	int[] queens = new int[board.length * 2];
	for(int i = 0; i < board.length * 2; i++){
	    queens[i] = -1;
	}
	solveH(queens,0,0,0);
    }
    public int getSolutionCount(){
    	return solutionCount;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String result = "";
	for(int i = 0;i < queens1.length; i += 2){
	    if(queens1[i] != -1){
		for(int a = 0; a < queens1.length; a++){
		    System.out.println(queens1[a]);
		}
		board[queens1[i]][queens1[i + 1]] = 2;
	    }
	}
	for(int c = 0;c < board.length;c++){
	    for(int r = 0;r < board.length;r++){
		if(board[c][r] < 2){
		    result += "- ";
		}
		else{
		    board[c][r] += 'Q';
		}
	    }
	    result += '\n';
	}
	board = new int[board.length][board.length];
    	return result;
    }
}
