/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callumhobby.adventofcode2024day3;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 *
 * @author CallumBinns
 */
public class InputReader {
    private String path;
    
    public InputReader(){
        this.path = "Input.txt";
    }
    
    public InputReader(String path){
        this.path = path;
    }
    
    public List<String> getInput(){
        List<String> input = new ArrayList<>();
        try{
            File file = new File(path);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                input.add(scan.nextLine());                
            }
        }
        catch (FileNotFoundException e){
            System.out.println("input reader has failed with error:" + e.getMessage());
        }
        return input;
    }
}