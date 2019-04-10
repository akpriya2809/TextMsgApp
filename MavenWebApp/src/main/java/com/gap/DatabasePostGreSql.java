package com.gap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePostGreSql {
	private final String url = "jdbc:postgresql://localhost:5432/test_db";
    private final String user = "postgres";
    private final String password = "postgres";
    
    public Connection connect() throws SQLException {
    	try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return DriverManager.getConnection(url, user, password);
    }
    
    public void insertkeywordsettings(String keyword, String valid, String invalid) {
    	String SQL = "INSERT INTO KEYWORD (Keyword,VALID, INVALID) VALUES (?, ?, ?) ";
    	try {
    		Connection conn = connect();
    		PreparedStatement pstmt = conn.prepareStatement(SQL);
    		pstmt.setString(1, keyword);
    		pstmt.setString(2, valid);
    		pstmt.setString(3, invalid);
            int id = pstmt.executeUpdate();
         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    	
    }
    
    
    public String getRegisteredKeyword() {
    	String SQL = "SELECT keyword from KEYWORD";
    	String str= "";
    	try {
    		Connection conn = connect();
    		PreparedStatement pstmt = conn.prepareStatement(SQL);
 
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	str = rs.getString("keyword");
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    	return str;
    	
    }
    public String getRegisteredValidResponse() {
    	String SQL = "SELECT valid from KEYWORD";
    	String str= "";
    	try {
    		Connection conn = connect();
    		PreparedStatement pstmt = conn.prepareStatement(SQL);
 
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	 str = rs.getString("valid");
            }
         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    	return str;
    	
    }
    public String getRegisteredInvalidResponse() {
    	String SQL = "SELECT invalid from KEYWORD";
    	String str = "";
    	try {
    		Connection conn = connect();
    		PreparedStatement pstmt = conn.prepareStatement(SQL);
 
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	str = rs.getString("invalid");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    	return str;
    	
    }
    
    public List<String> getAllPhoneNumbers() {
    	String SQL = "SELECT PHONE from CUSTOMER";
    	List<String> str = new ArrayList<String>();
    	try {
    		Connection conn = connect();
    		PreparedStatement pstmt = conn.prepareStatement(SQL);
 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	str.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    	return str;
    	
    }
    
    public void registerPhoneNumber() {
    	
    	
    }

}
