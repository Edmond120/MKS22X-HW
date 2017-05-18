class Location{
    int r,c,distTraveled,distToGoal;
    boolean aStar;
    public Location(int r, int c, Location previous, int distTraveled, int distToGoal, boolean aStar){
	this.r = r;
	this.c = c;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }
    public int compareTo(Location other){
	if(aStar){
	    return (other.distTraveled + other.distToGoal) - (distTraveled + distToGoal);
	}
	else{
	    return other.distToGoal - distToGoal;
	}
    }
}
interface Frontier{
    void add(Location x);
    Location next();
}
class FrontierPriorityQueue implements Frontier{
    MyHeapG<Location> heap = new MyHeapG<Location>();
}
class QueueFrontier implements Frontier{

}
class StackFrontier implements Frontier{

}
