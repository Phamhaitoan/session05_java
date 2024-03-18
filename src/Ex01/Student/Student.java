package Ex01.Student;

import java.util.Scanner;

public class Student {
    private int studentID;
    private String studentName;
    private String sex;
    private int age;
    private String Adress;
    public Student (){}

    public Student(int studentID, String studentName, String sex, int age, String adress) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.sex = sex;
        this.age = age;
        Adress = adress;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void inputData(Scanner scanner){
        System.out.println("nhập vào mã sinh viên");
        studentID = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên sinh viên");
        studentName = scanner.nextLine();
        System.out.println("nhập vào giới tính");
        sex = scanner.nextLine();
        System.out.println("nhập tuổi của sinh viên");
        age = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập địa chỉ của sinh viên");
        Adress = scanner.nextLine();
    }
    public void displayData() {
        System.out.println("Student{" +
                "studentID=" + studentID +
                ", studentName=" + studentName +
                ", sex=" + sex +
                ", age=" + age+
                ",  Adress=" + Adress +
                '}');
    }
}
