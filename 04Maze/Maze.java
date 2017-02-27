import java.util.*;
import java.io.*;

public class Maze{


    private int[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        readFile(filename);
    }
    public static void readFile(String filename) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        File infile = new File(filename);// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(infile);
	int lineNumber = 0;
	int newLines = 0;
	while(inf.hasNextLine()){
	    newLines++;
	    inf.nextLine();
	}
	inf.reset();
	if(inf.hasNextLine()){
	    String line = inf.nextLine();
	}
	else{
	    System.out.println("filecorrupt");
	    return false;
	}
	maze = new int[line.length][newLines];
	inf.reset();
	
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
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S. 

            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
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
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }

        //COMPLETE SOLVE

        return false; //so it compiles
    }


}
