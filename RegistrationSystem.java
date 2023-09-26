import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return code + ": " + title + " - " + schedule + " (" + capacity + " slots)";
    }
}

class Student {
    String id;
    String name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}

public class RegistrationSystem extends JFrame {
    private JComboBox<Student> studentComboBox;
    private JComboBox<Course> courseComboBox;
    private JButton registerButton;
    private JButton removeButton;

    private List<Student> students;
    private List<Course> courses;

    public RegistrationSystem() {
        setTitle("Student Course Registration System");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        students = new ArrayList<>();
        courses = new ArrayList<>();

        // Add some example data
        students.add(new Student("1001", "ANSHUL KUSHWAHA"));
        students.add(new Student("1002", "RAJ"));

        courses.add(
                new Course("CSE101", "Introduction to Programming", "Basic programming concepts", 30, "Mon/Wed 9-10"));
        courses.add(new Course("MATH201", "Calculus I", "Limits, derivatives, and integrals", 40, "Tue/Thu 11-12"));

        studentComboBox = new JComboBox<>(students.toArray(new Student[0]));
        courseComboBox = new JComboBox<>(courses.toArray(new Course[0]));
        registerButton = new JButton("Register");
        removeButton = new JButton("Remove");

        add(new JLabel("Select Student: "));
        add(studentComboBox);
        add(new JLabel("Select Course: "));
        add(courseComboBox);
        add(registerButton);
        add(removeButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerCourse();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeCourse();
            }
        });
    }

    private void registerCourse() {
        Student student = (Student) studentComboBox.getSelectedItem();
        Course course = (Course) courseComboBox.getSelectedItem();

        if (student != null && course != null) {
            if (course.capacity > student.registeredCourses.size()) {
                student.registeredCourses.add(course);
                JOptionPane.showMessageDialog(this, "Course registered successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Course is full!");
            }
        }
    }

    private void removeCourse() {
        Student student = (Student) studentComboBox.getSelectedItem();
        Course course = (Course) courseComboBox.getSelectedItem();

        if (student != null && course != null) {
            student.registeredCourses.remove(course);
            JOptionPane.showMessageDialog(this, "Course removed successfully!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistrationSystem().setVisible(true);
            }
        });
    }
}