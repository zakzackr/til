public class Main {

    public static void main(String[] args) {
        Classroom classroom1 = new Classroom(new Student[]{
                new Student("AC-343424", "James", "Smith", 6),
                new Student("AC-343428", "Maria", "Garcia", 5),
                new Student("AC-343434", "Robert", "Johnson", 3),
                new Student("AC-343454", "Danny", "Robertson", 10)
        }, "Algebra II", "Emily Theodore");

        Classroom classroom2 = new Classroom(new Student[]{
                new Student("AC-340014","Kent", "Carter",9),
                new Student("AC-340024","Isaiah", "Chambers",10),
                new Student("AC-340018","Leta", "Ferguson", 7)
        },  "English", "Daniel Pherb");

        Classroom[] classrooms = new Classroom[]{classroom1, classroom2};
        printAllStudents(classrooms);
    }

    public static void printAllStudents(Classroom[] classrooms){

        StringBuilder string = new StringBuilder();

        for (Classroom classroom: classrooms){
            Student[] students = classroom.students;

            for (Student student: students){
                string.append(student.getStudentInfo() + ", ");
            }
        }

        System.out.println(string.substring(0, string.length() - 2));
    }
}

class Student{
    public String studentId;
    public String firstName;
    public String lastName;
    public int gradeLevel;

    public Student(String studentId, String firstName, String lastName, int gradeLevel){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
    }

    public String getStudentInfo(){
        return studentId + ": " + firstName + " " + lastName + "(" + gradeLevel + ")";
    }
}

class Classroom{
    public Student[] students;
    public String courseName;
    public String teacher;

    public Classroom(Student[] students, String courseName, String teacher){
        this.students = students;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public String getClassIdentity(){
        return courseName + " managed by " + teacher;
    }

    public int getNumberOfStudents(){
        return students.length;
    }
}
