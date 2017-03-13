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
	    /*
	    System.out.println("error");
	    System.out.println(index);
	    System.out.println(temp);
	    System.out.println(end);
	    System.out.println(s.s);
	    System.out.println(ary[0] + " " + ary[1] + " " + ary[2]);
	    */
	    return false;
	}
	s.s = s.s.substring(end + 1);
	return true;
    }
    private boolean lineToArray(char[]ary,oString s){
	int index = 0;
	try{
	    for(int i = 0; i < s.s.length() && index < ary.length; i++){
		if(s.s.charAt(i) == '\n'){
		    s.s = s.s.substring(i + 1);
		    break;
		}
		else{
		    ary[index++] = s.s.charAt(i);
		}
		//System.out.println(end);
	    }
	}
	catch(Throwable e){
	    //System.out.println("sup");
	    e.printStackTrace();
	    //System.out.println("sup");
	    return false;
	}
	
	s.s = s.s.substring(ary.length);
	//System.out.println(s.s);
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
	oString file = new oString(getFile(fileName));
	int[]parms = new int[3];
	if(!lineToArray(parms,file)){
	    System.out.println("fileCorrupt1");
	    return 0;
	}
	char[][]board = new char[parms[0]][parms[1]];
	for(int r = 0; r < parms[0]; r++){
	    if(!lineToArray(board[r],file)){
		System.out.println("fileCorrupt2");
		return 0;
	    }
	}
	int[]cords = new int[4];
	file.s = file.s.substring(1);
	if(!lineToArray(cords,file)){
	    System.out.println("fileCorrupt3");
	    return 0;
	}
	int[][]board1 = new int[parms[0]][parms[1]];
	for(int r = 0; r < parms[0]; r++){
	    for(int c = 0; c < parms[1]; c++){
		if(board[r][c] == '*'){
		    board1[r][c] = -1;
		}
	    }
	}
	board1[cords[0] - 1][cords[1] - 1] = 1;
	int[][]board2 = new int[parms[0]][parms[1]];
	for(int r = 0; r < board2.length; r++){
	    for(int c = 0; c < board2[r].length; c++){
		board2[r][c] = board1[r][c];
	    }
	}
	int[][] boardT;
	for(int a = 0; a < parms[2] - 1;a++){
	    for(int r = 0; r < board1.length;r++){
		for(int c = 0; c < board1[r].length;c++){
		    if(board1[r][c] != -1){
			for(int n = 0; n < 8; n += 2){
			    if(r + dir[n] >= 0 && c + dir[n + 1] >= 0 &&
			       r + dir[n] < parms[0] && c + dir[n + 1] < parms[1] &&
			       board2[r + dir[n]][c + dir[n + 1]] != -1){
				board2[r + dir[n]][c + dir[n + 1]] += board1[r][c];
			    }
			}
			if(board1[r][c] != -1){
			    board1[r][c] = 0;
			}
		    }
		}
	    }
	    //show(board1);
	    //show(board2);
	    boardT = board1;
	    board1 = board2;
	    board2 = boardT;
	}
	return board1[parms[0] - 1][parms[1] - 1];
    }
    private static void show(int[][]b){
	for(int r = 0; r < b.length;r++){
	    for(int c = 0; c < b[r].length;c++){
		System.out.print(b[r][c] + " ");
	    }
	    System.out.print('\n');
	}
	System.out.print('\n');
    }
    private static int[]dir = {0,1,0,-1,1,0,-1,0};
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
