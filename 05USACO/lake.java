public class lake{
    private int waterLevel;
    private int steps;
    private int[][]board;
    private int[][]script;
    private boolean animate = false;
    public lake(int waterLevel,int steps,int[][]board,int[][]script){
	this.board = board;
	this.waterLevel = waterLevel;
	this.steps = steps;
	this.script = script;
    }
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
    }
    public int solve(){
	for(int s = 0; s < steps; s++){
	    if(animate){
		clear();
		Map();
		wait(20);
	    }
	    stomp(script[s][0],script[s][1],script[s][2]);
	}
	int water = 0;
	int w;
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		w = waterLevel - board[r][c];
		if(w > 0){
		    water += w;
		}
	    }
	}
	return water * 72 * 72;

    }
    private void stomp(int r, int c,int times){
	r -= 1;
	c -= 1;
	for(int t = 0; t < times; t++){
	    int h = 0;
	    for(int rr = r; rr < r + 3; rr++){
		for(int cc = c; cc < c + 3; cc++){
		    if(board[rr][cc] > h){
			h = board[rr][cc];
		    }
		}
	    }
	    for(int rr = r; rr < r + 3; rr++){
		for(int cc = c; cc < c + 3; cc++){
		    if(board[rr][cc] == h){
			board[rr][cc] -= 1;
		    }
		}
	    }
	}
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
    public void setAnimate(boolean x){
	animate = x;
    }
    private static String color(int a, int b,int c){
        return ("\033[0;" + a+ ";" + b + ";" + c+ "m");
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
		    System.out.println(color(ccc,background + 30,bright) + "█" + " ");
		}
	    System.out.println("\n");
	}
	System.out.println("\033[0;00m");
    }
    public void clear(){
	System.out.println("\033[2J");
    }
}
