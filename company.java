import javax.swing.*;	
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class company extends JFrame implements ActionListener{
	JButton b,lg,edit,dlt,bck;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5;
	JCheckBox c1,c2,c3,c4,c5;
	JComboBox jb;
	String pac[]={"below 3 lac","3 to 7 lakh","7 to 11 lakh ","11 to 15 lakh","above 15 lakh"};
	int flag=0;
	public company(String s){
		super(s);
		
		setLayout(null);

		l1=new JLabel("Company name:");
		l2=new JLabel("Package(p.a.) :");
		l3=new JLabel("Eligibility :");
		l7=new JLabel("Branch :");
		l4=new JLabel("Percentage req. :");
		l5=new JLabel("Backloags(max) :");
		l6=new JLabel("Co. location");
		
		t1=new JTextField(20);
		jb=new JComboBox(pac);
		c1=new JCheckBox("CS");
		c2=new JCheckBox("Mac");
		c3=new JCheckBox("Civil");
		c4=new JCheckBox("Electrical");
		c5=new JCheckBox("Elc");
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		
		
		bck=new JButton("Home");
		bck.addActionListener(this);
		b=new JButton("submit");
		b.addActionListener(this);
		lg=new JButton("Logout");
		lg.addActionListener(this);
		edit=new JButton("Edit");
		edit.addActionListener(this);
		dlt=new JButton("Delete");
		dlt.addActionListener(this);
																bck.setBounds(800,50,100,30);
																lg.setBounds(800,100,100,30);
																edit.setBounds(800,150,100,30);
																dlt.setBounds(800,200,100,30);
																
		l1.setBounds(50,50,100,50);t1.setBounds(160,50,200,40);
		l2.setBounds(50,110,100,50);jb.setBounds(160,115,200,30);
		l3.setBounds(50,170,100,50);t2.setBounds(160,170,200,40);
		l7.setBounds(50,230,100,50);c1.setBounds(160,240,70,30);
								    c2.setBounds(230,240,70,30);
									c3.setBounds(300,240,70,30);
									c4.setBounds(370,240,100,30);
									c5.setBounds(470,240,100,30);
									
		l4.setBounds(50,290,100,50);t3.setBounds(160,300,200,40);
		l5.setBounds(50,350,100,50);t4.setBounds(160,360,200,40);
		l6.setBounds(50,410,100,50);t5.setBounds(160,410,200,40);
									b.setBounds(160,490,110,30);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		
		add(t1);
		add(jb);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		
		add(b);
		add(lg);
		add(edit);
		add(dlt);
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		add(c5);
		add(bck);
		
	}
	public void actionPerformed(ActionEvent e){
		try{
			String cname=t1.getText();
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
			Statement st=cn.createStatement();
			ResultSet rs=null;
			PreparedStatement ps=null;
			PreparedStatement ps1=null;
			PreparedStatement ps3=null;
			company nw=new company("Compony");
			if(e.getSource()==b){
				Object pac=jb.getSelectedItem();

				String elg=t2.getText();
				String prc=t3.getText();
				String back=t4.getText();
				String loc=t5.getText();
				if(flag==0){
					if(st.executeUpdate("insert into compony values('"+cname+"','"+pac+"','"+elg+"','"+prc+"','"+back+"','"+loc+"')")>0){
					ps=cn.prepareStatement("insert into branch values(?,?)");
						if(c1.isSelected()){
							ps.setString(1,cname);
							ps.setString(2,"CS");
							ps.execute();
						}
						if(c2.isSelected()){
							ps.setString(1,cname);
							ps.setString(2,"Mac");
							ps.execute();
						}
						if(c3.isSelected()){
							ps.setString(1,cname);
							ps.setString(2,"Civil");
							ps.execute();
						}
						if(c4.isSelected()){
							ps.setString(1,cname);
							ps.setString(2,"Elc");
							ps.execute();
						}
						if(c5.isSelected()){
							ps.setString(1,cname);
							ps.setString(2,"Electrical");
							ps.execute();
						}
					
						JOptionPane.showMessageDialog(null,"Record Inserted");
							nw.setSize(1000,1000);
							nw.setVisible(true);
							this.setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(null,"Try again");
					}
				}
				
				if(flag==1){
					ps=cn.prepareStatement("update compony set package=? ,eligibility=?, percentage=? ,back=? ,loc=? where c_name=?");
					
					ps.setString(1,"3 to 7 lakh");
					ps.setString(2,elg);
					ps.setString(3,prc);
					ps.setString(4,back);
					ps.setString(5,loc);
					ps.setString(6,cname);
					
					ps3=cn.prepareStatement("delete from branch where c_name=?");
					ps3.setString(1,cname);
					ps3.executeUpdate();
					PreparedStatement ps2=cn.prepareStatement("insert into branch values(?,?)");
						if(c1.isSelected()){
							ps2.setString(1,cname);
							ps2.setString(2,"CS");
							ps2.execute();
						}
						if(c2.isSelected()){
							ps2.setString(1,cname);
							ps2.setString(2,"Mac");
							ps2.execute();
						}
						if(c3.isSelected()){
							ps2.setString(1,cname);
							ps2.setString(2,"Civil");
							ps2.execute();
						}
						if(c4.isSelected()){
							ps2.setString(1,cname);
							ps2.setString(2,"Elc");
							ps2.execute();
						}
						if(c5.isSelected()){
							ps2.setString(1,cname);
							ps2.setString(2,"Electrical");
							ps2.execute();
						}
					
					if(ps.executeUpdate()>0){
						JOptionPane.showMessageDialog(null,"Record Updated");
						nw.setSize(1000,1000);
						nw.setVisible(true);
						this.setVisible(false);
					}
				}
			}
			else if(e.getSource()==edit){
				ResultSet rs1=st.executeQuery("select * from branch where c_name='"+cname+"'");	
				while(rs1.next()){
						if(rs1.getString(2).equals("CS")){
							c1.setSelected(true);
						}
						if(rs1.getString(2).equals("Mac")){
							c2.setSelected(true);
						}
						if(rs1.getString(2).equals("Civil")){
							c3.setSelected(true);
						}
						if(rs1.getString(2).equals("Electrical")){
							c4.setSelected(true);
						}
						if(rs1.getString(2).equals("Elc")){
							c5.setSelected(true);
						}
				}
				rs=st.executeQuery("select * from compony where c_name='"+cname+"'");
				if(rs.next()){
					flag=1;
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(3));
					t3.setText(rs.getString(4));
					t4.setText(rs.getString(5));
					t5.setText(rs.getString(6));
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Record not found");
					nw.setSize(1000,1000);
					nw.setVisible(true);
					this.setVisible(false);
				}
			}
			else if(e.getSource()==dlt && flag==1){
					ps=cn.prepareStatement("delete from compony where c_name=?");
					ps.setString(1,cname);
					ps1=cn.prepareStatement("delete from branch where c_name=?");
					ps1.setString(1,cname);
					if(ps.executeUpdate()>0 && ps1.executeUpdate()>0){
						JOptionPane.showMessageDialog(null,"Delete");
						nw.setSize(1000,1000);
						nw.setVisible(true);
						this.setVisible(false);
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