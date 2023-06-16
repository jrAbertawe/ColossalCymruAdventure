import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovementTestSuite {

	@Test
	public void tc1() {
		Movement classUnderTest = new Movement();
		assertEquals(-3, classUnderTest.movePlayer(-3, 'n'));
	}
	
	@Test
	public void tc2() {
		Movement classUnderTest = new Movement();
		assertEquals(4, classUnderTest.movePlayer(4, 's'));
	}
	
	@Test
	public void tc3() {
		Movement classUnderTest = new Movement();
		assertEquals(-5, classUnderTest.movePlayer(-5, 'w'));
	}

	@Test
	public void tc4() {
		Movement classUnderTest = new Movement();
		assertEquals(7, classUnderTest.movePlayer(7, 'e'));
	}
	
	@Test
	public void tc5() {
		Movement classUnderTest = new Movement();
		assertEquals(1, classUnderTest.movePlayer(2, 'n'));
	}
	
	@Test
	public void tc6() {
		Movement classUnderTest = new Movement();
		assertEquals(1, classUnderTest.movePlayer(0, 's'));
	}
	
	@Test
	public void tc7() {
		Movement classUnderTest = new Movement();
		assertEquals(2, classUnderTest.movePlayer(3, 'w'));
	}
	
	@Test
	public void tc8() {
		Movement classUnderTest = new Movement();
		assertEquals(4, classUnderTest.movePlayer(3, 'e'));
	}
}
