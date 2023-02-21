package MarchDSA;

public class Day72 {
    public static void main(String[] args) {
        
        int mat[][]= {
            {1,3,5,7,8},{9,10,12,14,15},{17,19,20,22,24},{26,27,29,30,36}
        };
        displayMatrix(mat);
        finElement(mat,22);
        findEle(mat,22);  //shortest binery search 
    }

    private static void findEle(int[][] mat, int data) {
 
        int i=mat.length-1;
        int j=0;
     while(i>=0 && j<=mat.length-1){
        if(data == mat[i][j]){
            System.out.println("Found");
        }
        else if(data > mat[i][j]){
            i++;
        }else{
            j--;
        }
    }





    }

    private static void finElement(int[][] mat,int data) {

        //binary search approach

        for(int i=0;i<mat.length-1;i++){
            if(mat[i+1][0] > data){
                int idx=0;
                   while(idx < mat[i].length){
                    if(mat[i][idx] == data){
                        System.out.println("Found");
                        break;
                    }
                    idx++;
                    
                   }
                  

            }
            
        }
    }

    private static void displayMatrix(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }
    
}
