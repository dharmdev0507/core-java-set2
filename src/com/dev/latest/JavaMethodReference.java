package com.dev.latest;

import java.util.function.Function;
import java.util.function.Supplier;

public class JavaMethodReference {

	public static void main(String[] args) {
	
		//1.Method reference to static method : ClassName::MethodName
		Function<String, Integer> withStaticLamda = (String s) -> Integer.parseInt(s);
		System.out.println("Method reference to static method With Lamda : "+withStaticLamda.apply("12"));
		
		Function<String, Integer> withStaticMethodReference = Integer::parseInt;
		System.out.println("Method reference to static method : "+withStaticMethodReference.apply("22"));
		
		//2.Method reference to instance method of an existing object : ReferenceVariable::MethodName
		Company c = new Company("My_Company"); 
        Supplier<String> lambdaSupplier = () -> c.getName();
        System.out.println(lambdaSupplier.get());
         
        //Calling getName() of c using method reference
         
        Supplier<String> referenceSupplier = c::getName;
        System.out.println(referenceSupplier.get());
		
		//3.Method reference to instance method of an non-existing object : ClassName::MethodName
		Function<String, String> lambdaFunction = (String s) -> s.toLowerCase();
        System.out.println(lambdaFunction.apply("JAVA"));
              
        Function<String, String> referenceFunction = String::toLowerCase;
        System.out.println(referenceFunction.apply("JAVA"));
		
		//4.Constructor References : ClassName::new
        Supplier<Company> lambdaConstructorSupplier = () -> new Company();
        lambdaConstructorSupplier.get();
         
        Supplier<Company> referenceConstructorSupplier = Company::new;
        referenceConstructorSupplier.get();
	}

}

class Company{
	
    public Company() {
        System.out.println("Default Constructor called");
	}

	String name;
     
    public Company(String name) 
    {
        this.name = name;
    }
     
    public String getName()
    {
        return name;
    }
}