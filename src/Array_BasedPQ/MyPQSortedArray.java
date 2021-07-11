package Array_BasedPQ;

public class MyPQSortedArray {
    Entry[] array;
	int size;
	int capacity;
	
	MyPQSortedArray(){
		
		array = new Entry[1];
		size = 0;
		capacity = 1;
		
	}
    public void insert(int k, String v) {
		
		if(isEmpty()) {
		
			array[0] = new Entry(k, v);
			
		}
		else {
			
			if(size + 1 >= capacity) {
				
				//array is full, resize
				resize_array();
				
			}
			
			int position = -1;
			
			for(int i = 0; i < size; i++) {
				
				if(array[i].key < k) {
					
					position = i;
					
				}	
			}
			
			for(int i = size - 1; i > position; i--) {
				
				array[i+1] = array[i];
				
			}
			
			array[position + 1] = new Entry(k, v);
			
		}
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
		
		//the smallest index is at the start
		Entry first = array[0];
		
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

		Entry first = array[0];
		
		for(int i = 0; i < size - 1; i++) {
			
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
		System.out.println("Capacity of the Array: " + capacity);
	}
}
