public class KnightBoard{
    private int[][]board;
    private int[][]hallow;
    private int xLength;
    private int yLength;
    private int stepNum = 0;
    boolean show;
    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
	target = (startingRows * startingCols) + 1;
    }
    private String multiplySI(String a,int x){
	String result = "";
	for(int b = 0; b < x; b++){
	    result += a;
	}
	return result;
    }
    public String toString(){
	String display = "";
	String num;
	for(int c = 0; c < board.length; c++){
	    for(int r = 0; r < board[c].length; r++){
	        num = (board[c][r] + "");
		display +=  multiplySI("_" , (5 - num.length())) + num + " ";
	    }
	    display += '\n';
	}
	return display;
    }
    public void solve(){
	if(board.length == 1 && board[0].length == 1){
	    board[0][0] = 1;
	}
	else{
	    for(int r = 0; r < board.length; r++){
		for(int c = 0; c < board[c].length; c++){
		    addKnight(r,c,1);
		    if(solveH(r,c,2)){
			return;
		    }
		    else{
			removeKnight(r,c);
		    }
		}
	    }
	    System.out.println("unsolvable");
	}
    }
    private int target;
    private int[] knightMoves =
    {-1,2, 1,2,
     2,1, 2,-1,
     1,-2, -1,-2,
     -2,1, -2,-1,};
    private int[] possibleMoves(int row, int col){
	int[]moves = new int[16];
	for(int i = 0; i < moves.length; i += 2){
	    moves[i] = knightMoves[i] + row;
	}
	for(int i = 1; i < moves.length; i += 2){
	    moves[i] = knightMoves[i] + col;
	}
	return moves;
    }
    private void removeKnight(int row,int col){
	board[row][col] = 0;
    }
    private void addKnight(int row,int col,int number){
	board[row][col] = number;
    }
    private boolean inBoard(int row,int col){
	return (row >= 0 && col >= 0 && row < board.length && col < board[0].length);
    }
    public boolean solveH(int row,int col, int number){
	if(number == target){
	    return true;
	}
	else{
	    int[]moves = possibleMoves(row,col);
	    for(int move = 0; move < moves.length; move += 2){
		if(inBoard(moves[move],moves[move + 1])&&
		   board[moves[move]][moves[move + 1]] == 0 ){
		    addKnight(moves[move],moves[move + 1],number);
		    if(solveH(moves[move],moves[move + 1],number + 1)){
			return true;
		    }
		}
	    }
	    removeKnight(row,col);
	    return false;
	}
    }
}
    /*
    public void solve(){
    }
	
    private boolean solveH(int row ,int col, int number){
    }
    private void solve21x21(){
    }
    private int[][] _3x7blockH1s1e = {{ 1, 4, 7,18,15,10,13},
				      { 6,21, 2, 9,12,19,16},
				      { 3, 8, 5,20,17,14,11}};
    
    private int[][] _3x7blockH2s1e = {{ 7, 4, 1,18,15,10,13},
				      { 2,21, 6, 9,12,19,16},
				      { 5, 8, 3,20,17,14,11}};
    
    private int[][] _3x7blockH1s2e = {{ 1, 4, 7,18,15,10,13},
				      { 6,19, 2, 9,12,21,16},
				      { 3, 8, 5,20,17,14,11}};
    
    private int[][] _3x7blockH2s2e = {{ 7, 4, 1,18,15,10,13},
				      { 2,19, 6, 9,12,21,16},
				      { 5, 8, 3,20,17,14,11}};
    
    private int[][] _3x7blockV1s1e = {{ 1, 6, 3},
				      { 4,21, 8},
				      { 7, 2, 5},
				      {18, 9,20},
				      {15,12,17},
				      {10,19,14},
				      {13,16,11}};
    
    private int[][] _3x7blockV2s1e = {{ 7, 2, 5},
				      { 4,21, 8},
				      { 1, 6, 3},
				      {18, 9,20},
				      {15,12,17},
				      {10,19,14},
				      {13,16,11}};
    
    private int[][] _3x7blockV1s2e = {{ 1, 6, 3},
				      { 4,19, 8},
				      { 7, 2, 5},
				      {18, 9,20},
				      {15,12,17},
				      {10,21,14},
				      {13,16,11}};
    
    private int[][] _3x7blockV2s2e = {{ 7, 2, 5},
				      { 4,19, 8},
				      { 1, 6, 3},
				      {18, 9,20},
				      {15,12,17},
				      {10,21,14},
				      {13,16,11}};

    private void copy(int[][] block,int startX,int startY){
	int temp = startX;
	for(int y = 0; y < block.length; y++){
	    for(int x = 0; x < block[y].length; x++){
		board[startY][startX++] = block[y][x];
	    }
	    startY++;
	    startX = temp;
	}
    }
    private void copyHorizonalFlip(int[][]block,int startX, int startY){
	int temp = startX;
	for(int y = 0; y < block.length; y--){
	    for(int x = block[y].length - 1; x >= 0; x--){
		board[startY][startX++] = block[y][x];
	    }
	    startY++;
	    startX = temp;
	}
    }
    private void copyHorizonalFlip(int[][]block,int startX, int startY){
	int temp = startX;
	for(int y = block.length - 1; y >= 0; y--){
	    for(int x = 0; x < block[y].length; x++){
		board[startY][startX++] = block[y][x];
	    }
	    startY++;
	    startX = temp;
	}
    }
    private void solveSquareH(){
    }
    private int hallowDim;
    private int thicknessW;
    private int thicknessL;
    private int width;
    private int length;
    private void solveSquare(){
	if(xLength % 21 == 0){
	    solve21x21();
	}
	else{
	    int halve = xLength / 2;
	    System.out.println("halve: " + halve);
	    width = (halve / 3) * 3;
	    System.out.println("width: " + width);
	    length = (halve / 7) * 7;
	    System.out.println("length: " + length);
	    int remainder = xLength - (width + length);
	    System.out.println("remainder: " + remainder);
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
		hallowDim = width - length;
	    }
	    else{
		hallowDim = length - width;
	    }
	    System.out.println("newWidth: " + width);
	    System.out.println("newLength: " + length);
	    System.out.println("hallowDim :" + hallowDim);
	    thicknessW = width / 3;
	    System.out.println("widthPieces: " + thicknessW);
	    thicknessL = length / 7;
	    System.out.println("lengthPieces: " + thicknessL);
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
    */
