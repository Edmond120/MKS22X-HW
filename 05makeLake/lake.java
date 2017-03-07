public class lake{
    private int waterLevel;
    private int steps;
    private int[][]board;
    public lake(int r, int c, int waterLevel,int steps){
	board = new int[r][c];
	this.waterLevel = waterLevel;
	this.steps = steps;
    }
    public int highestPoint(){
	int n = 0;
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		if(board[r][c] > n){
		    n = board[r][c];
		}
	    }
	}
	return n;
    }
    public void Map(){
	int hPoint = highestPoint();
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		if(board[r][c] > waterLevel){
		    System.out.println("" + ((board[r][c] * int) / hPoint) + " ");
		}
		else{
		    
		}
	    }
	}
	System.out.println("");
    }

