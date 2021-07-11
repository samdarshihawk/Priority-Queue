package MDouble;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 
import java.util.Random;

public class tester1 {

	public static void main(String args[]) {
		
		
		MyPQUnSortedList<Integer, String> pr1 = new MyPQUnSortedList<Integer, String>();
		
		int[] N = {10, 100, 1000, 10000, 100000, 1000000};
		Random rand = new Random();
				
            
			long startTime = System.nanoTime();
			for (int i = 0; i < N.length-1; i++) {
			
				int input_size = N[i];
				System.out.println(" For N = "+input_size);
				if(input_size <= 10000) {
				
					try {
					
						// Creating an object of the file for reading the data
						File myObj = new File("elements_test_file1.txt");  
					
						Scanner Input = new Scanner(myObj);
						while (Input.hasNextLine()) {
					
							int int_random = rand.nextInt(input_size); 	
							String data = Input.nextLine();
						
							pr1.insert(int_random, data);
					
						}
						Input.close();
					
					} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
					}
				
				
				}
				else if (input_size > 10000 && input_size <= 100000) {
				

					try {
					
						// Creating an object of the file for reading the data
						File myObj = new File("elements_test_file2.txt");  
					
						Scanner Input = new Scanner(myObj);
						while (Input.hasNextLine()) {
					
							int int_random = rand.nextInt(input_size); 	
							String data = Input.nextLine();
						
							pr1.insert(int_random, data);
					
						}
						Input.close();
					
					} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
					}
				
				}else if(input_size > 100000 && input_size <= 1000000) {
				

					try {
					
						// Creating an object of the file for reading the data
						File myObj = new File("elements_test_file3.txt");  
					
						Scanner Input = new Scanner(myObj);
						while (Input.hasNextLine()) {
					
							int int_random = rand.nextInt(input_size); 	
							String data = Input.nextLine();
						
							pr1.insert(int_random, data);
					
						}	
						Input.close();
					
					} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
					}
				}
			
			long stopTime= System.nanoTime();
			System.out.println("Execution Time for inserting(K,V) method for MyPQUnsortedList  "+(stopTime-startTime)+" nanoseconds");
			if((pr1.min()) != null)
				System.out.println("MIN : " + pr1.min().getKey());
		
			if((pr1.min()) != null)
				System.out.println("REMOVE MIN : " + pr1.removeMin().getValue());
		
		
			
			if(pr1.isEmpty()) {
			
				System.out.println("Queue is Empty!");
			
			}
		
			//now removing the items
			long starTime2= System.nanoTime();
			while(!pr1.isEmpty()) {
			
				pr1.removeMin();
			
			}
			long stopTime2= System.nanoTime();
			System.out.println("Execution Time for removeMin method for MyPQUnsortedList "+(stopTime2-starTime2)+" nanoseconds");
			}
			
		
		

		
		
	}
}