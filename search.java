import javax.swing.*;	
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class search extends JFrame implements ActionListener{
	JButton b,lg,bck;
	JLabel header,body;
	JComboBox jb;
	JMenuBar mb;
	JMenu m1;
	JMenuItem mi1,mi2,mi3;
	
	DefaultTableModel dtm=null;
	JTable jt=null;
	JScrollPane js=null;
	Font f;
	
	public search(String s){
		super(s);
		setLayout(null);
		f= new Font("arial",Font.BOLD,15);
		dtm= new DefaultTableModel(0,0);
		jt=new JTable();
		
		String head[]={"Student id","Name","Father's Name","Email","Mobile","Gender","Branch"};
		dtm.setColumnIdentifiers(head);
		jt.setModel(dtm);
		js=new JScrollPane(jt);
		
		add(js);
		js.setFont(f);
		jt.setFont(f);
		
		
		header=new JLabel(new ImageIcon("images/search_head.jpg"));
		body=new JLabel(new ImageIcon("images/search_body.jpg"));
		
		mb= new JMenuBar();
		m1= new JMenu("More");
		mi1= new JMenuItem("Company Panel");
		mi2= new JMenuItem("Student Panel");
		mi3= new JMenuItem("Logout");
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		mb.add(m1);
		
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		
		setJMenuBar(mb);
		jb=new JComboBox();
		b=new JButton("Search");
		b.addActionListener(this);
		lg=new JButton("logout");
		lg.addActionListener(this);
		bck=new JButton("Back");
		bck.addActionListener(this);
																
		jb.setBounds(100,200,200,50);b.setBounds(600,200,200,50);
		js.setBounds(100,260,700,200);
		header.setBounds(0,0,1000,200);
		body.setBounds(0,200,1000,800);
		add(jb);
		add(b);
		add(header);
		add(body);
		//for take compony name inti combo box
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
			Statement st=cn.createStatement();
			ResultSet rs=null;
			rs=st.executeQuery("select * from compony");
			while(rs.next()){
				jb.addItem(rs.getString("c_name"));
			}
		}
		catch(ClassNotFoundException ee){
			System.out.println("Class :"+ee.getMessage());
		}
		catch(SQLException ee){
			System.out.println("Class :"+ee.getMessage());
		}
	}
	public void actionPerformed(ActionEvent e){
		dtm.setRowCount(0);
		int avg=0;
		int back=0;
		String branch="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
			Statement st=cn.createStatement();
			ResultSet rs=null;
			if(e.getSource()==b){
				Object cname=""+jb.getSelectedItem();
				//select from company
				rs=st.executeQuery("select * from compony where c_name='"+cname+"'");
				if(rs.next()){
					avg=rs.getInt("percentage");
					back=rs.getInt("back");
				}
				/*select from branch
				ResultSet rs1=st.executeQuery("select * from branch where c_name='"+cname+"'");
				while(rs1.next()){
					branch=rs1.getString("branch");
				}*/
				//select from student							//branch='"+branch+"' AND 
				ResultSet rs2=st.executeQuery("select * from student where btch>="+avg+" AND back<="+back);
				while(rs2.next()){
					String name=rs2.getString("name");
					dtm.addRow(new Object[]{rs2.getString("st_id"),rs2.getString("name"),rs2.getString("fname"),rs2.getString("email"),rs2.getInt("phone"),rs2.getString("Gender"),rs2.getString("branch")});
					
				}
			}
			else if(e.getSource()==mi3){
				this.setVisible(false);
				login obj=new login("Login");
				obj.setSize(1000,1000);
				obj.setVisible(true);
			}
			if(e.getSource()==mi2){
				this.setVisible(false);
				Student obj1=new Student("Student Panel");
				obj1.setSize(1000,1000);
				obj1.setVisible(true);
			}
			if(e.getSource()==mi1){
				this.setVisible(false);
				company obj2=new company("Company Panel");
				obj2.setSize(1000,1000);
				obj2.setVisible(true);
			}
		}
		catch(ClassNotFoundException ee){
			System.out.println("Class :"+ee.getMessage());
		}
		catch(SQLException ee){
			System.out.println("Class :"+ee.getMessage());
		}
		catch(Exception ee){
			System.out.println("Class :"+ee.getMessage());
		}
	}
	public static void main(String []args){
		search obj=new search("Login");
		obj.setSize(1000,1000);
		obj.setVisible(true);
	}
}