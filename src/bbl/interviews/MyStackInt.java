package bbl.interviews;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStackInt {
	
	private LinkedList<Integer> myStack;
	private LinkedList<Integer> maximums;
	private int currentMax;
	
		public MyStackInt()
		{
			myStack=new LinkedList<Integer>();
			maximums= new LinkedList<Integer>();
			currentMax=Integer.MIN_VALUE;
		}
		
		public void push(int num)
		{
			//adds num into top of stack (last element)
			myStack.push(num);
			if(currentMax<=num) 
			{	
				maximums.push(num);
				currentMax=num;
			}
		}
		
		public int pop() 
		{	
			//removes element from top of stack (last element)
			//returns being removed number
			//throws exception if the stack is empty
			testStack();
			int res=myStack.pop();
			if(res==currentMax)
			{
				maximums.pop();
				if(maximums.isEmpty()) currentMax=Integer.MIN_VALUE;
				else currentMax=maximums.peek();
			}
			return res;
		}
		

		public int peek()
		{
			//returns last number
			//throws exception if the stack is empty
			testStack();
			return myStack.peek();
		}

		public boolean isEmpty() 
		{
			//returns true if the stack is empty, otherwise false
			return myStack.isEmpty();
		}
		
		public int getMaxElement()
		{
			//returns the max number from the stack
			//throws exception if the stack is empty
			testStack();
			return maximums.peek();
		}
		
		private void testStack() 
		{
			if(myStack.isEmpty())
			{
				throw new NoSuchElementException("This MyStack is empty");
			}		
		}
			
		
	}