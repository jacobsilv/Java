

import processing.core.PApplet;


@SuppressWarnings("serial")
public class Ripple extends PApplet{
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 700;

    // Initializing the ripple objects
    ripple ripple;

 
    /**
     * Has a initial background and 
     * initializes both objects
     */
	public void setup() {

		// setup the size of the window 
		size(WINDOW_WIDTH, WINDOW_HEIGHT);
		ripple = new ripple();


	}
	
	
	/**
	 * Keep drawing the white background
	 * drawObjects is based on the two objects
	 * ripple and ripple2
	 * 
	 */
	public void draw() {

		// white background

		background(255);
		

		
		drawObjects();
		

	}
	
	
	/**
	 * Two objects are called and 
	 * their attributes in draw will
	 * occur 
	 */
	public void drawObjects() {
		
		
		ripple.draw();


	}
	
	static int mx;
	static int my;
	public class ripple {
		
		int counter;
			
		ripple() {
			mx = 0;
			my = 0;
			counter = 0;
		}
		
		// attribute of object that draws ripple
		void draw() {
			// counter that is constantly increasing
			counter++;
			
			// when mouse is pressed create ripple
			if (mousePressed) {
				
				//save the location of mouse x and y coordinates
				mx = mouseX;
				my = mouseY;
				counter = 1;
				
			}
			// random grey value
			int grey = (int) random(0, 255);
			
			// make sure no fill
			noFill();
			
			// increase stroke width
			strokeWeight(3);
			
			// have the ripple fade at different paces
			// simulate 5 ripples that occur at the location of mousePressed
			// the first stroke is a changing randomly assigned grey and does not fade
			stroke(grey);
			ellipse(mx, my, 1*counter, 1*counter);
			
			stroke(counter+5);
			ellipse(mx, my, 2*counter, 2*counter);
			
			stroke(counter+10);
			ellipse(mx, my, 3*counter, 3*counter);
			
			stroke(counter+25);
			ellipse(mx, my, 4*counter, 4*counter);
			
			stroke(counter+50);
			ellipse(mx, my, 5*counter, 5*counter);	
		}
	}
		

}
