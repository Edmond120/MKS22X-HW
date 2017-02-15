public class KnightBoard{
    private int[][]board;
    boolean show;
    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows,startingCols];
    }

    public String toString(){
	String display = "";
	String num;
	for(int c = 0; c < board.length; c++){
	    for(int r = 0; r < board[c].length; r++){
	        num = (board[c][r] + "");
		display += "_" * (5 - num.length()) + num + " ";
	    }
	    display += '\n';
	}
	return display;
    }
	
    public void solve(){
    }
	
    private boolean solveH(int row ,int col, int number){
    }
}
