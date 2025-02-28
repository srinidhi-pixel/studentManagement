package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;// instance variable are intialized in the constructor only. list is interface.
	//we will not create obj of the interface we create ref of the interface list implemenets arraylist . only child classes object is created 
	// arraylist is the child class  of list. create an object of arraylist 
	//list contains duplicate values
	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age)&& validateName(name) &&studentId(studentId)) { // this becomes true then only intialize otherwisedefaultvalue we are passing age in main class object 122.
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		courses=new ArrayList<String>();// intalized courses
	}
	}
	
	private boolean studentId(String studentId) {
		String studentIdRegex="S-[0-9]+$";//s-123
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdatcher = studentIdPattern.matcher(studentId);
		if (studentIdatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Invalid studentId .. use format s-123");
			return false;
		}
		
	}

	public void enrollCourse(String course) {
			//courses is Arraylist ref which has a method contains to check certain part object is part of the Arraylist
			// we are passing java which is string which is a class and non primitive data type. parent of string is super which is object class
		    //arraylist is non idempotent in nature
		    //list contains duplicate values. if u dont want duplicate values in list first check if the value if first
		    //present in the list then only add
		    if (validateCourseName(course)) { //true will go inside if
			if (!courses.contains(course)) { //bcz java is not added for first time it will return false .! will be true 
			courses.add(course);
			System.out.println("Student is enrolled to "+course+"  suceessfully!!");
		}else {
	System.err.println("Student has already enrolled into the course "+course);
	}
	}
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void printStudentInfo() {
		System.out.println("============Student Data============");
		System.out.println("Student Name: "+name);
		System.out.println("Student Age: "+age);
		System.out.println("Student Id: "+studentId);
		System.out.println("Enrolled for : "+courses);
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	
	//Validation Methods
	public boolean validateAge(int age) {
		if (age>=19 && age<=35 ) {
			return true;
		}else {
			System.err.println("Invalid age!! Student Age needs to be between 19 and 35");
			return false;
		}
	}
	
	
	
	public boolean validateName(String name) {
		//adi is lower case ^ indicates the name should start with some alphabet it can be from 1-2 []indicates start
		//Adi ADI adi malkkod //s allowed white spaces.
		//ending will be in dollor sign
		//firstname space Anand space Malkood + is used for joing 
		String nameRegx = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegx);
		 Matcher nameMatcher = namePattern.matcher(name);
		 if (nameMatcher.matches()) {
			return true;
		}
		 else {
			 System.err.println("Invalid Name !! please enter alphabets only");
			 return false;
		 }
	}
	
	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("java")||course.equalsIgnoreCase("DSA")||course.equalsIgnoreCase("Devops")) {
			return true;
		}
		else {
			System.err.println("Invalid  Course Name !! please select Courses from the list!![java,DSA,Devops]");
			 return false;
		}
		
	}
	
}
