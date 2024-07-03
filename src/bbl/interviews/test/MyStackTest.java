package bbl.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import bbl.interviews.MyStackInt;

class MyStackTest 
{
	@Test
	void test()
	{
		MyStackInt myStack=new MyStackInt();
		assertThrowsExactly(NoSuchElementException.class,()-> myStack.peek());
		assertThrowsExactly(NoSuchElementException.class,()-> myStack.pop());
		assertThrowsExactly(NoSuchElementException.class,()-> myStack.getMaxElement());
		
		myStack.push(10);
		assertEquals(10,myStack.peek());
		assertEquals(10,myStack.getMaxElement());
		assertEquals(10,myStack.pop());
		assertTrue(myStack.isEmpty());
		
		myStack.push(10);
		myStack.push(15);
		myStack.push(12);
		myStack.push(14);
		assertEquals(15,myStack.getMaxElement());
		assertEquals(14,myStack.pop());
		assertEquals(15,myStack.getMaxElement());
		assertEquals(12,myStack.pop());
		assertEquals(15,myStack.getMaxElement());
		assertEquals(15,myStack.pop());
		assertEquals(10,myStack.getMaxElement());	
		
		myStack.push(100);
		myStack.push(100);
		myStack.pop();
		assertEquals(100,myStack.getMaxElement());	

	
	}

}
