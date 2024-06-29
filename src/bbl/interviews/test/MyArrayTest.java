package bbl.interviews.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbl.interviews.MyArray;

class MyArrayTest {

	@Test
	void test()
	{
		MyArray<Integer> array=new MyArray<>(4);
		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->array.get(5));
		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->array.set(5, 6));
		assertNull(array.get(1));
		array.set(1, 5);
		assertEquals(5,array.get(1));
		array.setAll(99);
		assertEquals(99,array.get(1));
		assertEquals(99,array.get(2));
		array.set(3, 7);
		assertEquals(7,array.get(3));
		assertEquals(99,array.get(0));
		
	}

}
