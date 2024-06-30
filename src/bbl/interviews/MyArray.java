package bbl.interviews;

import java.util.HashMap;

//all methods must have complexity O[1]
public class MyArray<T>
{
// Data Structure
	private HashMap<Integer,T> myArray;
	private T valueForAll;
	private int size;
	
	@SuppressWarnings("unchecked")
	public void setAll(T value)
	{
		//all array's elements should be set with a given value
		this.myArray =  new HashMap<Integer,T>();
		valueForAll=value;
	}
	public void set(int index, T value)
	{
		//set new value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		if(index<0 || index>=size)
		{
	       throw new ArrayIndexOutOfBoundsException();
	    }
		myArray.put(index, value);
		 
	}
	public T get(int index)
	{
		//returns a value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		if(index<0 || index>=size)
		{
	       throw new ArrayIndexOutOfBoundsException();
	    }
		return myArray.getOrDefault(index, valueForAll);
	}
	
	@SuppressWarnings("unchecked")
	public MyArray(int size)
	{
		//creates the Array object for a given size
		//with setting null's at each element
		this.myArray =  new HashMap<Integer,T>();
		this.valueForAll=null;
		this.size=size;

	}
}