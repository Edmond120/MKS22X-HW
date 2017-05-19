class Location{
    int r,c,distTraveled,distToGoal;
    boolean aStar;
    public Location(int r, int c, Location previous, int distTraveled, int distToGoal, boolean aStar){
	this.r = r;
	this.c = c;
	this.distTraveled = distTraveled;
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
    public void add(Location x);
    public Location next();//also removes from Frontier
}
class FrontierPriorityQueue implements Frontier{
    MyHeapG<Location> heap = new MyHeapG<Location>();
    public void add(Location x){
	heap.add(x);
    }
    public Location next(){
        return heap.remove();
    }
}
class QueueFrontier implements Frontier{
    public void add(Location x){}
    public Location next(){
	return null;
    }
}
class StackFrontier implements Frontier{
    public void add(Location x){}
    public Location next(){
	return null;
    }
}
