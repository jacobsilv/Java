import processing.core.PApplet;
import processing.core.PImage;
/**
 * Recursion Homework Assignment
 * 
 * For this assignment I used three different recursion methods that 
 * each do a different task and are layered properly to make an interesting image.
 * the background is a rectangle recursion method calling itself three times each time.
 * The rectangles branch from the top left corner down
 * The triangle image is just a practice method for recursion.
 * It uses an image to generate recursion that constantly places the image
 * in the opposite quadrant by taking the negative location of the previous triangle.
 * The Sierpinski Triangle has three calls each calling the recursion three times
 * this causes the triangles to draw three triangles around each one.
 * The algorithm is set to calculate half the distance from the previous x and y
 * 
 * 
 * the number of recursions should not exceed 5 or the run speed will be too slow
 * 
 * 
 * @author Jacob Silverman
 * Masrour Basith
 * https://processing.org/reference/line_.html
 * http://www.cs.princeton.edu/courses/archive/fall12/cos126/assignments/sierpinski.html
 * http://www.cis.upenn.edu/~cis110/13sp/hw/hw03/sierpinski.shtml
 * http://lodev.org/cgtutor/sierpinski.html#With_a_Random_Function_
 * 
 */
@SuppressWarnings("serial")
public class Picasso extends PApplet {
	
	
	//depth is the number of recursive steps 
	int depth = 5;
	// recursive steps for the subImage recursion
	int depthOfImage = 6;
	//number of recursions
	
	// window size
	private final int START_SIZE = 700;
	// changes the width and height slightly
	private final int SIZE_FORMATER = 10;
	private final float HALF = (float) 0.50;
	PImage image = loadImage ("Trippy_tri.png");
	
	// initialize the colors at low values
	int red = 1;
	int green = 1;
	int blue = 1;
	
	// x and y coordinates of the mouse
	int xPos;
	int yPos;
	
	/**
	 * basic setup
	 */
	public void setup() {
		
	    size(START_SIZE, START_SIZE);
	    background(255); 
	} 
	
	/**
	 * draw all the recursions
	 */
	public void draw() {
		// sets positions to mouse coordinates
		xPos = mouseX;
		yPos = mouseY;
		
		background(255);
		

	    // calls the recursive method for Branching Triangle with initialized parameters
	    drawSierpinskiRectangle(1, red*2, green*xPos, blue*yPos, 0, 0, width - 100, height - 1);
	    
	    
	    // calls the recursive method for Sierpinki Triangles with initialized parameters
	    drawSierpinskiTriangle ( red*xPos, green*yPos, blue*2, SIZE_FORMATER, height - SIZE_FORMATER, // x1 & y1 initialized
	    		height - SIZE_FORMATER, height - SIZE_FORMATER, // x2 & y2 initialized
	    		width / 2, SIZE_FORMATER); // x3 & y3 initialized
		
	    
	    // calls the recursive method for triangle image with initialized parameters
	    subImage (1, xPos, yPos, 150);
	    
	    
	    
	    // have exclamation mark at the top of the triangle
	    textSize(30);
	    textAlign(CENTER);
	    fill(255);
	    
	    // has the coordinates of the text right at the top of the triangle
	    text("!", width/2+1, 75);
	}
	
	
	/**
	 * recursively draws an image of a triangle up ward
	 * 
	 * @param n how many recursive steps
	 * @param imageX the x position of the image
	 * @param imageY the y position of the image
	 * @param size is width and height of the image. (square)
	 */
	void subImage(int n, float imageX, float imageY, float size) {
		
		// sets image to be centered and displays images at initial setting
		imageMode(CENTER);
		image(image, imageX, imageY , size, size);
	    loadPixels();
	    
		// as long as depth is greater than 1
		if (n < depthOfImage){
			
				//calls the recursion of subImage increased by one
				// the x coordinates don't change only the y
				// size decreases
				subImage ( n+1, (-imageX-imageX*HALF+imageX/3)+START_SIZE,
						(-imageY-imageY*HALF+imageY/3)+START_SIZE, size-15);
				
		}
	}
	
	
	/**
	 * This function will draw only one triangle, 
	 * the outer triangle (the only not upside down one), 
	 * and then start the recursive function
	 * 
	 * @param n (integer) number of recursions
	 * @param red (integer) random number from 0-255 for red value
	 * @param green (integer) random number from 0-255 for green value
	 * @param blue (integer) random number from 0-255 for red value
	 * @param (float) y1 first y coordinate
	 * @param (float) x2 second x coordinate
	 * @param (float) y2 second y coordinate
	 */
	void drawSierpinskiRectangle(int n, int red, int green, int blue, float x1, float y1, float x2, float y2) {
		
		
	    //draw white rectangle in the upper right part, thereby making a black L
		fill(red/2-100, green/2-100, blue/2-100, 100);
	    rect((x1 + x2) * HALF, y1, x2 - SIZE_FORMATER, (y1 + y2) * HALF - SIZE_FORMATER);
	    
	    //call itself 3 times again, now for the 3 new rectangles in the L shape
	    if(n < depth) {
	    	
	    	// Number of recursions for the next call increased with 1
	    	// color modified and positioning 
	        drawSierpinskiRectangle(n + 1, red-25, green+25, blue+25, x1, y1, (x1 + x2) * HALF, (y1 + y2) * HALF);
	        drawSierpinskiRectangle(n + 1, red+25, green-25, blue+25, x1, (y1 + y2) * HALF, (x1 + x2) * HALF, y2);
	        drawSierpinskiRectangle(n + 1, red+25, green+25, blue-25, (x1 + x2) * HALF, (y1 + y2) * HALF, x2, y2);
	    }    
	}
	

	/**
	 * This function will draw only one triangle, 
	 * the outer triangle (the only not upside down one), 
	 * and then start the recursive function
	 * 
	 * @param red random number from 0-255 for red value
	 * @param green random number from 0-255 for green value
	 * @param blue random number from 0-255 for red value
	 * @param y1 first y coordinate
	 * @param x2 second x coordinate
	 * @param y2 second y coordinate
	 * @param x3 third x coordinate
	 * @param y3 third y coordinate
	 */
	void drawSierpinskiTriangle(int red, int green, int blue, float x1, float y1, float x2, float y2, float x3, float y3) {

			
        //Draw the 3 sides of the initial upside down triangle
        line(x1	, y1, x2, y2);
        line(x1, y1, x3, y3);
        line(x2, y2, x3, y3);
        
        
        // Call the recursive function that draws three sub triangles.
        // The 3 corners of the triangles are always the centers of sides, so they're averages
        // This represents the first recursion
        subTriangle (1, red, green, blue, // depth 1 and randomized colors
            (x1 + x2) * HALF, //x1 coordinate of first corner 
            (y1 + y2) * HALF, //y1 coordinate of first corner
            (x1 + x3) * HALF, //x2 coordinate of second corner
            (y1 + y3) * HALF, //y2 coordinate of second corner
            (x2 + x3) * HALF, //x3 coordinate of third corner
            (y2 + y3) * HALF  //y3 coordinate of third corner
        );            
	}    

	/**
	 * Recursive function that creates the Sierpinski Triangle.
	 * 
	 * @param n the depth or number of recursive steps
	 * @param red (integer) random number from 0-255 for red value
	 * @param green (integer) random number from 0-255 for green value
	 * @param blue (integer) random number from 0-255 for red value
	 * @param x1 first x coordinate
	 * @param y1 first y coordinate
	 * @param x2 second x coordinate
	 * @param y2 second y coordinate
	 * @param x3 third x coordinate
	 * @param y3 third y coordinate
	 */
	void subTriangle( int n, int red, int green, int blue, float x1, float y1, float x2, float y2, float x3, float y3) { 
		
		// randomize the stroke color
		stroke(red, green, blue);
		
        //Draw the 3 sides of the triangle as black lines
        line(x1	, y1, x2, y2);
        line(x1, y1, x3, y3);
        line(x2, y2, x3, y3);
	    
	    //Calls itself 3 times with new corners, but only if the current number of recursions is smaller than the maximum depth
	    if(n < depth) {
	    	
	        //first small triangle
	        subTriangle ( n+1,//Number of recursions for the next call increased with 1 with colors
        		red*2+25,	// random red modified
        		green+25, 	// random green modified
        		blue/2+25,	// random blue modified
	            (x1 + x2) * HALF + (x2 - x3) * HALF, //x1 coordinate of first corner
	            (y1 + y2) * HALF + (y2 - y3) * HALF, //y1 coordinate of first corner
	            (x1 + x2) * HALF + (x1 - x3) * HALF, //x2 coordinate of second corner
	            (y1 + y2) * HALF + (y1 - y3) * HALF, //y2 coordinate of second corner
	            (x1 + x2) * HALF, //x3 coordinate of third corner
	            (y1 + y2) * HALF  //y3 coordinate of third corner
	        );
	        
		
	        
	        // second small triangle
	        subTriangle ( n+1, // Number of recursions for the next call increased with 1
        		red/2+25,  // random red modified
        		green+25,  // random green modified
        		blue/2+25, // random blue modified
	            (x3 + x2) * HALF + (x2 - x1) * HALF, //x coordinate of first corner
	            (y3 + y2) * HALF + (y2 - y1) * HALF, //y coordinate of first corner
	            (x3 + x2) * HALF + (x3 - x1) * HALF, //x coordinate of second corner
	            (y3 + y2) * HALF + (y3 - y1) * HALF, //y coordinate of second corner
	            (x3 + x2) * HALF, //x coordinate of third corner
	            (y3 + y2) * HALF  //y coordinate of third corner
	        );
	        
	        
	        // third small triangle
	        subTriangle ( n+1, // Number of recursions for the next call increased with 1
        		red/2+25,  // random red modified
        		green+25,  // random green modified
        		blue*2+25, // random blue modified
	            (x1 + x3) * HALF + (x3 - x2) * HALF, //x coordinate of first corner
	            (y1 + y3) * HALF + (y3 - y2) * HALF, //y coordinate of first corner
	            (x1 + x3) * HALF + (x1 - x2) * HALF, //x coordinate of second corner
	            (y1 + y3) * HALF + (y1 - y2) * HALF, //y coordinate of second corner
	            (x1 + x3) * HALF, //x coordinate of third corner
	            (y1 + y3) * HALF  //y coordinate of third corner        
	        );         
	        
	     
	    }    
	}
}
