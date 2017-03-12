import java.util.*;
import java.io.*;
public class USACO{
    private int finalAnswer;

    public USACO(){
	
    }
    private boolean animate = false;
    public void setAnimate(boolean x){
	animate = x;
    }

    public int bronze(String fileName){
	oString file = new oString(getFile(fileName));
	int[] parm = new int[4];
	if(!lineToArray(parm,file)){
	    System.out.println("fileCorrupt");
	    return 0;
	}
	int[][] board = new int[parm[0]][parm[1]];
	for(int r = 0; r < parm[0];r++){
	    if(!lineToArray(board[r],file)){
		System.out.println("filecorrupt");
		return 0;
	    }
	}
	int[][] script = new int[parm[3]][3];
	for(int i = 0;i < parm[3];i++){
	    if(!lineToArray(script[i],file)){
		System.out.println("filecorrupt");
		return 0;
	    }
	}
	lake x = new lake(parm[2],parm[3],board,script);
	x.setAnimate(animate);
	return x.solve();
    }
    private boolean lineToArray(int[]ary,oString s){
	int index = 0;
	String temp = "";
	int end = 0;
	try{
	    for(int i = 0; i < s.s.length() && index < ary.length; i++){
		if(s.s.charAt(i) == ' ' || s.s.charAt(i) == '\n'){
		    if(s.s.charAt(i) == '\n'){
			end = i;
		    }
		    ary[index++] = Integer.parseInt(temp);
		    temp = "";
		}
		else{
		    temp += Character.toString(s.s.charAt(i));
		}
	    }
	}
	catch(Throwable e){
	    e.printStackTrace();
	    return false;
	}
	s.s = s.s.substring(end + 1);
	return true;
    }
    private String firstLine(String x){
	int i = 0;
	String temp = "";
	while(x.charAt(i) != '\n' && i < x.length()){
	    temp += Character.toString(x.charAt(i));
	}
	return temp;
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
class oString{
    public oString(String s){
	this.s = s;
    }
    String s;
}
