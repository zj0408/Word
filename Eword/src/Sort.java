import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Set;


public class Sort { 
	Map<String,Integer> Map = new LinkedHashMap<String, Integer>(); 
	Map sort(Map<String, Integer> map,int a) {  
	       Set<Entry<String,Integer>> m= map.entrySet();   
	       LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(m);
	       if(a==2) {
	       Collections.sort(List, new Comparator<Entry<String,Integer>>() {     
	           public int compare(Entry<String, Integer> a,  Entry<String, Integer> b) {  
	               return b.getValue().compareTo(a.getValue());  
	          }     
	       });  
	       }
	       else if(a==3) {
	    	   Collections.sort(List, new Comparator<Entry<String,Integer>>() {     
	               public int compare(Entry<String, Integer> a,  Entry<String, Integer> b) {  
	                   return a.getKey().compareTo(b.getKey());  
	              }     
	           });  
	       }
	       for(Entry<String,Integer> entry: List) {  
	           Map.put(entry.getKey(), entry.getValue());  
	       }
		return Map;  
	   } 
}