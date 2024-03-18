package Ex01.StudentManager;
import Ex01.Student.Student;

import java.util.Scanner;

public class StudentManager {
    private static Student[] students = new Student[100];
    private static int length = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager.showAllStudent();
        do {
            System.out.println("1.\tHiển thị danh sách sinh viên\n" +
                    "2.\tThêm mới n sinh viên\\n" +
                    "3.\tUpdate thông tin sinh viên theo id\n" +
                    "4.\tXoá sinh viên theo id\n" +
                    "5.\tThoát\n");
            System.out.println("Moi lua chon ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    showAllStudent();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sort();
                    break;
                case 6:
                    searchStudent(scanner);
                    break;


            }
        } while (true);
    }

    public static void showAllStudent(){

        for (int j = 0; j < length; j++) {
            students[j].displayData();
            System.out.println("--------------------------");
        }

    }
    public static void createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("bạn muốn nhập mấy thằng ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.inputData(scanner);
            students[length] = student;
            length++;
        }
    }
    public static void updateStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập sinh viên bạn muốn sửa thông tin");
        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            if (students[i].getStudentID() == idEdit ){
                System.out.println("chọn 1 để sửa tên sinh viên:");
                System.out.println("chọn 2 để sửa tuổi sinh viên");
                System.out.println("chọn 3 để sửa địa chỉ sinh viên");
                System.out.println("chọn 0 để quay lại");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("mời nhập tên sinh viên cần sửa");
                        String newName = scanner.nextLine();
                        students[i].setStudentName(newName);
                        break;
                    case 2:
                        System.out.println("mời nhập tuổi sinh viên cần sửa");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        students[i].setAge(newAge);
                        break;
                    case 3:
                        System.out.println("mời nhập địa chỉ của sinh viên cần sửa");
                        String newAdress = scanner.nextLine();
                        students[i].setAdress(newAdress);
                        break;
                    default:
                        System.out.println("thôi quay lại khỏi sửa");
                        break;
                }
            }
        }
    }

    public static void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập sinh viên bạn muốn xóa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;
        for (int i = 0; i < length-1; i++) {
            if (students[i].getStudentID() == idDelete) {
                students[i] = students[i+1];
                isExist = true;
            }
            if (!isExist){
                System.out.println("không tìm thấy sinh viên muốn xóa");
            }
            else{
                length--;
            }
        }
    }

    public  static void sort(){
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if (students[i].getAge() > students[j].getAge()){
                       Student st = students[i] ;
                      students[i]= students[j];
                     students[j] = st;
                }
            }
        }
    }

    public static void searchStudent(Scanner scanner){

        System.out.println("nhập tuổi cần tìm kiếm: ");
        int age = Integer.parseInt(scanner.nextLine());
        boolean check = true;
        for (int i = 0; i < length; i++) {
            if(students[i].getAge() == age) {
                System.out.println("thông tin sinh viên");
                students[i].displayData();
                check = false;
            }
        }
        if (check){
            System.out.println("không tìm thấy");
        }

    }
}
