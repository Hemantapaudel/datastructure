package arrays_dynamicprograms.basic;

public class MinimumNumberOfEdits {

	 static int min(int x,int y,int z)
	    {
	        if (x<y && x<z) return x;
	        if (y<x && y<z) return y;
	        else return z;
	    }
	
	public static int editDist(String str1, String str2, int firstLength, int secondLength){
		
		if(firstLength == 0)
			return secondLength;
		if(secondLength ==0){
			return firstLength;
		}
		// if last character are same , no need to edit it
		if(str1.charAt(firstLength-1) == str2.charAt(secondLength-1)){
			return editDist(str1, str2, firstLength-1, secondLength-1);
		}
		
		return 1 + min(editDist(str1, str2, firstLength-1, secondLength-1),
				editDist(str1, str2, firstLength-1, secondLength),
				editDist(str1, str2, firstLength, secondLength-1) );
	}
	
	
	public static void main(String[] args) {
		 String str1 = "sunday";
	        String str2 = "saturday";
	  
	        System.out.println( editDist( str1 , str2 , str1.length(), str2.length()) );

	}

}
