package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streams {

    public static void main(String[] args) {
    	//stream,sequence of data from source
    	//sequentially and parallel also making thread
    	
    	//stream w.r.t HOF- function which take others as parameter or return them as value
    	
    	List<String> strArr= new ArrayList<>();
    	strArr.add("as");
    	strArr.add("tu");
    	strArr.add("rt");
    	strArr.add("df");
    	
    	//LAMBDA EXPRESSION 
    	strArr.sort((str1,str2)-> str1.compareTo(str2));
    	System.out.println(strArr);
    	
    	//STREAM
    	//-------
    	
    	//1. Stream from a Collection using stream() method
    	Stream<String> refer=strArr.stream(); //list.stream();
    	
    	//2. Stream from an Array using stream() method (creating stream on array)
    	Integer[] intArr= {12,34,35};
//    		Stream<Integer> intRefer=intArr.stream(); //not valid on array this way
    	Stream<Integer> intRefer=Arrays.stream(intArr); //for array use Array.stream(arr)
    	
    	//3. a. Stream directly using of() method (directly creating stream )
    	Stream<Integer> intRefer2=Stream.of(10,12,24); //Stream directly for Integers
    	
    	//3. b. stream for user define object (directly)
    	Stream<Employee> userRefer=Stream.of(new Employee("abc",123),new Employee("xcv",488),new Employee("xvd",456));
    	
    	//STREAM FUNCTIONS
    	//----------------
    	
    	//we can use one stream only once
    	//refer 1st stream, mapRefer 2nd stream  --- two step so two stream
    	//here 1st stream -- uppercase
    	//2nd stream --- lowercase

    	//Eg.1
//    	Stream<String> refer=strArr.stream(); //delcared above
    	Stream<String> mapRefer=refer.map(alpha->alpha.toUpperCase());//map one of the intermediate operation in stream
    	mapRefer.forEach(alpha->System.out.println(alpha)); // one of the terminal method in stream operation collect()
    	
    	/* map(),filter()- intermediate operation
    	 * map() will apply the provided lambda expression to the element of stream
    	 * filter() will fetch the elemnt acc. to the condn.
    	 * forEach(), collect() - terminate operation, if these are used then only intermediate operation be executed
    	 * */
    	
    	//Eg.2
    	//writing above exp. in one line below
    	Stream<String> refer2=strArr.stream();
    	refer2.map(alpha->alpha.toUpperCase()).forEach(alpha->System.out.println(alpha));//
//    	|-------INTERMEDIATE OPERATION--------|---------TERMINATE OPERATION-------------|
    	
    	//Eg.3
    	Stream<String> refer3=strArr.stream();
    	refer3.map(alpha->alpha.toUpperCase()).sorted().forEach(alpha->System.out.println(alpha));//
//    	|----INTERMEDIATE OPERATION 1 --------|---IO2--|---------TERMINATE OPERATION-------------|
    	
    	///Eg.4
    	List<Integer> number = Arrays.asList(2,3,4,5);
    	number.stream().map(x->2*x).forEach(y->System.out.println(y));
//    	|--INTERMEDIATE OPERATION--|-----TERMINATE OPERATION--------|
    	
    	//Eg.5
    	List<Integer>output= number.stream().map(x->2*x).collect(Collectors.toList()); //to collect
    	
    	//Eg.6
    	userRefer.filter(emp->emp.getName().length()==4).forEach(System.out::println);
    	
    	//Eg.7
    	Stream<Integer> intStream =Stream.of(10,2,7,5,6,5,8,11);  //direct stream creation
    	intStream.filter(n->{System.out.println("Filtering : "+n); return n%2==0;})  //intermediate operation filtering even no
    	.map(n->{System.out.println("Mapping :"+n); return n*n*n;}) //intermediate operation mapping i.e, cube
    	.sorted()
    	.forEach(n->System.out.println("after sorted cube :"+n));	//terminate operation forEach & printing
    	
    	//without creating stream identifier (above example)
    	Stream.of(10,2,7,5,6,5,8,11)
    	.filter(n->{System.out.println("Filtering : "+n); return n%2==0;})  //intermediate operation filtering even no
    	.map(n->{System.out.println("Mapping :"+n); return n*n*n;}) //intermediate operation mapping i.e, cube
    	.sorted()
//    	.forEach(n->System.out.println("after sorted cube :"+n));	//terminate operation forEach & printing
    	.forEach(System.out::println); //method referencing

		//flatMap

		//reduce

		//sort , comparator

		//peek

		//intstream
    	
    	
    	
    	}

}

class Employee {
	public String name;
	public int salary;

	public Employee( String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
