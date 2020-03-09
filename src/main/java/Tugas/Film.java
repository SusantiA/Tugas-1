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
public class Film {
    
    static ArrayList listFilm = new ArrayList();
    static boolean isRunning = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    
    public static void showMenuF() throws IOException{
        
        System.out.println("======= FILM =======");
        System.out.println("[1] Show All Film");
        System.out.println("[2] Insert Film");
        System.out.println("[3] Edit Film");
        System.out.println("[4] Delete Film");
        System.out.println("[5] Exit");
        System.out.println("=====================");
        System.out.print("PILIHAN [1/2/3/4/5] = ");
        
        int pilihMenu = Integer.valueOf(input.readLine());
        switch(pilihMenu){
            case 1:
                showAllFilm();
                break;
            case 2:
                insertFilm();
                break;
            case 3:
                editFilm();
                break;
            case 4:
                deleteFilm();
                break;
            case 5:
                System.exit(0);
                System.out.println("PILIHAN TIDAK TERSEDIA!!!");
                break; 
            }                   
    }
    
    public static void showAllFilm(){
        File file = new File("film.txt");
        try(BufferedReader bv = new BufferedReader(new FileReader(file))){
            String barisData;        
            while((barisData = bv.readLine())!= null){
                System.out.println(barisData);
            }
        }catch(FileNotFoundException ex1){    
            System.out.println("File tidak dapat ditemukan "+ file.toString());
        }catch(Exception ex2){
            System.out.println("File tidak dapat dibaca "+ file.toString());
        }
            for(int i = 0; i < listFilm.size(); i++){
                System.out.println(String.format("[%d] %s",i, listFilm.get(i)));
            }
            System.out.println();
        }
    
    public static void insertFilm() throws IOException{
        System.out.print("Masukkan Nama Film: ");
        String namaFilm = input.readLine();
        listFilm.add(namaFilm);
    }
    
    public static void editFilm() throws IOException{
        showAllFilm();
        System.out.print("Pilih Nomor Film: ");
        int indexFilm = Integer.valueOf(input.readLine());
        
        System.out.print("Nama Baru Film: ");
        String namaBaru = input.readLine();
        listFilm.set(indexFilm, namaBaru);
    }
    
    public static void deleteFilm() throws IOException{
        showAllFilm();
        System.out.print("Pilih Nomor Film: ");
        int indexFilm = Integer.valueOf(input.readLine());
        listFilm.remove(indexFilm);
    }
    
    public static void main(String[] args) throws IOException {
        do {
            showMenuF();
        } while (isRunning);   
    }
}