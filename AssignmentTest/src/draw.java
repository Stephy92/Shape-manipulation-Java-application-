	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import javax.swing.AbstractButton;
	import javax.swing.BorderFactory;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;
	import javax.swing.border.TitledBorder;
	
	
	public class draw extends JFrame{
		
		// Button Icon & Button declaration
		private ImageIcon addImg = new ImageIcon ("add.png");
		private ImageIcon delImg = new ImageIcon ("del.png");
		private ImageIcon aliImg = new ImageIcon ("align.png");
		private ImageIcon colorPic = new ImageIcon ("color.png");
		JButton add = new JButton("Add");
		JButton delete = new JButton("Delete");
		JButton align = new JButton("Align");
		JButton clr = new JButton("Set Color");
			
		// ComboBox selection items
		static String[] shapes = {"Rectangle", "Oval", "Circle","Round Rectangle","Square"};
		static JComboBox ShapeTitle = new JComboBox(shapes);
		
		//Constructor : set the interface gui design
		public draw (){
			
			// Call the TestMain class function to work in this interface 					
			TestMain tM = new TestMain();	  
			
			// Size for Combo Box	
			ShapeTitle.setPreferredSize(new Dimension(200, 30));
						
			
			//set Add button Image's position
			add.setIcon(addImg);
			add.setHorizontalTextPosition(AbstractButton.RIGHT);
			add.setVerticalTextPosition(AbstractButton.BOTTOM);
				        
				       
			//set Delete button's image position
			delete.setIcon(delImg);
			delete.setHorizontalTextPosition(AbstractButton.RIGHT);
			delete.setVerticalTextPosition(AbstractButton.BOTTOM);
				        
				        
			//set Align button's image position
			align.setIcon(aliImg);
			align.setHorizontalTextPosition(AbstractButton.RIGHT);
			align.setVerticalTextPosition(AbstractButton.BOTTOM);
				        
				        
			//Set Color button's image position
			clr.setIcon(colorPic);
			clr.setHorizontalTextPosition(AbstractButton.RIGHT);
			clr.setVerticalTextPosition(AbstractButton.BOTTOM);
				      
				   
			//*****Menu Bar******//
			JMenuBar jmb = new JMenuBar();
			// Menu bar for option
			JMenu jmOption = new JMenu("Option");
			JMenuItem jmAddDraw = new JMenuItem("Add");
			JMenuItem jmDel = new JMenuItem("Delete");
			JMenuItem jmAlign = new JMenuItem("Align");
			jmOption.add(jmAddDraw);
			jmOption.add(jmDel);
			jmOption.add(jmAlign);
			jmOption.addSeparator();
			jmb.add(jmOption);
			
			//Menu bar for color
			JMenu jmColor = new JMenu ("Choose Color");
			//JMenuItem jmCol = new JMenuItem ("Color");
			//jmColor.add(jmCol);
			jmb.add(jmColor);
							
			//Menu Bar for Shape
			JMenu jmShape = new JMenu("Shape");
			JMenuItem jmRect = new JMenuItem ("Rectangle");
			JMenuItem jmCic = new JMenuItem ("Circle");
			JMenuItem jmSquare = new JMenuItem ("Square");
			JMenuItem jmRR = new JMenuItem ("Round Rectangle");
			JMenuItem jmOval = new JMenuItem ("Oval");
			jmShape.add(jmRect);
			jmShape.add(jmCic);
			jmShape.add(jmSquare);
			jmShape.add(jmRR);
			jmShape.add(jmOval);
			jmb.add(jmShape);
					
			// add new panel & put in all the button inside the panel
			JPanel p1 = new JPanel();
			String name =("Select an Option");
			p1.setPreferredSize(new Dimension(100, 80));
			p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3,3,
			       3, 3, Color.black), name, TitledBorder.LEFT, TitledBorder.TOP));
			p1.add(ShapeTitle);
			p1.add(add);
			p1.add(delete);
			p1.add(align);
			p1.add(clr);
			
			// Calling the event function of TestMain
			ShapeTitle.addActionListener(tM);
			add.addActionListener(tM);
			delete.addActionListener(tM);
			align.addActionListener(tM);
			clr.addActionListener(tM);
			jmAddDraw.addActionListener(tM);	
			jmDel.addActionListener(tM);
			jmColor.addActionListener(tM);
			
			//add panel into container
			getContentPane().setLayout(new BorderLayout(1,3));
			getContentPane().add("North", p1);
			getContentPane().add("Center",tM);
			
			//set frame settings
			setBackground(Color.white);
			this.pack();
		    this.setSize(800,600);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setVisible(true);
		    this.setResizable(false);  
		    this.setJMenuBar(jmb);
		}
		
		// main function of the project
		public static void main(String[] args){
			new draw();
		}
		
		// for select the combo items
		public static String getSelectedItem() {
			// TODO Auto-generated method stub
			return (String) ShapeTitle.getSelectedItem();
		}
	
	}
