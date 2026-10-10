package com.dev.string;

class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog barks");
    }
}

public class TestMain {

	public static void main(String[] args) {
		Dog d = new Dog();//if child object refers Parent so in this scenario so parent class have same method like child to override  
		d.eat();
		d.bark();
	}

}
