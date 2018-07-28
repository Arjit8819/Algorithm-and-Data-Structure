package edu.neu.coe.info6205.assng4;

import java.util.Arrays;
import java.util.Random;

public class Birthdayandcoupon {

	static int m; //slos/bins
	static int[] hash; //This array is the hashtable.
	static int C1; //Will have value for C1.
        static int B0; // will have values for B0.
	static int axis = 50; // This is the number of time loop will run.

	public static void main(String[] args) {
		m = 365;
		double averageC = 0.0;
		double averageB = 0.0;
		for (int i = 0; i < axis; i++) {
			hash = new int[m];
			Arrays.fill(hash, -1);
			 C1 = 0;
                         B0 = 0;
			hashtable();
                        averageC = averageC + C1;
			averageB = averageB + B0;
		}
		System.out.println("Avarage for first collision birthday :"+averageC/axis);
		System.out.println("m to fill all the bins :"+averageB/axis);
		
	}

	
	static void hashtable() {
				Birthday();
				for(int i=0;i<m;i++) {
					if(hash[i]==-1) {
						couponcollector();
					}
				}
			}
				

	
	
	static void Birthday() {
		int count = 0;
		for (int i = 0; i < m; i++) {
			 Random random = new Random();
                         int x =  random.nextInt(m);
                            int z = x%m;
			 if (hash[z] == -1) {
				hash[z] = x;
				count++;
			 } else{
				C1 = count;
				break;
			}
		}
	}
	
	
	static void couponcollector() {
		for (int i = 0; i < m; i++) {
			Random r = new Random();
			int val = r.nextInt(m);
			int mod = val % m;
				hash[mod] = val;
				B0++;
		}
	}
	
	static void TestCase(int Array[]) {
		for (int i = 0; i < m; i++) {
			int x = Array[i] % m;
			hash[x] = Array[i];
		}
	}

}
