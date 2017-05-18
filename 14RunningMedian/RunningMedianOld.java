public class RunningMedian{		       
    private MyHeapG max = new MyHeapG<Integer>();
    private MyHeapG min = new MyHeapG<Integer>(false);
    public RunningMedian(){}
    private void print(int x){
	if(debug){
	    System.out.println(x);
	}
    }
    private boolean Eadd(int num){
	if(num >= max.peek() && num <= min.peek()){
		max.add(num);
		print(1);
		return true;
	    }
	    else if(num < max.peek()){
		max.add(num);
		print(2);
		return true;
	    }
	    else{
		min.add(num);
		print(3);
		return false;
	    }
    }
    private void NEadd(int num,MyHeapG<Integer> max,MyHeapG<Integer> min){
	int median = max.remove();
	    if(Eadd(num)){
		min.add(median);
		print(4);
	    }
	    else{
		max.add(median);
		print(5);
	    }
    }
    private void StartAdd(int num){
	//System.out.println("debug");
	if(max.getSize() == 0 && min.getSize() == 0){
	    max.add(num);
	    print(6);
	}
	else if(max.getSize() != 0){
	    if(max.peek() > num){
		min.add(max.remove());
		max.add(num);
		print(7);
	    }
	    else{
		min.add(num);
		print(8);
	    }
	}
	else{
	    if(min.peek() < num){
		max.add(min.remove());
		min.add(num);
		print(9);
	    }
	    else{
		max.add(num);
		print(10);
	    }
	}
    }
    public void add(int num){
	if(max.getSize() == 0 || min.getSize() == 0){
	    StartAdd(num);
	    print(10);
	}
        else if(max.getSize() == min.getSize()){
	    Eadd(num);
	    print(11);
	}
	else if(max.getSize() > min.getSize()){
	    NEadd(num,max,min);
	    print(12);
	}
	else{
	    NEadd(num,min,max);
	    print(13);
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
    private boolean debug = false;
    public void debug(){
	debug = true;
	System.out.println("min " + min.getSize());
	System.out.println("max " + max.getSize() + "\n");
    }
    public static void main(String[]args){
	RunningMedian x = new RunningMedian();
	for(int i = 0; i < args.length; i++){
	    x.add(Integer.parseInt(args[i]));
	    x.debug();
	}
	System.out.println(x.getMedian());
    }
}
