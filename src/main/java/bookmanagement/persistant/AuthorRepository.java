package bookmanagement.persistant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmanagement.models.AuthorDTO;


public class AuthorRepository {
	
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	//public ResultMessage add(AuthorDTO author)
	//public ResultMessage edit(AuthorDTO author)
	//public ResultMessage delete(int id)
	
	//public AuthorDTO findById(int id)
	public List<AuthorDTO> findAll(){
		
		List<AuthorDTO> authors=new ArrayList<>();
		String sql="SELECT * FROM author";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AuthorDTO author=new AuthorDTO();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setAddress(rs.getString("address"));
				author.setContact_ph(rs.getString("contact_ph"));
				authors.add(author);
			}
			}catch(SQLException e){
				System.out.println("SQL findAll author error"+e);
				
			}
			return authors;
		}
	}
	
	

