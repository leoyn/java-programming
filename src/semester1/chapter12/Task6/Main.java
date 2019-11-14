package semester1.chapter12.Task6;

public class Main {
    public static void main(String[] args) {
        University uni = new University();
    
        Student student1 = new Student("Max", "Musterman");
        Student student2 = new Student("Lulu", "Musterman");
        Student student3 = new Student("Mina", "Musterfrau");

        uni.addStudent(student1).addStudent(student2).addStudent(student3);

        student1.addExam(new Exam("Programming", 1)).addExam(new Exam("Product Design", 2));
        student2.addExam(new Exam("Machine Learning", 2));
        student3.addExam(new Exam("Engineering", 1)).addExam(new Exam("IoT Technology", 2));


        Student currentStudent = uni.head;
        
        while(currentStudent != null) {
            System.out.println(currentStudent.firstname + ", " + currentStudent.lastname);

            Exam currentExam = currentStudent.head;

            while(currentExam != null) {
                System.out.println("   " + currentExam.name + ": " + currentExam.grade);

                currentExam = currentExam.next;
            }

            currentStudent = currentStudent.next;
        }

    }
}