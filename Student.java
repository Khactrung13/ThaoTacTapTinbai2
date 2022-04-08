/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLapTrinhTapTin2;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student extends Person{
    private int id;   
    private double gpa;
    
    public Student() {
        
    }

    public Student(int id, String name, int age, String address, double gpa) {
        super(name, age, address);
        this.id = id;
        this.gpa = gpa;
    }
    
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id:");
        this.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap name:");
        this.setName(sc.nextLine());
        System.out.print("Nhap tuoi:");
        this.setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap address:");
        this.setAddress(sc.nextLine());
        System.out.print("Nhap gpa:"); 
        this.setGpa(sc.nextFloat());
        sc.nextLine();
    }
    public String getLine(){
        
        return id +","+ name+","+age+","+ address+"," + gpa + "\n";
        
    }
    public void parse(String line){
        String params[] = line.split(",");
        Scanner sc = new Scanner(System.in);
        try {
            id =Integer.parseInt(params[0]);
            name= params[1];
            age =Integer.parseInt(params[2]);
            address= params[3];
            gpa = Float.parseFloat(params[4]);
        } catch (ArrayIndexOutOfBoundsException ex){             
        }finally{            
        }
        
    }
    public void display(){
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name +",age:"+age+ ", address=" + address + ", gpa=" + gpa + '}';
    }
    
    
}
