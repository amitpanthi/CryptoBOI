package com.tas;

import java.io.*;
import java.util.*;

public class Railfence
{
    public static String encryption(String str,int rails){

        boolean checkdown=false; /*checking if the current position of the matrix is in the terminal
rows so as to reverse the direction of assignment*/
        int j=0;
        int row=rails;
        int col=str.length();
        char a[][]=new char[row][col];
        for(int i=0;i<col;i++){ //traversing horizontally
            if(j==0||j==row-1) //checking for the terminal rows to change the direction vertically
                checkdown= !checkdown; //inverting the values at the terminal rows

            a[j][i]=str.charAt(i); //assignmentof the letters

            if(checkdown)
                j++;
            else
                j--;
        }

        //thisplaying in-process view
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                System.out.print(a[i][k]+" ");//thanks to null initialization ; i lost several hours thinking about this
            }
            System.out.println();
        }

        String en="";

        System.out.print("Encrypted text:");

        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                if(a[i][k]!=0)
                    en=en+a[i][k];
            }
        }
        return en;//printing the ciphertext
    }
}