package Rikkei.academy.run;

import Rikkei.academy.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int size;
        ArrayList<Product> arr = new ArrayList<>();
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần\n" +
                    "4. Xóa sản phẩm theo mã sản phẩm\n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm\n" +
                    "7. Thoát\n");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Nhập số sản phẩm bạn muốn thêm: ");
                        size = sc.nextInt();
                        if (size<0)
                            System.out.println("Số lượng không phù hợp!");
                    } while (size < 0);
                    for (int i = 0; i < size; i++) {
                        arr.add(new Product());
                        arr.get(i).inputData();
                        arr.get(i).setInterest();
                    }
                    break;
                case 2:
                    for (int i = 0; i < arr.size(); i++) {
                        arr.get(i).displayData();
                    }
                    if (arr.size()==0)
                        System.out.println("Danh sách trống.");
                    break;
                case 3:
                    Collections.sort(arr);
                    break;
                case 4:
                    System.out.println("Nhập vào mã sản phẩm bạn muốn xóa: ");
                    int deleteId = sc.nextInt();
                    boolean flag = false;
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getProductId() == deleteId){
                            arr.remove(i);
                            System.out.println("Xóa thành công sản phẩm có mã --> " + deleteId);
                            flag = true;
                        }
                    }
                    if (!flag)
                        System.out.println("Mã trên không tồn tại.");
                    break;
                case 5:
                    System.out.println("Nhập vào tên sản phẩm bạn muốn tìm: ");
                    sc.nextLine();
                    String findName = sc.nextLine();
                    boolean flagName = false;
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getProductName().equalsIgnoreCase(findName)){
                            arr.get(i).displayData();
                            flagName = true;
                        }
                    }
                    if (!flagName)
                        System.out.println("Không tìm thấy sản phẩm -->" + findName);
                    break;
                case 6:
                    System.out.println("Nhập vào mã sản phẩm bạn muốn thay đổi trạng thái: ");
                    int changeId = sc.nextInt();
                    boolean flagStatus = false;
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getProductId() == changeId){
                            arr.get(i).setProductStatus();
                            flagStatus = true;
                        }
                    }
                    if (!flagStatus)
                        System.out.println("Mã trên không tồn tại.");
                    break;
                case 7:
                    System.exit(0);
            }
        } while (choice != 7);
    }
}
