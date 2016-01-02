/**
 * Student
 * @author: Jacob Silverman, js6135
 * tutoring at computer lab
 */

import java.util.ArrayList;
public class Student {
	private String name;
	private long studentID;
	private ArrayList<Course> courses;


	/**
	 * method to create Student object
	 * @param n name
	 * @param ID student ID
	 * @param c Course
	 */	
	public Student(String n, long ID, ArrayList<Course> c) {
		this.name = n;
		this.studentID = ID;
		this.courses = c;
	}
	
	/**
	 * method to add objects <code>Course c</code>
	 * to the ArrayList Courses
	 * @param c Course
	 */
	public void addCourse(Course c) {
		
		this.courses.add(c);
	}
	
	/**
	 * method to remove objects <code>Course c</code>
	 * to the ArrayList Courses
	 * @param c Course
	 */
	public void delCourse(Course c) {
		this.courses.remove(c);
	}
	
	/**
	 * method to calculate the GPA of the student
	 * based off the grades he/she has in each of
	 * his/her courses
	 * @return GPA
	 */
	public float getGPA() {
		int convertToGPA = 25;
		float total = (float) 0.0;
		int credits = 0;
		
		// iterating thought all the elements in the ArrayList
		for (Course c : courses) {
			
			// no need to get length of ArrayList
			total += (c.getGrade() * c.getCredits());
			credits += c.getCredits();
		}

		// finds average grade
		float averageGrade = (total/(credits));
		
		// then converts average grade to GPA scale
		return averageGrade/convertToGPA;
	}
	
	
	// Another method to get GPA that is less code
	/*
	public float getGP() {
		float total = (float) 0.0;
		// iterating thought all the elements in the ArrayList
		for (Course c : courses) {	
			// no need to get length of ArrayList
			total += c.getGrade();
		}
		return (total/ courses.size());
	}
	 */
	
	/**
	 * toString method
	 * 
	 * @return the values of name, studentIf, courses,
	 * and GPA of the student in a organized fashion.
	 */
	public String toString() {
		String reference = "Name of student is " + name + " with the student id of " + studentID
				+ "\nthe courses enrolled in by this student are (   ";
		
		// grabs the elements of the courses array
		for (Course c: courses) {
			reference += c.getName() + "   ";
			
		}
		reference += ")\nwith a " + getGPA() + " GPA";
		
		
		
		return reference;
	}
	
	
	/**
	 * Testing 
	 * Not apart of the assignment
	 * testing 
	 * @param argvs
	 */
	public static void main(String[] argvs) {
		Course cs = new Course("Intro to CS", 4, (float) 80.8);
		Course e = new Course("Intro to Econ", 4, (float) 96.6);
		ArrayList<Course> allCourses = new ArrayList<Course>();
		
		
		Student j = new Student("Jacob", 1290030, allCourses);
		
		j.addCourse(cs);
		j.addCourse(e);
		
		System.out.println(j);
		System.out.println(cs);
		System.out.println(e);

	}	
	
}
