package hrd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DAO {
    private static Connection getCon() throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection
                          ("jdbc:oracle:thin:@//localhost:1521/xe", "loginboard", "hkit2019");
        System.out.println("DB연결");
        return con;
    }
    
    private static void close(Connection con, PreparedStatement ps, ResultSet rs) {
    	if(rs != null) {
    		try {	rs.close();} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(ps != null) {
    		try { ps.close(); } catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(con != null) {
    		try { con.close(); } catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
    
    //물품 등록
    public static void productReg(ProductVo vo) {    	
    	Connection con = null;
    	PreparedStatement ps = null;
    	
    	String sql = " INSERT INTO i_product "
    			+ " (p_no, p_name) "
    			+ " VALUES "
    			+ " ((select nvl(max(p_no), 0) + 1 FROM i_product), ?) ";
    	try {
    		con = getCon();
    		ps = con.prepareStatement(sql);    		
    		ps.setString(1,  vo.getP_name());
    		
    		ps.executeUpdate();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		close(con, ps, null);
    	}    	
    }
}






