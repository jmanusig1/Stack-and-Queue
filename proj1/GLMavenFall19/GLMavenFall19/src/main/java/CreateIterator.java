/*
 * Interface : CreateIterator.java
 * 
 * Name: Jared Manusig
 * NetId: Jmanus2
 * Email: jmanus2@uic.edu
 * Project 1, CS 342 || Professor Mark Hallenbeck
 * Description: An interface to be used in a generic list
 * 				implementation using a linked-list structure.
 * 				Import Iterator and requires a list to have an
 * 				Iterator to be made.
 */
import java.util.Iterator;

public interface CreateIterator<E>{
	
	abstract Iterator<E> createIterator();
}
