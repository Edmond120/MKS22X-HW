import java.util.*;
class Location{
    int r,c,distTraveled,distToGoal;
    boolean aStar;
    boolean queue = false;
    Location previous;
    public Location(int r, int c, Location previous, int distTraveled, int distToGoal, boolean aStar){
	this.r = r;
	this.c = c;
	this.distTraveled = distTraveled;
	this.distToGoal = distToGoal;
	this.previous = previous;
	this.aStar = aStar;
    }
    public int compareTo(Location other){
	if(aStar){
	    return (other.distTraveled + other.distToGoal) - (distTraveled + distToGoal);
	}
	else if(queue){
	    return other.distTraveled - distTraveled;
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
	if(heap.getSize() == 0){
	    return null;
	}
	else{
	    return heap.remove();
	}
    }
}
class QueueFrontier implements Frontier{
    MyHeapG<Location> heap = new MyHeapG<Location>();
    public void add(Location x){
	x.queue = true;
	heap.add(x);
    }
    public Location next(){
	if(heap.getSize() == 0){
	    return null;
	}
	else{
	    return heap.remove();
	}
    }
}
class StackFrontier implements Frontier{
    LinkedList<Location> stack = new LinkedList<Location>();
    public void add(Location x){
	stack.add(x);
    }
    public Location next(){
	if(stack.size() == 0){
	    return null;
	}
	else{
	    return stack.removeLast();
	}
    }
}
