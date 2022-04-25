package com.example.maze;

public class suduko {
    public static boolean isvalid(int board[][],int num,int row,int col)
    {
        return isRowsafe(board,row,num) && isColsafe(board,col,num) && isThreeByThreesafe(board,num,row,col);
    }


    public static boolean isRowsafe(int board[][],int row,int num)
    {
        for (int i = 0; i < board.length; i++)
        {
            if(board[row][i] == num)
                return false;
        }
        return true;
    }

    public static boolean isColsafe(int board[][],int col,int num)
    {
        for (int i = 0; i < board.length; i++)
        {
            if(board[i][col] == num)
                return false;
        }
        return true;
    }

    //Obtain algorithm from this YouTube Video (4:07) Link: https://youtu.be/mcXc8Mva2bA and given to help by Jeffery
    public static boolean isThreeByThreesafe(int board[][],int num,int row,int col)
    {
        //To get the top left corner of the 3x3 box where the position is in...
        int localSecRow = row - row % 3;
        int localSecCol = col - col % 3;


        for (int i = localSecRow; i < localSecRow + 3; i++)
        {
            for (int j = localSecCol; j < localSecCol + 3; j++)
            {
                if(board[i][j] == num)
                    return false;

            }

        }

        return true;
    }
    public static void printBoard(int board[][])
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }


    public static boolean solve(int board[][],int row,int col){

        if(col >= board.length){
            col = 0;
            row++;
        }
        if (row >=board.length){
            return true;
        }
        int c[] = {1,2,3,4,5,6,7,8,9};
        if (board [row][col] != 0){
            return solve(board,row,col+1);
        }
        for (int y : c)
        {
            if (isvalid(board,y,row,col))
            {
                board[row][col]= y;
                if (solve(board,row,col+1)) {
                    return true;
                }else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void main (String[]args){
        ///board is taken from https://www.geeksforgeeks.org/program-sudoku-generator/ and 0 are empty place holders
            int board[][] =
                            {{3,8,5,0,0,0,0,0,0},
                             {9,2,1,0,0,0,0,0,0},
                             {6,4,7,0,0,0,0,0,0},
                             {0,0,0,1,2,3,0,0,0},
                             {0,0,0,7,8,4,0,0,0},
                             {0,0,0,6,9,5,0,0,0},
                             {0,0,0,0,0,0,8,7,3},
                             {0,0,0,0,0,0,9,6,2},
                             {0,0,0,0,0,0,1,4,5},
                    };
            System.out.println(solve(board,0,0));
            printBoard(board);
        }
    }
