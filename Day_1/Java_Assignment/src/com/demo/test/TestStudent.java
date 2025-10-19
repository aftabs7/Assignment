package com.demo.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.LowAttendenceExceptions;
import com.demo.model.Student;

public class TestStudent {

	public static void main(String[] args) {

		List<Student>students=new ArrayList<Student>();
		
		students.add(new Student(1,"Rohan","CSE",85,80));
		students.add(new Student(2,"Omkar","IT",90,87));
		students.add(new Student(3,"Rahul","Chemical",80,56));
		students.add(new Student(4, "Priya", "ECE", 75, 82));
        students.add(new Student(5, "Arjun", "CS", 40, 70));
        students.add(new Student(6, "Sneha", "IT", 63, 60));
        students.add(new Student(7, "Manish", "ME", 99, 85));
        students.add(new Student(8, "Riya", "ECE", 70, 78));
        students.add(new Student(9, "Dev", "CS", 55, 90));
        students.add(new Student(10, "Tina", "IT", 88, 92));
        
        for (Student s : students) {
            try {
                s.calculateGrade();
            } catch (LowAttendenceExceptions e) {
                System.out.println(e.getMessage());
            }
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
            System.out.println("\n✅ Students have been serialized to 'students.dat'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        List<Student> deserializedStudents = null;
        if (deserializedStudents != null) {
            deserializedStudents.sort((s1, s2) -> Double.compare(s2.getAttendance_percentage(), s1.getAttendance_percentage()));

            System.out.println("\n📊 Students sorted by decreasing attendance:");
            for (Student s : deserializedStudents) {
                System.out.println(s);
            }
        }
        
	}

}
