package Ex02;

import java.time.Year;
import java.util.Scanner;

public class Phone {
        private String id, title, author, description;
        private int year;
        private Category category;
        private int categoryCode;

        public int getCategoryCode()
        {
            return categoryCode;
        }

        public void setCategoryCode(int categoryCode)
        {
            this.categoryCode = categoryCode;
        }

        public Phone(String id, String title, String author, String description, int year, Category category)
        {
            this.id = id;
            this.title = title;
            this.author = author;
            this.description = description;
            this.year = year;
            this.category = category;
        }

        public Phone()
        {
        }

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getAuthor()
        {
            return author;
        }

        public void setAuthor(String author)
        {
            this.author = author;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        public int getYear()
        {
            return year;
        }

        public void setYear(int year)
        {
            this.year = year;
        }

        public Category getCategory()
        {
            return category;
        }

        public void setCategory(Category category)
        {
            this.category = category;
        }

        public void inputData(Scanner scanner, Phone[] phones, Category[] categories)
        {
            while (true)
            {
                System.out.println("Nhập mã điện thoại bắt đầu bằng P và có 4 ký tự");
                String idInput = scanner.nextLine();
                boolean idExist = false;
                if (!idInput.startsWith("P"))
                {
                    System.out.println("Mã điện thoại phải bắt đầu bằng P");
                } else if (idInput.length() != 4)
                {
                    System.out.println("Mã điện thoại phải có 4 ký tự");
                } else
                {
                    this.id = idInput;
                    for (Phone phone : phones)
                    {
                        if (phone.getId().equals(idInput))
                        {
                            System.out.println("Mã điện thoại này đã tồn tại");
                            idExist = true;
                        }
                    }
                    if (!idExist)
                        break;
                }
            }
            while (true)
            {
                System.out.println("Nhập tên điện thoại, từ 6-50 ký tự");
                String titleInput = scanner.nextLine();
                boolean titleExist = false;
                if (titleInput.length() < 6 || titleInput.length() > 50)
                {
                    System.out.println("Tên điện thoại phải có độ dài từ 6-50 ký tự");
                } else
                {
                    for (Phone phone : phones)
                    {
                        if (phone.getTitle().equals(titleInput))
                        {
                            System.out.println("tên diện thoại này đã tồn tại");
                            titleExist = true;
                        }
                    }
                    if (!titleExist)
                        break;
                }
            }
            while (true) //Author name
            {
                System.out.println("Mời nhập tên hãng");
                String authorInput = scanner.nextLine();
                if (authorInput.isBlank())
                {
                    System.out.println("Tên hãng không được để trống");
                } else break;
            }
            while (true)
            {
                System.out.println("Mời nhập năm sản xuất của điện thoại");
                int yearInput = Integer.parseInt(scanner.nextLine());
                if (yearInput < 1970 || yearInput > Year.now().getValue())
                {
                    System.out.println("Năm san xuât không được nhỏ hơn 1970 hoặc lớn hơn hiện tại");
                } else break;
            }
            while (true)
            {
                System.out.println("Mời nhập mô tả");
                String descriptionInput = scanner.nextLine();
                if (descriptionInput.isBlank())
                {
                    System.out.println("Mô tả không được để trống");
                } else break;
            }
            while (true)// Category
            {
                System.out.println("Mời nhập mã thể loại");
                int codeInput = Integer.parseInt(scanner.nextLine());
                boolean codeExist = false;
                for (Category c : categories)
                {
                    if (c.getId() == codeInput)
                    {
                        this.categoryCode = codeInput;
                        this.category = c;
                        codeExist = true;
                        break;
                    }
                }
                if (!codeExist)
                {
                    System.out.println("Mã thể loại này không tồn tại, vui lòng nhập lại");
                } else break;
            }
        }

        public void displayData()
        {
            System.out.println("Mã điện thoại: " + this.id);
            System.out.println("Tên điện thoại: " + this.title);
            System.out.println("Tên hãng: " + this.author);
            System.out.println("Năm sản xuất: " + this.year);
            System.out.println("Thể loại: " + this.category.getName());
        }
}

