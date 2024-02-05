package baekjoon.paintingChess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static String[] rowStartWithWhite = {"W","B","W","B","W","B","W","B"};
    public static String[] rowStartWithBlack = {"B","W","B","W","B","W","B","W"};
    public static List<String[]> POSSIBLE_ROW = new ArrayList<>(Arrays.asList(rowStartWithWhite,rowStartWithBlack));

    public static void main(String[] args) {
        List<String[]> chessStartBlack = createChessFromBlack();

        InputService inputService = new InputService();
        Integer[] size = inputService.readAsArrayInteger(" ");
        List<String[]> board = new ArrayList<>();
        for(int row =0;row<size[0];row++){
            board.add(inputService.readAsArrayString(""));
        }

        int lowestVal = Integer.MAX_VALUE;

        for(int startRow=0;startRow<size[0]-7;startRow++){
            for(int startColumn=0;startColumn<size[1]-7;startColumn++){
                int blackStartVal = 0;
                for(int row=0;row<8;row++){
                    for(int column=0;column<8;column++) {
                        if(!chessStartBlack.get(row)[column].equals(board.get(startRow+row)[startColumn+column])){
                            blackStartVal++;
                        }
                    }
                }
                int countToChange = Math.min(blackStartVal,64-blackStartVal);
                if(countToChange<lowestVal){
                    lowestVal = countToChange;
                }

            }
        }
        System.out.println(lowestVal);
    }

    public static List<String[]> createChessFromBlack(){
        List<String[]> chess = new ArrayList<>();
        for(int row=0;row<8;row++){
            chess.add(POSSIBLE_ROW.get((row+1)%2));
        }
        return chess;
    }
    public static class InputService{
        private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        public Integer[] readAsArrayInteger(String reg){
            return Arrays.stream(readAsArrayString(reg)).map(Integer::parseInt).toArray(Integer[]::new);
        }

        public String[] readAsArrayString(String reg){
            String[] arrayString = null;
            try{
                arrayString = bf.readLine().split(reg);
            }catch (Exception e){
                e.printStackTrace();
            }

            return arrayString;
        }
    }
}
