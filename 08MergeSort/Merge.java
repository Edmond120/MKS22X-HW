import java.util.Random;
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
	int sets = (ary.length / 2) + (ary.length % 2);
	int setSize = 1;
	int selectedSet = 0;
	int start;
	int end;
	boolean loop = true;
	//	System.out.println(toString(ary));
	while(true){
	    if(sets == 1){
		if(loop){
		    loop = false;
		}
		else{
		    break;
		}
	    }
	    setSize = setSize * 2;
	    selectedSet = 0;
	    //System.out.println("loop");
	    while(selectedSet < sets){
		//System.out.println("sets: " + sets + ", " + "setSize: " + setSize + ", " + "selectedSet: " + selectedSet);
		//System.out.println(setSize * selectedSet);
		//System.out.println(setSize * (selectedSet + 1) - 1);
		int x = (setSize * (selectedSet + 1)) - 1;
		if(x >= ary.length){
		    x = ary.length - 1;
		}
		Quick.quicksort(ary,setSize * selectedSet,x );
		selectedSet++;
		//System.out.println(toString(ary));
	    }
	    sets = (sets / 2) + (sets % 2);
	}
	    
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
	Random random = new Random();
	int[] ary = new int[1000000];
	for(int i = 0; i < ary.length; i++){
	    ary[i] = random.nextInt() % 100;
	}
	mergesort(ary);
    }
}

    
class Quick{
    private static void swap(int[]ary,int a,int b){
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }
    public static int part(int[]ary,int start,int end){
	int r = new Random().nextInt(end - start + 1) + start;
	int v = ary[r];
	int i = start;
	int oStart = start;
	while(i <= end){
	    if(ary[i] == v){
		i++;
	    }
	    else if(ary[i] < v){
		swap(ary,i++,start++);
	    }
	    else{
		swap(ary,i,end--);
	    }
	}
	if(end > oStart && ary[end] == ary[end - 1]){
	    int a = end - 1;
	    while(a != oStart && ary[a] == ary[end]){a -= 1;}
	    return ((end - a)/2) + a;
	}
	    
	return end;

	/*
	int dc = 0;
	//int ii = i;
	if(i > 0 && ary[i] == v){
	    while(i-- > 0 && ary[i] == v){
		dc++;
	    }
	    return i + 1 + (dc / 2);
	}
	else{
	    return i;
	}
	*/
    }
    private static int partOld ( int [] data, int start, int end){
	int r = new Random().nextInt(end - start + 1) + start;
	//System.out.println(data[r]);
	int t = data[r];
	data[r] = data[start];
	r = start;
	data[start++] = t;
	for(int i = start; start != end;i++){
	    if(data[i] < data[r]){
		if(i != start){
		    t = data[start];
		    data[start++] = data[i];
		    data[i] = t;
		    i--;
		}
		else{
		    start++;
		}
	    }
	    else{
		if(i != end){
		    t = data[end];
		    data[end--] = data[i];
		    data[i] = t;
		    i--;
		}
		else{
		    end++;
		}
	    }
	}
	if(data[start] < data[r]){
	    t = data[start];
	    data[start] = data[r];
	    data[r] = t;
	    //System.out.println("a");
	}
	else{
	    if(start > 1){
		t = data[start - 1];
	        data[start-- - 1] = data[r];
		data[r] = t;
		//System.out.println("b");
	    }
	    else{start--;
		//System.out.println("c");
	    }
	}
	return start;
	
	
    }
    public static int quickselect(int []data, int k){
	int start = 0;
	int end = data.length - 1;
	int i = part(data,start,end);
	if(k >= data.length){
	    System.out.println("k is bigger than the array");
	    return 0;
	}
	if(k == data.length - 1){
	    int aaa = data[0];
	    for(int iii = 1; iii < data.length; iii++){
		if(data[iii] > aaa){
		    aaa = data[iii];
		}
	    }
	    return aaa;
	}
		
	while(i != k){
	    if(i > k){
		end = i;
	    }
	    else if(i < k){
		start = i;
	    }
	    i = part(data,start,end);
	}
	return data[i];
    }
    public static void quicksort(int[]ary,int start, int end){
	int p = part(ary,start,end);
	quicksortH(ary,start,p);
	quicksortH(ary,p,end);
	return;
    }
    public static boolean check(int[]ary){
	for(int i = 1; i < ary.length; i++){
	    if(ary[i - 1] > ary[i]){
		return false;
	    }
	}
	return true;
    }
    private static void quicksortH(int[]ary,int start,int end){
	if(end - start <= 2){
	    if(end - start == 2){
		if(ary[start] > ary[start + 1]){
		    swap(ary,start,start + 1);
		}
		if(ary[start + 1] > ary[end]){
		    swap(ary,start + 1,end);
		}
	    }
	    //System.out.println("return");
	    return;
	}
	else{
	    int p = part(ary,start,end);
	    //System.out.println(start + ":" + p + ":" + end);
	    if(p != end){
		quicksortH(ary,start,p);
	    }
	    if(p != start){
	    quicksortH(ary,p,end);
	    }
	}
    }
}
