public class test{
    public static void main(String[]args){
	for(int x = 22; x < 50; x++){
	    if(x % 21 != 0){
		int xLength = x;
		System.out.println("------------");
		System.out.println(x);
		int halve = xLength / 2;
		int width;
		int length;
		int thicknessW;
		int thicknessL;
		int hallowDim;
		System.out.println("halve: " + halve);
		width = (halve / 3) * 3;
		System.out.println("width: " + width);
		length = (halve / 7) * 7;
		System.out.println("length: " + length);
		int remainder = xLength - (width + length);
		System.out.println("remainder: " + remainder);
		//just going to hard code this part since there is only 9 possibilities
		if(remainder == 1){
		    width -= 6;
		    length += 7;
		}
		else if(remainder == 2){
		    width += 9;
		    length -= 7;
		}
		else if(remainder == 3){
		    width += 3;
		}
		else if(remainder == 4){
		    width -= 3;
		    length += 7;
		}
		else if(remainder == 5){
		    width -= 9;
		    length += 14;
		}
		else if(remainder == 6){
		    width += 6;
		}
		else if(remainder == 7){
		    length += 7;
		}
		else if(remainder == 8){
		    width -= 6;
		    length += 14;
		}
		else if(remainder == 9){
		    width += 9;
		}
		if(width > length){
		    hallowDim = width - length;
		}
		else{
		    hallowDim = length - width;
		}
		System.out.println("newWidth: " + width);
		System.out.println("newLength: " + length);
		System.out.println("hallowDim :" + hallowDim);
		thicknessW = width / 3;
		System.out.println("widthPieces: " + thicknessW);
		thicknessL = length / 7;
		System.out.println("lengthPieces: " + thicknessL);
	    }
	}
    }
}
