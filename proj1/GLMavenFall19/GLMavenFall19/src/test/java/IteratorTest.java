/*
 * Name: Jared Manusig
 * Email: Jmanus2@uic.edu
 * 
 * Description: Test file to test the iterator class
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IteratorTest {

	//create a generic stack and queue
	private GenericQueue<String> s;
	private GenericStack<Double> d; 
	//variables to hold the length of the stack and queue
	int xq;
	int xs;
	
	//initialize the stack, queue, and lengths
	@BeforeEach
	public void init() {
		s = new GenericQueue<String>("Wumbo");
		d = new GenericStack<Double>(4.0);
		//xq, xs = 1 for length
		xq = 1;
		xs = 1;
	}
	
	//test that we can make an iterator
	@Test
	void testInitGQ() {
		Iterator it = s.createIterator();
		assertNotNull(it, "Generic Queue Iterator made incorrectly");
		assertEquals(it.next(), "Wumbo", "Iterator incorrectly made for generic queue");
	}
	
	@Test
	void testInitGS() {
		
		Iterator it = d.createIterator();
		assertNotNull(it, "Generic Stack Iterator made incorrectly");
		assertEquals(it.next(), 4.0, "Iterator incorrectly made for generic Stack");
	}
	
	
	//test that the head does not change by the iterator
	@Test
	void testNodeChangeGQ() {
		Iterator it = d.createIterator();
		it.next();
		
		assertEquals(d.head.data, 4.0, "Iterator changed head for generic Stack");
		
	}
	
	@Test
	void testNodeChangeGS() {
		Iterator it = s.createIterator();
		it.next();
		
		assertEquals(s.head.data, "Wumbo", "Iterator changed head for Generic queue");
	}
	
	//test has next 
	@Test
	void testHasNextGS() {
		Iterator it = s.createIterator();
		
		assertTrue(it.hasNext(), "Has next does not work for Generic queue");
	}
	
	@Test
	void testHasNextGQ() {
		Iterator it = d.createIterator();
		
		assertTrue(it.hasNext(), "Has next does not work for Generic Stack");
	}
	
	
	//test that next iterates over a list
	@ParameterizedTest
	@ValueSource(strings = {"Patrick", "SpongeBob", "Squidward", "Pearl"})
	void testNextValueGQ(String name) {
		s.enqueue(name);
		
		Iterator it = s.createIterator();
		it.next();
		
		assertTrue(it.next() == name, "Next does not work for Generic Queue");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Patrick", "SpongeBob", "Squidward", "Pearl"})
	void testNextValueGS(String name) {
		s.enqueue(name);
		
		Iterator it = s.createIterator();
		it.next();
		
		assertTrue(it.next() == name, "Next does not work for Generic Stack");
	}
	
	//test hasNext should be false when there is no next node
	@Test
	void testhasNextNullGQ() {
		Iterator it = d.createIterator();
		it.next();
		
		assertFalse(it.hasNext(),  "hasNext() does not work for Queue");
	}
	

	@Test
	void testhasNextNullGS() {
		Iterator it = s.createIterator();
		it.next();
		
		assertFalse(it.hasNext(),  "hasNext() does not work for Queue");
	}
	
	//test that the length doesnt change by the iterator
	@Test
	void testLengthGQ() {
		Iterator it = s.createIterator();
		it.next();
		
		assertEquals(s.getLength(), xq, "Iterator changes the length for Generic Queue");
	}
	
	@Test
	void testLengthGS() {
		Iterator it = d.createIterator();
		it.next();
		
		assertEquals(d.getLength(), xs, "Iterator changes the length for Generic Stack");
	}
	
	//Test that the type does not change
	@Test
	void testTypeGQ() {
		Iterator it = s.createIterator();
		
		assertTrue(it.next() instanceof String, "Iterator changes the Type for Queue");
	}
	
	@Test
	void testTypeGS() {
		Iterator it = d.createIterator();
		
		assertTrue(it.next() instanceof Double, "Iterator changes the Type for Stack");
	}
	

	//Test FIFO and LIFO
	@Test
	void testFIFO() {
		s.enqueue("W");
		s.enqueue("U");
		s.enqueue("M");
		
		Iterator it = s.createIterator();
		
		assertEquals(it.next(), "Wumbo", "Next is wrong");
		assertEquals(it.next(), "W", "Next is wrong");
		assertEquals(it.next(), "U", "Next is wrong");
		
	}
	
	@Test
	void testLIFO() {
		d.push(3.0);
		d.push(3.1);
		d.push(3.2);
		
		Iterator it = d.createIterator();
		
		assertEquals(it.next(), 3.2, "Next is wrong");
		assertEquals(it.next(), 3.1, "Next is wrong");
		assertEquals(it.next(), 3.0, "Next is wrong");
		
	}
	
	
}
