
public class test {
    public static void main(String[] args) {
        int[] nums ={2,3,1,2,4,3};
//        Array01_Binary_Search binarySearch = new Array01_Binary_Search();
//        System.out.println(binarySearch.search(nums,9));
//
//        Array02_Remove_Element removeElement = new Array02_Remove_Element();
//        System.out.println(removeElement.remove(nums,2));

//        Array03_Squares_Of_A_Sorted_Array squaresOfASortedArray = new Array03_Squares_Of_A_Sorted_Array();
//        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(nums)));

//        Array04_Minimum_Size_Subarray_Sum array04 = new Array04_Minimum_Size_Subarray_Sum();
//        System.out.println(array04.minSubArrayLen(nums,7));
        Array05_Spiral_Matrix_II spiral_matrix_ii = new Array05_Spiral_Matrix_II();
        int n = 5;
        int[][] mitrax =spiral_matrix_ii.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mitrax[i][j]+" ");
            }
            System.out.println();
        }
    }
}
