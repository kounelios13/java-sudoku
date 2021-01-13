package Interfaces;

public interface SolverInterface {

	//creates square groups to make solving easier
	public int[][] createSquares(int width,int height,int[][] rows_array);
	//returns true if all the squares are correct
	public boolean checkSquares(int[][] squares_array);
	//check that each row has unique numbers , returns true if correct
	public boolean checkRows(int [][] rows_array);
	//check that each column has unique numbers , returns true if correct
	public boolean checkColumns(int [][] columns_array);
	//get final result , true = correct , false = incorrect
	public boolean getResult(int [][] rows_array,int[][] col_array);
}
