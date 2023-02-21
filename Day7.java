package MarchDSA;

public class Day7 {
    public static void main(String[] args) {
        

        //matrix shell rotation

        int mat[][] = {
            {1,2,3,4,5,6,50},
            {7,8,9,10,11,12,60},
            {13,14,15,16,17,18,70},
            {19,20,21,22,23,24,80},
            {25,26,27,28,29,30,90},
            {31,32,33,34,35,36,100}
        };

        displayMatrix(mat);
        ringMatrix(mat,2,4);
    }

    private static void ringMatrix(int[][] mat,int s,int r) {
             
        int row = mat.length;
        int col = mat[0].length;
        System.out.println("Rows : "+row + "  Coloms :"+col);
    
        int rmin=s-1;
        int rmax=row-s;
        int cmin=s-1;
        int cmax=col-s;

        int idx=0;

        int ring[] = new int[2*(rmax-rmin)+2*(cmax-cmin)];

        //left
        System.out.println("Rleemnts in left : ");
        for(int i=rmin;i<=rmax;i++){
             ring[idx] = mat[i][cmin];
             System.out.print(ring[idx]+"  ");
             idx++;
        }

        //bottom
        cmin++;
        System.out.println("Rleemnts in bottom : ");
        for(int i=cmin;i<=cmax;i++){
            ring[idx] = mat[rmax][i];
            System.out.print(ring[idx]+"  ");
            idx++;
        }

        rmax--;
        System.out.println("Rleemnts in right  with rmax: "+rmax +" colmax : "+cmax+ "+ idx  : "+idx+ " size : "+ring.length);//(3,8,14)
        for(int i=rmax;i>=rmin;i--){
            ring[idx] =mat[i][cmax];
            System.out.print(ring[idx] + " ");
            idx++;

        }

        cmax--;
        System.out.println("Rleemnts in top : ");
        for(int i=cmax;i>rmin;i--){
            ring[idx]=mat[rmin][i];
            System.out.print(ring[idx]+ " ");
            idx++;
        }
      

        for(int i : ring){
            System.out.print(i+"--> ");
        }

        rotateMatrix(ring,2,4);
        System.out.println();

        modifyMatrix(mat,ring,2,4);
        //displayMatrix(mat);

    }

    private static void rotateMatrix(int[] ring, int s, int r) {
        System.out.println();
        for(int i : ring){
            System.out.print(i+" ");
        }

        int ptr1 = 0 ;
        int ptr2 = r-1; //3
        while(ptr1 < ptr2){
            swap(ring, ptr1, ptr2);
            ptr1++; ptr2--;
        }
        int ptr3=r;
        int ptr4=ring.length-1;
        while(ptr3 <= ptr4){
            swap(ring, ptr3, ptr4);
            ptr3++;
            ptr4--;
        }

        ptr1=0;ptr2=ring.length-1;
        while(ptr1 < ptr2){
            swap(ring, ptr1, ptr2);
            ptr1++;
            ptr2--;
        }
        

        System.out.println();
        for(int i : ring){
            System.out.print(i+" ");
        }

    }

    private static void swap(int[] ring, int i, int j) {

        int tmp = ring[i];
        ring[i]=ring[j];
        ring[j] = tmp;

    }

    private static void modifyMatrix(int[][] mat, int[] ring, int s, int r) {
  
        int row = mat.length;
        int col = mat[0].length;
        int rmin=s-1;
        int cmin=s-1;
        int rmax=row-s;
        int cmax=col-s;
        int idx = 0;
        //left
        for(int i=rmin;i<= rmax;i++){
            mat[i][cmin]=ring[idx];
            idx++;

        }
        //bottom

        cmin++;
        for(int i=cmin;i<= cmax;i++){
            mat[rmax][i]=ring[idx];
            idx++;
        }
 
        //right

        rmax--;
        for(int i=rmax;i<= rmin;i--){
            mat[i][cmax]=ring[idx];
            idx++;
        }

        //top
        cmax--;
        for(int i=cmax;i<cmin;i++){
            mat[rmin][i]=ring[idx];
            idx++;
        }
        //rotateMatrix(ring, s, rmax);

       displayMatrix(mat);

    }

    private static void displayMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("  "+mat[i][j]+" ");
                //System.out.format("  %d  ", mat[i][j]);
            }
            System.out.println("  ");
        }
    }
    
}
