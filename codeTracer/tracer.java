import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class tracer extends Thread{
    private Scanner keyboard = new Scanner(System.in);
    public void print(String x){
	//will format what is printed out later
	System.out.println(x);
    }
    public Scanner getKeyboard(){
	return keyboard;
    }
    public String input(){
	return getKeyboard().nextLine();
    }
    public static void makeFile(String fileName){
	try{
		File file = new File(fileName);
		if (file.createNewFile()){
		    System.out.println("file created");
		}
		else{
		    System.out.println("plz remove " + fileName + " first");
		    return;
		}
	    }
	    catch(IOException e){
		e.printStackTrace();
	    }
    }
    private boolean equals(StackTraceElement[]a,StackTraceElement[]b){
	if(a.length != b.length){
	    return false;
	}
	int end;
	for(int i = 0; i < a.length; i++){
	    if(!(a[i].equals(b[i]))){
		return false;
	    }
	}
	return true;
    }
    private StackTraceElement[] stack;
    private Thread mainThread;
    public tracer(Thread mainThread){
	this.mainThread = mainThread;
    }
    public void run(){
	stack = mainThread.getStackTrace();
    }
    public static void main(String[]args){
	if(args.length == 0){
	    tracer a = new tracer();
	    //System.out.println(a.getKeyboard().nextLine());
	    a.print(Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	else{
	    System.out.println("unacceptable input");
	}
    }
}
