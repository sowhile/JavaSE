/**
 * @author WangDa
 * @version 1.1
 * */

public class maze{
 	public static void main(String[] args){
        T t = new T();
        int arr[][] = new int[10][10];
        t.setArr(arr);
        t.printArr(arr);
        t.run(arr, 1, 1);
        t.printArr(arr);
 	}
 }

 class T{
    //�����Թ�
    public void setArr(int arr[][]){
        for(int i = 0; i < arr[0].length; i++){
            arr[0][i] = 1;
            arr[arr.length - 1][i] = 1;
        }
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = 1;
            arr[i][arr[0].length - 1] = 1;
        }
        arr[1][2] = 1;
        arr[2][2] = 1;
        arr[2][3] = 1;
        arr[2][5] = 1;
        arr[2][6] = 1;
        arr[3][6] = 1;
        arr[3][8] = 1;
        arr[4][2] = 1;
        arr[4][3] = 1;
        arr[4][4] = 1;
        arr[4][5] = 1;
        arr[5][5] = 1;
        arr[5][7] = 1;
        arr[6][3] = 1;
        arr[6][5] = 1;
        arr[7][3] = 1;
        arr[7][7] = 1;
        arr[8][3] = 1;
        arr[8][7] = 1;
    }

    //��ӡ�Թ�
    public void printArr(int arr[][]){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    /*
    * ���Թ���0��ʾ�����ߣ�û�߹�  1Χǽ  2�Ѿ��߹���·��  3��·
    * ���ԣ�
    * 
    */
    public boolean run(int arr[][], int i, int j){
        if(arr[arr.length - 2][arr[0].length - 2] == 2)
            return true;
        else{
            if(arr[i][j] == 0){
                arr[i][j] = 2;
                if(run(arr, i + 1, j))
                    return true;
                else if(run(arr, i, j + 1))
                    return true;
                else if(run(arr, i, j - 1))
                    return true;
                else if(run(arr, i - 1, j))
                    return true;
                else{
                    arr[i][j] = 3;
                    return false;
                }
            }
            else
                return false;
        }
    }
 }