public class MyDeque{
    private String[]ary;
    private int start;
    private int end;
    public MyDeque(int len){
	if(len < 2){
	    len = 2;
	}
	ary = new String[len + 1];
	start = 0;
	end = 1;
    }
    public MyDeque(){
	ary = new String[11];
	start = 0;
	end = 0;
    }
    private void updateStart(){
	if(start < 0){
	    start = ary.length - 1;
	}
    }
    private void updateEnd(){
	if(end >= ary.length){
	    end = 0;
	}
    }
    private boolean checkForResize(){
	return ary[start] != null && ary[end] != null;
    }
    private void resize(int len){
	
    }
    public void addFirst(String input){
	ary[start--] = input;
	updateStart();
	if(checkForResize()){
	    resize((ary.length * 3 / 2) + 1);
	}
    }
    public void addLast(String input){
	ary[end++] = input;
	updateEnd();
	if(checkForResize()){
	    resize((ary.length * 3 / 2) + 1);
	}
    }
    public String getFirst(){
	if(start + 1 != ary.length){
	    return ary[start + 1];
	}
	else{
	    return ary[0];
	}
    }
    public String getLast(){
	if(end != 0){
	    return ary[end - 1];
	}
	else{
	    return ary[ary.length - 1];
	}
    }
    public void debug(){
	System.out.println("start: " + start);
	System.out.println("end: " + end);
    }
    public String removeFirst(){
	if(start == ary.length - 1){
	    start = 0;
	    return ary[ary.length - 1];
	}
	return ary[start++] ;
    }
    public String removeLast(){
	if(end == 0){
	    end = ary.length - 1;
	    return ary[0];
	}
	return ary[end--];
    }
}
