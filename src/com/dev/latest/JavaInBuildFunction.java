package com.dev.latest;

import java.util.function.*;

public class JavaInBuildFunction {

	public static void main(String[] args) {
		
		//1.Predicate  --> boolean test(T t)
		Predicate<Integer> checkAge = age->age>=18;
		System.out.println("Have right to vote : "+checkAge.test(18));
		
		//2.Consumer   --> void accept(T t1)
		Consumer<String> consumer = name->System.out.println(name);
		consumer.accept("Rajesh");
		
		//3.Function   --> R apply(T t)
		Function<String, String> transformation = name-> name.toUpperCase();
		System.out.println("Fuction : "+transformation.apply("Mumbai"));
		
		Function<String, Integer> translength = name-> name.length();
		System.out.println("Fuction length: "+translength.apply("Mumbai"));
		
		//4.Supplier   --> R get()
		Supplier<Double> data = ()->Math.random();
		System.out.println("Supplier : "+data.get());
		
		//5. Bi-Predicate   --> boolean test(T t1,T t2)
		BiPredicate<String, String> checkEquality = (a,b)->a.equals(b);
		System.out.println("Bi_Predicate : "+checkEquality.test("Java", "Java"));
		
		//6.Bi-Consumer   --> void accept(T t1,T t2)
		BiConsumer<String, String> biConsume = (firstName,lastName)-> System.out.println(firstName+" "+lastName);
		biConsume.accept("Dharmdev", "Yadav");
		
		//7. Bi-Function   --> R apply(T t1,T t2)
		BiFunction<Integer, Double, Double> biFunction = (a,b)-> a+b;
		System.out.println("BiFunction : "+biFunction.apply(10, 20.0));
		
		//8. UnaryOperator --> T apply(T t) ==like function where both i/p and o/p are same 
		UnaryOperator<Integer> unaryOperator = (n)->n*n;
		System.out.println("UnaryOperator : "+unaryOperator.apply(4));
		
		//6.BinaryOperator --> T apply(T t1,T t2) ==Like Bifunction where both i/p and o/p are same
		BinaryOperator<Integer> binaryOperator = (a,b)->a>b?a:b;
		System.out.println("BinaryOperator : "+binaryOperator.apply(22, 20));
		
	}

}
