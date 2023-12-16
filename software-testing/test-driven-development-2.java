class Main{
    public static void main(String[] args){
        Student[] studentList1 = new Student[]{
                new Student(1000,9,"Matt Verdict", 14, 5.5),
                new Student(1001,9,"Amy Lam", 14, 5.5),
                new Student(1002,10,"Bryant Gonzales", 15, 5.9),
                new Student(1003,9,"Kimberly York", 15, 5.3),
                new Student(1004,11,"Christine Bryant", 15, 5.8),
                new Student(1005,10,"Mike Allen", 16, 6.2),
        };

        Student[] studentList2 = new Student[]{
                new Student(1000,9,"Matt Verdict", 14, 5.5),
                new Student(1001,9,"Amy Lam", 13, 5.5),
                new Student(1002,10,"Bryant Gonzales", 15, 5.9),
                new Student(1003,9,"Kimberly York", 15, 5.3),
                new Student(1004,11,"Christine Bryant", 15, 5.8),
                new Student(1005,10,"Mike Allen", 16, 6.2),
        };

        // choseStudent should return Matt Verdict with id 1000
        System.out.println(Student.chooseStudent(studentList1).studentId == 1000);  // false
        // choseStudent should return Amy Lam with id 1001
        System.out.println(Student.chooseStudent(studentList2).studentId == 1001);  // false

        // -> could not pass the testing...
    }
}

class Student {
    public int studentId;
    public int grade;
    public String name;
    public int age;
    public double height;

    public Student(int studentId, int grade, String name, int age, double height) {
        this.studentId = studentId;
        this.grade = grade;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public static Student chooseStudent(Student[] students){
        int minAge = students[0].age;
        int minIdx = 0;

        for (int i = 1; i < students.length; i++){
            Student student = students[i];
            if (student.age < minAge){
                minAge = student.age;
                minIdx = i;
            } else if (student.age == minAge){
                if (student.height > students[minIdx].height){
                    minIdx = i;
                }
            }
        }

        return students[minIdx];
    }
}
