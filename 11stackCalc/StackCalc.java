public class StackCalc{
    public static double eval(String arg){
	return new StackCalc().evalHelper(arg);
    }
    private double evalHelper(String arg){
	Lnode start = new Lnode();
	int prev = 0;
	for(int i = 0;i < arg.length();i++){
	    if(arg.charAt(i) == ' '){
		String sub = arg.substring(prev,i);
		prev = i + 1;
		if(!operation(sub,start)){
		    start.front = (new Lnode(sub));
		    start.front.back = start;
		    start = start.front;
		}
		else{
		    start = start.front;
		}
	    }
	}
	operation(arg.substring(arg.length() - 1,arg.length()),start);
	return start.front.num;
    }
    private boolean operation(String sub,Lnode start){
	for(int i = 0;i < 9;i++){
	    if(sub.charAt(0) == "123456789".charAt(i)){
		return false;
	    }
	}
	Lnode x;
	if(sub.equals("+")){
	    start.subsitude(new Lnode(start.back.num + start.num));
	}
	else if(sub.equals("-")){
	    start.subsitude(new Lnode(start.back.num - start.num));
	}
	else if(sub.equals("*")){
	    start.subsitude(new Lnode(start.back.num * start.num));
	}
	else if(sub.equals("/")){
	    start.subsitude(new Lnode(start.back.num / start.num));
	}
	else{
	    System.out.println("incorrect input");
	    return false;
	}
	return true;
    }
    class Lnode{
	Lnode back = null;
	Lnode front = null;
	double num;
	Lnode(String num){
	    this.num = Double.parseDouble(num);
	}
	Lnode(double num){
	    this.num = num;
	}
	Lnode(){
	}
	void subsitude(Lnode newNode){
	    newNode.back = back.back;
	    back.back.front = newNode;
	    front = newNode;
	}
    }
}
