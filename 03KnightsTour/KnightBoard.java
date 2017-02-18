public class KnightBoard{
    private int[][]board;
    private int xLength;
    private int yLength;
    private int stepNum = 0;
    boolean show;
    public KnightBoard(int startingRows,int startingCols) {
	xLength = startingRows;
	yLength = startingCols;
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
    private void solve21x21(){
    }
    private boolean _3Or7;
    private int hallowX;
    private int hallowY;
    private int thicknessW;
    private int thicknessL;
    private int width;
    private int length;
    private void solveSquareH(){
    }
    private void solveSquare(){
	if(xLength % 21 == 0){
	    solve21x21();
	}
	else{
	    int halve = xLength / 2;
	    width = (halve / 3) * 3;
	    length = (halve / 7) * 7;
	    int remainder = xLength - (width + height);
	    //just going to hard code this part since there is only 9 possibilities
	    if(remainder == 1){
		width -= 6;
		length += 7;
	    }
	    else if(remainder == 2){
		width += 9;
		length -= 7;
	    }
	    else if(remainder == 3){
		width += 3;
	    }
	    else if(remainder == 4){
		width -= 3;
		length += 7;
	    }
	    else if(remainder == 5){
		width -= 9;
		length += 14;
	    }
	    else if(remainder == 6){
		width += 6;
	    }
	    else if(remainder == 7){
		length += 7;
	    }
	    else if(remainder == 8){
		width -= 6;
		length += 14;
	    }
	    else if(remainder == 9){
		width += 9;
	    }
	    if(width > length){
		_3Or7 = true;
	    }
	    else{
		_3or7 = false;
	    }
	    if(_30r7){
		hallowX = width - length;
	    }
	    else{
		hallowX = length - width;
	    }
	    thicknessW = width / 3;
	    thicknessL = length / 7;
	    solveSquareH();
	}
    }
    public void fastSolve(){
	if(xLength == yLength){
	    if(xLength > 20){
		solveSquare();
		return;
	    }
	}
	else if(xLength >= 3 && yLength >= 3 && (xLength >= 21 || yLength >= 21)){
	    solveRectangle();
	    return;
	}
	else{
	    System.out.println("fastSolve is only for boards that meet these requirements \n 1. Both sides must be >= 3 \n 2. One of those sides is >= 21");
	}
    }
}
