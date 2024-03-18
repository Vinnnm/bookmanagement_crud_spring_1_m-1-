package bookmanagement.persistant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmanagement.models.*;
import bookmanagement.utils.ResultMessage;

//crud
public class BookRepository {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	//create(insert)
	public ResultMessage add(BookRequestDTO book) {
		ResultMessage result_message=new ResultMessage();
		
		String sql="INSERT INTO book(code, name, price, author_id) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,book.getCode());
			ps.setString(2,book.getName());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4,book.getAuthor_id());
			
		
		result_message.setResult(ps.executeUpdate());
		result_message.setMessage("Insert Successful");
		
			
		}catch(SQLException e){
			System.out.println("SQL Insert error"+e);//for backend developer
			result_message.setResult(0);
			if(e.toString().contains("Duplicate entry")) {
				result_message.setMessage("Insert Fail:your code is already exist,try another code "+e);
			}
			else {
				result_message.setMessage("Insert Fail: "+e);
			}
			
			
		}
		return result_message;
		
	}
	//Update
	public int edit(BookRequestDTO book) {
		int result=0;
		String sql="UPDATE  book SET  name=?, price=?, author_id=? WHERE code=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,book.getName());
			ps.setDouble(2, book.getPrice());
			ps.setInt(3, book.getAuthor_id());
			ps.setString(4, book.getCode());
			
		result=	ps.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("SQL Update error"+e);
			
		}
		return result;
		
	}
	//Delete
	public int delete(String code) {
		int result=0;
		String sql="DELETE FROM book WHERE code=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,code);
		result=	ps.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("SQL Delete error"+e);
			
		}
		return result;
		
	}
	//Read=>ResponseDTO return single object
	public BookResponseDTO findByCode(String code) {
		BookResponseDTO book=new BookResponseDTO();
		String sql="SELECT * FROM book WHERE code=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,code);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			//String code=rs.getString("code");
			book.setCode(rs.getString("code"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			//book.setAuthor(rs.getString("author_name"));
			}
		}catch(SQLException e){
			System.out.println("SQL findByCode error"+e);
			
		}
		return book;
		
	}
	//Read=>ResponseDTO return collection object
	public List<BookResponseDTO> findAll() {
		
		List<BookResponseDTO> books=new ArrayList<>();
		String sql="SELECT b.*,a.name as author_name"+" FROM book b INNER JOIN author a on b.author_id=a.id ";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BookResponseDTO book=new BookResponseDTO();
			
			book.setCode(rs.getString("code"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			book.setAuthor(rs.getString("author_name"));
			books.add(book);
			}
		}catch(SQLException e){
			System.out.println("SQL findAll error"+e);
			
		}
		return books;
		
	}
}
