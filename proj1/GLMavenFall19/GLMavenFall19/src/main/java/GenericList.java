/*
 * Class : GenericList.java
 * 
 * Name: Jared Manusig
 * NetId: Jmanus2
 * Email: jmanus2@uic.edu
 * Project 1, CS 342 || Professor Mark Hallenbeck
 * Description: Creates a generic abstract list that a queue and stack
 * 				can inherit from. Uses a linked-list structure.
 */

import java.util.Iterator;

public abstract class GenericList<I> implements CreateIterator{
	
	//declare the head of the linked list
	protected Node<I> head = null;
	//private length of the list structure
	private int length = 0;
	
	//inner class node for a singular indice
	public class Node<T>{
		//data inside node
		T data;
		//next node
		Node<T> next;
		
		//constructor to make a new node
		Node(T d) { data = d; }
	}
	
	//function prints out the entire list
	public void print() { 
		
		//create a temporary node for traversal
		Node<I> currNode = head;
		
		//go through the entire list and print the data field
		while(currNode != null) {
			System.out.println(currNode.data);
			//go to next node
			currNode = currNode.next;			
		}
	
	}
	
	//abstract method add to add to the list (To be implemented in inheritance)
	protected abstract void add(I data); 
	
	//defined delete function for the list
	public I delete() {
		//check if the head is null; If so, return null
		if(head == null)
			return null;
		
		//otherwise get the head data
		I val = head.data;
		
		//change head to be the next value
		head = head.next;
		
		//subtract the list length
	    length --;
	    
	    //return the value
	    return val;
	    
	};
	
	
	//getter method to return length
	int getLength() {
		return length;
	}
	
	//function increments the length
	public void incLen() {
		length ++;
	}
	
	//function decrements the length
	protected void decLen() {
		//if length is 0 or less, it should not decrement
		if(length > 0 )
			length --;
	}
	
	//implementation of the CreateIterator interface
	public Iterator<I> createIterator(){
		//return a list iterator given a head
		return new GLIterator<I>(head);
	}


}
