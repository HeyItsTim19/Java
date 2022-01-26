/*
 * Lab2.java
 *
 * A class of static methods that operate on Students
 *
 */
public class Lab2 {
    
	/*
	 * Purpose: determines which student has the higher grade
	 * Parameters: Student - s1, Student - s2
	 * Returns: Student - the Student with the higher grade,
	 *                    s1 if they have the same grade
	 * Precondition: s1 and s2 are not null
	 */
	public static Student getHigherGradeStudent(Student s1, Student s2) {
		
	if(s2.getGrade()>s1.getGrade()){
	return s2;
	}
		return s1; 
	}


	/*
	 * Purpose: determines whether the grade of Student s
	 *          is above the threshold
	 * Parameters: Student - s, int - threshold
	 * Returns: boolean - true if grade is above threshold, false otherwise
	 * Preconditions: s is not null
	 */
	// TODO: implement isGradeAbove
	public static boolean isGradeAbove(Student s, int threshold){
		if(s.getGrade()>threshold){
			return true;
		}
		return false;
	}


	/*
	 * Purpose: creates an array sIDs of all Students in students
	 * Parameters: Student[] - students
	 * Returns: String[] - array of sIDs
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClasslist
	public static String[] getClasslist (Student[] students){
	int k = students.length;
	String[] Stud_Ids = new String[k];
	for(int i = 0; i<students.length; i++){
		Stud_Ids[i] = students[i].getSID();

	}
	return Stud_Ids;	
	}

	/*
	 * Purpose: counts the number of Students in students
	 *          with grade above threshold
	 * Parameters: Student[] - students, int - threshold
	 * Returns: int - the number of students with a grade above threshold
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement countAbove
	// HINT: you should be using the isGradeAbove method!
	public static int countAbove(Student[] students, int threshold){
		int count = 0;
	for(int i =0; i<students.length; i++){
		if(students[i].getGrade()>threshold){
			count++;
		}
	}
		return count; // so it compiles
	}

	/*
	 * Purpose: calculates the average grade of Students in students,
	 *          does NOT include students with -1 grade in calculation
	 *          average is 0.0 if students is empty or all students have -1 grade
	 * Parameters: Student[] - students
	 * Returns: double - the average grade
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClassAverage
	// HINT: you can use the isGradeAbove method again
	public static double getClassAverage(Student[] students){
		double sum = 0; 
		int count = 0;
		for(int i=0; i<students.length; i++){
			if(students[i].getGrade()>0){
			count++;
			sum = sum+students[i].getGrade();}
		}
		if(count!=0){
		return (sum/count);
		}else{
			return 0;
		}


	}

	/*
	 * Purpose: creates a new array 1 longer than students
	 *          and adds all students and s to the new array
	 * Parameters: Student[] - students, Student s
	 * Returns: Student[] - the new array
	 * Preconditions: students is not null and contains no null elements
	 *                Student s is not already contained within students
	 */
	// TODO: implement registerStudent
	public static Student[] registerStudents(Student[] students, Student s){
		int k = students.length;
		Student[] NewArr = new Student[k+1];

		int i =0;
		while(i<students.length){
			NewArr[i] = students[i];
			i++;}
		NewArr[i]=s;

		return NewArr;

		

	}
}
