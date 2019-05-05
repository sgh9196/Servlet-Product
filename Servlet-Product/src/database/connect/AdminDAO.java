package database.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.domain.MemberVO;
import org.domain.ProductVO;
 
public class AdminDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	
	public String chkUserLogin(String id, String pw) {
		
		String name = null;
		
		try {
			
			ResultSet rs = null;
			ProductDAO dao = new ProductDAO();
			con = dao.getDataFactory().getConnection();
			
			String query = "SELECT name FROM t_member ";
			query += "WHERE id = ? AND pw = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery(); 
			if(rs!= null) {
				rs.next();
				name = rs.getString("name");
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch(Exception e) { }
		
		return name;
		
	}
	
	/* Check (User ID) */
	public boolean chkUserID(String id) {
		
		boolean tmp = false;
		
		try {
			
			ResultSet rs = null;
			ProductDAO dao = new ProductDAO();
			con = dao.getDataFactory().getConnection();
			
			String query = "SELECT id FROM t_member WHERE id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			tmp = ((rs=pstmt.executeQuery()).next()) ? false : true;
			
			rs.close(); pstmt.close(); con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
		
	}

	/* t_member User ADD */
	public int addUser(MemberVO vo) {
		
		int rlst = 0;
		
		try {
			
			ProductDAO dao = new ProductDAO();
			con = dao.getDataFactory().getConnection();
			
			String query = "INSERT INTO t_member(id, pw, name, phone) ";
			query += "VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			
			rlst = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rlst;
		
	}
	
	public int addProduct(ProductVO pVO) {
		
		int rlst = 0;
		
		String query = "INSERT INTO t_product(pName, pCount, pMoney, pStandard, firstDate, inDate) ";
		query += "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			
			ProductDAO dao = new ProductDAO();
			con = dao.getDataFactory().getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, pVO.getpName());
			pstmt.setInt(2, pVO.getpCount());
			pstmt.setInt(3, pVO.getpMoney());
			pstmt.setDouble(4, pVO.getpStandard());
			pstmt.setString(5, pVO.getFirstDate());
			pstmt.setString(6, pVO.getinDate());
			
			rlst = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rlst;
		
	}
	
	public void upProduct(ProductVO pVO) {
		
		String query = "UPDATE t_product SET pCount=?, pMoney=?, pStandard=?, firstDate=?, inDate=? ";
		query += "WHERE pName = ?";
		
		try {
			
			ProductDAO dao = new ProductDAO();
			con = dao.getDataFactory().getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pVO.getpCount());
			pstmt.setInt(2, pVO.getpMoney());
			pstmt.setDouble(3, pVO.getpStandard());
			pstmt.setString(4, pVO.getFirstDate());
			pstmt.setString(5, pVO.getinDate());
			pstmt.setString(6, pVO.getpName());
			
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delProduct(String name) {
		
		String query = "DELETE FROM t_product WHERE pName = ?";
		
		try {
			
			ProductDAO dao = new ProductDAO();
			con = dao.getDataFactory().getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<ProductVO> getProductList() {
		
		List<ProductVO> ary = new ArrayList<ProductVO>();
		
		String query = "SELECT * FROM t_product";
		
		try {
			
			ProductDAO dao = new ProductDAO();
			con = dao.getDataFactory().getConnection();
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs != null) {
			
				while(rs.next()) {
					
					ProductVO mVO = new ProductVO();
					
					mVO.setpName(rs.getString("pName"));
					mVO.setpCount(rs.getInt("pCount"));
					mVO.setpMoney(rs.getInt("pMoney"));
					mVO.setpStandard(rs.getDouble("pStandard"));
					mVO.setFirstDate(rs.getString("firstDate"));
					mVO.setinDate(rs.getString("inDate"));
					
					ary.add(mVO);
					
				}
				
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ary;
		
	}
	
}

