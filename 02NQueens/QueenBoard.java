public class QueenBoard{
    private int[]queens;
    private int[]temp;
    private int pos;
    private int[] diagonals;
    private int solutionCount = -1;
    private int dLMO;
    public int getSolutionCount(){
	return solutionCount;
    }
    public QueenBoard(int size){
	//only for display
	board = new int[size][size];
	queens = new int[size];
	temp = new int[size];
	diagonals = new int[size * 4 - 2];
	dLMO = diagonals.length - 1;
	for(int i = 0; i < size; i++){
	    queens[i] = i;
	}
    }
    //only for display
    private int[][]board;
    public void solve(){
    }
    private copyToTemp(int start){
	while(start < queens.length){
	    temp[start] = queens[start++];
	}
    }
    public void countSolutions(){
	pos = queens.length - 2;
	solutionCount = 0;
	copyToTemp(0);
	while(pos > 0){
	    copyToTemp(pos);
	    countSolutionsH();
	    pos--;
	}
    }
    private void countSolutionsH(){
	
    }
    private boolean check(){
	for(int i = 0; i < diagonals.length; i++){
	    if(diagonals[i] > 1){
		return false;
	    }
	}
	return true;
    }
    private void updateDiagonals(){
	for(int i = pos; i < queens.length; i++){
	    diagonals[queens[i] - i] += 1;
	    diagonals[dLMO - (queens[i] - i)] += 1;
	}
	if(check){
	    solutionCount++;
	}
    }
}
