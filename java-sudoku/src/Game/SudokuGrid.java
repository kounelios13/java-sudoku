package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SudokuGrid {

	//set font to be used inside squares
	Font font1 = new Font("SansSerif", Font.BOLD, 23);
	
	//number of squares
	int horizontal_squares,vertical_squares;
	
	//number of rows and columns
	int inner_rows,inner_cols;
	
    public SudokuGrid(int horizontal_squares,int inner_rows,int vertical_squares,int inner_cols) {
    	
    	//set base variables
    	//needed to construct grid
        this.horizontal_squares = horizontal_squares;
        this.vertical_squares = vertical_squares;
        this.inner_rows = inner_rows;
        this.inner_cols = inner_cols;
        
        //invoke swing runnable
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	//try to set default look and feel
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }
                //create base frame
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
               
                //add game board
                frame.add(new SudokuBoard());
                
                //add menu grid
                frame.add(new MenuPane(), BorderLayout.AFTER_LINE_ENDS);
                
                //pack components on frame
                frame.pack();
                
                //frame properties
                frame.setMinimumSize(new Dimension(800,600));
                frame.setTitle("S U D O K U");
        		frame.setLocationRelativeTo(null);
        		
        		//show frame
                frame.setVisible(true);
            }
        });
    }

    public class MenuPane extends JPanel {

    	//options menu
    	
        public MenuPane() {
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setLayout(new GridBagLayout());
            
            //gridbagconstraints is the easiest way to stack buttons in swing
            
            GridBagConstraints gbc = new GridBagConstraints();
            
            //GBC properties
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            //adding buttons to menu on the y axis
            add(new JButton("Solve"), gbc);
            gbc.gridy++;
            add(new JButton("New"), gbc);
            gbc.gridy++;
            add(new JButton("Hint"), gbc);
            gbc.gridy++;
            add(new JButton("Reset"), gbc);
            gbc.gridy++;
            add(new JButton("History"), gbc);
        }
    }

    @SuppressWarnings("serial")
	public class SudokuBoard extends JPanel {

    	//outer board panel
    	
        public int ROWS = horizontal_squares;
        public int COLUMNS = vertical_squares;

        private SubBoard[] subBoards;

        public SudokuBoard() {
            setBorder(new EmptyBorder(4, 4, 4, 4));
            subBoards = new SubBoard[ROWS * COLUMNS];
            setLayout(new GridLayout(ROWS, COLUMNS, 2, 2));
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLUMNS; col++) {
                    int index = (row * ROWS) + col;
                    SubBoard board = new SubBoard();
                    board.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 3), new EmptyBorder(4, 4, 4, 4)));
                    subBoards[index] = board;
                    add(board);
                }
            }
        }
    }

    public class SubBoard extends JPanel {

    	//inner board panel
    	
        public int ROWS = inner_rows;
        public int COLUMNS = inner_cols;

        private JTextField[] fields;

        public SubBoard() {
            setLayout(new GridLayout(ROWS, COLUMNS, 2, 2));
            fields = new JTextField[ROWS * COLUMNS];
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLUMNS; col++) {
                    int index = (row * COLUMNS) + col;
                    JTextField field = new JTextField(4);
                    field.setHorizontalAlignment(JTextField.CENTER);
                    field.setFont(font1);
                    fields[index] = field;
//                    field.setText(Integer.toString(index));
                    add(field);
                }
            }
        }
    }
}
