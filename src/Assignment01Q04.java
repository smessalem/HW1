import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (direction != 'L' && direction != 'R') {
            return array;
        }

        if (array.length == 0) {
            return array; // No need to shift an empty array
        }

        if (move < 0) {
            direction = (direction == 'L') ? 'R' : 'L'; // flip direction if move is negative
            move = -move; // Convert left shift to right shift
        }

        move = move % array.length; // Normalize the move value to be within the array length

        if (direction == 'L') {
            int[] temp = new int[move];
            System.arraycopy(array, 0, temp, 0, move);
            System.arraycopy(array, move, array, 0, array.length - move);
            System.arraycopy(temp, 0, array, array.length - move, move);
        } else if (direction == 'R') {
            int[] temp = new int[move];
            System.arraycopy(array, array.length - move, temp, 0, move);
            System.arraycopy(array, 0, array, move, array.length - move);
            System.arraycopy(temp, 0, array, 0, move);
        }


        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}