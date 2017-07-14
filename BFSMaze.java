package MazeChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//import MazeChallenge.RealMaze.Cell;

public class BFSMaze {


	int numRows;
	int numCols;
	int numLife;
	int startX;
	int startY;
	int endX;
	int endY;
	
	BFSMaze(int r, int c, int startX, int startY, int endX, int endY, int numLife)
	{
		this.numRows = r;
		this.numCols = c;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.numLife = numLife;		
	}
	
	boolean isValid(int row, int col)
	{
	    // return true if row number and column number
	    // is in range
	    return (row >= 0) && (row < numRows) &&
	           (col >= 0) && (col < numCols);
	}
	 
	// Hash map to store the prev connected cell
	private Map<Cell, Cell> prev = new HashMap<Cell, Cell>();
	
	// To find the shortest path use BFS 
	public ArrayList<String> BFS(Cell[][] mat)
	{
		boolean[][] visited = new boolean[numRows][numCols]; 
		
		visited[startX][startY] = true;
		Queue<Cell> q = new LinkedList<>();
		
		q.add(mat[startX][startY]);
		
		int count= 0;
		
		while(!q.isEmpty())
		{
			count++;
			
			Cell c = q.peek();
			
			if(c.isMine()) {
				count += 1;
                // Minus life if find mine
                --this.numLife;
            }		
			
			if(this.numLife > 0 )
			{
				 // If we have reached the destination cell,
		        if (c.isEnd() == true)
		        {
		          break;
		        }
		       
		        q.poll();
		        	        
		        int row = c.getX();
		        int col = c.getY();

		       // if adjacent cell is valid, has path and
		       // not visited yet, enqueue it.
		       if(c.isUp() && isValid(row - 1 , col) && !visited[row - 1][col])
		       {
		           // mark cell as visited and enqueue it
		           visited[row - 1][col] = true;
		           q.add(mat[row - 1][col]);
		           prev.put(mat[row - 1][col],c);
		        }     
		       if(c.isRight() && isValid(row, col + 1) && !visited[row][col + 1])
		       {
		           // mark cell as visited and enqueue it
		           visited[row][col + 1] = true;
		           q.add(mat[row][col + 1]);
		           prev.put(mat[row][col + 1],c );
		        }
		       if(c.isDown() && isValid(row + 1, col) && !visited[row + 1][col])
		       {
		           // mark cell as visited and enqueue it
		           visited[row + 1][col] = true;
		           q.add(mat[row + 1][col]);
		           prev.put(mat[row + 1][col], c);
		        }
		       if(c.isLeft() && isValid(row, col -1 ) && !visited[row][col - 1])
		       {
		           // mark cell as visited and enqueue it
		           visited[row][col - 1] = true;
		           q.add(mat[row][col - 1]);
		           prev.put(mat[row][col - 1],c);
		        }
			}
		}
		
		 LinkedList<Cell> directions = new LinkedList<Cell>();
		    for (Cell node = mat[endX][endY]; node != null; node = prev.get(node)) {
		        directions.add(node);
		    }
		    
		return printDirection(directions);
	}
	
	// Print the direction of movement
	private ArrayList<String> printDirection(LinkedList<Cell> d)
	{
		// Reverse the collection since head of the LinkedList in the destination
		Collections.reverse(d);
		
		ArrayList<String> path = new ArrayList<String>();
		
		// Check X and Y in the list to print the direstion of the movement
		for(int i = 0; i<d.size() - 1; i++)
		{
			if (d.get(i).getY() < d.get(i + 1).getY()) {
                System.out.print("Right->");
                path.add("'right'");
            }
			else
		       if (d.get(i).getX() < d.get(i + 1).getX()) {
		    	   System.out.print("Down->");
		    	   path.add("'down'");
		       }
		       else
		    	   if (d.get(i).getX() > d.get(i + 1).getX()) {
		    		   System.out.print("Up->");
		    		   path.add("'up'");
		    	   }
		    	   else
		    		   if (d.get(i).getY() > d.get(i + 1).getY()) {
		    			   System.out.print("Left->");
		    			   path.add("'left'");
		    		   }
		}
		
		return path;
	}
}
