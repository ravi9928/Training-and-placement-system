import javax.swing.*;	
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Student extends JFrame implements ActionListener,ItemListener{
	JButton b,lg,edit,dlt,bck;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JRadioButton r,r1,r2,r3,r4,r5;
	ButtonGroup gender,branch;
	String back[]={"No","Yes"};
	JComboBox bac;
	Font f;
	int flag=0;
	public Student(String s){
		super(s);
		
		setLayout(null);
		f= new Font("arial",Font.BOLD,12);
		gender=new ButtonGroup();
		branch=new ButtonGroup();
		bac=new JComboBox(back);
		l1=new JLabel("Student-ID :");
		l2=new JLabel("Student Name :");
		l3=new JLabel("Father's Name :");
		l4=new JLabel("Email :");
		l5=new JLabel("Phone No. :");
		l6=new JLabel("Gender :");
		l7=new JLabel("Branch :");
		l8=new JLabel("10th percent :");
		l9=new JLabel("12th percent :");
		l10=new JLabel("B.Tech Aggr :");
		l11=new JLabel("Back:");
		l12=new JLabel("No. of back:");
		
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		t8=new JTextField(20);
		t9=new JTextField("0");
		
		bac.addItemListener(this);
		b=new JButton("submit");
		b.addActionListener(this);
		lg=new JButton("Logout");
		lg.addActionListener(this);
		edit=new JButton("Edit/Search");
		edit.addActionListener(this);
		dlt=new JButton("Delete");
		dlt.addActionListener(this);
		bck=new JButton("Back");
		bck.addActionListener(this);
		
		r=new JRadioButton("Male");
		r1=new JRadioButton("Female");
		r2=new JRadioButton("CS");
		r3=new JRadioButton("Elc");
		r4=new JRadioButton("Mac");
		r5=new JRadioButton("Civil");
		
		gender.add(r);
		gender.add(r1);
		branch.add(r2);
		branch.add(r3);
		branch.add(r4);
		branch.add(r5);											
																lg.setBounds(800,50,100,30);
																edit.setBounds(800,100,100,30);
																dlt.setBounds(800,150,100,30);
																bck.setBounds(800,200,100,30);
		l1.setBounds(50,50,100,50);t1.setBounds(160,50,150,40);
		l2.setBounds(50,110,100,50);t2.setBounds(160,110,150,40);
		l3.setBounds(50,170,100,50);t3.setBounds(160,170,150,40);
		l4.setBounds(50,230,100,50);t4.setBounds(160,230,150,40);
		l5.setBounds(50,290,100,50);t5.setBounds(160,290,150,40);
		l6.setBounds(50,350,100,50);r.setBounds(160,350,100,30);r1.setBounds(270,350,100,30);
		l7.setBounds(50,410,100,50);r2.setBounds(160,410,100,30);r3.setBounds(270,410,100,30);r4.setBounds(380,410,100,30);r5.setBounds(490,400,100,50);
		l8.setBounds(50,460,100,50);t6.setBounds(160,460,150,40);
		l9.setBounds(50,520,100,50);t7.setBounds(160,520,150,40);
		l10.setBounds(50,580,100,50);t8.setBounds(160,580,150,40);
		l11.setBounds(50,640,100,50);bac.setBounds(160,640,150,40);
		l12.setBounds(50,690,100,50);t9.setBounds(160,700,150,40);
									b.setBounds(160,750,110,30);
					
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		l7.setFont(f);
		l8.setFont(f);
		l9.setFont(f);
		l10.setFont(f);
		l11.setFont(f);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		add(t9);
		add(r);
		add(r1);
		add(r2);
		add(r3);
		add(r4);
		add(r5);
		add(bac);
		add(b);
		add(lg);
		add(edit);
		add(dlt);
		add(bck);
		t9.setVisible(false);
		l12.setVisible(false);
		
	}
	public void itemStateChanged(ItemEvent ie){
		String yon=(String)bac.getSelectedItem();
		if(yon.equals("Yes")){
			l12.setVisible(true);
			t9.setVisible(true);
		}
		else if(yon.equals("No")){
			l12.setVisible(false);
			t9.setVisible(false);
		}
	}
	public void actionPerformed(ActionEvent e){
		try{
			String id=t1.getText();
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
			Statement st=cn.createStatement();
            PreparedStatement ps=null;
			ResultSet rs=null;
			String msg="";
			if(e.getSource()==b){
				String name=t2.getText();
				String fname=t3.getText();
				String email=t4.getText();
				int phone=Integer.parseInt(t5.getText());
				String gender="";
				if(r.isSelected()){
				gender="Male";	
				}
				else if(r1.isSelected()){
				gender="Female";	
				}
				String branch="";
				if(r2.isSelected()){
				branch="CS";	
				}
				else if(r3.isSelected()){
				branch="Elc";	
				}
				else if(r4.isSelected()){
				branch="Mac";	
				}
				else if(r5.isSelected()){
				branch="Civil";	
				}
				String sec=t6.getText();
				String hsec=t7.getText();
				int btch=Integer.parseInt(t8.getText());	
				int back=Integer.parseInt(t9.getText());				
					//insert into table
				if(flag==0){
					if(st.executeUpdate("insert into Student values('"+id+"','"+name+"','"+fname+"','"+email+"',"+phone+",'"+gender+"','"+branch+"','"+sec+"','"+hsec+"',"+btch+","+back+")")>0){
						JOptionPane.showMessageDialog(null,"Record Inserted");
						Student obj=new Student("Student");
						obj.setSize(1000,1000);
						obj.setVisible(true);
						this.setVisible(false);
						
					}
					else{
						JOptionPane.showMessageDialog(null,"Try again");
					}
				}
				//edit and update
				else if(flag==1){
					ps=cn.prepareStatement("update student set name=?, fname=? ,email=? ,phone=? , gender=? ,branch=? ,secondary=? ,h_secondary=?, btch=? ,back=? where st_id=?");
					ps.setString(1,name);
					ps.setString(2,fname);
					ps.setString(3,email);
					ps.setString(4,phone+"");
					ps.setString(5,gender);
					ps.setString(6,branch);
					ps.setString(7,sec);
					ps.setString(8,hsec);
					ps.setString(9,btch+"");
					ps.setString(10,back+"");
					ps.setString(11,id);
					msg="Record Updated";
					if(ps.executeUpdate()>0){
						JOptionPane.showMessageDialog(null,msg);
						this.setVisible(false);
						Student obj=new Student("Student");
						obj.setSize(1000,1000);
						obj.setVisible(true);
					}
				}
				
			}
			//search by student id
			else if(e.getSource()==edit){
				rs=st.executeQuery("select * from student where st_id='"+id+"'");

				if(rs.next()){
					flag=1;
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					String gen=rs.getString(6);
					if(gen.equals("Male")){
						r.setSelected(true);
					}
					else if(gen.equals("Female")){
						r1.setSelected(true);
					}
					String brn=rs.getString(7);
					if(brn.equals("CS")){
						r2.setSelected(true);
					}
					else if(brn.equals("Elc")){
						r3.setSelected(true);
					}
					else if(brn.equals("Mac")){
						r4.setSelected(true);
					}
					else if(brn.equals("Civil")){
						r5.setSelected(true);
					}
					t6.setText(rs.getInt(8)+"");
					t7.setText(rs.getString(9));
					t8.setText(rs.getString(10)+"");
					t9.setText(rs.getInt(11)+"");
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Record not found");
					this.setVisible(false);
					Student obj=new Student("Student");
					obj.setSize(1000,1000);
					obj.setVisible(true);
				}
			}
			//delete work
			else if(e.getSource()==dlt && flag==1){
					ps=cn.prepareStatement("delete from student where st_id=?");
					ps.setString(1,id);
					if(ps.executeUpdate()>0){
						JOptionPane.showMessageDialog(null,"Delete");
						this.setVisible(false);
						Student obj=new Student("Student");
						obj.setSize(1000,1000);
						obj.setVisible(true);
					}
			}
			else if(e.getSource()==lg){
				this.setVisible(false);
				login obj=new login("Login");
				obj.setSize(1000,1000);
				obj.setVisible(true);
			}
			else if(e.getSource()==bck){
				this.setVisible(false);
				mgmt obj1=new mgmt("Management");
				obj1.setSize(1000,1000);
				obj1.setVisible(true);
			}
			cn.close();
		}
		catch(ClassNotFoundException ee){
			System.out.println("Class :"+ee.getMessage());
		}
		catch(SQLException ee){
			System.out.println("SQL :"+ee.getMessage());
		}
		catch(NumberFormatException ee){
			System.out.println("Variable :"+ee.getMessage());
		}
	}
	
}