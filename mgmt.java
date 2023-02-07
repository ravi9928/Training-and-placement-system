import javax.swing.*;	
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class mgmt extends JFrame implements ActionListener{
	JLabel back;
	JButton stud,comp,srch,lg;
	public mgmt(String s){
		super(s);
		
		setLayout(null);
		stud=new JButton("Student Panel");
		comp=new JButton("Company Panel");
		srch=new JButton("Search Panel");
		lg=new JButton("Logout");
		
		stud.addActionListener(this);
		comp.addActionListener(this);
		srch.addActionListener(this);
		lg.addActionListener(this);
		
		back=new JLabel(new ImageIcon("images/bg(mgm).jpg"));
		stud.setBounds(70,150,200,50);
		comp.setBounds(70,350,200,50);
		srch.setBounds(70,550,200,50);
		lg.setBounds(800,50,100,30);
		
		add(stud);
		add(comp);
		add(srch);
		add(lg);
		add(back);
		back.setBounds(0,0,1000,1000);
	}	
	public void actionPerformed(ActionEvent et){
		if(et.getSource()==stud){
			Student st=new Student("Student");
			st.setSize(1000,1000);
			this.setVisible(false);
			st.setVisible(true);
		}
		if(et.getSource()==comp){
			company cm=new company("Company");
			cm.setSize(1000,1000);
			this.setVisible(false);
			cm.setVisible(true);
		}
		if(et.getSource()==srch){
			search cm=new search("Search");
			cm.setSize(1000,1000);
			this.setVisible(false);
			cm.setVisible(true);
		}
		else if(et.getSource()==lg){
			this.setVisible(false);
			login obj=new login("Login");
			obj.setSize(1000,1000);
			obj.setVisible(true);
		}
		
	}
	
	
}