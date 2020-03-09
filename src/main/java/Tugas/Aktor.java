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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Aktor {
    static ArrayList listAktor = new ArrayList();
    static boolean isRunning = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    
    public static void showMenuA() throws IOException{
        System.out.println("========= AKTOR =========");
        System.out.println("[1] Show All Aktor");
        System.out.println("[2] Insert Aktor");
        System.out.println("[3] Edit Aktor");
        System.out.println("[4] Delete Aktor");
        System.out.println("[5] Exit");
        System.out.println("========================");
        System.out.print("PILIHAN [1/2/3/4/5] = ");
        
        int pilihMenu = Integer.valueOf(input.readLine());
        
        switch(pilihMenu){
            case 1:
                showAllAktor();
                break;
            case 2:
                insertAktor();
                break;
            case 3:
                editAktor();
                break;
            case 4:
                deleteAktor();
                break;
            case 5:
                System.exit(0);
                System.out.println("PILIHAN TIDAK TERSEDIA!!!"); 
                break;
        }
    }
    
    public static void showAllAktor(){    
        File file = new File("actor.txt");
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String barisData;        
            while((barisData = bf.readLine())!= null){
                System.out.println(barisData);
            }
        }catch(FileNotFoundException ex1){    
            System.out.println("File tidak dapat ditemukan "+ file.toString());
        }catch(Exception ex2){
            System.out.println("File tidak dapat dibaca "+ file.toString());
        }
        for(int i = 0; i < listAktor.size(); i++){
                System.out.println(String.format("[%d] %s",i, listAktor.get(i)));
        }
        System.out.println();
    }
    
    public static void insertAktor() throws IOException{
        System.out.print("Masukkan Nama Aktor: ");
        String namaAktor = input.readLine();
        listAktor.add(namaAktor);
    }
    
    public static void editAktor() throws IOException{
        showAllAktor();
        System.out.print("Pilih Nomor Aktor: ");
        int indexAktor = Integer.valueOf(input.readLine());
        System.out.print("Nama Baru Aktor: ");
        String namaBaru = input.readLine();     
        listAktor.set(indexAktor, namaBaru);
    }
    
    public static void deleteAktor() throws IOException{
        showAllAktor();
        System.out.print("Pilih Nomor Aktor: ");
        int indexAktor = Integer.valueOf(input.readLine());
        listAktor.remove(indexAktor);
    }
    
    public static void main(String[] args) throws IOException { 
        do {
            showMenuA();
        } while (isRunning);
    }
}