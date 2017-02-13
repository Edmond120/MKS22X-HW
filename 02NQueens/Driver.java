public class Driver{
    public static void test(int size){
	QueenBoard x = new QueenBoard(size);
	x.countSolutions();
	System.out.println("board size: " + size);
	System.out.println("Solutions: " + x.getSolutionCount());
	System.out.println("Solution: ");
	System.out.println(x.toString());
    }
    public static void main(String[] args){
	long time;
	for(int i = 1; i < 11; i++){
	    time = System.currentTimeMillis();
	    test(i);
	    System.out.println("runtime: " + ((System.currentTimeMillis() - time) / 1000));
	}
    }
}
