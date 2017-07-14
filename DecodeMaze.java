package MazeChallenge;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DecodeMaze {
	
	private int numRows;
	private int numCols;
	private int numLife;
	private Cell[][] decodedMat;
	
	private final int UP_MASK = 1; 
	private final int RIGHT_MASK = 2;
	private final int DOWN_MASK = 4;
	private final int LEFT_MASK = 8;
	private final int START_MASK = 16;
	private final int END_MASK = 32;
	private final int MINE_MASK = 64;
	
	int startX = -1;
	int startY = -1;
	
	int endX = -1;
	int endY = -1;
	
	DecodeMaze(int R, int C, int numLife)
	{
		this.numLife = numLife;
		this.numRows = R;
		this.numCols = C;	
		decodedMat = new Cell[R][C];
	}
	
	// This function is to extract the information from the numeric matrix
	public ArrayList<String> decodeMatrix(int[][] mat)
	{
		for(int i = 0; i < numRows; i++)
			for(int j = 0; j < numCols; j++)
			{
				decodedMat[i][j] = setCellFeatures(mat[i][j], i ,j );
				if(decodedMat[i][j].isStart() == true)
				{
					startX = i;
					startY = j;
				}
				
				if(decodedMat[i][j].isEnd() == true)
				{
					endX = i;
					endY = j;
				}
				
			}
		
		//utilPrint();
		printUtil2();
		//BFSMaze(int r, int c, int startX, int startY, int endX, int endY, int numLife)
		BFSMaze b = new BFSMaze(numRows, numCols, startX, startY, endX, endY, numLife);	
		return b.BFS(decodedMat);

	}
	
	// Convert the numeric value to set of feature based on the set bits
	private Cell setCellFeatures(int num, int x, int y)
	{
		Cell c = new Cell();
		
		c.setX(x);
		c.setY(y);
		
		// Set up variable
		if((num & UP_MASK) == UP_MASK)
		{
		  c.setUp(true);
		}
		
		// Set right variable
		if((num & RIGHT_MASK) == RIGHT_MASK)
		{
			c.setRight(true);
		}
		
		// Set down variable
		if((num & DOWN_MASK) == DOWN_MASK)
		{
			c.setDown(true);
		}
		
		// Set left variable
		if((num & LEFT_MASK) == LEFT_MASK)
		{
			c.setLeft(true);
		}
		
		// Set start variable
		if((num & START_MASK) == START_MASK)
		{
			c.setStart(true);
		}
		
		// Set end variable
		if((num & END_MASK) == END_MASK)
		{
			c.setEnd(true);
		}
		
		// Set Mine variable
		if((num & MINE_MASK) == MINE_MASK)
		{
			 c.setMine(true);
		}
		
		return c;
	}
	
	/* Utility function to print the decoded Matrix */
	private void utilPrint()
	{
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				if(decodedMat[i][j].isStart())
				{
					System.out.print("S, ");
				}
				else
					if(decodedMat[i][j].isEnd())
					{
						System.out.print("E,");
					}
					else
						if(decodedMat[i][j].isMine())
						{
							System.out.print("M, ");
						}
						else
						{
							System.out.print("+, ");
						}
			}
			System.out.println();
		}
	}
	
	private void printUtil2()
	{
		// Make a dummy array of twice the size set blank where we cant move
		// Set X where left or right and up and down is allowed
		char[][] matrix = new char[(numRows * 2) + 1][(numCols * 2) + 1];
		 for(int i = 0; i < numRows; i++) {
	            for(int j = 0; j < numCols; j++) {
	                if (decodedMat[i][j].isStart()) {
	                	matrix[(i * 2) + 1][(j * 2) + 1] = 'S';
	                } else if (decodedMat[i][j].isEnd()) {
	                	matrix[(i * 2) + 1][(j * 2) + 1] = 'E';
	                } else if (!decodedMat[i][j].isMine()) {
	                	matrix[(i * 2) + 1][(j * 2) + 1] = 'X';
	                } else {
	                	matrix[(i * 2) + 1][(j * 2) + 1] = 'M';
	                }
	                if(decodedMat[i][j].isLeft()) {
	                	matrix[(i * 2) + 1][(j * 2)] = 'X';
	                }
	                if(decodedMat[i][j].isRight()) {
	                	matrix[(i * 2) + 1][(j * 2) + 2] = 'X';
	                }
	                if(decodedMat[i][j].isUp() && j > 0) {
	                	matrix[i * 2][(j * 2) + 1] = 'X';
	                }
	                if(decodedMat[i][j].isDown()) {
	                	matrix[(i * 2) + 2][(j * 2) + 1] = 'X';
	                }
	            }
	        }
		    // Print the new matrix
			for(int i = 0; i < numRows *2; i++)
			{
				for(int j = 0; j < numCols*2; j++)
				{
					System.out.print(matrix[i][j]);
				}
				System.out.println();
			}
	}	
}
