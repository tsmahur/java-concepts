package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


interface Display {
//	void printing();
	void printing(int n);
	
}

@FunctionalInterface
interface Operation {
double calculation(double num1,double num2);
default void show() {
	 System.out.println("inside Operation show()");
}
}

@FunctionalInterface
interface Calculator{
	int calculate(int a,int b);

}

class Adder implements Calculator{

	@Override
	public int calculate(int a,int b) {
		return a+b;
	}
}
public class Lambda {

    public static void main(String[] args) {

		//------------- before lambda -------
		Calculator c=new Adder();
		c.calculate(1,2);

		//anonymous class
		Calculator subb=new Calculator() {
			@Override
			public int calculate(int a, int b) {
				return a-b;
			}
		};

		subb.calculate(2,1);

		//----------- after lambda ------------
		Calculator multiplier = (x,y) -> x+y; //argument -> body
		multiplier.calculate(2,4);

		//multiline lambda expression
		Calculator multiplier2 = (x,y) -> {
			x=2 * x;

			return x+y;
		};

		// Consumer
		List<String> a=new ArrayList<>();
		a.forEach(x-> {
			x = 2 + x;
			System.out.println(x);

		});

//        a.stream().filter()


    //LAMBDA  EXPRESSION
    		//--------------------
    		
    		//implementation of interface using lambda expression
    		/* -------Similar to below definition-------- 
    		 * double calculation(double num1,double num2){
    		 * 	return num1+ num2;
    		 * }
    		 */
    		Operation adder=(num1,num2) -> num1+num2; //LAMBDA AS OBJECT (adder)
    		//invoking interface method using lambda exp identifier(interface)
    		System.out.println("adder"+adder.calculation(10, 5));
			adder.show();
    		//--------------------------------------------------------
    		
    		Operation adder2=(num1,num2) -> {System.out.println("num1="+num1+" num2="+num2);
    										return num1+num2; };
    		System.out.println("adder2="+adder2.calculation(10, 20));
    		//-------------------------------------------------------
    		
    		Operation sub=(num1,num2) -> num1-num2;
    		System.out.println("sub="+sub.calculation(10, 5));
    		//-------------------------------------------------------
    		
    		Operation sub2=(num1,num2) -> {
    			if(num1>num2) return num1-num2;
    			else return num2-num1;	};
    		System.out.println("sub2="+sub2.calculation(5, 10));
    		//-------------------------------------------------------
    		
//    		Display dispIdentifier=()-> System.out.println("hello");
//    		dispIdentifier.printing();
    		//-------------------------------------------------------
    		
    		Display dispIdentifier2=(n)-> System.out.println("hello"+n);
    		dispIdentifier2.printing(9);
    		//-------------------------------------------------------
    		
    		//BUILT-IN FUNCTIONAL INTERFACE
    		//-----------------------------
    		Function<Long, Long> addNum = (value) -> value + 10;
    		Predicate<Integer> checkAge = (age) -> age > 18;
    		Supplier<Integer> generateRandom = ()-> (int) (Math.random() * 100);
    		Consumer<String> printValue = (name)-> System.out.println(name);
    		BiPredicate<Integer,String> checkExpRole = (exp,role) -> exp>4 && role.equals("Manager");
    		
    		System.out.println("addNum="+addNum.apply(13L));
    		System.out.println("checkAge="+checkAge.test(10));
    		System.out.println("generateRandom="+generateRandom.get());
    		printValue.accept("hello"); // print hello
    		System.out.println(checkExpRole.test(5, "Manager"));
    		System.out.println(checkExpRole.test(5, "Clerk"));

    		//METHOD REFERENCES
    		//----------------
    		System.out.println("------------");
    		List<String> strArr=List.of("qw","qww","ds");
    		strArr.forEach(s-> System.out.println(s)); //lambda exp in forEach()
    		System.out.println("------------");
    		strArr.forEach(System.out::println); //method references 
    		//better in performance, but do not take argument
    		
    }
}
