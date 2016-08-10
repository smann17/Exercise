//Sean Mann 8/9/16
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Excercise {
	public static void main(String[] args){
		String array = Arrays.toString(primeNumber(5));
		System.out.println(array);
		
		array = Arrays.toString(primeNumber(3));
		System.out.println(array);
		
		int[] arraySet = {2,3,5,5,3,7,2,7,9,1,2,3,9};
		
		int oddOne = oddOneOutSlow(arraySet);
		System.out.println("Slow: The number " + oddOne + " does not repeat");
		
		int oddOne2 = oddOneOut(arraySet);
		System.out.println("Fast: The number " + oddOne2 + " does not repeat");
		
		System.exit(0);
	}
	
	//Task: Given a number n, return an array with the prime numbers from 1 to n
	public static int[] primeNumber(int n){
		ArrayList<Integer> primeArray2= new ArrayList<Integer>();
		int count = 1;
		boolean prime;
		
		
		for (int i = 2; i<=n; i++){
			prime=true;
			for(int k=2; k<i; k++){
				if (i%k==0){
					prime=false;
					break;
				}
			}
			if (prime==true){
				
				primeArray2.add(i);
				count++;
			}
		}
		int[] primeArray = new int[count-1];
		primeArray[0]=1;
		for (int i=1; i<primeArray2.size(); i++){
			primeArray[i]=primeArray2.get(i-1); 
		}
		return primeArray;
	}
	
	//Task: given an array of positive integers, return the number that 
	//does not repeat in the array. (There will only be one non-repeating number)
	//Thoughts: This was my initial thought process with two for loops, but
	//it would have a Big O notation of O(n^2)
	public static int oddOneOutSlow(int[] intArray){
		int theOne = -1;
		int count = 0;
		for (int i=0; i<intArray.length; i++){
			count=0;
			for (int k=0; k<intArray.length; k++){
				if (intArray[i]==intArray[k]){
					count++;
				}
			}
			if (count==1){
				theOne = intArray[i];
				break;
			}
		}
		//System.out.println("The one is " + theOne);
		return theOne;
	}
	
	//Task: given an array of positive integers, return the number that 
	//does not repeat in the array. (There will only be one non-repeating number)
	//Thoughts: This was my other thought process as this is more streamlined
	//as it will result in O(n)
	public static int oddOneOut(int[] intArray){
		int oddOne = -1;
		Map<Integer, Integer> appearance = new HashMap<Integer, Integer>();
		for (int i=0; i<intArray.length; i++){
			if (!appearance.containsKey(intArray[i])){
				appearance.put(intArray[i], 1);
			}
			else {
				int count = appearance.get(intArray[i]);
				count++;
				appearance.put(intArray[i], count);
			}
		}
		for (Map.Entry<Integer, Integer> entry : appearance.entrySet()) {
			if (entry.getValue()==1){
				oddOne=entry.getKey();
				//System.out.println("The number " + entry.getKey() + " is not repeated");
			}
		    /*String key = entry.getKey().toString();
		    Integer value = entry.getValue();
		    System.out.println("key, " + key + " value " + value);*/
		}
		return oddOne;
	}
	
	
}
