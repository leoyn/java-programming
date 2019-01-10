package chapter12.Task6;

public class Exam {
    public String name;
    public byte grade;
    public Exam next;

    public Exam(String name, int grade) {
        this.name = name;
        this.grade = (byte) grade;
    }
}