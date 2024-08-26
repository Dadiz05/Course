package edu.iuh.fit;

import java.util.Arrays;

/**
 * @description Lớp mô tả danh sách các Khóa học trong trường học, bao gồm các
 * phương thức thêm, xóa, tìm kiếm, và sắp xếp các Khóa học.
 * @author: Vi, Nguyen Gia
 * @version: 1.0
 * @created: $DATE
 */

public class CourseList {
    private Course[] courses;
    private int count;

    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0.");
        courses = new Course[n];
    }

    public boolean addCourse(Course course) {
        if (course == null || exists(course) || count == courses.length) {
            System.out.println("Error: Cannot add course. Either the course exists or the list is full.");
            return false;
        }
        courses[count++] = course;
        return true;
    }

    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(course.getId())) {
                return true;
            }
        }
        return false;
    }

    public Course[] getCourses() {
        Course[] temp = new Course[count];
        System.arraycopy(courses, 0, temp, 0, count);
        return temp;
    }

    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null;
                return true;
            }
        }
        System.out.println("Error: Course with ID " + id + " not found.");
        return false;
    }

    public Course searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                return courses[i];
            }
        }
        return null;
    }

    public Course[] searchByTitle(String title) {
        Course[] results = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                results[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(results, resultCount);
    }

    public Course[] searchByDepartment(String department) {
        Course[] results = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                results[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(results, resultCount);
    }

    public Course[] sortByTitle() {
        Course[] sortedCourses = Arrays.copyOf(courses, count);
        Arrays.sort(sortedCourses, (c1, c2) -> c1.getTitle().compareToIgnoreCase(c2.getTitle()));
        return sortedCourses;
    }

    public Course[] findMaxCreditCourses() {
        if (count == 0) return new Course[0];
        int maxCredit = courses[0].getCredit();
        for (int i = 1; i < count; i++) {
            if (courses[i].getCredit() > maxCredit) {
                maxCredit = courses[i].getCredit();
            }
        }
        Course[] maxCourses = new Course[count];
        int maxCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                maxCourses[maxCount++] = courses[i];
            }
        }
        return Arrays.copyOf(maxCourses, maxCount);
    }

    public String findDepartmentWithMostCourses() {
        if (count == 0) return null;
        String[] departments = new String[count];
        int[] departmentCount = new int[count];
        int deptCount = 0;

        for (int i = 0; i < count; i++) {
            String dept = courses[i].getDepartment();
            boolean found = false;
            for (int j = 0; j < deptCount; j++) {
                if (departments[j].equalsIgnoreCase(dept)) {
                    departmentCount[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                departments[deptCount] = dept;
                departmentCount[deptCount++] = 1;
            }
        }

        int maxCount = departmentCount[0];
        String topDepartment = departments[0];
        for (int i = 1; i < deptCount; i++) {
            if (departmentCount[i] > maxCount) {
                maxCount = departmentCount[i];
                topDepartment = departments[i];
            }
        }
        return topDepartment;
    }
}
