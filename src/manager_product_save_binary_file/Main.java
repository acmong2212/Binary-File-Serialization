package manager_product_save_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone 13", "Apple", 33000, "Màu hồng"));
        products.add(new Product("Iphone 12", "Apple", 23000, "Màu đen"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Quản lý sản phẩm");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    writeToFile("products.txt", products);
                    break;
                case 2:
                    display(products);
                    break;
                case 3:
            }
        }
    }

    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void display(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}
