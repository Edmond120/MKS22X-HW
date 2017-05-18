import java.util.ArrayList;
class MyHeapG<E extends Integer>{
    //multiply index by 2 to get left branch, then add 1 to get right branch
    ArrayList<E> heap;
    private int constant;
    public int getSize(){
	return heap.size() - 1;
    }
    public MyHeapG(){
	construct();
    }
    private void construct(){
	constant = 1;
	heap = new ArrayList<E>();
	heap.add(null);
    }
    public MyHeapG(boolean x){
	construct();
	if(!x){
	    constant = -1;
	}
    }
    private int swap(int a,int b){
	E temp = heap.get(a);
	heap.set(a,heap.get(b));
	heap.set(b,temp);
	return b;
    }
    public void add(E s){
	int index = heap.size();
	heap.add(s);
	while((index = pushUp(index)) > 0){
	    if(index == -1){
		break;
	    }
	}
    }
    public E remove(){
	E removed = peek();
	if(heap.size() == 2){
	    return heap.remove(1);
	}
	heap.set(1,heap.remove(heap.size() - 1));
	int index = 1;
	while((index = pushDown(index)) < heap.size()){
	    if(index == -1){
		break;
	    }
	}
	return removed;
    }
    public E peek(){
	return heap.get(1);
    }
    //left branch is even, right branch is odd
    private int pushUp(int index){
	try{
	    if(heap.get(getParent(index)).compareTo(heap.get(index))
	       * constant < 0){
		return swap(index,getParent(index));
	    }
	    else{
		return -1;
	    }
	}
	catch(NullPointerException e){
	    return -1;
	}
    }
    private int pushDown(int index){
	if(getRight(index) >= heap.size()){
	    if(getRight(index) == heap.size()){
		if(heap.get(getLeft(index)).compareTo(heap.get(index)) * constant <= 0){return - 1;}
		else{
		    return swap(index,getLeft(index));
		}
	    }
	    else{
		return -1;
	    }
	}
	if(heap.get(getLeft(index)).compareTo(heap.get(index)) * constant <= 0 &&
	   heap.get(getRight(index)).compareTo(heap.get(index)) * constant <= 0){
	    return -1;
	}
	int comp = 
	    heap.get(getLeft(index)).compareTo(heap.get(getRight(index)))
	    * constant;
	if(comp > 0){
	    return swap(index,getLeft(index));
	}
	else{
	    return swap(index,getRight(index));
	}
    }
    private int getLeft(int index){
	return index * 2;
    }
    private int getRight(int index){
	return getLeft(index) + 1;
    }
    private int getParent(int index){
	if(index % 2 == 0){
	    return index / 2;
	}
	else{
	    return (index - 1) / 2;
	}
    }
    
}
