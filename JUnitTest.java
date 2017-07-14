package MazeChallenge;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;
//import junit.framework.Assert;

public class JUnitTest {

	  @org.junit.Test
	 public void testRun() throws Exception {
		  FormatMaze test = new FormatMaze();
          
		  String line = "(3,3)-[34,14,12,6,77,5,1,19,9]";
	      String line2 = "(3,3)-[9,14,12,6,77,5,1,19,34]";
	        ArrayList<String> mazeDirections1 = new ArrayList<>();
	        mazeDirections1.add("'up'");
	        mazeDirections1.add("'up'");
	        mazeDirections1.add("'left'");
	        test.formatMaze(line, 3);
	        Assert.assertEquals(mazeDirections1, test.formatMaze(line, 3));

	        ArrayList<String> mazeDirections2 = new ArrayList<>();
	        mazeDirections2.add("'right'");
	        test.formatMaze(line, 3);
	        Assert.assertEquals(mazeDirections2, test.formatMaze(line2, 3));
	    }

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}

}
