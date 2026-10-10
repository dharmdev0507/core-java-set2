package com.dev.latest;

public class Permutation {

	public static void main(String[] args) {
        String input1="ABC";
        stringPermutations("",input1);
	}
	
    private static void stringPermutations(String permutation, String input1) {
    	
        if (input1.length()==0){
            System.out.println("pemutation : "+permutation);
        }else {
            for (int i=0;i<input1.length();i++){
                stringPermutations(permutation+input1.charAt(i),input1.substring(0,i)+input1.substring(i+1,input1.length()));
            }
        }
    }

}
