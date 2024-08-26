package edu.iuh.fit;

/**
 * @description Lớp mô tả các Khóa học trong trường học, bao gồm các thuộc tính:
 * Mã khóa học, Tên khóa học, Số tín chỉ và Khoa phụ trách.
 * @author: Vi, Nguyen Gia
 * @version: 1.0
 * @created: $DATE
 */

public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;

        if (id == null || id.trim().length() < 3) {
            throw new IllegalArgumentException("ID must have at least 3 characters.");
        }
        for (char ch : id.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                throw new IllegalArgumentException("ID must contain only letters or digits.");
            }
        }

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty.");
        }

        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0.");
        }

    }

    public Course() {
        this("", "", 0, "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().length() < 3) {
            throw new IllegalArgumentException("ID must have at least 3 characters.");
        }
        for (char ch : id.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                throw new IllegalArgumentException("ID must contain only letters or digits.");
            }
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty.");
        }
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0.");
        }
        this.credit = credit;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-25s%5d  %15s", id, title, credit, department);
    }
}
