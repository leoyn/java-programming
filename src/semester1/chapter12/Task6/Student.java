package semester1.chapter12.Task6;

public class Student {

    public String lastname;
    public String firstname;
    public Student next;
    public Exam head;

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public boolean isBeforeStudent(Student student) {
        int index = 0;

        while(index < firstname.length() || index < student.firstname.length()) {
            int a = index < firstname.length() ? firstname.charAt(index) : 0;
            int b = index < student.firstname.length() ? student.firstname.charAt(index) : 0;

            if(a > b) return false;
            if(a < b) return true;
            
            index++;
        }

        return false;
    }

    public Student addExam(Exam exam) {
        exam.next = head;
        head = exam;

        return this;
    }
}