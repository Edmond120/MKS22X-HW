public class Recursion{
    public static String name(){
	return "Wong,Edmond";
    }
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n,1,0);
    }
    private static double sqrtHelper(double n,double guess,double oldGuess){
	if(oldGuess == guess){
	    return guess;
	}
	else{
	    return sqrtHelper(n,((n / guess) + guess) / 2,guess);
	}
    }
}
class Driver{
    public static void main(String[]args){
	System.out.println(Recursion.sqrt(Integer.parseInt(args[0])));
    }
}
