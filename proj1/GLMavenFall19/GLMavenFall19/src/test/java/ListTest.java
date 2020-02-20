/*
 * Name: Jared Manusig
 * Email: Jmanus2@uic.edu
 * 
 * Description: Test file to test the Stack class
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ListTest {
	
	//declare a generic stack for testig
	private GenericStack<String> s;
	//x hold the length of the stack
	int x;
	
	@BeforeEach
	public void init() {
		s = new GenericStack<String>("Wumbo");
		//x = 1 for length
		x = 1;
	}
	
	@Test
	void testInitGS() {
		assertEquals("GenericStack", s.getClass().getName(), "did not initialize proper object");
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
	void testPopListVal() {
		
		assertEquals("Wumbo", s.pop(), "value not returned");
		
	}
	
	@Test
	void testEmptyList() {
		s.pop();
		assertNull(s.head);
	}
	
	
	//test the length from constructor
	@Test
	public void stackConstructorLength() {
		assertNotNull(s);
		assertEquals(s.getLength(), 1, "Constructor length incorrect");
	}
	
	//test that push actually works
	@ParameterizedTest
	@ValueSource(strings = {"Blossom", "Bubbles", "Buttercup"})
	public void testPush(String name) {
		s.push(name);
		
		assertTrue(s.pop() == name, "Push Not working");	
	}
	
	//test that it pushes to front
	@Test
	public void testPushFront() {
		s.push("Vicks");
		s.push("Vasaline");
		s.push("Kateinko");
		
		assertEquals(s.pop(), "Kateinko", "Does not push to back");
	}
	
	//test that length is proper when pushing
	@ParameterizedTest
	@ValueSource(strings = {"Blossom", "Bubbles", "Buttercup"})
	public void testPushLen(String name) {
		s.push(name);
		x++;
		assertEquals(s.getLength(), x, "Push Length Not working");	
	}
	
	
	//test that length does not go below 0
	@Test
	public void testNegativePop(){
		//function tests if we can pop beyond 0
		s.pop();
		s.pop();
		s.pop();
		
		assertTrue(s.getLength() == 0, "Pop Length does not work");
		
	}
	
	//test that push and pop produce a proper length
	@Test
	public void testPopLength() {
		s.push("Watashi");
		s.push("Onigiri");
		s.push("Daisuke");
		s.push("Kirito");
		s.push("Bokura ga ita");
		s.push("SNAFU");
		
		s.pop();
		s.pop();
		s.pop();
		
		assertEquals(s.getLength(), 4, "Pop Length does not work");
	
	}
	
	
	//test that the type does not change
	@Test
	public void testStackType() {
		String node = s.pop();
		
		assertTrue(node instanceof String, "Stack Type is Wrong");
	
	}

	@Test
	public void testStackType2() {
		GenericStack<Double> d = new GenericStack<Double>(4.0);
	
		Double node = d.pop();
		assertTrue(node instanceof Double, "Stack Type is Wrong");
	}
	
	@Test
	public void testStackType3() {
		GenericStack<Integer> d = new GenericStack<Integer>(4);
	
		Integer node = d.pop();
		assertTrue(node instanceof Integer, "Stack Type is Wrong");
	}
	
	
	//test that the length are 
	@Test
	public void testNValues() {
		GenericStack<Integer> s = new GenericStack<Integer>(1);
		
		
		for(int i = 1; i < 1000; i++) {
			s.push(i);
			assertEquals(s.getLength(), i + 1, "List Length is wrong when pushing");
			
		}
	}
	
	
	@Test
	public void testLIFO() {
		s.push("W");
		s.push("U");
		s.push("M");
		s.push("B");
		s.push("O");
		
		assertEquals(s.pop(), "O", "LIFO not working");
		assertEquals(s.pop(), "B", "LIFO not working");
		assertEquals(s.pop(), "M", "LIFO not working");
		assertEquals(s.pop(), "U", "LIFO not working");
		assertEquals(s.pop(), "W", "LIFO not working");
	}
	
}
