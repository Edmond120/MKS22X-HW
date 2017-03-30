class Timer{
    public Timer(){
    }
    private long time;
    public void start(){
	time = System.currentTimeMillis();
    }
    public long stop(){
	return (System.currentTimeMillis() - time) / 1000;
    }
    public static String toString(int[]ary){
	String result = "";
	for(int i = 0; i < ary.length;i++){
	    result += ary[i] + " ";
	}
	return result;
    }
}
public class MyLinkedList{
    Lnode start;
    Lnode end;
    Lnode current;
    int currentPlace = -1;
    int size = 0;
    public int size(){
	return size;
    }
    public String toString(){
	int[] ary = toArray();
	String result = "[ ";
	for(int i = 0; i < ary.length;i++){
	    result += ary[i] + ", ";
	}
	return result + "]";
    }
    public int[] toArray(){
	int[]ary = new int[size];
	for(int i = 0; i < size;i++){
	    ary[i] = get(i);
	}
	return ary;
    }
    public MyLinkedList(){
	start = new Lnode();
	start.after = new Lnode();
	start.after.before = start;
	end = start;
	current = start;
    }
    public MyLinkedList(int[]array){
	start = new Lnode();
	start.after = new Lnode();
	start.after.before = start;
	end = start;
	current = start;
	for(int i = 0;i < array.length;i++){
	    add(array[i]);
	}
    }
    public int remove(int index){
	Lnode x = select(index);
	x.before.after = x.after;
	x.after.before = x.before;
	size--;
	return x.num;
    }
    public int set(int index,int newValue){
	Lnode x = select(index);
	int a = x.num;
	x.num = newValue;
	return a;
    }
    public int indexOf(int value){
	for(int i = 0;i < size; i++){
	    if(get(i) == value){
		return i;
	    }
	}
	return -1;
    }
    public int get(int index){
	return select(index).num;
    }
    public boolean add(int value){
	addH(value,end);
	end = end.after;
	return true;
    }
    public void addLast(int value){
	add(value);
    }
    public void addStart(int value){
	addH(value,start);
    }
    public void add(int index,int value){
	addH(value,select(index).before);
	if(index == size - 1){
	    end = end.after;
	}
    }
    private boolean goTo(int index){
	if(index >= size){
	    return false;
	}
	if(currentPlace > index){
	    moveLeft(currentPlace - index);
	}
	else{
	    moveRight(index - currentPlace);
	}
	return true;
	
    }
    private Lnode select(int index){
	int a;
	if(currentPlace > index){
	    a = currentPlace - index;
	}
	else{
	    a = index - currentPlace;
	}
	int b = (size - 1) - index;
	if(index > b){
	    if(b < a){
		current = end;
		currentPlace = size - 1;
	    }	    	
	}
	else{
	    if(index < a){
		current = start.after;
		currentPlace = 0;
	    }
	}
	goTo(index);
	return current;
    }
    private void addH(int value,Lnode node){
	node.after.before = new Lnode(value,node,node.after);
	node.after = node.after.before;
	size++;
    }
    private void moveRight(int times){
	while(times-- > 0){
	    current = current.after;
	    currentPlace++;
	}
    }
    private void moveLeft(int times){
	while(times-- > 0){
	    current = current.before;
	    currentPlace--;
	}
    }
    class Lnode{
	Lnode before = null;
	Lnode after = null;
	int num;
	Lnode(){
	}
	Lnode(int num,Lnode before,Lnode after){
	    this.num = num;
	    this.before = before;
	    this.after = after;
	}
    } 
}
