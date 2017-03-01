import java.util.*;
import java.io.*;

public class Maze{


    private int[][]maze;
    private boolean animate;
    private boolean validFile;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */
    private int indexOf(int[]key,int num){
	for(int i = 0; i < key.length; i++){
	    if(num == key[i]){
		return i;
	    }
	}
	return 0;
    }
    private int[]key = {-2,-1,0};
    private String[]lock = {"E","#"," "};
    private boolean part2 = false;
    public String toString(){
	String result = "";
	for(int line = 0; line < maze.length; line++){
	    for(int i = 0; i < maze[line].length; i++){
		if(maze[line][i] > 0){
		    result += maze[line][i] + " ";
		}
		else{
		    if(part2 && maze[line][i] == -4){
			result += "P ";
		    }
		    else{
			result += lock[indexOf(key,(maze[line][i]))] + " ";
		    }
		}
	    }
	    result += "\n";
	}
	return result;
    }
    public Maze(String filename){
	try{
	    validFile = readFile(filename);
	}
	catch(FileNotFoundException e){
	    System.out.println("file not found");
	    e.printStackTrace();
	}
    }
    public boolean readFile(String filename) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        File infile = new File(filename);// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(infile);
	int lineNumber = 0;
	int newLines = 0;
	while(inf.hasNextLine()){
	    newLines++;
	    inf.nextLine();
	}
	if(newLines == 0){
	    System.out.println("filecorrupt");
	    return false;
	}
        inf.close();
	inf = new Scanner(infile);
	String line = inf.nextLine();
	maze = new int[line.length()][newLines];
	inf.close();
	inf = new Scanner(infile);
	
        while(inf.hasNextLine()){
	    line = inf.nextLine();
            for(int i = 0; i < line.length(); i++){
		if(line.charAt(i) == '#'){
		    maze[lineNumber][i] = -1;
		}
		else if(line.charAt(i) == ' '){
		}
		else if(line.charAt(i) == 'E'){
		    maze[lineNumber][i] = -2;
		}
		else if(line.charAt(i) == 'S'){
		    maze[lineNumber][i] = 1;
		}
		else{
		    System.out.println("filecorrupt");
		    return false;
		}
	    }
	    lineNumber++;
	}
	return true;
    }   

    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    private int[] dirX = {0,0,1,-1};
    private int[] dirY = {1,-1,0,0};
    public boolean solve(){
	int temp;
	int step = 2;
	ArrayList<cord> branches = new ArrayList<cord>();
	for(int line = 0; line < maze.length; line++){
	    for(int i = 0; i < maze[line].length; i++){
		if(maze[line][i] == 1){
		    branches.add(new cord(line,i));
		}
	    }
	}	    
	while(true){
	    if(animate){
		System.out.println("\033[2J\033[1;1H"+this.toString());
		wait(20);
	    }
	    int s = branches.size();
	    if(s == 0){
		break;
	    }
	    for(int i = 0; i < s;i++){
		cord c = branches.get(0);
		for(int ii = 0; ii < 4; ii++){
		    int x = c.x + dirX[ii];
		    int y = c.y + dirY[ii];
		    if(x < maze.length && y < maze[x].length && (maze[x][y] == 0 || maze[x][y] == -2)){
			if(maze[x][y] == 0){
			    branches.add(new cord(x,y));
			    maze[x][y] = step;
			}
			else{
			    part2 = true;
			    phase2(x,y,step);
			    return true;
			}
		    }
		}
		branches.remove(0);
	    }
	    step++;
	    
	}
	return false;
    }
    private void phase2(int x, int y,int step){
	while(step > 0){
	    if(animate){
		System.out.println("\033[2J\033[1;1H"+this.toString());
		wait(20);
	    }
	    step--;
	    for(int i = 0; i < 4; i++){
		int xx = x + dirX[i];
		int yy = y + dirY[i];
		if(xx < maze.length && yy < maze[xx].length && (maze[xx][yy] == step)){
		    maze[xx][yy] = -4;
		    x = xx;
		    y = yy;
		}
	    }
	}
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private void wait(int millis){ //ADDED SORRY!
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
         }
    }

}
class cord{
    int x;
    int y;
    public cord(int x,int y){
	this.x = x;
	this.y = y;
    }
}
