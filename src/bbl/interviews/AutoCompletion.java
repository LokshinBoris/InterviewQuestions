package bbl.interviews;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AutoCompletion
{

	private TreeSet<String> myTree;
	
	public AutoCompletion()
	{
		Comparator<String> comp=(String s1, String s2)->(s1.toLowerCase().compareTo(s2.toLowerCase()));
		myTree=new TreeSet<String>(comp);
	
	}
	
	public boolean addWord(String word)
	{
	
		//adds new word into auto-completion variants
		// return true if added, false otherwise (if a given a word already exists)
		return myTree.add(word);
	}
	public String [] getVariants(String prefix)
	{
	
	// return all words beginning with a given prefix
	// Complexity of funding variants is O(logN)
		char endSymb=prefix.toLowerCase().charAt(prefix.length()-1);
		endSymb++;
		String endPrefix=prefix.substring(0, prefix.length()-1)+Character.toString(endSymb);
		Set<String> set=myTree.subSet(prefix.toLowerCase(), true, endPrefix.toLowerCase(), false);
		
		return set.stream().toArray(String[]::new);	
	}
}
