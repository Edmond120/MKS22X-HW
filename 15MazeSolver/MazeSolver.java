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
    public static final int DFS = 0; //Stack
    public static final int BFS = 1; //Queue
    public static final int BestFirst = 2;
    public static final int AStar = 3;
    public void solve(){
	solve(BFS);
    }
    public void solve(int style){
	if(style == DFS){

	}
	else if(style == BFS){
	    BFS();
	}
	else if(style == BestFirst){
	    BestFirst();
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
    private boolean noSolution(Location next){
	if(next == null){
	    System.out.println("no solution");
	    return false;
	}
	else{
	    return true;
	}
    }
    private char mazeGet(Location x){
	return mazeGet(x,0,0);
    }
    private void mazeSet(Location x, char c){
	mazeSet(x,0,0,c);
    }
    private char mazeGet(Location x,int disX,int disY){
	return maze.get(x.r + disX,x.c + disY);
    }
    private void mazeSet(Location x,int disX,int disY, char c){
	maze.set(x.r + disX, x.c + disY, c);
    }
    private int[]displacement = {0,1, 0,-1, 1,0, -1,0};
    private void backTrack(Location end){
	mazeSet(end,'E');
	end = end.previous;
	while(end.previous != null){
	    mazeSet(end,'@');
	    end = end.previous;
	}
	mazeSet(end,'S');
    }
    private void BestFirst(){
        go(false,new FrontierPriorityQueue());
    }
    private void AStar(){
        go(true,new FrontierPriorityQueue());
    }
    private void BFS(){
	go(false,new QueueFrontier());
    }
    private void go(boolean AStar,Frontier frontier){
	maze.getStart().aStar = AStar;
	frontier.add(maze.getStart());
	mazeSet(maze.getStart(),'?');
	Location next = maze.getStart();
	boolean solved = false;
	while(noSolution(next) && distance(maze.getEnd(),next) != 0){
	    for(int i = 0; i < 7; i += 2){
		if(mazeGet(next,displacement[i],displacement[i + 1]) == ' '){
		    int newX = next.r + displacement[i];
		    int newY = next.c + displacement[i + 1];
		    frontier.add(new Location(newX,
					      newY,
					      next,
					      next.distTraveled + 1,
					      abs(newX - maze.getEnd().r) +
					      abs(newY - maze.getEnd().c),
					      AStar));
		    maze.set(newX,newY,'?');
		}
	    }
	    mazeSet(next,'.');
	    next = frontier.next();
	    if(animate){
		System.out.println(maze.toString(1));
	    }
	}
	backTrack(next);
    }
    public String toString(){
	return maze.toString();
    }
    public static void main(String[]args){
	MazeSolver x = null;
	int Style = BFS;
	if(args.length == 1){
	    x = new MazeSolver(args[0]);
	}
	else if(args.length == 2){
	    x = new MazeSolver(args[0]);
	    if(args[1].equals("BFS")){
		Style = BFS;
	    }
	    else if(args[1].equals("DFS")){
		Style = DFS;
	    }
	    else if(args[1].equals("BestFirst")){
		Style = BestFirst;
	    }
	    else if(args[1].equals("AStar")){
		Style = AStar;
	    }
	    else{
		Style = Integer.parseInt(args[1]);
	    }
	}
	else{
	     System.out.println("params = {filename, solve style}");
	     return;
	}
	x.solve(Style);
	System.out.println(x.toString());
    }
}
