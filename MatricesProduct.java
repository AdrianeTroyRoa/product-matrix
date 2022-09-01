/*
 * CODE BY:
 * Adriane Troy V. Roa
*/
import java.util.Scanner;

class MatricesProduct{

    //initializing and declaring (some) dataholders to be used later
    int row[] = new int[2];
    int col[] = new int[2];
    int matrixA[][];
    int matrixB[][];
    int dimIndex;
    boolean inputNotDone;
   
    //declaring the main method that implements the contents of the constructor
    public static void main(String[] args){
        new MatricesProduct();
    }

    //constructor generalizing the step-by-step process of multiplying the matrices
    MatricesProduct(){
        rowsAndColumns();
        int rowA = this.row[0];
        int colA = this.col[0];
        valuesOfMatrixA(rowA, colA);

        //special condition to stop the process if an error takes place in rowsAndColumns method
        if(inputNotDone)
            return;

        rowsAndColumns();
        int rowB = this.row[1];
        int colB = this.col[1];
        valuesOfMatrixB(rowB, colB);
        multiplyMatrices();
    }
    
    //method for configuring the number of rows and columns
    public void rowsAndColumns(){
        inputNotDone = true;
        String[] dimensions = {"",""};
        char[] integers = {'0','1','2','3','4','5','6','7','8','9'};
        short index = 0;

        if(dimIndex == 0)
            System.out.println("Please enter the number of rows and columns of Matrix A and its values");
        else
            System.out.println("Please enter the number of rows and columns of Matrix B and its values");

        Scanner in = new Scanner(System.in);
        String rowAndColumn = in.nextLine();
        for(char i: rowAndColumn.toCharArray()){
            if(i == '-')
                dimensions[index] += i;
            else if(i == ' '){
                if(!(dimensions[index].equals(""))){
                    index++;
                }
                continue;
            }
            for(int j=0; j<integers.length; j++){
                if(i == integers[j]){
                    dimensions[index] += i;
                }
            }
        }

        //involving try-catch statements for possible error handling
        try{
            row[dimIndex] = Integer.parseInt(dimensions[0]);
            col[dimIndex] = Integer.parseInt(dimensions[1]);
        }
        catch(NumberFormatException e){
            row[dimIndex] = 0;
            col[dimIndex] = 0;
            System.out.println("invalid row or column number");
            return;
        }
        finally{
            dimIndex++;
        }
        inputNotDone = false;
    }

    //method to facilitate the values of Matrix A
    public void valuesOfMatrixA(int row, int col){
        matrixA = new int[row][col];
        Scanner in = new Scanner(System.in);
        String[] theVals = new String[col];

        for(int i = 0; i<theVals.length; i++){
            theVals[i] = "";
        }

        for(int i = 0; i<row; i++){
            String values = in.nextLine();
            char[] integers = {'0','1','2','3','4','5','6','7','8','9'};
            char[] valArray = values.toCharArray();
            short index = 0;
            for(char j: valArray){
                if(j == '-')
                    theVals[index] += j;
                else if(j == ' '){
                    if(!(theVals[index].equals(""))){
                        index++;
                    }
                    continue;
                }
                for(int k=0; k<integers.length; k++){
                    if(j == integers[k]){
                        theVals[index] += j;
                    }
                }
            }

            //facilitate possible inputs with error
            try{
                for(int j = 0; j<col; j++){
                    matrixA[i][j] = Integer.parseInt(theVals[j]);
                }
            }
            catch(NumberFormatException e){
                System.out.println("invalid row or column number");
                return;
            }

            //clearing theVals array for the next loop
            for(int j = 0; j<theVals.length; j++){
                theVals[j] = "";
            }
        }
    }

    //method that facilitates values inputted for Matrix B (similar implementation with that of Matrix A)
    public void valuesOfMatrixB(int row, int col){
        matrixB = new int[row][col];
        Scanner in = new Scanner(System.in);
        String[] theVals = new String[col];

        for(int i = 0; i<theVals.length; i++){
            theVals[i] = "";
        }

        for(int i = 0; i<row; i++){
            String values = in.nextLine();
            char[] integers = {'0','1','2','3','4','5','6','7','8','9'};
            char[] valArray = values.toCharArray();
            short index = 0;
            for(char j: valArray){
                if(j == '-')
                    theVals[index] += j;
                else if(j == ' '){
                    if(!(theVals[index].equals(""))){
                        index++;
                    }
                    continue;
                }
                for(int k=0; k<integers.length; k++){
                    if(j == integers[k]){
                        theVals[index] += j;
                    }
                }
            }

            try{
                for(int j = 0; j<col; j++){
                    matrixB[i][j] = Integer.parseInt(theVals[j]);
                }
            }
            catch(NumberFormatException e){
                System.out.println("invalid row or column number");
                return;
            }

            for(int j = 0; j<theVals.length; j++){
                theVals[j] = "";
            }
        }
    }

    //method that performs the actual multiplication of matrices
    public void multiplyMatrices(){
        int row;
        int col;

        //try-catch statements in case of unexpected errors in datahandling
        try{
            row = matrixA.length;
            col = matrixB[0].length;
        }
        catch(Exception e){
            System.out.println("Invalid inputs.");
            return;
        }

        int[][] productMatrix = new int[row][col];

        System.out.println("The product matrix:");
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                for(int k = 0; k<matrixB.length; k++){
                    productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                System.out.print(productMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
