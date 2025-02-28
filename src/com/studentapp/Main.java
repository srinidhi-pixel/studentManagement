package com.studentapp;

public class Main {
 //string args is the runtime argument
	public static void main(String[] args) {
		System.out.println("**********Student Mangement system*********");
        //s1 is a ref unique idetification hashcode of the object create in heap memeory.how to get that hachcode 
		// we implement hashcode using tostring method to get oneline description of the state of instance variable
		// when u create an  object student class is going to load into the memory
		//object is created in heap memeory. 4 instance variable is created name age courses, id
		//constructor will be intialized or called
		// for most of the instance variable we have to do validation 
		Student s1 = new Student("adi", 22, "S-1"); // s-1
		//  s1.printStudentInfo();
		// System.out.println(s1); //bcz of to string in student class it will print in oneline
		 s1.enrollCourse("java");
		 s1.enrollCourse("DSA");
		 s1.enrollCourse("Devops");
		 s1.enrollCourse("C#");
		// System.out.println(s1);
		 s1.printStudentInfo();
		 
		 Student s2= new Student("shri",24, "S-2"); 
		 s2.enrollCourse("java");
		// System.out.println(s2);
		 s2.printStudentInfo();
		 
		 Student s3= new Student("bhav",27, "S-21"); 
		 s3.enrollCourse("java");
		// System.out.println(s3);
		 s3.printStudentInfo();
	}
     
}
