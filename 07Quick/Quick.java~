import java.util.Random;
public class sorts{
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
    public static void main(String[]ary){
        int[]x = {0,4,2,7,3,5,7,1};
	partition(x,0,7,false,4);
	for(int i = 0; i < x.length; i++){
	    System.out.print(x[i] + " ");
	}
	System.out.print("\n");
    }
}
