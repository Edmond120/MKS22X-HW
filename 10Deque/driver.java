class driver{
    public static void main(String[]ary){
	MyDeque x = new MyDeque(5);
	x.debug();
	System.out.print('\n');
	x.addFirst("1");
	System.out.println(x.getFirst());
	x.debug();
	x.addFirst("2");
	System.out.println(x.getFirst());
	x.debug();
	x.addFirst("3");
	System.out.println(x.getFirst());
	x.debug();
	x.addFirst("4");
	System.out.println(x.getFirst());
	x.debug();
	x.addFirst("5");
	System.out.println(x.getFirst());
	x.debug();
	System.out.println(x.getFirst());
	/*
	for(int i = 0; i < 5; i++){
	    System.out.println(x.removeFirst());
	}
	*/
    }
}
