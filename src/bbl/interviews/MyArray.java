package bbl.interviews;

//all methods must have complexity O[1]
public class MyArray<T>
{
// Data Structure
	private T[] myArray;
	private boolean allMark;
	private T valueForAll;
	private int size;
	
	@SuppressWarnings("unchecked")
	public void setAll(T value)
	{
		//all array's elements should be set with a given value
		this.myArray =  (T[])new Object[size];
		allMark=true;
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
		if(allMark && value==valueForAll)
		{
	       myArray[index]=null; 
	    }
		else myArray[index]=value;
		 
	}
	public T get(int index)
	{
		//returns a value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		if(index<0 || index>=size)
		{
	       throw new ArrayIndexOutOfBoundsException();
	    }
		T res=valueForAll;
		if(myArray[index]!=null || !allMark) res=myArray[index];
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public MyArray(int size) {
		//creates the Array object for a given size
		//with setting null's at each element
		this.myArray =  (T[])new Object[size];
		this.allMark=false;
		this.valueForAll=null;
		this.size=size;

	}
}