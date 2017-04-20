class driver{
    public static void main(String[]ary){
	MyDeque x = new MyDeque(5);
	x.addFirst("1");
	x.addFirst("2");
	x.addFirst("3");
	x.addFirst("4");
	x.addFirst("5");
	System.out.println(x.getFirst());
	for(int i = 0; i < 5; i++){
	    System.out.println(x.removeFirst());
	}
    }
}
