/*
 * Class : GenericQueue.java
 * 
 * Name: Jared Manusig
 * NetId: Jmanus2
 * Email: jmanus2@uic.edu
 * Project 1, CS 342 || Professor Mark Hallenbeck
 * Description: A generic Queue that inherits from a generic List
 * 
 */

import java.util.Iterator;

public class GenericQueue<I> extends GenericList<I>{
	
	//empty constructor
	public GenericQueue() {
		
	}
	
	//constructor given a parameter
	public GenericQueue(I d) {
		//create a new node
		head = new Node<I>(d);
		//set next = null
		head.next = null;
		//make length 1 since we added a node
		incLen();
	}
	
	//function adds a new node into the list
	protected void add(I d) {
		//create the insert node
		Node<I> ins = new Node<I>(d);
		ins.next = null;
		
		//create a node for traversal
		Node<I> currNode = head;
		
		//but if the head is null, head = insert
		if(head == null)
			head = ins;
		
		//otherwise, loop until we get to the second to last node
		while(currNode.next != null) 
			currNode = currNode.next;
		
		//then insert the node
		currNode.next = ins;
		
		//increment the length
		incLen();
		
		System.out.println("Ins Size: " + getLength());
	}
	
	//calls add since add is protected
	public void enqueue(I d) {
		this.add(d);
	}
	
	//calls delete since delete is protected
	public I dequeue() {
		return delete();
	}
	
	
	
	public static void main(String[] args) {
		GenericQueue<Integer> gs = new GenericQueue<Integer>(0);
		
		System.out.println("len " + gs.getLength());
		//if(gs.head.data == null)
			//System.out.println("Yay");
		
		gs.print();
		System.out.println("^Shouldve been something \n");
		
		for(int i = 1; i < 10; i++) {
			gs.enqueue(i);
			
		}
		
		Iterator<Integer> it = gs.createIterator();
		
		
		
	    while(it.hasNext() != false) {
			System.out.println("Next: " + it.next());
			System.out.println("data " + gs.head.data);
		}
	    
	    System.out.println("Length after Iteration: " + gs.getLength());
	    
	    for(int i = 0; i < 5; i++) {
	    	gs.dequeue();
	    }
	    
	    System.out.println("--------------------POP-----------------");
	    
	    it = gs.createIterator();
	    
	    while(it.hasNext() != false) {
			System.out.println(it.next());
			System.out.println("data " + gs.head.data);
		}
	    
	    System.out.println("---Print---");
	    gs.print();
	    
		
		
		
	}


	
}
