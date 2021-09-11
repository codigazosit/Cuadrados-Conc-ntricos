import java.util.InputMismatchException;
import java.util.Scanner;

public final class CuadradosConcentricos {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("*** *** Cuadrado dinámico *** ***");

        try {
            int size = requestNumber();

            String character = requestCharacter();

            size = validateSize(size);

            String[][] square = new String[size][size];

            createSquare(character, square);

            showMatrix(square);
        } catch (InputMismatchException ex) {
            System.out.println("Error, el valor debe ser un número.");
        }
    }

    private static int requestNumber() throws InputMismatchException {
        System.out.println("Ingresa el tamaño del cuadrado:");
        int tamaño = scanner.nextInt();
        scanner.nextLine();
        if (tamaño > 0)
            return tamaño;
        return -1;
    }

    private static String requestCharacter() {
        System.out.println("Ingresa el caracter para crear el cuadrado (Por defecto: *)");

        String caracter = scanner.nextLine();

        return getFirstCharacter(caracter);
    }

    private static String getFirstCharacter(String string) {
        String symbol = "*";
        if (string.length() > 0) {
            symbol = "" + string.charAt(0);
        }
        return symbol;
    }

    private static int validateSize(int size) {
        if (size % 2 == 0) {
            size++;
            System.out.println("Nota: el valor ha sido modificado a: " + size + "\n");
        }
        return size;
    }

    private static void createSquare(String symbol, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                fillMatrixHorizontal(matrix, i, symbol);
                fillMatrixVertical(matrix, i, symbol);
            }
        }
    }

    private static void fillMatrixHorizontal(String[][] matrix, int index, String symbol) {
        if ((matrix.length - index) > index) {
            for (int i = index; i < (matrix.length - index); i++) {
                matrix[index][i] = symbol;
            }
        } else {
            for (int i = (matrix.length - index - 1); i <= index; i++) {
                matrix[index][i] = symbol;
            }
        }
    }

    private static void fillMatrixVertical(String[][] matrix, int index, String symbol) {
        if ((matrix.length - index) > index) {
            for (int i = index; i < (matrix.length - index); i++) {
                matrix[i][index] = symbol;
            }
        } else {
            for (int i = (matrix.length - index - 1); i <= index; i++) {
                matrix[i][index] = symbol;
            }
        }
    }

    private static void showMatrix(String[][] matrix) {
        for (String[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (chars[j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(chars[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
