public class driver{
    public static void print(MyLinkedList x){
	System.out.println(Timer.toString(x.toArray()));
    }
    public static void main(String[]args){
	int[]ary = {0,1,2,3,4,5,6,7,8,9,10};
	MyLinkedList x = new MyLinkedList(ary);
	System.out.println(x.toString());
	if(true){
	    for(Integer i : x){
		System.out.print(i + " ");
	    }
	    System.out.print('\n');
	}
    }
}
