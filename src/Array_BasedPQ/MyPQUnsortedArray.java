package Array_BasedPQ;

public class MyPQUnsortedArray {

	Entry[] array;
	int size;
	int capacity;
	
	MyPQUnsortedArray(){
		
		array = new Entry[1];
		size = 0;
		capacity = 1;
		
	}
	
	public void insert(int k, String v) {
		
		if(size < capacity) {
			
			array[size] = new Entry(k,v);
			
		}//if the array is full
		else {
			
			resize_array();
			array[size] = new Entry(k,v);
		
		}
		//size is increased by one after insertion
		size++;
	}
	
	public void resize_array() {
		
		Entry [] temp_array = new Entry[capacity * 2];
		
		for(int i = 0; i<size; i++) {
			
			temp_array[i] = array[i];
			
		}
		
		capacity = capacity * 2;
		array = temp_array;
		
	}
	
	public Entry min() {
		
		if(size == 0) {
			
			return null;
			
		}
		
		int smallest = array[0].key;
		Entry first = array[0];
		
		for(int i = 0; i < size; i++) {
			
			if(array[i].key < smallest) {
				
				first = array[i];
				smallest = array[i].key;
				
			}
			
		}
		
		return first;
		
	}
	
	public void reduce_size() {
		
		Entry [] temp_array = new Entry[capacity / 2];
		
		for(int i = 0; i<size; i++) {
			
			temp_array[i] = array[i];
			
		}
		
		capacity = capacity / 2;
		array = temp_array;
		
	}
	
	public Entry removeMin() {
		
		if(size == 0) {
			
			return null;
			
		}
		
		int smallest = array[0].key;
		Entry first = array[0];
		int index = 0;
		
		for(int i = 0; i < size; i++) {
			
			if(array[i].key < smallest) {
				
				first = array[i];
				smallest = array[i].key;
				index = i;
			}
			
		}
		
		for(int i = index; i < size - 1; i++) {
			
			array[i] = array[i+1];
			
		}		
		size = size - 1 ;
		
		if(size < capacity / 4) {
			
			reduce_size();
			
		}
		
		return first;
		
	}
	
	public boolean isEmpty() {
		
		if(size == 0)
			return true;
		
		return false;
		
	}

	
	public void show() {
		
		for(int i = 0; i<size; i++) {
			
			System.out.println(array[i].value);
			
		}
		System.out.println("Size : " + size);
		System.out.println("Capacity of the Array : " + capacity);
	}
}