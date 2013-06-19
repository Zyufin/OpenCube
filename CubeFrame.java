import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CubeFrame extends JFrame{
  private JFrame frame;
	private GridBagLayout gridbag;
	private GridBagConstraints c;
	private Cube cube;
	private ArrayList<CubePanel> panels;
	private Random rand;
	private ArrayList<BasicArrowButton> buttons;
	public CubeFrame(){
		super("OpenCube");
		frame = this;
		panels = new ArrayList<CubePanel>(9);
		cube = new Cube(panels);
		buttons = new ArrayList<BasicArrowButton>(16);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		JPanel jpanel = new JPanel();
		jpanel.setSize(500, 500);
		jpanel.setLocation(250, 250);
		frame.add(jpanel);
		gridbag = new GridBagLayout();//GridBagLayout is used to specify the orientation and relative size of the buttons and CubePanels.  
		c = new GridBagConstraints();
		jpanel.setLayout(gridbag);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 7;
		c.gridheight = 1;
		BasicArrowButton button1 = new BasicArrowButton(BasicArrowButton.NORTH);
		jpanel.add(button1, c);
		button1.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.up();
			}
		});
		buttons.add(button1);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 5;
		BasicArrowButton button2 = new BasicArrowButton(BasicArrowButton.WEST);
		jpanel.add(button2, c);
		button2.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.left();
			}
		});
		buttons.add(button2);
		c.gridx = 6;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 5;
		BasicArrowButton button3 = new BasicArrowButton(BasicArrowButton.EAST);
		jpanel.add(button3, c);
		button3.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.right();
			}
		});
		buttons.add(button3);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 7;
		c.gridheight = 1;
		BasicArrowButton button4 = new BasicArrowButton(BasicArrowButton.SOUTH);
		jpanel.add(button4, c);
		button4.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.down();
			}
		});
		buttons.add(button4);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button5 = new BasicArrowButton(BasicArrowButton.WEST);
		jpanel.add(button5, c);
		button5.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.left(1, 3);
				cube.left(1, 4);
			}
		});
		buttons.add(button5);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button6 = new BasicArrowButton(BasicArrowButton.WEST);
		jpanel.add(button6, c);
		button6.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.left(1, 2);
			}
		});
		buttons.add(button6);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button7 = new BasicArrowButton(BasicArrowButton.WEST);
		jpanel.add(button7, c);
		button7.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.left(1, 1);
				cube.left(1, 0);
			}
		});
		buttons.add(button7);
		c.gridx = 5;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button8 = new BasicArrowButton(BasicArrowButton.EAST);
		jpanel.add(button8, c);
		button8.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.right(1, 3);
				cube.right(1, 4);
			}
		});
		buttons.add(button8);
		c.gridx = 5;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button9 = new BasicArrowButton(BasicArrowButton.EAST);
		jpanel.add(button9, c);
		button9.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.right(1, 2);
			}
		});
		buttons.add(button9);
		c.gridx = 5;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button10 = new BasicArrowButton(BasicArrowButton.EAST);
		jpanel.add(button10, c);
		button10.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.right(1, 1);
				cube.right(1, 0);
			}
		});
		buttons.add(button10);
		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button11 = new BasicArrowButton(BasicArrowButton.SOUTH);
		jpanel.add(button11, c);
		button11.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.down(0, 1);
				cube.down(0, 0);
			}
		});
		buttons.add(button11);
		c.gridx = 3;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button12 = new BasicArrowButton(BasicArrowButton.SOUTH);
		jpanel.add(button12, c);
		button12.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.down(0, 2);
			}
		});
		buttons.add(button12);
		c.gridx = 4;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button13 = new BasicArrowButton(BasicArrowButton.SOUTH);
		jpanel.add(button13, c);
		button13.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.down(0, 3);
				cube.down(0, 4);
			}
		});
		buttons.add(button13);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button14 = new BasicArrowButton(BasicArrowButton.NORTH);
		jpanel.add(button14, c);
		button14.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.up(0, 1);
				cube.up(0, 0);
			}
		});
		buttons.add(button14);
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button15 = new BasicArrowButton(BasicArrowButton.NORTH);
		jpanel.add(button15, c);
		button15.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.up(0, 2);
			}
		});
		buttons.add(button15);
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		BasicArrowButton button16 = new BasicArrowButton(BasicArrowButton.NORTH);
		jpanel.add(button16, c);
		button16.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.up(0, 3);
				cube.up(0, 4);
			}
		});
		buttons.add(button16);
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel1 = new CubePanel(cube.getArrays().get(0) , cube);
		jpanel.add(panel1, c);
		panels.add(panel1);
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel2 = new CubePanel(cube.getArrays().get(1), cube);
		jpanel.add(panel2, c);
		panels.add(panel2);
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel3 = new CubePanel(cube.getArrays().get(2), cube);
		jpanel.add(panel3, c);
		panels.add(panel3);
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel4 = new CubePanel(cube.getArrays().get(3), cube);
		jpanel.add(panel4, c);
		panels.add(panel4);
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel5 = new CubePanel(cube.getArrays().get(4), cube);
		jpanel.add(panel5, c);
		panels.add(panel5);
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel6 = new CubePanel(cube.getArrays().get(5), cube);
		jpanel.add(panel6, c);
		panels.add(panel6);
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel7 = new CubePanel(cube.getArrays().get(6), cube);
		jpanel.add(panel7, c);
		panels.add(panel7);
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel8 = new CubePanel(cube.getArrays().get(7), cube);
		jpanel.add(panel8, c);
		panels.add(panel8);
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		CubePanel panel9 = new CubePanel(cube.getArrays().get(8), cube);
		jpanel.add(panel9, c);
		panels.add(panel9);
		
		for(int i = 0; i < 50; i++){//Performs 50 random rotations on the cube before the JFrame is set to visible
			rand = new Random();
			this.doClick(buttons.get(Math.abs(rand.nextInt(16))));
		}
		
		jpanel.setVisible(true);
	}
	private void doClick(BasicArrowButton button){
		button.doClick();
	}
	public static void main(String[] args){
		CubeFrame gg = new CubeFrame();
		gg.setVisible(true);
		System.out.println("Welcome to OpenCube!  Thank you for playing!  \n The larger arrow buttons rotate the entire cube while the smaller buttons rotate only a specific row or column. \n Simply close and reopen the application for a newly scrambled cube. \n The determination of a correct solution to the cube is left up to the user. \n Good Luck!!!");
	}
}

