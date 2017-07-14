package MazeChallenge;

public class Cell {

	/* A cell can has foolowing features */
	
	private boolean up = false;
	private boolean right = false;
	private boolean down = false;
	private boolean left = false;
	private boolean start = false;
	private boolean end = false;
	private boolean mine = false;
	private int x = -1;
	private int y = -1;
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setUp(boolean status)
	{
		this.up = status;
	}
	
	public void setRight(boolean status)
	{
		this.right = status;
	}
	
	public void setLeft(boolean status)
	{
		this.left = status;
	}
	
	public void setDown(boolean status)
	{
		this.down = status;
	}
	
	public void setStart(boolean status)
	{
		this.start = status;
	}
	
	public void setEnd(boolean status)
	{
		this.end = status;
	}
	
	public void setMine(boolean status)
	{
		this.start = status;
	}
	
	public boolean isStart()
	{
		return this.start;
	}
	
	public boolean isEnd()
	{
		return this.end;
	}
	
	public boolean isMine()
	{
		return this.mine;
	}
	
	public boolean isLeft()
	{
		return this.left;
	}
	
	public boolean isRight()
	{
		return this.right;
	}
	
	public boolean isUp()
	{
		return this.up;
	}
	
	public boolean isDown()
	{
		return this.down;
	}
	
	/*
		UP = 1
		RIGHT = 2
		DOWN = 4
		LEFT = 8
		START = 16
		END = 32
		MINE = 64
	*/
}
