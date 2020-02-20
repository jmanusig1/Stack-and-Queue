/*
 * Class : GenericIterator.java
 * 
 * Name: Jared Manusig
 * NetId: Jmanus2
 * Email: jmanus2@uic.edu
 * Project 1, CS 342 || Professor Mark Hallenbeck
 * Description: A generic Iterator that iterates through a generic list
 * 
 */

import java.util.Iterator;

public class GLIterator<I> implements Iterator<I>{

	//create a node that will make a copy of the list head
	GenericList<I>.Node<I> itHead;

	//constructor takes the head of a list
	public GLIterator(GenericList<I>.Node<I> list) {
		itHead = list;
	}
	
	
	//function returns a boolean to determine if there exists a next
	@Override
	public boolean hasNext() {
		//if there is no node, there there is no next
		if(itHead != null)
			return true;		
		return false;
	}
	
	//function returns the value of current node and goes to next
	@Override
	public I next() {
		//if the head is null, then oop return null
		if(itHead == null)
			return null;
		//otherwise, get the data and go to next
		I val = itHead.data;
		itHead = itHead.next;
		
		//and return value
		return val;
	}
	

}
