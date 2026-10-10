package com.dev.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Charcount {

	public static void main(String[] args) {
		 AtomicBoolean found = new AtomicBoolean(false);
		 String str = "programming";
		 
		 Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		 
		 for(char ch : str.toCharArray()) {
			 map.put(ch, map.getOrDefault(ch, 0)+1);
		 }
		 
		 map.forEach((k,v)->System.out.println(k+" : "+v));
		 System.out.println("#############################");
		 
		 map.forEach((key,value)->{
			 if(!found.get()&& value==1) {
            	 System.out.println(key+":"+value);
            	 found.set(true);
             } 
		 });
	}

}
