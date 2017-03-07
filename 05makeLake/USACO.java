import java.util.*;
import java.io.*;
public class USACO{
    private int finalAnswer;

    public USACO(){
	
    }

    public int bronze(String fileName){
	String file = getFile(fileName);
	System.out.println(file);
	int[] parm = new int[4];
	return 0;
    }

    public int silver(String fileName){
	return 0;
    }

    public String getFile(String fileName){
	String file = "";
	try{
	    Scanner inf = new Scanner(new File(fileName));
	    while(inf.hasNextLine()){
		file += inf.nextLine() + "\n";
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File is not found.");
	}
	return file;
    }
	
    public static void main(String[] args){
	USACO x = new USACO();
	x.bronze("testfile1.txt");
    }
}
