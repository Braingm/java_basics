
public class TwoDimensionalArray {

    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] result = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == i || j == (size - 1) - i)
                    result[i][j] = symbol;
                else {
                    result[i][j] = ' ';
                }
            }
        }

        return result;
    }
}
