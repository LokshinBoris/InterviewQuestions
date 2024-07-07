package bbl.interviews;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class InterviewQuestions
{
public static void displayOccurrences(String [] strings) {
	HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
	TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
	displayOccurrences(treeMapOccurrences);
}

public static void displayOccurrencesStream(String[] strings) {
	Arrays.stream(strings)
	.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
	.entrySet().stream().sorted((e1, e2) -> {
		int res = Long.compare(e2.getValue(), e1.getValue());
		return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
	}).forEachOrdered(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
}

private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
	treeMapOccurrences.entrySet().forEach(e -> {
		e.getValue().forEach(str -> System.out.printf("%s => %d\n",str, e.getKey()));
	});
	
}

private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
	TreeMap<Integer, TreeSet<String>> result =
			new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
	mapOccurrences.entrySet()
	.forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>() ).add(e.getKey()));
	
	return result;
}

private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
	HashMap<String, Integer> result = new HashMap<>();
	for(String str: strings) {
		result.merge(str, 1, Integer::sum);
	}
	return result;
}
static public boolean isSum2(int [] array, int sum)
{
	//returns true if a given array contains two numbers, the summing of which
	//equals a given 'sum' value
	//complexity O[N] only one pass over the elements
	Map <Integer ,Integer> map =new HashMap<>(array.length);
	boolean res=false;
	int index=0;
	while(index<array.length && !res)
	{
		res=map.containsKey(sum-array[index]);
		map.put(array[index], index);
		index++;
	}
	return res;
}


static public int getMaxWithNegativePresentation(int [] array) 
{
	//returns maximal positive value for which exists negative one with the same abs value
	//if no pair of positive and negative values with the same abs value the method returns -1
	//complexity O[N] only one pass over the elements
	Map <Integer ,Integer> map =new HashMap<>(array.length);
	int maxValue=-1;
	int tmp;
	for(int i=0;i<array.length;i++)
	{
		if(map.containsKey(-array[i]))
		{
			tmp=Math.abs(array[i]);
			if(tmp>maxValue && tmp!=0) maxValue=tmp;
		}
		map.put(array[i], i);
	} 
	return maxValue;
}

public static Map<Integer, Integer> getMapSquares(List<Integer> numbers) {
	Map<Integer, Integer> res = numbers.stream()
			.collect(Collectors.toMap(n -> n, n -> n * n, (v1, v2) -> v1,
					LinkedHashMap::new));
	return res;
}
public static boolean isAnagram(String word, String anagram)
{
	
	//returns true if "anagram" string contains all
	// letters from "word" in another order (case sensitive)
	//O[N] (sorting is disallowed)
	boolean res=false;
	int wordLength=word.length();
	int anagramLength=anagram.length();
	if(wordLength>0 && anagramLength>0 && wordLength==anagramLength && word.compareTo(anagram)!=0)
	{
		
		Map <Character,Long> map=word.chars().mapToObj(c -> (char) c)
								 .collect(Collectors.groupingBy(c->c, Collectors.counting()));	
		boolean notLetter=true;
		int i=0;
		while(i<anagramLength && notLetter)
		{		
			Character chr=anagram.charAt(i);
			if(map.get(chr)!=null) map.compute(chr, (k,v)-> v>1? v-1: null);
			else notLetter=false;
			i++;
		}
		if(map.size()==0 && notLetter) res=true;
	}
	return res;
}

public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
		List<LocalDate> dates) 
{
	
	//create List<DateRole> with roles matching with the given dates
	//most effective data structure
	TreeMap<LocalDate,String> treeMap=new TreeMap<LocalDate,String>();
	rolesHistory.forEach(d -> treeMap.put(d.date(),d.role()));
	List<DateRole> res=dates.stream().
				   map(d -> { 
					   			Entry<LocalDate,String> entry=treeMap.floorEntry(d);
					   			DateRole dr = entry==null ? new DateRole(d,null) : new DateRole(d, entry.getValue());
					   			return dr;
					   		}
				      ).
				   toList(); 			
	return res;
}
public static void displayDigitsStatistics()
{
	
	//display out statistics in the following format (example)
	/* 1 -> <count of occurrences>
	 * 2 -> .....
	 * .........
	 */
	//sorted by counts of occurrences in the descending order
	//takes 1000000 random numbers in range [0-Integer.MAX_VALUE)
	//one pipeline with no additional yours methods
	
	Random rand = new Random();
	rand.ints(1000000,0,Integer.MAX_VALUE).boxed().map(n -> n.toString())
							.flatMapToInt(String::chars).mapToObj(c -> (char) c)
							.collect(Collectors.groupingBy(c->c, Collectors.counting()))							
							.entrySet().stream().sorted((e1, e2) -> {
								int res = Long.compare(e2.getValue(), e1.getValue());
								return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
							}).forEachOrdered(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
}

}


