public class SnakeArray {

    public static void fillArray(int[][] array) {
        boolean direction = false;
        int beginValue = 1;
        for (int z = 0; z < 10; z++, direction = (!direction)) {
            if (direction) {
                for (int i = 0, j = z; j >= 0; i++, j--)
                    array[i][j] = beginValue++;
            } else {
                for (int i = z, j = 0; i >= 0; i--, j++)
                    array[i][j] = beginValue++;
            }
        }

        for (int z = 1; z < 10; z++, direction = (!direction)) {
            if (direction) {
                for (int i = z, j = 10 - 1; j >= z; i++, j--)
                    array[i][j] = beginValue++;
            } else {
                for (int i = 10 - 1, j = z; i >= z; i--, j++)
                    array[i][j] = beginValue++;
            }
        }
    }

    public static void printArr(int[][] array) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                System.out.print(array[i][j] + " ");
            System.out.println("");
        }
    }
}
