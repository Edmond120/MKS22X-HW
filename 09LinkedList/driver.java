public class driver{
    public static void print(MyLinkedList x){
	System.out.println(Timer.toString(x.toArray()));
    }
    public static void main(String[]args){
	MyLinkedList x = new MyLinkedList();
	for(int a = 0; a < 10; a++){
	    if(a == 5){
		x.add(1000);
	    }
	    else{
		x.add(a);
	    }
		print(x);
	}
	System.out.println(x.size());
	System.out.println(x.toString());
	System.out.println(x.get(4));
	System.out.println(x.set(4,200));
	print(x);
	System.out.println(x.indexOf(200));
	x.add(3,123);
	print(x);
	System.out.println(x.remove(3));
	print(x);
    }
}
