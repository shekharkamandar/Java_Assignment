import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
public class Solution
{

	public static void main(String[] args)
	{
		
		System.out.println("Welcome");
		try
		{
				String url="jdbc:mysql://localhost:3306/S_Database";
				String uname="root";
				String pass="root";
			
				//String query="select * from student";
				
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("class is loaded...........");
				Connection con=DriverManager.getConnection(url,uname,pass);
				
				int choice=0;
				Scanner sobj=new Scanner(System.in);
				while(choice<=5)
				{
					System.out.println("#####################################################################");
					System.out.println("CRUD operations");
					System.out.println("1 Insert student data into student table");
					System.out.println("2 Update student data into student table");
					System.out.println("3 Delete student data into student table");
					System.out.println("4 Get a list of all students");
					System.out.println("5 Get one student information depending on the student id filter");
					System.out.println("#####################################################################");
					System.out.println("Enter your choice");
					choice=sobj.nextInt();
					switch(choice)
					{
						case 1: System.out.println("Insert data................");
								
						String I="insert into STUDENT1(STUDENT_NO,STUDENT_NAME,STUDENT_DOB,STUDENT_DOJ)values(?,?,?,?)";
						PreparedStatement pstmt=con.prepareStatement(I);
						
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						
						System.out.println("Enter Student No");
						int no=Integer.parseInt(br.readLine());
						
						System.out.println("Enter Student name:");
						String name=br.readLine();
						
						System.out.println("Enter Student DOB:");
						String dob=br.readLine();
						
						System.out.println("Enter Student DOJ:");
						String doj=br.readLine();
				pstmt.setInt(1,no);
				pstmt.setString(2,name);
				pstmt.setString(3,dob);
				pstmt.setString(4,doj);
				
				
				pstmt.executeUpdate();
				
				///st.executeUpdate(q);
				System.out.println("Inserted in table....");		
				
						
						
						break;
						case 2: 	System.out.println("Update data.........");
						
									String U="Update STUDENT1 SET STUDENT_DOB='1999-05-19' WHERE STUDENT_NO=1";
									PreparedStatement pstmt1=con.prepareStatement(U);
									
									pstmt1.executeUpdate();
									System.out.println("Update data into table.............");
						break;
						case 3:		System.out.println("Delete data........");
									String D="DELETE from STUDENT1 WHERE STUDENT_NO=4";
									PreparedStatement pstmt2=con.prepareStatement(D);
									
									pstmt2.executeUpdate();
									System.out.println("Update data into table.............");
						break;
						case 4:    System.out.println("Display all student");
									String Q="select * from STUDENT1";
						
									Statement stmt=con.createStatement();
								   ResultSet rs=stmt.executeQuery(Q);
								   while(rs.next())
								   {
									   System.out.println(rs.getInt(1));
									   System.out.println(rs.getString(2));
									   System.out.println(rs.getString(3));
									   System.out.println(rs.getString(4));
								   }
								   rs.close();
						break;
						case 5 : System.out.println("Get Any one student information");
										String G="select * from STUDENT1 where STUDENT_NO=2";
										
										Statement stmt1=con.createStatement();
									    ResultSet rss=stmt1.executeQuery(G);
									   System.out.println("#################");
									   while(rss.next())
									   {
										   System.out.println(rss.getInt(1));
										   System.out.println(rss.getString(2));
										   System.out.println(rss.getString(3));
										   System.out.println(rss.getString(4));
									   }  
									   System.out.println("#################");	   
									   
						break;
						default: 
							return;
					}
					

	
					//con.close();
				
				}	
		}		
		catch(Exception e)
		{
			System.out.println("exception errrorrr...");
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
