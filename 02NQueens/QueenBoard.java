public class QueenBoard{
    private int[]queens;
    private int swapT;
    private int holder;
    private int pos;
    private boolean[] diagonals;
    private int solutionCount = -1;
    private int dLMO;
    private int sMO;
    private boolean once = false;
    private boolean done = false;
    private int size;
    public int getSolutionCount(){
	return solutionCount;
    }
    public QueenBoard(int size){
	//only for display
	this.size = size;
	sMO = size - 1;
	board = new boolean[size][size];
	queens = new int[size];
	dLMO = size * 4 - 3;
	for(int i = 0; i < size; i++){
	    queens[i] = i;
	}
    }
    //only for display
    private boolean[][]board;
    public void solve(){
	once = true;
	countSolutions();
    }
    public String toString(){
	if(size == 2 || size == 3){
	    return "boards with sizes 2x2 or 3x3 can't be solved";
	}
	else{
	    String result = "";
	    for(int c = 0; c < board.length; c++){
		for(int r = 0; r < board.length; r++){
		    if(board[c][r]){
			result += "Q ";
		    }
		    else{
			result += "- ";
		    }
		}
		result += "\n";
	    }
	    return result;
	}
    }
    private void makeBoard(int[] ary){
	clearBoard();
	for(int i = 0; i < ary.length; i++){
	    board[i][ary[i]] = true;
	}
    }
    private void clearBoard(){
	for(int c = 0; c < board.length; c++){
	    for(int r = 0; r < board.length; r++){
		board[c][r] = false;
	    }
	}
    }
    private void copyToTemp(int start,int[]x,int[]y){
	while(start < x.length){
	    y[start] = x[start++];
	}
    }
    public void countSolutions(){
	if(queens.length == 1){
	    board[0][0] = true;
	    solutionCount = 1;
	}
	else if(queens.length == 2 || queens.length == 3){
	    clearBoard();
	    solutionCount = 0;
	}
	else{
	    pos = queens.length - 3;
	    solutionCount = 0;
	    while(pos >= 0){
		int[]temp = new int[queens.length];
		copyToTemp(0,queens,temp);
		countSolutionsH(pos,temp);
		if(once && done){
		    break;
		}
		pos--;
	    }
	}
    }
    private void countSolutionsH(int tempPos, int[]temp){
	if(tempPos == queens.length - 2){
	    check(temp,0);
	    swap(temp,tempPos,tempPos + 1);
	    if(!once){
		check(temp,0);
	    }
	}
	else{
	    int[] newTemp = new int[temp.length];
	    copyToTemp(0,temp,newTemp);
	    for(int i = tempPos; i < temp.length; i++){
		swap(temp,tempPos,i);
		countSolutionsH(tempPos + 1,temp);
		copyToTemp(tempPos,newTemp,temp);
	    }
	}	
    }
    private void check(int[]temp,int start){
	diagonals = new boolean[size * 4 - 2];
	if(updateDiagonals(temp,start)){
	    if(once){
		makeBoard(temp);
		done = true;
	    }
	    else{
		solutionCount++;
	    }
	}
	return;
    }
    private void swap(int[]temp,int x,int y){
	swapT = temp[x];
	temp[x] = temp[y];
	temp[y] = swapT;
    }
    private boolean updateDiagonals(int[]temp,int start){
	for(int i = start; i < temp.length; i++){
	    if(diagonals[(i - temp[i]) + sMO] == true){
		return false;
	    }
	    else{
		diagonals[(i - temp[i]) + sMO] = true;
	    }
	    if(diagonals[dLMO - (((sMO - i) - temp[i]) + sMO)] == true){
		return false;
	    }
	    else{
		diagonals[dLMO - (((sMO - i) - temp[i]) + sMO)] = true;
	    }
	}
	return true;
    }
}
