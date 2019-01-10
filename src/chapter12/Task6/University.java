package chapter12.Task6;

public class University {
    public Student head;

    public University addStudent(Student student) {
        if(head != null) {
            Student currentStudent = head;
            Student previousStudent = null;

            while(currentStudent != null && currentStudent.isBeforeStudent(student)) {
                previousStudent = currentStudent;
                currentStudent = currentStudent.next;
            }

            student.next = currentStudent;
            if(previousStudent != null) previousStudent.next = student;
            else head = student;
        } else head = student;

        return this;
    }
}