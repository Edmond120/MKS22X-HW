public class MazeSolver{
    Maze maze;
    boolean animate;
    public MazeSolver(String filename){
	this(filename,false);
    }
    public MazeSolver(String filename,boolean animate){
	this.animate = animate;
	maze = new Maze(filename);
    }
    public final int DFS = 0; //Stack
    public final int BFS = 1; //Queue
    public final int BestFirst = 2;
    public final int AStar = 3;
    public void solve(){
	solve(BFS);
    }
    public void solve(int style){
    }
    public String toString(){
	return maze.toString();
    }
}
