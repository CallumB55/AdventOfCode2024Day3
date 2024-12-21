/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.callumhobby.adventofcode2024day3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CallumBinns
 */
public class AdventOfCode2024Day3 {

    public static void main(String[] args) {
        InputReader corruptedData = new InputReader("src\\main\\java\\com\\callumhobby\\adventofcode2024day3\\Input.txt");
        List<Mul> muls = new ArrayList<Mul>();
        for (String ln : corruptedData.getInput()) {
            String[] possibleMuls = ln.split("mul\\(");
            for (String possibleMul : possibleMuls) {
                possibleMul = cleanupHelper(possibleMul);
                if (possibleMul.length() > 2) {
                    muls.add(new Mul(possibleMul));
                }
  
            }
        }
        Integer totalOfMuls = 0;
        for (Mul mul : muls) {
            totalOfMuls += mul.product;
        }
        System.out.println("Total sum of multiplications: "+totalOfMuls);
    }
    
    
    public static String cleanupHelper(String in){
        String outString = "";
        Character c;
        for (int i = 0; i < in.length(); i++) {
            c=in.charAt(i);
            if (c == ',' || Character.isDigit(c)) {
                outString += c;
            }
            else if(c == ')'){
                break;
            }
            else{
                return "";
            }
        }
        String[] splitTest = outString.split(",");
        if (splitTest.length == 2) {
            return outString;
        }
        return "";
        
    }
}
