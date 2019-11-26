package com.gainjava.knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel label;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	
	OnlineTest(String s)
	{
		super(s);
		label=new JLabel();
		add(label);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		label.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this,"correct answers= "+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			label.setText("Que1:  Which of the following is not introduced with Java 8?");
			jb[0].setText("Stream API");jb[1].setText("Serialization");jb[2].setText("Spliterator");jb[3].setText("Lambda Expression");	
		}
		if(current==1)
		{
			label.setText("Que2: What is the purpose of BooleanSupplier function interface?");
			jb[0].setText("represents supplier of Boolean-valued results");jb[1].setText("returns Boolean-valued result");jb[2].setText("There is no such function interface");jb[3].setText("returns null if Boolean is passed as argument");
		}
		if(current==2)
		{
			label.setText("Que3: What is the return type of lambda expression?");
			jb[0].setText("String");jb[1].setText("Object");jb[2].setText("void");jb[3].setText("Function");
		}
		if(current==3)
		{
			label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
			jb[0].setText("for (String i : StringList)");jb[1].setText("foreach (String i : StringList)");jb[2].setText("StringList.forEach()");jb[3].setText("List.for()");
		}
		if(current==4)
		{
			label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
			jb[0].setText(" Nashorn");jb[1].setText("V8");jb[2].setText("Inscript");jb[3].setText("Narcissus");
		}
		if(current==5)
		{
			label.setText("Que6: How to read entire file in one line using java 8?");
			jb[0].setText("Files.readAllLines()");jb[1].setText("Files.read()");jb[2].setText("Files.readFile()");jb[3].setText("Files.lines()");
		}
		if(current==6)
		{
			label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
			jb[0].setText("try catch finally");jb[1].setText("IOException");jb[2].setText("AutoCloseable");jb[3].setText("Streams");
		}
		if(current==7)
		{
			label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
			jb[0].setText("Configuration");jb[1].setText("Criteria");jb[2].setText("SessionManagement");jb[3].setText("Session");		
		}
		if(current==8)
		{
			label.setText("Que9: SessionFactory is a thread-safe object.");
			jb[0].setText("true");jb[1].setText("false");jb[2].setText("don't know");jb[3].setText("false");
		}
		if(current==9)
		{
			label.setText("Que10: Which of the following is not a state of object in Hibernate?");
			jb[0].setText("Attached()");jb[1].setText("Detached()");jb[2].setText("Persistent()");jb[3].setText("Transient()");
		}
		label.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[0].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[2].isSelected());
		if(current==4)
			return(jb[0].isSelected());
		if(current==5)
			return(jb[0].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[2].isSelected());
		if(current==8)
			return(jb[0].isSelected());
		if(current==9)
			return(jb[0].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test App");
	}


}
