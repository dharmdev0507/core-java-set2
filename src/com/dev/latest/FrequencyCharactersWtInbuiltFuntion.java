package com.dev.latest;

//Frequency Count of Characters without using Collection
public class FrequencyCharactersWtInbuiltFuntion {

	public static void main(String[] args) {

		String s = "programming";
		
		int[] freq = new int[256];
		
		for(Character ch : s.toCharArray()) {
			
			if(!Character.isWhitespace(ch)) {
				freq[ch]++;
			}
		}
		
		
		for(int i=0;i<256;i++) {
			if(freq[i]>0) {
				System.out.println((char)i+" : "+freq[i]);
			}
		}

	}

}
