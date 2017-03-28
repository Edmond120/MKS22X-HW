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
}
public class MyLinkedList{
    Lnode start = null;
    Lnode end = null;
    Lnode current = null;
    int currentPlace = 0;
    int size = 0;
    public MyLinkedList(){
    }
    public MyLinkedList(int[]array){
	
    }
    public add(int num){
	add(num,0);
    }
    public add(int num,int i){
	int a = currentPlace - i;
	if(a < 0){
	    a *= -1;
	}
	if(a < i && a < size){
	    go(i);
	    addH(num);
	}
	else if(a < size / 2){
	    current = start;
	    go(i);
	    addH(num);
	}
	else{
	    current = end;
	    go(i);
	    addH(num);
	}
    }
    private addH(num){
	//-1,0,1,2,3,4,5
	Lnode x = new Lnode(num,current.before,current);
	current.before.after = x;
	current.before = x;
    }
    private go(int i){
    }
    public static String toString(int[]ary){
	String s = "[ ";
	for(int i = 0; i < ary.length; i++){
	    s += ary[i] + ", ";
	}
	return s + "]";
    }
    public static void print(int[]ary){
	System.out.println(toString(ary));
    }
    class Lnode{
	Lnode before = null;
	Lnode after = null;
	int num;
	Lnode(){
	}
	Lnode(int num,node before,node after){
	    this.num = num;
	    this.before = before;
	    this.after = after;
	}
    } 
}
