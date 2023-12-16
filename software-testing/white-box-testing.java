// white-box tesring:ホワイトボックステストを適用することによって、単にk人の最年少で背の高い学生が返されるかどうかを判断するのではなく、状態が変更されていない（副作用が発生していないことを）ことを保証することができる。
// black-box testingの時は、「k人の最年少で背の高い学生が返されるかどうか」のみがテストされたため、入力配列への副作用についてはテストされていない。

import java.util.ArrayList;

class Main{
    public static void main(String[] args){
        ArrayList<Student> studentList1 = new ArrayList<>(){
            {
                add(new Student(1000,9,"Matt Verdict", 14, 5.5));
                add(new Student(1001,9,"Amy Lam", 14, 5.5));
                add(new Student(1002,10,"Bryant Gonzales", 15, 5.9));
                add(new Student(1003,9,"Kimberly York", 15, 5.3));
                add(new Student(1004,11,"Christine Bryant", 15, 5.8));
                add(new Student(1005,10,"Mike Allen", 16, 6.2));
            }
        };
        // 最年少かつ最も高い生徒をid順に並べると、[1000, 1001, 1002, 1004, 1003, 1005]

        ArrayList<Student> studentList2 = new ArrayList<>(){
            {
                add(new Student(1000,9,"Matt Verdict", 14, 5.5));
                add(new Student(1001,9,"Amy Lam", 13, 5.5));// 変更され、13歳
                add(new Student(1002,10,"Bryant Gonzales", 15, 5.9));
                add(new Student(1003,9,"Kimberly York", 15, 5.3));
                add(new Student(1004,11,"Christine Bryant", 15, 5.8));
                add(new Student(1005,10,"Mike Allen", 16, 6.2));
            }
        };
        // 最年少かつ最も高い生徒をid順に並べると、[1001, 1000, 1002, 1004, 1003, 1005]

        // studentList1に対してテスト実行（white-box testing）: 入力配列が変更されていないかもテストする
        printStudents(studentList1);
//        printStudents(chooseStudent(studentList1, 5));
        System.out.println(chooseStudent(studentList1, 1).get(0).studentId == 1000);
        printStudents(studentList1);
        System.out.println(areStudentListsEquals(studentList1, studentList1));

        // studentList2に対してテスト実行（white-box testing）
        printStudents(studentList2);
//        printStudents(chooseStudent(studentList2, 5));
        System.out.println(chooseStudent(studentList2, 5).get(0).studentId == 1001);
        printStudents(studentList2);
        System.out.println(areStudentListsEquals(studentList2, studentList2));
    }

    public static boolean areStudentListsEquals(ArrayList<Student> students1, ArrayList<Student> students2){
        return students1.equals(students2);
    }

    // returning k students
    public static ArrayList<Student> chooseStudent(ArrayList<Student> list, int k){
        ArrayList<Student> copy = new ArrayList<>();
        copy.addAll(list);

        heapify(copy);
        ArrayList<Student> output = new ArrayList<>();

        for (int i = 0; i < k; i++){
            swap(copy, 0, copy.size() - 1);
            output.add(copy.remove(copy.size() - 1));
            minHeap(copy, 0);
        }

        return output;
    }

    public static boolean compareStudent(Student s1, Student s2){
        if (s1.age == s2.age){
            return (s1.height == s2.height)? s1.studentId < s2.studentId: s1.height > s2.height;
        }

        return s1.age < s2.age;
    }

    // StudentListをmin-heapにする
    public static void heapify(ArrayList<Student> list){
        int idx = parent(list.size() - 1);
        for (int i = idx; i >= 0; i--){
            minHeap(list, i);
        }
    }

    public static void minHeap(ArrayList<Student> list, int i){
        int l = left(i);
        int r = right(i);

        int min = i;

        // 条件追加
        if (l < list.size() && compareStudent(list.get(l), list.get(min))) min = l;
        if (r < list.size() && compareStudent(list.get(r), list.get(min))) min = r;

        if (min != i){
            swap(list, i, min);
            minHeap(list, min);
        }
    }

    public static void swap(ArrayList<Student> list, int i, int j){
        Student temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    public static int left(int i){
        return 2 * i + 1;
    }

    public static int right(int i){
        return 2 * i + 2;
    }

    public static int parent(int i){
        return (int)Math.floor((i - 1) / 2);
    }

    public static void printStudents(ArrayList<Student> list){
        for (Student student: list){
            System.out.print(student.studentId + " ");
        }

        System.out.println();
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
}

