public class RunningMedian{		       
    MyHeapG max = new MyHeapG<Integer>();
    MyHeapG min = new MyHeapG<Integer>(false);
    public RunningMedian(){}
    private boolean Eadd(int num){
	if(num >= max.peek() && num <= min.peek()){
		max.add(num);
		return true;
	    }
	    else if(num < max.peek()){
		max.add(num);
		return true;
	    }
	    else{
		min.add(num);
		return false;
	    }
    }
    private void NEadd(int num,MyHeapG<Integer> max,MyHeapG<Integer> min){
	int median = max.remove();
	    if(Eadd(num)){
		min.add(median);
	    }
	    else{
		max.add(median);
	    }
    }
    public void add(int num){
	if(max.getSize() == min.getSize()){
	    Eadd(num);
	}
	else if(max.getSize() > min.getSize()){
	    NEadd(num,max,min);
	}
	else{
	    NEadd(num,min,max);
	}
    }
    public double getMedian(){
	if(max.getSize() == min.getSize()){
	    return (max.peek() + min.peek()) / 2.0;
	}
	else if(max.getSize() > min.getSize()){
	    return max.peek();
	}
	else{
	    return min.peek();
	}
    }
    public static void main(String[]args){
	RunningMedian x = new RunningMedian();
	for(int i = 0; i < args.length; i++){
	    x.add(Integer.parseInt(args[i]));
	}
	System.out.println(x.getMedian());
    }
}
