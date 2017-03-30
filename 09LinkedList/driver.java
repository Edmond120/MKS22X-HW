public class driver{
    public static void print(MyLinkedList x){
	System.out.println(Timer.toString(x.toArray()));
    }
    public static void main(String[]args){
	MyLinkedList x = new MyLinkedList();
	for(int a = 1; a < 10; a++){
	    x.add(a);
	    print(x);
	}
    }
}
