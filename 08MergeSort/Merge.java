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
// [0,1,2,3,4,5,6,7,8,9,10,11]
public class Merge{
    public static void mergesort(int[]ary){
	int sets = ary.length;
	int setSize = 1;
	int selectedSet = 1;
	int start;
	int end;
	while(selectedSet <= sets){
	    sets = (sets / 2) + (sets % 2);
	    setSize = setSize * 2;
	    
    }
    
    public static String toString(int[]ary){
	String s = "";
	for(int i = 0; i < ary.length; i++){
	    s += ary[i] + " ";
	}
	return s;
    }
    public static void print(int[]ary){
	System.out.println(toString(ary));
    }
    public static void main(String[]args){
    }
}
