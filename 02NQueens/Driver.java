public class Driver{
    public static void test(int size){
	time = System.currentTimeMillis();
	QueenBoard x = new QueenBoard(size);
	x.countSolutions();
	System.out.println("board size: " + size);
	System.out.println("SolutionCount: " + x.getSolutionCount());
	System.out.println("runTime: " + ((System.currentTimeMillis() - time) / 1000));
	System.out.println("Solve: ");
	time = System.currentTimeMillis();
	x.solve();
	System.out.println(x.toString());
	System.out.println("runTime: " + ((System.currentTimeMillis() - time) / 1000));
    }
    private static long time;
    public static void main(String[] args){
	for(int i = 1; i < 11; i++){
	    test(i);
	}
    }
}
