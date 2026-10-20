class Solution {
    public void setZeroes(int[][] arr) {
        int n= arr.length, m = arr[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for(int i =0 ;i<n;i++){
            for(int j =0;j<m;j++){
              if(arr[i][j]==0){
                row[i]=true;
                col[j]=true;
              }  
            }
        }

        for(int i =0;i<n;i++){
            if(row[i]==true){
                for(int j=0;j<m;j++){
                    arr[i][j]=0;
                }
            }
        }
        for(int i =0;i<m;i++){
            if(col[i]==true){
                for(int j=0;j<n;j++){
                    arr[j][i]=0;
                }
            }
        }

        
    }
}