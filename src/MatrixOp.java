import java.util.Scanner;

public class MatrixOp {
    public static void main(String[] args) {
        //variables
        int[][] matrixOne;
        int[][] matrixTwo;
        int[][] matrixThree;
        Scanner keyboard = new Scanner(System.in);
        boolean print = false;
        String printResponse;
        char printResponseChar;
        int heightInputOne;
        int widthInputOne;
        int heightInputTwo;
        int widthInputTwo;
        String operation;
        char response;
        int partialSum;
        //check if user would like matrices printed to console after entering them
        System.out.println("Would you like each matrix to be printed to the console? >>> ");
        printResponse = keyboard.nextLine();
        printResponseChar = printResponse.charAt(0);
        if (printResponseChar == 'y' || printResponseChar == 'Y') {
            print = true;
        }
        // create matrix one
        System.out.println("Enter height for matrix one >>> ");
        heightInputOne = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter width for matrix one >>> ");
        widthInputOne = keyboard.nextInt();
        keyboard.nextLine();
        matrixOne = new int[heightInputOne][widthInputOne];
        //create matrix two
        System.out.println("Enter height for matrix two >>> ");
        heightInputTwo = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter width for matrix two >>> ");
        widthInputTwo = keyboard.nextInt();
        keyboard.nextLine();
        matrixTwo = new int[heightInputTwo][widthInputTwo];
        // fill matrix one
        for (int i = 0; i < heightInputOne; i++) {
            for (int j = 0; j < widthInputOne; j++) {
                System.out.println("Enter a value for matrix one, position [" + i + "][" + j + "] >>> ");
                matrixOne[i][j] = keyboard.nextInt();
                keyboard.nextLine();
            }
        }
        if (print) {
            printMatrix(matrixOne, heightInputOne, widthInputOne);
        }
        //fill matrix two
        for (int i = 0; i < heightInputTwo; i++) {
            for (int j = 0; j < widthInputTwo; j++) {
                System.out.println("Enter a value for matrix two, position [" + i + "][" + j + "] >>> ");
                matrixTwo[i][j] = keyboard.nextInt();
                keyboard.nextLine();
            }
        }
        if (print) {
            printMatrix(matrixTwo, heightInputTwo, widthInputTwo);
        }
        //choose operation
        System.out.println("Choose an operation. (mult/add) >>> ");
        operation = keyboard.nextLine();
        response = operation.charAt(0);
        //addition
        if (response == 'a') {
            //check dimensions for equality
            if (heightInputOne != heightInputTwo || widthInputOne != widthInputTwo) {
                System.out.println("Cannot add matrices with different dimensions.");
            }
            else {
                matrixThree = new int[heightInputOne][widthInputOne];
                for (int i = 0; i < heightInputOne; i++) {
                    System.out.print("[");
                    for (int j = 0; j < widthInputOne; j++) {
                        matrixThree[i][j] = matrixOne[i][j] + matrixTwo[i][j];
                        System.out.print(matrixThree[i][j] + " ");
                    }
                    System.out.println("]");
                }
            }
        }
        //multiplication
        else if (response == 'm') {
            //check if dimensions are appropriate for multiplication
            if (widthInputOne != heightInputTwo) {
                System.out.println("Invalid dimensions.");
            }
            else {
                matrixThree = new int[heightInputOne][widthInputTwo];
                //code cycles in order: height two, height one, width two
                for (int i = 0; i < widthInputTwo; i++) {
                    for (int j = 0; j < heightInputOne; j++) {
                        //addition of components
                        partialSum = 0;
                        for(int k = 0; k < heightInputTwo; k++) {
                            partialSum += (matrixOne[j][k]*matrixTwo[k][i]);
                        }
                        matrixThree[j][i] = partialSum;
                    }
                }
                printMatrix(matrixThree, heightInputOne, widthInputTwo);
            }
        }
        else {
            System.out.println("Invalid operation.");
        }
    }
    public static void printMatrix(int[][] matrix, int height, int width) {
        for (int i = 0; i < height; i++) {
            System.out.print("[ ");
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
