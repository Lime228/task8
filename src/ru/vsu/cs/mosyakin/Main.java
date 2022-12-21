package ru.vsu.cs.mosyakin;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [][] grid1 = {{0, 0, 1, 0, 6},
                          {1, 0, 1, 1, 4},
                          {0, 0, 0, 0, 0},};
        System.out.println(grid1.length);
        System.out.println(grid1[0].length);


        solution(grid1);
    }

    public static void solution(int[][] array) {
        List<Integer> listLine = new ArrayList<>();
        List<Integer> listColumn = new ArrayList<>();
        int countZero = 0;
        int countZero1 = 0;
        for (int j = 0; j < array.length; j++){
            for (int i = 0; i < array[0].length; i++) {
                if (array[j][i] == 0) {
                    countZero += 1;
                }
            }
            if (countZero == array[0].length){
                listLine.add(j);
            }
            countZero = 0;
        }
        for (int j = 0; j < array[0].length; j++) {
            for (int[] ints : array) {
                if (ints[j] == 0) {
                    countZero1 += 1;
                }
            }
            if (countZero1 == array.length){
                listColumn.add(j);
            }
            countZero1 = 0;
        }
        print(billingСycle(array,listColumn,listLine));

    }
    public static int[][] billingСycle(int[][] array1, List<Integer> listColumn, List<Integer> listLine){
        boolean lineDelete = false;
        boolean columnDelete = false;
        int[][] array2 = new int[array1.length][array1[0].length];
        int l = 0;
        int c = 0;
        for (int[] ints : array1) {
            for (int i = 0; i < array1[0].length; i++) {
                for (Integer integer : listLine) {
                    if (integer == i) {
                        lineDelete = true;
                        break;
                    }
                }
                for (Integer integer : listColumn) {
                    if (integer == i) {
                        columnDelete = true;
                        break;
                    }
                }
                if (!lineDelete && !columnDelete) {
                    array2[c][l] = ints[i];
                    l++;
                }
                lineDelete = false;
                columnDelete = false;
            }
            c++;
            l = 0;
        }
        return array2;
    }
    public static void print(int[][] array){
        for (int i = 0; i < 3; i++) {  //идём по строкам
            for (int j = 0; j < 4; j++) {//идём по столбцам
                System.out.print(" " + array[i][j] + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
    }


}