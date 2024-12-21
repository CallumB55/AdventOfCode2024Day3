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
        corruptedData.customSplit("mul\\(", false);
        for (String ln : corruptedData.getCustomSplit()) {
            String cleanString = cleanupHelper(ln);
            if (cleanString.length() > 2) {
                muls.add(new Mul(cleanString));
            }
        }

        Integer totalOfMuls = 0;
        for (Mul mul : muls) {
            totalOfMuls += mul.product;
        }
        System.out.println("Total sum of multiplications: " + totalOfMuls);

        muls.clear();
        totalOfMuls = 0;
        corruptedData.customSplit("don't\\(\\)", true);
        List<String> donts = corruptedData.getCustomSplit();
        for (int i = 0; i < donts.size(); i++) {
            if (donts.get(i).contains("do()")) {
                muls.addAll(cleanMulLoop(donts.get(i).substring(donts.get(i).indexOf("do()") + 4)));
            }
            else if (i == 0){//first one is a do
                muls.addAll(cleanMulLoop(donts.get(i)));
            }
        }
        
        for (Mul mul : muls) {
            totalOfMuls += mul.product;
        }
        System.out.println("Total sum of do multiplications: " + totalOfMuls);

    }

    public static List<Mul> cleanMulLoop(String dataPotentiallyContainingMuls) {
        List<Mul> muls = new ArrayList<Mul>();
        for (String possibleMul : dataPotentiallyContainingMuls.split("mul\\(")) {
            possibleMul = cleanupHelper(possibleMul);
            if (possibleMul.length() > 2) {
                muls.add(new Mul(possibleMul));
            }
        }
        return muls;
    }

    public static String cleanupHelper(String in) {
        String outString = "";
        Character c;
        for (int i = 0; i < in.length(); i++) {
            c = in.charAt(i);
            if (c == ',' || Character.isDigit(c)) {
                outString += c;
            } else if (c == ')') {
                break;
            } else {
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
