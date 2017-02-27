public class driver{
    private static boolean show = false;
    public static void main(String[] args){
	for(int a = 5; a < 20; a++){
	    KnightBoard x = new KnightBoard(a,a);
	    x.solve();
	    System.out.println(x.toString());
	}
    }
}
