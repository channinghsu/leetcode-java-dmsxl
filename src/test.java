import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums ={-7,-3,2,3,11};
//        Array01_BinarySearch binarySearch = new Array01_BinarySearch();
//        System.out.println(binarySearch.search(nums,9));

//        Array02_RemoveElement removeElement = new Array02_RemoveElement();
//        System.out.println(removeElement.remove(nums,2));

        Array03_SquaresOfASortedArray squaresOfASortedArray = new Array03_SquaresOfASortedArray();
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(nums)));
    }
}
