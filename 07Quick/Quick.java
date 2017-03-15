import java.util.Random;
public class Quick{
    public static int part ( int [] data, int start, int end){
	int r = new Random().nextInt(data.length);
	System.out.println(data[r]);
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
	}
	else{
	    if(start > 1){
		t = data[start - 1];
	        data[start - 1] = data[r];
		data[r] = t;
	    }
	    else{start--;};
	}
	return start;
	
	
    }
    /*
    public static int[] partition(int[]ary,int start, int end,boolean randomNum,int num){//end is inclusive
	int[]temp = new int[end - start + 1];
	for(int i = start; i <= end; i++){
	    temp[i] = ary[i];
	}
	if(randomNum){
	    int x = new Random().nextInt(temp.length);
	    if(x != 0){
		int t = temp[x];
		temp[x] = temp[0];
		temp[0] = t;
	    }
	}
	else{
	    int t = temp[num];
	    temp[num] = temp[0];
	    temp[0] = t;
	}
	for(int i = 1; i < temp.length;i++){
	    if(temp[i] < temp[0]){
		ary[start++] = temp[i];
	    }
	    else{
		ary[end--] = temp[i];
	    }
	}
	ary[start] = temp[0];
	return ary;
    }
    */
    public static void main(String[]ary){
        int[]x = {0,4,2,7,3,5,7,1};
	//partition(x,0,7,false,4);
	System.out.println(part(x,0,7));
	for(int i = 0; i < x.length; i++){
	    System.out.print(x[i] + " ");
	}
	System.out.print("\n");
    }
}
