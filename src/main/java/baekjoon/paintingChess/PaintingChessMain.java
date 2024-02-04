package baekjoon.paintingChess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/***
 * https://www.acmicpc.net/problem/1018
 * 다시 페인팅하기
 */
public class PaintingChessMain {
    public static void main(String[] args) {
        InputService inputService = new InputService();

        List<Integer> boardSize = inputService.asListInteger(" ");

        List<List<String>> board = new ArrayList<>();
        for(int i=0;i<boardSize.get(0);i++){
            board.add(inputService.asListString(""));
        }

        ChessBoardFinderToPaint chessBoardFinderToPaint = new ChessBoardFinderToPaint(board);

        Integer lowestVal = chessBoardFinderToPaint.calLowestPlace();

        System.out.println(lowestVal);
    }

    public static class ChessBoardCreator{
        private Integer rowSize;
        private Integer columnSize;
        private List<List<String>> possibleRows;

        public ChessBoardCreator(){
            rowSize = 8;
            columnSize = 8;
            possibleRows = new ArrayList<>();
            possibleRows.add(new ArrayList<>(Arrays.asList("W","B","W","B","W","B","W","B")));
            possibleRows.add(new ArrayList<>(Arrays.asList("B","W","B","W","B","W","B","W")));
        }

        public Integer getRowSize(){
            return rowSize;
        }

        public Integer getColumnSize(){
            return columnSize;
        }

        public List<List<String>> getStartWithWhite(){
            List<List<String>> boardStartWithWhite = new ArrayList<>();
            for(int i=0;i<rowSize;i++){
                boardStartWithWhite.add(possibleRows.get(i%2));
            }
            return boardStartWithWhite;
        }

        public List<List<String>> getStartWithBlack(){
            List<List<String>> boardStartWithBlack = new ArrayList<>();
            for(int i=0;i<rowSize;i++){
                boardStartWithBlack.add(possibleRows.get((i+1)%2));
            }
            return boardStartWithBlack;
        }
    }
    public static class ChessBoardFinderToPaint{
        List<List<String>> board;
        ChessBoardCreator chessBoardCreator;

        public ChessBoardFinderToPaint(List<List<String>> board){
            this.board = board;
            chessBoardCreator = new ChessBoardCreator();
        }

        public Integer calLowestPlace(){
            Integer tempLowestVal = Integer.MAX_VALUE;
            for(int startRow=0;startRow<(board.size()-chessBoardCreator.getRowSize()+1);startRow++){
                for(int startColumn=0;startColumn<(board.get(startRow).size()-chessBoardCreator.getRowSize()+1);startColumn++){
                    Integer val = calPlace(startRow,startColumn);
                    if(tempLowestVal>val){
                        tempLowestVal = val;
                    }
                }
            }

            return tempLowestVal;
        }


        public Integer calPlace(Integer startRow,Integer startColumn){
            List<List<String>> boardStartWithWhite = chessBoardCreator.getStartWithWhite();
            List<List<String>> boardStartWithBlack = chessBoardCreator.getStartWithBlack();

            Integer valStartWhite = 0;
            Integer valStartBlack = 0;

            for(int chessRow=0;chessRow<chessBoardCreator.getRowSize();chessRow++){
                for(int chessColumn=0;chessColumn<chessBoardCreator.getColumnSize();chessColumn++){
                    if(!board.get(startRow+chessRow).get(startColumn+chessColumn).equals(boardStartWithBlack.get(chessRow).get(chessColumn))){
                        valStartBlack++;
                    }
                    if(!board.get(startRow+chessRow).get(startColumn+chessColumn).equals(boardStartWithWhite.get(chessRow).get(chessColumn))){
                        valStartWhite++;
                    }
                }
            }

            if(valStartWhite>valStartBlack){
                return valStartBlack;
            }
            return valStartWhite;
        }
    }

    public static class ChessService{
        private List<List<String>> board;
        public ChessService(List<List<String>> board){
            this.board = board;
        }

        public String getDifferentValue(String currentColor){
            if(currentColor.equals("B")){
                return "W";
            }
            return "B";
        }

        public Integer lowestValueToPaint(){
            int tempLowest=Integer.MAX_VALUE;
            for(int i =7;i<board.size();i++){
                for(int j=7;j<board.get(i).size();j++){

                    List<List<String>> candidateBoard = sliceBoard(i,j);

                    Integer placeToPaintReverse = calculatePlaceToPaintReverse(candidateBoard);

                    Integer placeToPaint = calculatePlaceToPaint(candidateBoard);
                    if(placeToPaintReverse<placeToPaint){
                        placeToPaint = placeToPaintReverse;
                    }
                    if(placeToPaint<tempLowest){
                        tempLowest = placeToPaint;
                    }
                }
            }
            return tempLowest;
        }

        public List<List<String>> sliceBoard(int lastRow, int lastColumn){
            List<List<String>> candidateBoard = new ArrayList<>();
            for(int i=(lastRow-7);i<lastRow+1;i++){
                candidateBoard.add(board.get(i).subList(lastColumn-7,lastColumn+1));
            }
            return candidateBoard;
        }

        public Integer calculatePlaceToPaintReverse(List<List<String>> candidateBoard){
            int tempPlaceToPaint = 0;
            String currentColor = candidateBoard.get(7).get(7);
            String downColor = getDifferentValue(currentColor);
            String beforeColor = "";
            for(int row=7;row>=0;row--){
                for(int column=7;column>=0;column--){
                    currentColor = candidateBoard.get(row).get(column);
                    if((column%8)==7){

                        if(currentColor.equals(downColor)){
                            tempPlaceToPaint++;
                            downColor = getDifferentValue(currentColor);
                            beforeColor = getDifferentValue(currentColor);
                        }
                        else{
                            beforeColor = currentColor;
                            downColor = currentColor;
                        }
                    }
                    else{
                        if(currentColor.equals(beforeColor)){
                            tempPlaceToPaint++;
                            beforeColor = getDifferentValue(currentColor);
                        }
                        else {
                            beforeColor = currentColor;
                        }
                    }
                }
            }
            return tempPlaceToPaint;
        }

        public Integer calculatePlaceToPaint(List<List<String>> candidateBoard){
            String currentColor = candidateBoard.get(0).get(0);
            String upColor = getDifferentValue(currentColor);
            String beforeColor = "";
            Integer tempPlaceToPaint = 0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    currentColor = candidateBoard.get(i).get(j);
                    //첫번째 열인 경우 위의 값만 비교
                    if((j%8)==0){
                        if(upColor.equals(currentColor)){
                            tempPlaceToPaint++;
                            upColor = getDifferentValue(currentColor);
                            beforeColor = getDifferentValue(currentColor);
                        }
                        else{
                            beforeColor = currentColor;
                            upColor = currentColor;
                        }
                    }
                    //아닌 경우 왼쪽 값과 비교
                    else{
                        if(beforeColor.equals(currentColor)){
                            tempPlaceToPaint++;
                            beforeColor = getDifferentValue(currentColor);
                        }
                        else{
                            beforeColor = currentColor;
                        }
                    }

                }
            }

            return tempPlaceToPaint;
        }
    }

    public static class InputService{

        private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        public List<Integer> asListInteger(String reg){
            return asListString(reg).stream()
                    .map(Integer::parseInt).collect(Collectors.toList());
        }

        public List<String> asListString(String reg){
            String string= new String();
            try{
                string = bf.readLine();
            }catch (Exception e){
                e.printStackTrace();
            }
            return new ArrayList<>(Arrays.asList(string.split(reg)));
        }

    }
}
