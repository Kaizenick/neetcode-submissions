class Solution {

    public static boolean BinarySearch(int[] array, int target){
        int i = 0;
        int j = array.length - 1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(array[mid]>target){
                j = mid - 1;
            }else if(array[mid]<target){
                i = mid + 1;
            }else if(array[mid] == target){
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        int mid = 0;
        while(i<=j){
            mid = i + (j-i)/2;
            if(matrix[mid][0]>target){
                j = mid - 1;
            }else if(matrix[mid][0]<target){
                i = mid + 1;
            }else if(matrix[mid][0] == target){
                return true;
            }
            int mid_now = mid;
        }
        if(j<0){
            return false;
        }

        return BinarySearch(matrix[j], target);

//        ------------ m + log(n) ---------------------
//        for(int i = matrix.length-1;i>=0; i--){
//            if(matrix[i][0]<=target){
//                return BinarySearch(matrix[i], target);
//            }
//        }
//        return false;

    }
}
