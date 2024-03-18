package Ex02;

import java.util.Scanner;

public class Library
{
    private static int categoryCount = 0;
    private static int phoneCount = 0;

    public static void main(String[] args)
    {
        Category[] categories = new Category[10];
        Phone[] phones = new Phone[100];
        for (int i = 0; i < phoneCount; i++)
        {
            boolean catExisted = false;
            for (int j = 0; j < phoneCount; j++)
            {
                if (categories[i].getId() == phones[i].getCategoryCode())
                {
                    catExisted = true;
                    break;
                }
            }
            if (!catExisted)
            {
                categories[i] = phones[i].getCategory();
                categoryCount++;
            }
        }
        Scanner scanner = new Scanner(System.in);
        ManageLibrary(scanner, categories, phones);
    }

    private static void ManageLibrary(Scanner scanner, Category[] categories, Phone[] phones)
    {
        System.out.println("=============QUẢN LÝ Cửa Hàng===============");
        System.out.println("\t 1. Quản lý thể loại");
        System.out.println("\t 2. Quản lý điện thoại");
        System.out.println("\t 0. Thoát");
        System.out.println("Mời nhập lựa chọn");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice)
        {
            case 1:
                ManageCategory(scanner, categories, phones);
                break;
            case 2:
                ManagePhone(scanner);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Lựa chọn không khả dụng");
                break;
        }
    }

    private static void ManageCategory(Scanner scanner, Category[] categories, Phone[] phones)
    {
        System.out.println("===========QUẢN LÝ THỂ LOẠI===========");
        System.out.println("\t 1. Thêm mới thể loại");
        System.out.println("\t 2. Hiển thị danh sách theo tên thể loại từ A-Z");
        System.out.println("\t 3. Thống kê thể loại và số điện thoại có trong mỗi thể loại");
        System.out.println("\t 4. Cập nhật thể loại");
        System.out.println("\t 5. Xóa thể loại (kiểm tra tồn tại điện thoại trước khi xóa)");
        System.out.println("\t 0. Quay lại");
        System.out.println("Mời nhập lựa chọn");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice)
        {
            case 1:
                Category newCat = new Category();
                newCat.inputData(scanner, categories);
                categories[categoryCount] = newCat;
                categoryCount++;
                break;
            case 2:
                for (int i = 0; i < categoryCount; i++)
                {//Bubble sort base on 1st char in category name (which is a string)
                    for (int j = 0; j < categoryCount; j++)
                    {
                        if ((int) categories[j].getName().charAt(0) > (int) categories[j + 1].getName().charAt(0))
                        {
                            Category temp = categories[j];
                            categories[j] = categories[j + 1];
                            categories[j + 1] = temp;
                        }
                    }
                }
                for (Category c : categories)
                {
                    c.displayData();
                }
                break;
            case 3:
                ShowCategories(categories, phones);
                break;
            case 4:
                System.out.println("Nhập mã thể loại muốn cập nhật");
                int idUpdate = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < categoryCount; i++)
                {
                    if (categories[i].getId() == idUpdate)
                    {
                        System.out.println("Mời cập nhật");
                        categories[i].inputData(scanner, categories);
                        break;
                    }
                }
                break;
            case 5:
                System.out.println("Nhập mã thể loại muốn xóa");
                int idDelete = Integer.parseInt(scanner.nextLine());
                boolean canDelete = true;
                for (int i = 0; i < categoryCount; i++)
                {
                    if (idDelete == categories[i].getId())
                    {
                        for (int j = 0; j < phoneCount; j++)
                        {
                            if (phones[j].getCategoryCode() == idDelete)
                            {
                                System.out.println("Trong thể loại này đang có điện thoại này, không thể xóa");
                                canDelete = false;
                                break;
                            }
                        }
                        if (canDelete)
                        {
                            categories[i] = null;
                            for (int k = i; k < categoryCount - 1; k++)
                            {//Shift elements up
                                categories[k] = categories[k + 1];
                            }
                            categories[categoryCount] = null;
                        }
                        break;
                    }
                }
                break;
            case 0:
                ManageLibrary(scanner, categories, phones);
            default:
                System.out.println("Lựa chọn không khả dụng");
                break;
        }
    }

    private static void ManagePhone(Scanner scanner, Category[] categories, Phone[] phones)
    {
        System.out.println("=========QUẢN LÝ Điện thoại==========");
        System.out.println("\t 1. Thêm mới điện thoại");
        System.out.println("\t 2. Cập nhật thông tin");
        System.out.println("\t 3. Xóa");
        System.out.println("\t 4. Tìm kiếm");
        System.out.println("\t 5. Hiển thị danh sách theo nhóm thể loại");
        System.out.println("\t 0. Quay lại");
        System.out.println("Mời nhập lựa chọn");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice)
        {
            case 1:
                Phone newPhone = new Phone();
                newPhone.inputData(scanner, phones, categories);
                phones[phoneCount] = newPhone;
                break;
            case 2:
                Phone phoneToUpdate = FindPhoneIndex(scanner, phones);
                if (phoneToUpdate != null)
                {
                    phoneToUpdate.inputData(scanner, phones, categories);
                } else System.out.println(" không tồn tại");
                break;
            case 3:
                Phone phoneToDelete = FindPhoneIndex(scanner, phones);
                if (phoneToDelete != null)
                {
                    phoneToDelete = null;
                    for (int i = 0; i < phoneCount - 1; i++)
                    {
                        phones[i] = phones[i + 1];
                    }
                    phones[phoneCount] = null;
                } else System.out.println("không tồn tại");
                break;
            case 4:
                System.out.println("Mời nhập từ khóa tìm kiếm");
                String searchInput = scanner.nextLine();
                boolean phoneIsFound = false;
                for (Phone phone : phones)
                {
                    if (phone.getTitle().contains(searchInput) || phone.getAuthor().contains(searchInput))
                    {
                        System.out.println("Điện thoại có thông tin giống với nội dung tìm kiếm:");
                        phone.displayData();
                        phoneIsFound = true;
                    }
                }
                if (!phoneIsFound)
                    System.out.println("Không tìm thấy điện thoại nào thỏa mãn yêu cầu");
                break;
            case 5:
                ShowCategories(categories, phones);
                break;
            case 0:
                ManageLibrary(scanner, categories, phones);
            default:
                System.out.println("Lựa chọn không khả dụng");
                break;
        }
    }

    private static void ShowCategories(Category[] categories, Phone[] phones)
    {
        System.out.println("Danh sách các thể loại: ");
        for (int i = 0; i < categoryCount; i++)
        {
            System.out.println(categories[i].getName());//Hiển thị tên thể loại
            for (int j = 0; j < phoneCount; j++)
            {
                if (phones[j].getCategory() == categories[i])
                {
                    phones[j].displayData();//Nếu trùng thể loại thì hiển thị ra
                }
            }
        }
    }

    private static Phone FindPhoneIndex(Scanner scanner, Phone[] phones)
    {
        System.out.println("Nhập mã cần tìm");
        String input = scanner.nextLine();
        for (int i = 0; i < phoneCount; i++)
        {
            if (phones[i].getId().equals(input))
            {
                return phones[i];
            }
        }
        return null;
    }
}