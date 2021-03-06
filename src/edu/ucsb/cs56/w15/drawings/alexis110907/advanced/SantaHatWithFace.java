package edu.ucsb.cs56.w15.drawings.alexis110907.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Face with a santa hat on
      
   @author Alexis Jimenez
   @version for CS56, W15, UCSB, 02/19/2015
   
*/
public class SantaHatWithFace extends SantaHat implements Shape
{
    //Constructor for santa hat with face
    public SantaHatWithFace(double x,double y,double width,double height)
    {
	//make the santa hat
	super (x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();



	double lowerLeftOfHatX = x-width;
	double lowerLeftOfHatY = y+ height;
	double leftEyeX = x - (.5 * width);
	double leftEyeY = y + height + (.5*width);  
	double rightEyeX = x + (.25 * width);
	double rightEyeY = y + height + (.5*width);
	double noseX = x - (.05 * width);
	double noseY = y + height + width;
	double mouthX = x - (.5 * width);
	double mouthY = y + height + (1.5 * width);

	//methods to make eyes, face and nose
	//make the face
	Shape face = new Ellipse2D.Double(lowerLeftOfHatX,lowerLeftOfHatY, (2 * width), (2 * width));

	//make the left eye
	Shape leftEye = new Ellipse2D.Double(leftEyeX,leftEyeY,(.15*(2*width)),(.15*(2*width)));

	//make the left inner eye
	Shape leftEyeInner = new Ellipse2D.Double(leftEyeX+(.1*width),leftEyeY,(.1*width),(.1*width));

	//make the right eye
	Shape rightEye = new Ellipse2D.Double(rightEyeX,rightEyeY,(.3*width),(.3*width));


	//make the right inner eye
	Shape rightEyeInner = new Ellipse2D.Double(rightEyeX +(.1*width),rightEyeY,(.1*width),(.1*width));

	//make the nose
	Shape nose = new Ellipse2D.Double(noseX,noseY,(.1*width),(.1*width));

	//make the mouth
	Shape mouth = new Ellipse2D.Double(mouthX,mouthY,(width),(.0001*width));



	//make face
	GeneralPath entireSantaHat = this.get();
        entireSantaHat.append(leftEye, false);
        entireSantaHat.append(rightEye, false);
	entireSantaHat.append(leftEyeInner, false);
        entireSantaHat.append(rightEyeInner, false);
        entireSantaHat.append(nose, false);
	entireSantaHat.append(mouth, false);
	entireSantaHat.append(face, false); 
    }
}
