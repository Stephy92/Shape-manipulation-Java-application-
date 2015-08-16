	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
	import javax.swing.AbstractButton;
	import javax.swing.BorderFactory;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JColorChooser;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;
	import javax.swing.border.TitledBorder;
	
	
	public class draw extends JFrame{
		private ImageIcon addImg = new ImageIcon ("add.png");
		private ImageIcon delImg = new ImageIcon ("del.png");
		private ImageIcon aliImg = new ImageIcon ("align.png");
		private ImageIcon colorPic = new ImageIcon ("color.png");
		
		static String[] shapes = {"Rectangle", "Oval", "Circle", "Triangle","Round Rectangle","Square"};
		static JComboBox ShapeTitle = new JComboBox(shapes);
		public draw (){
			JPanel p1 = new JPanel();
			JButton add = new JButton("Add");
			JButton delete = new JButton("Delete");
			JButton align = new JButton("Align");
			JButton clr = new JButton("Set Color");
			
			//Add buttons into panel
			
					//add button listener and action for add, delete, and also align button
					//add button listener and action for color button
					
			TestMain tM = new TestMain();	   
			// Size for Combo Box
						
			ShapeTitle.setPreferredSize(new Dimension(200, 30));
						
			
			//add Button Image
			add.setIcon(addImg);
			add.setHorizontalTextPosition(AbstractButton.RIGHT);
			add.setVerticalTextPosition(AbstractButton.BOTTOM);
				        
				       
			//del Button Image
			delete.setIcon(delImg);
			delete.setHorizontalTextPosition(AbstractButton.RIGHT);
			delete.setVerticalTextPosition(AbstractButton.BOTTOM);
				        
				        
			//align button image
			align.setIcon(aliImg);
			align.setHorizontalTextPosition(AbstractButton.RIGHT);
			align.setVerticalTextPosition(AbstractButton.BOTTOM);
				        
				        
			//align color image
			clr.setIcon(colorPic);
			clr.setHorizontalTextPosition(AbstractButton.RIGHT);
			clr.setVerticalTextPosition(AbstractButton.BOTTOM);
				      
				   
			//*****Menu Bar******//
			JMenuBar jmb = new JMenuBar();
			// Menu bar for option
			JMenu jmOption = new JMenu("Option");
			JMenuItem jmAddDraw = new JMenuItem("Add Draw");
			JMenuItem jmAddFill = new JMenuItem("Add Fill");
			JMenuItem jmDel = new JMenuItem("Delete");
			JMenuItem jmAlign = new JMenuItem("Align");
			jmOption.add(jmAddDraw);
			jmOption.add(jmAddFill);
			jmOption.add(jmDel);
			jmOption.add(jmAlign);
			jmOption.addSeparator();
			jmb.add(jmOption);
			
			//Menu bar for color
			JMenu jmColor = new JMenu ("Choose Color");
			JMenuItem jmCol = new JMenuItem ("Color");
			jmColor.add(jmCol);
			jmb.add(jmColor);
							
			//Menu Bar for Shape
			JMenu jmShape = new JMenu("Shape");
			JMenuItem jmRect = new JMenuItem ("Rectangle");
			JMenuItem jmCic = new JMenuItem ("Circle");
			JMenuItem jmSquare = new JMenuItem ("Square");
			JMenuItem jmTri = new JMenuItem ("Triangle");
			JMenuItem jmOval = new JMenuItem ("Oval");
			jmShape.add(jmRect);
			jmShape.add(jmCic);
			jmShape.add(jmSquare);
			jmShape.add(jmTri);
			jmShape.add(jmOval);
			jmb.add(jmShape);
					
	
			
			
			ShapeTitle.addActionListener(tM);
			
			String name =("Select an Option");
			p1.setPreferredSize(new Dimension(100, 80));
			p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3,3,
			       3, 3, Color.black), name, TitledBorder.LEFT, TitledBorder.TOP));
			p1.add(ShapeTitle);
			p1.add(add);
			p1.add(delete);
			p1.add(align);
			p1.add(clr);
	
			add.addActionListener(tM);
			delete.addActionListener(tM);
			align.addActionListener(tM);
			clr.addActionListener(tM);
			
			
			
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
		    
		
	   
		}
		public static void main(String[] args){
			new draw();
		}
		public static String getSelectedItem() {
			// TODO Auto-generated method stub
			return (String) ShapeTitle.getSelectedItem();
		}
	
	}
