/*
 * Class : GenericStack.java
 * 
 * Name: Jared Manusig
 * NetId: Jmanus2
 * Email: jmanus2@uic.edu
 * Project 1, CS 342 || Professor Mark Hallenbeck
 * Description: A generic Stack that inherits from a generic list
 * 
 */

import java.util.Iterator;

public class GenericStack<I> extends GenericList<I> {
	
	//generic constructor
	public GenericStack() {
		
	}
	
	//generic constructor for a stack with a parameter
	public GenericStack(I d) {
		//create a new node
		head = new Node<I>(d);
		//set next = null
		head.next = null;
		//make length 1 since we added a node
		incLen();
	}
	
	//function adds to the list at the front
	protected void add(I d) {
		Node<I> ins = new Node<I>(d);
		ins.next = head;
		head = ins;
		incLen();
	}
	
	//function calls add since it is protected
	public void push(I d) {
		this.add(d);
	}
	
	//function calls delete since it is protected
	public I pop() {
		return delete();
	}
	
	public static void main(String[] args) {
		GenericStack<String> gs = new GenericStack<String>();
		
		System.out.println("len " + gs.getLength());
		//if(gs.head.data == null)
			//System.out.println("Yay");
		
		gs.print();
		System.out.println("^Shouldve been something \n");
		
		for(int i = 1; i < 10; i++) {
			gs.push("Wumbo : " + i);
			
		}
		
		Iterator<String> it = gs.createIterator();
		
		
		
	    while(it.hasNext() != false) {
			System.out.println("Next: " + it.next());
			System.out.println("data " + gs.head.data);
		}
	    
	    System.out.println("Length after Iteration: " + gs.getLength());
	    
	    for(int i = 0; i < 5; i++) {
	    	gs.pop();
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
