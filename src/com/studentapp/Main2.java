package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
 //string args is the runtime argument
	private static List<Student> studentList; // static variables are access inside static methods
	public static void main(String[] args) {
		System.out.println("**********Student Mangement system*********");
        studentList = new ArrayList<Student>();
    		  
		Student s1 = new Student("adi", 22, "S-1"); // s-1
	
		 s1.enrollCourse("java");
		 s1.enrollCourse("DSA");
		 s1.enrollCourse("Devops");
		 s1.enrollCourse("C#");
		
		 
		 Student s2= new Student("shri",24, "S-2"); 
		 s2.enrollCourse("java");
		
		 
		 Student s3= new Student("bhav",27, "S-21"); 
		 s3.enrollCourse("java");
		 
		 studentList.add(s1);
		 studentList.add(s2);
		 studentList.add(s3);
		 
		 Student result = findStudentById("S-210");
		 System.out.println("Result "+result);
		 
		 sortByName();
	}
     
	
	
	private static void sortByName() {
		Comparator<Student> studentNameComparator= (o1,o2)->o1.getName().compareTo(o2.getName());

//			@Override
//			public int compare(Student o1, Student o2) {
//				// TODO Auto-generated method stub
//				return o1.getName().compareTo(o2.getName());
//			}
//			
//		};
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
	}


	public static Student findStudentById(String studentId) {
		//local variable should be explicilty intialized
		//student is non primitve datatype which gets the default value null
		Student result = null;
		try {
		result= studentList.stream().filter(x ->x.getStudentId().equalsIgnoreCase(studentId))
		.findFirst()
		.orElseThrow(()-> new RuntimeException("No Data Found"));
		}catch(RuntimeException e) {
			System.err.println("Studenyt with Id "+studentId+" not found");
	}
		return result;
}
}
