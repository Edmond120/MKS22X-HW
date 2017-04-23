class driver{
    public static void main(String[]ary){
	MyDeque x = new MyDeque(5);
	x.debug();
	System.out.print('\n');
	x.addFirst("1");
	System.out.println(x.getLast());
	x.debug();
	x.addLast("2");
	System.out.println(x.getLast());
	x.debug();
	x.addLast("3");
	System.out.println(x.getLast());
	x.debug();
	x.addLast("4");
	System.out.println(x.getLast());
	x.debug();
	x.addLast("5");
	System.out.println(x.getLast());
	x.debug();
	x.addLast("6");
	x.addLast("7");
	x.addLast("8");
	x.debug();
	//System.out.println(x.getLast());

	System.out.println("size:::: " + x.size());
	int len = x.size();
	for(int i = 0; i < len; i++){
	    System.out.print(x.removeLast());
	}
	
    }
}
