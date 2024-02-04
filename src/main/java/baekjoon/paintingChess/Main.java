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
        List<String[]> chessStartWhite = createChessFrom("white");
        List<String[]> chessStartBlack = createChessFrom("black");

        InputService inputService = new InputService();
        Integer[] size = inputService.readAsArrayInteger(" ");
        List<String[]> board = new ArrayList<>();
        for(int row =0;row<size[0];row++){
            board.add(inputService.readAsArrayString(""));
        }

        int lowestVal = Integer.MAX_VALUE;
        int blackStartVal = 0;
        int whiteStartVal = 0;

        for(int startRow=0;startRow<size[0]-7;startRow++){
            for(int startColumn=0;startColumn<size[1]-7;startColumn++){
                for(int row=0;row<8;row++){
                    for(int column=0;column<8;column++) {
                        if(!chessStartBlack.get(row)[column].equals(board.get(startRow+row)[startColumn+column])){
                            blackStartVal++;
                        }
                        if(!chessStartWhite.get(row)[column].equals(board.get(startRow+row)[startColumn+column])){
                            whiteStartVal++;
                        }
                    }
                }
                if(blackStartVal<lowestVal){
                    lowestVal = blackStartVal;
                }
                if(whiteStartVal<lowestVal){
                    lowestVal = whiteStartVal;
                }
            }
        }
        System.out.println(lowestVal);
    }

    public static List<String[]> createChessFrom(String color){
        List<String[]> chess = new ArrayList<>();
        if(color.equals("white")){
            for(int row=0;row<8;row++){
                chess.add(POSSIBLE_ROW.get(row%2));
                return chess;
            }
        }
        for(int row=0;row<8;row++){
            chess.add(POSSIBLE_ROW.get((row+1)%2));
            return chess;
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
