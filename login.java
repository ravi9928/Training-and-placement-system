import javax.swing.*;	
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
	JLabel jl1,jl2,back;
	JTextField jt1;
	JPasswordField jp;
	JButton jb;
	Font f;
	public login(String s){
		super(s);
		
		setLayout(null);
		f= new Font("arial",Font.BOLD,20);
		jl1=new JLabel("Email :");
		jt1=new JTextField(20);
		
		jl2=new JLabel("Password :");
		jp=new JPasswordField(20);
		jb=new JButton("Login");
		back=new JLabel(new ImageIcon("images/bg1.jpg"));
		jb.addActionListener(this);
		jl1.setBounds(150,200,150,60);jt1.setBounds(320,205,230,50);
		jl2.setBounds(150,280,150,60);jp.setBounds(320,285,230,50);
									  jb.setBounds(320,360,120,40);
		
		back.setBounds(0,0,1000,1000);
		
		jl1.setFont(f);
		jt1.setFont(f);
		jl2.setFont(f);
		jp.setFont(f);
		jb.setFont(f);
		
		add(jl1);
		add(jt1);
		add(jl2);
		add(jp);
		add(jb);
		add(back);
	}
	public void actionPerformed(ActionEvent et){
		String email=jt1.getText();
		String pass=jp.getText();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from login where email='"+email+"'");
			if(rs.next()){
				if(rs.getString(2).equals(pass)){
					mgmt sf=new mgmt("Manegement");
					sf.setSize(1000,1000);
					sf.setVisible(true);
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null,"invalid password");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"invalid email");
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver :"+e.getMessage());
		}
		catch(SQLException e){
			System.out.println("SQL :"+e.getMessage());
		}
		
	}
	public static void main(String []args){
		login obj=new login("Login");
		obj.setSize(1000,1000);
		obj.setVisible(true);
	}
}