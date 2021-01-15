package SudokuGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuButtonsListener implements ActionListener{

	//Squares array
	int[][] squares_arr;
	
	//buttons that we are gonna listen for
    JButton solve_button;
    JButton newGame_button;
    JButton hint_button;
    JButton reset_button;
    JButton history_button;
    
    public MenuButtonsListener(JButton solve,JButton newGame,JButton hint,JButton reset,JButton history,int[][] squares_arr)
    {
    	solve_button = solve;
    	newGame_button = newGame;
    	hint_button = hint;
    	reset_button = reset;
    	history_button = history;
    	this.squares_arr = squares_arr;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == solve_button)
		{
			for(int i=0;i<squares_arr.length;i++)
			{
				System.err.println("--Tetragwno noumero [" + i + "]");
				for(int j=0;j<squares_arr.length;j++)
				{
					System.err.print(String.valueOf(squares_arr[i][j] + " "));
				}
			}
		}
		else if(e.getSource() == newGame_button)
		{
			
		}
		else if(e.getSource() == hint_button)
		{
			
		}
		else if(e.getSource() == reset_button)
		{
			
		}
		else if(e.getSource() == history_button)
		{
			
		}
		else
		{
			return;
		}
	}

}