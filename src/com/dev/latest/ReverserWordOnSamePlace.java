package com.dev.latest;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverserWordOnSamePlace {

	public static void main(String[] args) {
		
		String s1 = "Today is Monday";
		String response = Stream.of(s1.split(" ")).map(word->new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
		
		System.out.println("Response :: "+response);
		
		String s2="welcome";
		String response2 = Arrays.stream(s2.split("")).map(word->new StringBuilder(word).toString()+new StringBuilder(word).toString()).collect(Collectors.joining(""));
        System.out.println("Response 2 ## : "+response2);
		
	}

}
