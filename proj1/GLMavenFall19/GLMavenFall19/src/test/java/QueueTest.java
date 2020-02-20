/*
 * Name: Jared Manusig
 * Email: Jmanus2@uic.edu
 * 
 * Description: Test file to test the Queue class
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QueueTest {
	
	//make a generic queue of string
	private GenericQueue<String> s;
	//x holds the length of the list
	int x;
	
	@BeforeEach
	public void initQueueString() {
		s = new GenericQueue<String>("Wumbo");
		//x = 1 for length
		x = 1;
	}
	
	@Test
	void testInitGS() {
		assertEquals("GenericQueue", s.getClass().getName(), "did not initialize proper object");
	}
	
	@Test
	void testInitNode() {
		assertEquals("GenericList$Node", s.head.getClass().getName(), "did not initialize node in constructor");
		
	}
	
	@Test
	void testForNodeVal() {
		assertEquals("Wumbo", s.head.data, "value not in node");
	}
	
	@Test
	void testDequeueListVal() {
		
		assertEquals("Wumbo", s.dequeue(), "value not returned");
		
	}
	
	@Test
	void testEmptyList() {
		s.dequeue();
		assertNull(s.head);
	}
	
	
	@Test
	public void queueConstructorLength() {
		
		//first check if it is not null
		assertNotNull(s);
		
		//check for the length of a new list
		assertEquals(s.getLength(), 1, "Constructor for length did not work");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Patrick", "SpongeBob", "Squidward"})
	public void testEnqueue(String name) {
		//enqueue the string of names
		s.enqueue(name);
		
		//dequeue to get the last name
		s.dequeue();
		
		//check if it equals the name
		assertEquals(s.dequeue(), name, "Enqueue does not work");
	}
	
	//Test that Enqueue and Decrement properly inc/dec the length
	@Test
	public void testQueueLengthDecrement() {
		s.enqueue("Wombat");
		s.enqueue("wUmbO");
		s.enqueue("Asakusa");
		s.enqueue("Manila");
		s.enqueue("Sayang");
		
		s.dequeue();
		s.dequeue();
		s.dequeue();

		assertEquals(s.getLength(), 3, "List Length did not work");
	
	}
	
	
	//Test that we can dequeue a list
	@Test
	public void testDequeueNull() {
		//function tests if we can dequeue a null list
		s.dequeue();
		assertNull(s.dequeue(), "Deque Empty list does not work");
	}
	
	//test that length does not go below 0
	@Test
	public void testQueueLengthZero() {
		s.enqueue("hiya");
		s.enqueue("Wombat");
		s.enqueue("wumbology");
		s.enqueue("Chiayafuru");
		
		//dequeue until it goes past 0
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.dequeue();
		
		assertEquals(s.getLength(), 0, "Dequeue Does not work, length wrong");
	
	}
	
	
	//test enqueue length
	@ParameterizedTest
	@ValueSource(strings = {"Patrick", "SpongeBob", "Squidward", "Krabs"})
	public void testQueueLengthInc(String name) {
		x++;
		s.enqueue(name);

		assertTrue(s.getLength() == x, "Length of enqueue does not work");
	}
	
	//test that the type stays the same
	@Test
	public void testQueueType() {
	
		String node = s.dequeue();
	
		assertTrue(node instanceof String, "Queue wrong type");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"4.0", "3", "Squidward", "false"})
	public void testQueueTypeTwo(String data) {
		//function tests if ints and doubles are still strings
		s.enqueue(data);
		String node = s.dequeue();
		
		assertTrue(node instanceof String, "Queue wrong type");
	
	}
	
	@Test
	public void testStackType3() {
		GenericQueue<Double> d = new GenericQueue<Double>(4.0);
	
		Double node = d.dequeue();
		assertTrue(node instanceof Double, "Queue Type is Wrong");
	}
	
	@Test
	public void testStackType4() {
		GenericQueue<Integer> d = new GenericQueue<Integer>(4);
	
		Integer node = d.dequeue();
		assertTrue(node instanceof Integer, "Queue Type is Wrong");
	}
	
	
	//test taht te length is correct for large loops
	@Test
	public void testNValue() {
		//function tests if length works for a large N
		GenericQueue<Integer> nums = new GenericQueue<Integer>(1);
		
		for(int i = 1; i < 1000; i++) {
			nums.enqueue(i);
			assertTrue(nums.getLength() == i+1, "Length does not work");
		}
	}
	
	//test that FIFO works
	@Test
	public void testFIFO() {
		
		s.enqueue("W");
		s.enqueue("U");
		s.enqueue("M");
		s.enqueue("B");
		s.enqueue("O");
		
		assertTrue(s.dequeue() == "Wumbo", "FIFO not working");
		assertTrue(s.dequeue() == "W", "FIFO not working");
		assertTrue(s.dequeue() == "U", "FIFO not working");
		assertTrue(s.dequeue() == "M", "FIFO not working");
		assertTrue(s.dequeue() == "B", "FIFO not working");
		assertTrue(s.dequeue() == "O", "FIFO not working");
	}
}
