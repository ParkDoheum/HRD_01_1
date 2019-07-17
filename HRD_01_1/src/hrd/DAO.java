package hrd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        
    //제품 리스트 가져오기
    public static List<ProductVo> selProductList(String orderby) {
    	List<ProductVo> list = new ArrayList();
    	Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String sql = " SELECT p_name, p_no, p_cnt, TO_CHAR(p_regdate, 'YYYY-MM-DD') as p_regdate "
    			+ " FROM i_product order by " + orderby;
    	
    	try {
			con = getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setP_name(rs.getString("p_name"));
				vo.setP_no(rs.getInt("p_no"));				
				vo.setP_cnt(rs.getInt("p_cnt"));
				vo.setI_date(rs.getString("p_regdate"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
    	
    	return list;
    }
    
    //입고/출고 등록
    public static void regImEx(ProductVo vo) {
    	Connection con = null;
    	PreparedStatement ps = null;
    	
    	String no = "i_no";
    	String cnt = "i_cnt";
    	
    	if(vo.getTableNm().equals("i_export")) {
    		no = "e_no";
    		cnt = "e_cnt";
    	}
    	
    	String sql = " INSERT INTO  " + vo.getTableNm()
    			+ " (" + no + ", p_no, " + cnt + ") "
    			+ " select nvl(max( " + no + "), 0) + 1, ?, ? from " + vo.getTableNm();
    	
    	try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTableNm());			
			ps.setInt(1, vo.getP_no());
			ps.setInt(2,  vo.getI_cnt());
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
    }   
    
    //입고 조회
    public static List<ProductVo> selectImportList() {    	
    	List<ProductVo> list = new ArrayList<ProductVo>();    	
    	Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String sql = " SELECT A.i_no, B.p_name, A.i_cnt, A.i_date "
    			+ " FROM i_import A "
    			+ " INNER JOIN i_product B "
    			+ " ON A.p_no = B.p_no "
    			+ " order by A.i_date DESC ";
    	
    	try {
			con = getCon();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int i_no = rs.getInt("i_no");
				int i_cnt = rs.getInt("i_cnt");
				
				System.out.println("i_no : " + i_no);
				System.out.println("i_cnt : " + i_cnt);
				
				ProductVo vo = new ProductVo();
				
				vo.setI_no(rs.getInt("i_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setI_cnt(rs.getInt("i_cnt"));
				vo.setI_date(rs.getString("i_date"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
    	
    	return list;
    }
    
  //출고 조회
    public static List<ProductVo> selectExportList() {    	
    	List<ProductVo> list = new ArrayList<ProductVo>();    	
    	Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String sql = " SELECT A.e_no, B.p_name, A.e_cnt, A.e_date "
    			+ " FROM i_export A "
    			+ " INNER JOIN i_product B "
    			+ " ON A.p_no = B.p_no "
    			+ " order by A.e_date DESC ";
    	
    	try {
			con = getCon();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {								
				ProductVo vo = new ProductVo();				
				vo.setI_no(rs.getInt("e_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setI_cnt(rs.getInt("e_cnt"));
				vo.setI_date(rs.getString("e_date"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
    	
    	return list;
    }
    
    //재고 수량 변경
    public static void productUpdCnt(ProductVo vo) {
    	Connection con = null;
    	PreparedStatement ps = null;
    	String flag = " + ";
    	if(vo.getFlag().equals("ex")) {
    		flag = " - ";
    	}    	
    	
    	String sql = " update i_product"
    			+ " set p_cnt = p_cnt " + flag + " ? "
    			+ " where p_no = ? ";
    	
    	try {
			con = getCon();
			ps = con.prepareStatement(sql);			
			ps.setInt(1, vo.getI_cnt());
			ps.setInt(2, vo.getP_no());
			ps.execute();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
    	
    }
    
}






