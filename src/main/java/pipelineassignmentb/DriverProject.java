package pipelineassignmentb;

import pipelineassignmenta.Course;
import pipelineassignmenta.Lecturer;
import pipelineassignmenta.Student;
import pipelineassignmenta.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.joda.time.DateTime;

public class DriverProject {
    static Student student1;
    static Student student2;
    static Student student3;

    static Lecturer lecturer1;
    static Lecturer lecturer2;

    static Module programming;
    static Module biology;
    static Course compSci;
    static Course bioAndCompSci;

    public static void main(String[] args){
        student1 = new Student("John", new DateTime(1999,8,1,0,0,0));
        student2 = new Student("George", new DateTime(2000,3,1,0,0,0));
        student3 = new Student("Hannah", new DateTime(2001,12,1,0,0,0));

        lecturer1 = new Lecturer("Anthony", new DateTime(1969,4,1,0,0,0));
        lecturer2 = new Lecturer("Joe", new DateTime(1990,9,1,0,0,0));

        programming = new Module("Programming", "P1000", lecturer1);
        biology = new Module("Biology", "BIO2000", lecturer2);

        compSci = new Course("CS101",
                new ArrayList<Module>(List.of(programming)), new DateTime(2022,9,20,0,0,0), new DateTime(2025,5,20,0,0,0));

        bioAndCompSci = new Course("BCS202",
                new ArrayList<Module>(Arrays.asList(programming,biology)), new DateTime(2021,9,20,0,0,0), new DateTime(2024,5,20,0,0,0));

        //Adding courses to students
        student1.addCourse(bioAndCompSci);
        student2.addCourse(compSci);

        List<Course> courseList = new ArrayList<Course>();
        courseList.add(compSci);
        courseList.add(bioAndCompSci);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        /*System.out.println(student1.getUsername());
        System.out.println(student2.getID());
        System.out.println(student1.getModules());
        System.out.println(lecturer1.getID());
        System.out.println(programming.getStudentList());
        System.out.println(compSci.getEnrolledStudents());*/

        for(Course course:courseList){
            System.out.println("Course id "+course.getCourseID());
            System.out.println("Course Modules: ");
            course.getCourseModules().forEach(module -> System.out.println(module.getModuleName()));
        }

        for(Student student: studentList){
            System.out.println("Student name: " + student.getName() + "\nStudent ID: " + student.getID());
            student.getModules().forEach(module -> System.out.println("Modules: " + module.getModuleName()));
            student.getCourses().forEach(course -> System.out.println("Courses: " + course.getCourseID() + "\n"));
        }
    }
}
