package com.codersmart.algorithms.common;

import java.util.HashMap;
import java.util.Map;

public class SudokuValidation {
    public static void main(String[] args){

    }

    public boolean isValidSudoku(char[][] board) {
        // 1 map -> + 9 maps \|/ + 9 maps square
        Map<Character, Integer>[][] boxes = new Map[3][3];
        Map<Character, Integer> rowMap = new HashMap<>();
        Map<Character, Integer>[] colMaps = new Map[9];
        for(int i = 0; i < 9; i++) { // rows
            rowMap.clear();

            for (int j = 0; j < 9; j++) { // cols
                if(i == 0){
                    colMaps[j] = new HashMap<>();
                }
                if(i%3 == 0 && j %3 ==0){
                    boxes[i/3][j/3] = new HashMap<>();
                }

                if(board[i][j] != '.'){
                    if(rowMap.get(board[i][j]) != null){
                        return false;
                    }
                    if(boxes[i/3][j/3].get(board[i][j]) != null){
                        return false;
                    }
                    if(colMaps[j].get(board[i][j]) != null){
                        return false;
                    }
                    rowMap.put(board[i][j], 1);
                    boxes[i/3][j/3].put(board[i][j], 1);
                    colMaps[j].put(board[i][j], 1);
                }
            }
            if(!isValid(rowMap)){
                return false;
            }
        }
        for(Map map: colMaps){
            if(!isValid(map)) return false;
        }
        for(Map[] row : boxes){
            for(Map map: row){
                if(!isValid(map)) return false;
            }
        }
        return true;
    }

    private boolean isValid(Map<Character, Integer> map) {
        for(Integer count : map.values()){
            if(count > 1) return false;
        }
        return true;
    }

}
