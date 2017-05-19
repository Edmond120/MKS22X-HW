import java.lang.IllegalArgumentException;
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
	if(style == DFS){

	}
	else if(style == BFS){

	}
	else if(style == BestFirst){

	}
	else if(style == AStar){
	    AStar();
	}
	else{
	    throw new IllegalArgumentException();
	}
    }
    private int abs(int x){
	if(x < 0){
	    x *= -1;
	}
	return x;
    }
    private int distance(Location a, Location b){
	return abs(a.r - b.r) + abs(a.c - b.c);
    }
    private void AStar(){
	Frontier frontier = new FrontierPriorityQueue();
	frontier.add(maze.getStart());
	Location next = maze.getStart();
	while(distance(maze.getEnd(),next) != 0){
	    
	}
    }
    public String toString(){
	return maze.toString();
    }
}
