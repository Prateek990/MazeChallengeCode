package MazeChallenge;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class FormatMaze {

	private int life;
	private int numRow;
	private int numCol;
	
	private int[][] mat;
	
	// This function is to format the string
	public  ArrayList<String> formatMaze(String str, int life)
	{
		//str
		this.life = life;		
		numRow = Integer.parseInt(str.substring(str.indexOf('(') + 1, str.indexOf(',')));
		numCol = Integer.parseInt(str.substring(str.indexOf(',') + 1, str.indexOf(')')));
		
		String arr = str.substring(str.indexOf('[') + 1, str.indexOf(']'));
		
		// to check the input
		//System.out.println(arr);		
		
		mat = new int[numRow][numCol];
		return convertToMat(arr);
		
	}
	
	/* To convert input array string to a 2D matrix */
	private ArrayList<String> convertToMat(String str)
	{
		String[] arr = str.split(",");
		int count = 0;
		for(int i = 0; i < numRow; i++)
			for(int j = 0; j < numCol; j++)
			{
				mat[i][j] = Integer.valueOf(arr[count++]);
			}
		
		// A function to debug
		printMat();
		
		DecodeMaze r = new DecodeMaze(numRow, numRow, life);
		return r.decodeMatrix(mat);
	}
	
	/* To print integer values 2D matrix*/
	private void printMat()
	{
		//System.out.println(Arrays.deepToString(mat));
		for(int i = 0; i < numRow; i++)
		{
			for(int j = 0; j < numCol; j++)
			{
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
