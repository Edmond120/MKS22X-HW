import java.util.Random;
public class Quick{
    public static int part ( int [] data, int start, int end){
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
  //return the value that is the kth smallest value of the array. 
  //use your partition method to help you accomplish this.
    public static void main(String[]ary){
	int n = Integer.parseInt(ary[0]);
        int[]x = {0,4,2,7,3,5,7,1};
	//partition(x,0,7,false,4);
	//System.out.println(part(x,0,7));
	System.out.println(quickselect(x,n));
	for(int i = 0; i < x.length; i++){
	    System.out.print(x[i] + " ");
	}
	System.out.print("\n");
    }
}
