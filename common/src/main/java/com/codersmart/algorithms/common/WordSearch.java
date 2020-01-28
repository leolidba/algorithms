package com.codersmart.algorithms.common;

public class WordSearch {
    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCE";
        System.out.println(new WordSearch().exist(chars, word));
        char[][] chars2 = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        word = "AAB";
        System.out.println(new WordSearch().exist(chars2, word));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b'}}, "ba"));
        for(int i = 0; i< chars.length; i++){
            for(int j = 0; j < chars[0].length; j ++){
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return false;
        if(board == null || board.length ==0 || board[0].length == 0) return false;
        int M = board.length;
        int N = board[0].length;

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j < board[0].length; j ++){
                if(findWord(board, word, i, j, 0, M, N))
                    return true;
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int i, int j, int index, int rowNum, int colNum) {
        if(board[i][j] == word.charAt(index)){
            board[i][j] = '!';
        }else{
            return false;
        }
        boolean result = false;
        if(index == word.length() - 1){
            result = true;
        }

        if(!result && j < colNum -1 ){
            result = findWord(board, word, i, j + 1, index + 1, rowNum, colNum);
        }
        if(!result && i+1 < rowNum) {
            result = findWord(board, word, i+ 1, j, index + 1, rowNum, colNum);
        }
        if(!result && j - 1 >=0 ){
            result = findWord(board, word, i, j - 1, index + 1, rowNum, colNum);
        }
        if(!result && i - 1 >=0){
            result = findWord(board, word, i - 1, j, index + 1, rowNum, colNum);
        }
        board[i][j] = word.charAt(index);
        return result;
    }
}
