package baekjoon.minecraft;
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] ground;
    static int row;
    static int column;
    static int blockHaving;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer config = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(config.nextToken());
        column = Integer.parseInt(config.nextToken());
        blockHaving = Integer.parseInt(config.nextToken());

        ground = new int[row][column];

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for(int i=0;i<row;i++){
            StringTokenizer rowProducer = new StringTokenizer(bf.readLine());
            for(int j=0;j<column;j++){
                int height = Integer.parseInt(rowProducer.nextToken());
                if(height<minHeight){
                    minHeight = height;
                }
                if(height>maxHeight){
                    maxHeight =  height;
                }
                ground[i][j] = height;
            }
        }
        int minTime = Integer.MAX_VALUE;
        int groundHeight = minHeight;

        for(int heightToTrim=minHeight;heightToTrim<=maxHeight;heightToTrim++){
            int grossTime = calGrossTime(heightToTrim);
            if(grossTime<=minTime){
                minTime = grossTime;
                groundHeight = heightToTrim;
            }
        }
        System.out.println(minTime+" "+groundHeight);
    }

    public static int calGrossTime(int heightToTrim){
        int currentBlockNum = blockHaving;
        int grossTime = 0;
        for(int[] row:ground){
            for(int height:row){
                if(height>heightToTrim){
                    int numToDel = height-heightToTrim;
                    grossTime += numToDel*2;
                    currentBlockNum += numToDel;
                }
                else if(height<heightToTrim){
                    int numToAdd = heightToTrim - height;
                    grossTime += numToAdd;
                    currentBlockNum -= numToAdd;
                }
            }
        }
        if(currentBlockNum<0){
            return Integer.MAX_VALUE;
        }
        return grossTime;
    }
}
