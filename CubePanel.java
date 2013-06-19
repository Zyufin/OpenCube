import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class CubePanel extends JPanel{  //An extension of JPanel is used to draw the cube.  
  ArrayList<Integer> square;//Each visible square is a single "CubePanel", which merely associates the appropriate ArrayList to that panel
	Cube cube;					// and allows the panel to request its updated color from the Cube data structure before repainting.
 	CubePanel(ArrayList<Integer> array, Cube c){
  square = array;
 	cube = c;
 		
 		
 	}
 	protected void paintComponent(Graphics g) { 
 		super.paintComponent(g);
 		printBorder(g);
 		this.setBackground(cube.getColor(square));
		this.setSize(130, 130);
	}
}
