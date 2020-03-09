/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;
/**
 *
 * @author ASUS
 */
import java.io.IOException;
import java.util.Scanner;

public class Halaman_Utama {
     public static void main(String[] args) throws IOException{
        String ulg = "y";
        while (ulg.equals("y"))
        {
            System.out.println(" ");
            Scanner input = new Scanner(System.in);
            String ul="",lagi;
            System.out.println("~~~~~~~SELAMAT DATANG~~~~~~~");
            System.out.println("         MENU UTAMA        ");
            System.out.println("1. AKTOR ");
            System.out.println("2. FILM");
            System.out.println("3. SUTRADARA");
            System.out.println("4. KELUAR");
            System.out.println("=============================");
            System.out.print("PILIHAN [1/2/3/4] = ");
            int pilih = input.nextInt();
            
            switch (pilih){
                case 1 :{
                    Aktor a = new Aktor();
                    a.showMenuA();
                    break;
                }
                case 2 :{
                    Film f=new Film();
                    f.showMenuF();
                    break;
                }
                case 3 :{
                    Sutradara s=new Sutradara();
                    s.showMenuS();
                    break;
                }
                case 4 :{
                    System.exit(0);
                    System.out.println("PILIHAN TIDAK TERSEDIA!!!");
                }
                    break;
            }
            System.out.println("===================================");
            System.out.println("Apakah anda ingin mengulang (y/t)? ");
            ulg = input.next();
        }
    }
}
