public class driver{
    public static void main(String[]args){
	Maze x = new Maze(args[0]);
	x.setAnimate(true);
	System.out.println(x.solve());
    }
}
