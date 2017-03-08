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
    private static String color(int a, int b,int c, int d){
        return ("\033[0;" + a+ ";" + b + ";" + c + ";" + d + "m");
    }
    public void Map(){
	int hPoint = highestPoint();
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		int ccc = 34;
		if(board[r][c] > waterLevel){
		    ccc = 32;
		}
		    int bright = 2;
		    int background = (board[r][c] * 16 /hPoint);
		    if(background > 16){
			background = 16;
		    }
		    if(background > 8){
			background =- 8;
			bright = 1;
		    }
		    System.out.println(color(ccc,background + 30,bright) + █ + " ");
		}
	    }
	    System.out.println("\n");
	}
	System.out.println("\033[0;00m");
    }
}
