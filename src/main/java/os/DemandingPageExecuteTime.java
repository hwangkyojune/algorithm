package os;

public class DemandingPageExecuteTime {
    // demanding page의 특성을 고려해 설계하면 시간의 차이가 얼마나 나는지 확인
    public static void main(String[] args) {

        int[][] arrayFillColumn = new int[10000][10000];

        long beforeTimeManyPageFault = System.currentTimeMillis();
        for (int j=0;j<10000;j++){
            for (int i=0;i<10000;i++){
                arrayFillColumn[i][j]=i+j;
            }
        }
        long afterTimeManyPageFault = System.currentTimeMillis();

        int[][] arrayFillRow = new int[10000][10000];

        long beforeTimeLessPageFault = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            for(int j=0;j<10000;j++){
                arrayFillRow[i][j] = i+j;
            }
        }

        long afterTimeLessPageFault = System.currentTimeMillis();

        System.out.println("row부터 차례로 채운 경우 : "+(afterTimeLessPageFault-beforeTimeLessPageFault));
        System.out.println("column부터 차례로 채운 경우 : " + (afterTimeManyPageFault-beforeTimeManyPageFault));
    }
}
