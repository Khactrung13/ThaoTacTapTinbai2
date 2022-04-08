/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLapTrinhTapTin2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ManagementStudent {
    
    static List<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);  

    public static void main(String[] args) {
        int luachon;
        do{
            showMenu();
            luachon = sc.nextInt();
            sc.nextLine();
            switch(luachon){
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Nhap id:");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap name:");
                    String name = sc.nextLine();
                    System.out.print("Nhap tuoi:");
                    int age = Integer.parseInt(sc.nextLine());
                    sc.nextLine();
                    System.out.print("Nhap address:");
                    String address= sc.nextLine();
                    System.out.print("Nhap gpa:"); 
                    Double gpa = Double.parseDouble(sc.nextLine());
                    sc.nextLine();
                    Student student = new Student(id, name, age, address, gpa);
                    studentList.add(student);
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    saveFile();                  
                    break;
                case 4:
                    readFile();
                    break;
                case 5:                    
                    return;
                default:
                    System.out.println("Nhap sai!!!");
                    break;
            }
        }while(luachon!=9);
    }
    public static void showMenu(){
        System.out.println("1.Them sinh vien");
        System.out.println("2.Hien thi thong tin sinh vien");
        System.out.println("3.Ghi vao file student.txt");
        System.out.println("4.Doc du lieu tu file student.txt");
        System.out.println("5.Ket thuc chuong trinh");
        System.out.println("chon:");
        
    }
    public static  void input(Student st){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id:");
        st.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap name:");
        st.setName(sc.nextLine());
        System.out.print("Nhap tuoi:");
        st.setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap address:");
        st.setAddress(sc.nextLine());
        System.out.print("Nhap gpa:"); 
        st.setGpa(sc.nextFloat());
        sc.nextLine();
    }
//    private static void inputStudent() {
//
//        System.out.println("Nhap so sinh vien can them:");
//        int n = Integer.parseInt(sc.nextLine());
//        for (int i = 1; i <= n; i++) {
//            System.out.println("Nhap sinh vien thu " + i);
//            Student student = new Student();
//            student.input();
//            
//            studentList.add(student);
//        }
//    }
    private static void displayStudent() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    private static void saveFile()  {
        System.out.println("Bat dau luu");
        FileOutputStream fos = null;
        try {          
            fos = new FileOutputStream("student.txt");
            
            for (Student student : studentList) {
                String line = student.getLine();
                
                byte[] b = line.getBytes("utf8");
                
                fos.write(b);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if( fos != null){
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }   
    private static void readFile() {
       
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bf = null;
        
        try {
            fis = new  FileInputStream("student.txt");
            
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            
            bf = new  BufferedReader(reader);
            
            String line = null;
            while((line=bf.readLine()) !=null){
                if(line.isEmpty()){
                    continue;
                }
                Student student = new Student();
                student.parse(line);
                studentList.add(student);
        }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis !=null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(bf!=null){
                try {
                    bf.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManagementStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
