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

public class Sutradara {
    static ArrayList listSutradara = new ArrayList();
    static boolean isRunning = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    
    public static void showMenuS() throws IOException{
        
        System.out.println("========= SUTRADARA ========");
        System.out.println("[1] Show All Sutradara");
        System.out.println("[2] Insert Sutradara");
        System.out.println("[3] Edit Sutradara");
        System.out.println("[4] Delete Sutradara");
        System.out.println("[5] Exit");
        System.out.println("========================");
        System.out.print("PILIHAN [1/2/3/4/5] = ");
        
        int pilihMenu = Integer.valueOf(input.readLine()); 
        switch(pilihMenu){
            case 1:
                showAllSutradara();
                break;
            case 2:
                insertSutradara();
                break;
            case 3:
                editSutradara();
                break;
            case 4:
                deleteSutradara();
                break;
            case 5:
                System.exit(0);
                System.out.println("PILIHAN TIDAK TERSEDIA!!!");
                break;     
        }   
    }
    
    public static void showAllSutradara(){
        File file = new File("sutradara.txt");
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
        for(int i = 0; i < listSutradara.size(); i++){
                System.out.println(String.format("[%d] %s",i, listSutradara.get(i)));
        }
        System.out.println();
    }
    
    public static void insertSutradara() throws IOException{
        System.out.print("Masukkan Nama Sutradara: ");
        String namaSutradara = input.readLine();
        listSutradara.add(namaSutradara);
    }
    
    public static void editSutradara() throws IOException{
        showAllSutradara();
        System.out.print("Pilih Nomor Sutradara: ");
        int indexSutradara = Integer.valueOf(input.readLine());
        System.out.print("Nama Baru Sutradara: ");
        String namaBaru = input.readLine();
        listSutradara.set(indexSutradara, namaBaru);
    }
    
    public static void deleteSutradara() throws IOException{
        showAllSutradara();
        System.out.print("Pilih Nomor Sutradara: ");
        int indexSutradara = Integer.valueOf(input.readLine());
        listSutradara.remove(indexSutradara);
    }
    
    public static void main(String[] args) throws IOException {
        do {
            showMenuS();
        } while (isRunning);    
    }    
}
