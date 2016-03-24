import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class deliverable4 {
	private int [] randArr = null;
	ArrayList<int[]> listOfArr = new ArrayList<int[]>();
	@Before
	public void setUp() throws Exception {
		for(int k = 0 ; k < 100 ; k++) {
			//create an array of random length
			int randArrLen = rand();
			randArr = generateArray(randArrLen);
			for(int j = 0 ; j < randArr.length ; j++) {
				//populate it with random numbers
				int newRand = rand();
				randArr[j] = newRand;
				listOfArr.add(randArr);
				//System.out.print("["+randArr[j]+"]");
			}
			//System.out.println("\n");
		}
		
	}
	@Test 
	public void test6Idempotent() {
		for(int i = 0 ; i <listOfArr.size() ; i++) {
			int[] newArr = listOfArr.get(i);
			Arrays.sort(newArr);
			int [] copyArr = Arrays.copyOf(newArr,newArr.length);
			Arrays.sort(newArr);
			assertTrue(Arrays.equals(newArr,copyArr));			
		}	
	}
	@Test public void test7Pure() {
		for(int i = 0 ; i < listOfArr.size(); i++) {
			int[] newArr = listOfArr.get(i);
			int [] copyArr = Arrays.copyOf(newArr,newArr.length);
			Arrays.sort(newArr);
			Arrays.sort(copyArr);
			assertTrue(Arrays.equals(newArr,copyArr));			
		}
	
	}
	@Test public void test1Output() {
		for(int i = 0 ; i < listOfArr.size(); i++) {
			int[] newArr = listOfArr.get(i);
			int [] copyArr = Arrays.copyOf(newArr,newArr.length);
			Arrays.sort(newArr);
			Arrays.sort(copyArr);
			int newArrLen = newArr.length;
			int copyArrLen = copyArr.length;
			assertTrue(newArrLen == copyArrLen);	
		}

	}
	
	public static int rand() {
		Random rn = new Random();
		int randomArrLength = rn.nextInt((100 - 50) + 1) + (50);
		return randomArrLength;
	}
	public static int[] generateArray(int rand) {
		int[] arr = new int[rand];
		for(int i = 0 ; i < rand ; i++) {
			arr[i] = rand;
		}
		return arr;
	}
	
}
