package Project3_DevasnhAgrawal;


import java.io.Serializable;
import java.util.ArrayList;
/**
 * The Heap class used to add sort and delete. 
 * 
 *
 */
public class Heap<E extends Comparable<E>> implements Serializable {
	 private ArrayList<E> arr; 
	    private int size; 
	    private int maxsize; 
//	  Constructor used to initialise the array list. 
	    public Heap() {
	    	arr = new ArrayList<>();
	    }
	    
	    // Functions used to return the required positions. 
	    private int parent(int pos) 
	    { 
	        return pos / 2; 
	    } 
	
	    private int leftChild(int pos) 
	    { 
	        return (2 * pos); 
	    } 
	    private int rightChild(int pos) 
	    { 
	        return (2 * pos) + 1; 
	    } 
	    public int size(){
	        return arr.size();
	      }
	    public boolean isEmpty(){
	        return size() == 0;
	      }

	      private int last(){
	        return size() - 1;
	      }
	  
	      private boolean isLeaf(int pos) 
	    { 
	        if (pos >= (size / 2) && pos <= size) { 
	            return true; 
	        } 
	        return false; 
	    } 
	      
	     // FUnction used to swap two positions of the array
	  
	    private void swap(int fpos, int spos) 
	    { 
	        E tmp; 
	        tmp =  arr.get(fpos); 
	        arr.set(fpos,arr.get(spos)); 
	        arr.set(spos, tmp); 
	    } 
	  
	    
	      private void maxHeapify(int pos, int size) 
	    { 
	        if (isLeaf(pos)) 
	            return; 
	        if(arr.get(pos).compareTo(arr.get(leftChild(pos)))<0 
	        		|| arr.get(pos).compareTo(arr.get(rightChild(pos)))<0) {
	        		
	        	 if (arr.get(leftChild(pos)).compareTo(arr.get(rightChild(pos))) > 0) { 
	        		 swap(pos,leftChild(pos));
	        		 maxHeapify(leftChild(pos),size);
	        }
	        	 else {
	        		 swap(pos,rightChild(pos));
	        		 maxHeapify(rightChild(pos),size);
	        		 }
	        	 }
	        } 
	      
	      // Funciton used to insert into the heap 
	      public void insert(E data) 
	    { 
	    	arr.add(data);  
	    	if(arr.size() >0 ) {
	    		int curIndex = arr.size() -1 ;
	    		 while((arr.get(curIndex)).compareTo(arr.get(parent(curIndex)))>0) {
	    			 swap(curIndex,parent(curIndex));
	    			 curIndex = parent(curIndex);
	    		 }	
	    	}
	       } 
	      
	    // Function to print out the list. 
	    public String print() 
	    { 
	    	String string = " ";
	    	for(int i = 0; i< arr.size();i++) {
	    		string += arr.get(i);
	    		
	    	}
	    	return string;
	    } 
	    
	    // Function used to sort the heap 
	    public void heapSort() {
	    	for(int i = arr.size()-1;i>=0;i++) {
	    		E tem = arr.get(0);
	    		arr.set(0,arr.get(0));
	    		arr.set(i,tem);
	    	}
	    }
	    
	    
	    // Function used to delete the max. 
	     public E delete() 
	    { 
	       if(isEmpty())
	    	   return null ;
	       swap(0, last());
	       E max = arr.remove(last());
	       maxHeapify(0,size());
	       return max;
	       
	    }
}
