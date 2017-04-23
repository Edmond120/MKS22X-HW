public class MyDeque{
    private String[]ary;
    private int start;
    private int end;
    private int _size = 0;
    public int size(){
	return _size;
    }
    public int getSize(){
	return size();
    }
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
	return start == end;
    }
    private void resize(int len){
	String[]newAry = new String[len];
	int index = 0;
	for(int i = start + 1;i != start;i++){
	    if(i >= ary.length){
		i = 0;
	    }
	    System.out.print(ary[i] + " ");
	    newAry[index++] = ary[i];
	}
	start = newAry.length - 1;
	ary = newAry;
    }
    public void addFirst(String input){
	ary[start--] = input;
	updateStart();
	if(checkForResize()){
	    resize((int)Math.floor(ary.length * resizeRatio));
	}
	_size++;
    }
    public void addLast(String input){
	ary[end++] = input;
	updateEnd();
	if(checkForResize()){
	    resize((int)Math.floor(ary.length * resizeRatio));
	}
	_size++;
    }
    private double resizeRatio = 2;
    public void setResizeRatio(double x){
	resizeRatio = x;
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
	System.out.println("size: " + size());
	for(int i = 0; i < ary.length;i++){
	    System.out.print(ary[i] + " ");
	}
	System.out.print('\n');
    }
    public String removeFirst(){
	_size--;
	if(start + 1 == ary.length){
	    start = 0;
	    return ary[0];
	}
	return ary[start++ + 1] ;
    }
    public String removeLast(){
	_size--;
	if(end == 0){
	    end = ary.length - 1;
	    return ary[1];
	}
	return ary[end-- - 1];
    }
}
