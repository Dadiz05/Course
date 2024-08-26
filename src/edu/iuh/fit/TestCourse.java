package edu.iuh.fit;

import java.util.Scanner;

/**
 * @description Lớp kiểm thử cho việc quản lý các Khóa học trong trường học.
 * Thực hiện các chức năng như thêm, xóa, tìm kiếm, và sắp xếp các Khóa học thông qua menu.
 * @author: Vi, Nguyen Gia
 * @version: 1.0
 * @created: $DATE
 */

public class TestCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        while (true) {
            System.out.println("\n--- Course Management Menu ---");
            System.out.println("1. Add a Course");
            System.out.println("2. Remove a Course");
            System.out.println("3. Search Course by ID");
            System.out.println("4. Search Courses by Title");
            System.out.println("5. Search Courses by Department");
            System.out.println("6. Sort Courses by Title");
            System.out.println("7. Find Courses with Maximum Credits");
            System.out.println("8. Find Department with Most Courses");
            System.out.println("9. Display All Courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Course Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Course Credit: ");
                    int credit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully.");
                    } else {
                        System.out.println("Error adding course.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Course ID to Remove: ");
                    id = scanner.nextLine();
                    if (courseList.removeCourse(id)) {
                        System.out.println("Course removed successfully.");
                    } else {
                        System.out.println("Error: Course not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Course ID to Search: ");
                    id = scanner.nextLine();
                    Course foundCourse = courseList.searchById(id);
                    if (foundCourse != null) {
                        System.out.println("Course found:\n" + foundCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Course Title to Search: ");
                    title = scanner.nextLine();
                    Course[] foundCoursesByTitle = courseList.searchByTitle(title);
                    if (foundCoursesByTitle.length > 0) {
                        System.out.println("Courses found:");
                        for (Course c : foundCoursesByTitle) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses found with that title.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Department to Search: ");
                    department = scanner.nextLine();
                    Course[] foundCoursesByDept = courseList.searchByDepartment(department);
                    if (foundCoursesByDept.length > 0) {
                        System.out.println("Courses found:");
                        for (Course c : foundCoursesByDept) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses found in that department.");
                    }
                    break;

                case 6:
                    Course[] sortedCourses = courseList.sortByTitle();
                    System.out.println("Courses sorted by title:");
                    for (Course c : sortedCourses) {
                        System.out.println(c);
                    }
                    break;

                case 7:
                    Course[] maxCreditCourses = courseList.findMaxCreditCourses();
                    System.out.println("Courses with maximum credits:");
                    for (Course c : maxCreditCourses) {
                        System.out.println(c);
                    }
                    break;

                case 8:
                    String topDepartment = courseList.findDepartmentWithMostCourses();
                    System.out.println("Department with most courses: " + topDepartment);
                    break;

                case 9:
                    Course[] allCourses = courseList.getCourses();
                    if (allCourses.length > 0) {
                        System.out.println("All Courses:");
                        for (Course c : allCourses) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses available.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
