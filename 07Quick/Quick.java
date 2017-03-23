import java.util.Random;
public class Quick{
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
    public static void quicksort(int[]ary){
	int p = part(ary,0,ary.length - 1);
	quicksortH(ary,0,p);
	quicksortH(ary,p,ary.length - 1);
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
  //return the value that is the kth smallest value of the array. 
  //use your partition method to help you accomplish this.
    public static void main(String[]ary){
	try{
	Timer timer = new Timer();
	int[] x = new int[1];
	if(ary.length == 0){
	    System.out.println("quick(array length) || quick(array length, k for quickselect) || quick -d array length (duplicates)");
	    return;
	}
	if(ary[0].equals("-d")){
	    int nn = Integer.parseInt(ary[1]);
	    int[]xx = new int[nn];
	    Random rr = new Random();
	    int d = rr.nextInt(100);
	    for(int a = 0; a < xx.length; a++){
		if(rr.nextInt(101) < 50){
		    xx[a] = d;
		}
		else{
		    xx[a] = rr.nextInt(100);
		}
	    }
	    /*
	    for(int i = 0; i < xx.length;i++){
		System.out.print(xx[i] + " ");
	    }
	    */
	    //System.out.print("\n");
	    if(ary.length == 2){
		timer.start();
		quicksort(xx);
		/*
		System.out.println("sorted");
		for(int i = 0; i < xx.length;i++){
		System.out.print(xx[i] + " ");
		}
		*/
		System.out.println("runTime: " + timer.stop());
		System.out.println(check(xx));
	    }
	    else{
		System.out.println("quickselect");
		System.out.print(quickselect(xx,Integer.parseInt(ary[2])));
		System.out.print("\n");
	    }
	    //System.out.print("\n");
	    return;
	}
	int n = Integer.parseInt(ary[0]);
	x = new int[n];
	Random r = new Random();
	for(int a = 0; a < x.length; a++){
	    x[a] = r.nextInt(100);
	}
	/*
	for(int i = 0; i < x.length; i++){
	    System.out.print(x[i] + " ");
	}
	*/
	//System.out.print("\n");
	if(ary.length == 1){
	        timer.start();
		quicksort(x);
	    
		//System.out.println("sorted");
		/*
	    for(int i = 0; i < x.length; i++){
		System.out.print(x[i] + " ");
	    }
	    System.out.print("\n");
		*/
		System.out.println("runTime: " + timer.stop());
		System.out.println(check(x));
	}
	else{
	    System.out.println("quickselect");
	    System.out.println(quickselect(x,Integer.parseInt(ary[1])));
	}
	}catch(Throwable e){}
    }
}
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
