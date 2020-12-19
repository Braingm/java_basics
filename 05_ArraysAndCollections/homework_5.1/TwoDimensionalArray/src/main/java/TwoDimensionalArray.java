public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] result = new char[size][size];

        for (int i = 0; i < size ; i++){
            for (int j = 0; j < size; j++){
                if (j == i || j == (size-1) - i)
                    result[i][j] = symbol;
                else {
                    result[i][j] = ' ';
                }
            }
        }

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return result;
    }
}
