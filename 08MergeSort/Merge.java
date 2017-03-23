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
public class Merge{
    public static void mergesort(int[]ary){
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
}
