/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callumhobby.adventofcode2024day3;

/**
 *
 * @author CallumBinns
 */
public class Mul {
    private Integer left;
    private Integer right;
    public Integer product;
    
    public Mul(String commaSeparatedPair){
        String[] vals = commaSeparatedPair.split(",");
        this.left = Integer.valueOf(vals[0]);
        this.right = Integer.valueOf(vals[1]);
        this.product = left*right;
    }
    
}
