package Hello;

import java.util.Scanner;

public class Hello {

	public static void printBoard(int[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				System.out.print(board[row][col]+ " ");
			}
			System.out.println("");
		}
	}

	public static int compMove()
	{
		int x = (int)((Math.random()*7));
		return x;
	}

	public static int userMove()
	{
		Scanner myscan = new Scanner(System.in);
		System.out.println("Choose a column(1-7)");
		int x = myscan.nextInt();
		myscan.close();
		return x-1;
	}
	
	public static boolean checkWinPlayer(int[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length-4; col++)
			{
				if(board[row][col] == 1 && board[row][col+1] == 1 && board[row][col+2] == 1 && board[row][col+3] == 1)
					return true;
			}
		}
		
		for (int col = 0; col < board[0].length; col++)	
		{
			for (int row = 0; row < board.length-3; row++)
			{
				if(board[row][col] == 1 && board[row+1][col] == 1 && board[row+2][col] == 1 && board[row+3][col] == 1)
					return true;
			}
		}
		return false;
	}
	
	public static boolean checkWinComputer(int[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length-4; col++)
			{
				if(board[row][col] == 2 && board[row][col+1] == 2 && board[row][col+2] == 2 && board[row][col+3] == 2)
					return true;
			}
		}
		
		for (int col = 0; col < board[0].length; col++)
		{
			for (int row = 0; row < board.length-3; row++)
			{

				if(board[row][col] == 2 && board[row+1][col] == 2 && board[row+2][col] == 2 && board[row+3][col] == 2)
					return true;
			}
		}
		return false;
	}
	
	public static void updateBoard(int col, int[][] board, int player)
	{
		for (int row = 5; row > -1; row--)
		{
			if(board[row][col] == 0)
			{
				board[row][col] = player;
				break;
			}
		}		
	}
	
	public static void main(String[] args) {
		
		
		int[][] board = new int[6][7];
		
		printBoard(board);
		while(checkWinPlayer(board) == false && checkWinComputer(board) == false)
		{
			int player = 1;
			updateBoard(userMove(), board, player);
			printBoard(board);
			System.out.println("");
			
			player = 2;
			int temp = compMove();
			System.out.println("The computer's move is in column " + (temp+1) + "\n");
			
			updateBoard(temp,board, player);			
			printBoard(board);
			
			checkWinPlayer(board);
			checkWinComputer(board);
			
			if(checkWinPlayer(board) == true)
			{
				System.out.println("You won");
				break;
			}
			if(checkWinComputer(board))
			{
				System.out.println("You lost");
				break;
			}
		}

		
	}

}