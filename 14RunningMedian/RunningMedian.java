public class RunningMedian{
    MyHeapG<Integer> min = new MyHeapG<Integer>(false);
    MyHeapG<Integer> max = new MyHeapG<Integer>();
    public RunningMedian(){
    }
    public void add(int num){
	if(max.getSize() == 0 && min.getSize() == 0){
	    max.add(num);
	}
	else if(min.getSize() == 0){
	    if(num > max.peek()){
		min.add(num);
	    }
	    else if(num < max.peek()){
		min.add(max.remove());
		max.add(num);
	    }
	    else{
		min.add(num);
	    }
	}
	else{
	    if(max.getSize() == min.getSize()){
		if(num < max.peek()){
		    max.add(num);
		}
		else if(num > min.peek()){
		    min.add(num);
		}
		else{
		    max.add(num);
		}
	    }
	    else if(max.getSize() > min.getSize()){
		if(num < max.peek()){
		    min.add(max.remove());
		    max.add(num);
		}
		else{
		    min.add(num);
		}
	    }
	    else{
		if(num < max.peek()){
		    max.add(num);
		}
		else if(num > min.peek()){
		    max.add(min.remove());
		    min.add(num);
		}
		else{
		    max.add(num);
		}
	    }
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
