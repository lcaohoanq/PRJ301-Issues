package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBUtils;

public class MobileDAO {

	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public List<MobileDTO> getAllMobile() {
		List<MobileDTO> mobilesList = new ArrayList<>();
		try {
			con = DBUtils.getConnection();
			if (con != null) {
				pstm = con.prepareStatement("SELECT * FROM tbl_Mobile");
				rs = pstm.executeQuery();

				while (rs.next()) {
					String mobileId = rs.getString("mobileId");
					String description = rs.getString("description");
					float price = rs.getFloat("price");
					String mobileName = rs.getString("mobileName");
					int yearOfProduction = rs.getInt("yearOfProduction");
					int quantity = rs.getInt("quantity");
					int notSale = rs.getInt("notSale");
					String url = rs.getString("url");

					mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
							notSale, url));
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mobilesList;
	}

	public List<MobileDTO> selectPriceInRange(int min, int max) throws Exception {
		List<MobileDTO> mobilesList = new ArrayList<>();
		try {
			con = DBUtils.getConnection();
			if (con != null) {
				pstm = con.prepareStatement("SELECT * FROM tbl_Mobile WHERE price BETWEEN ? AND ?");
				pstm.setInt(1, min);
				pstm.setInt(2, max);
				rs = pstm.executeQuery();

				while (rs.next()) {
					String mobileId = rs.getString("mobileId");
					String description = rs.getString("description");
					float price = rs.getFloat("price");
					String mobileName = rs.getString("mobileName");
					int yearOfProduction = rs.getInt("yearOfProduction");
					int quantity = rs.getInt("quantity");
					int notSale = rs.getInt("notSale");
					String url = rs.getString("url");
					mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
							notSale, url));
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mobilesList;
	}

	public List<MobileDTO> searchMobileByName(String search) throws Exception {
		List<MobileDTO> mobilesList = new ArrayList<>();
		try {
			con = DBUtils.getConnection();
			if (con != null) {
				pstm = con.prepareStatement("SELECT * FROM tbl_Mobile WHERE mobileName LIKE ?");
				pstm.setString(1, "%" + search + "%");
				rs = pstm.executeQuery();

				while (rs.next()) {
					String mobileId = rs.getString("mobileId");
					String description = rs.getString("description");
					float price = rs.getFloat("price");
					String mobileName = rs.getString("mobileName");
					int yearOfProduction = rs.getInt("yearOfProduction");
					int quantity = rs.getInt("quantity");
					int notSale = rs.getInt("notSale");
					String url = rs.getString("url");
					mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
							notSale, url));
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mobilesList;
	}

	public List<MobileDTO> getMobileById(String mobileId) throws Exception {
		List<MobileDTO> mobilesList = new ArrayList<>();
		try {
			con = DBUtils.getConnection();
			if (con != null) {
				pstm = con.prepareStatement("SELECT * FROM tbl_Mobile WHERE mobileId = ?");
				pstm.setString(1, mobileId);
				rs = pstm.executeQuery();

				if (rs.next()) {
					String description = rs.getString("description");
					float price = rs.getFloat("price");
					String mobileName = rs.getString("mobileName");
					int yearOfProduction = rs.getInt("yearOfProduction");
					int quantity = rs.getInt("quantity");
					int notSale = rs.getInt("notSale");
					String url = rs.getString("url");
					mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
							notSale, url));
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mobilesList;
	}

	public boolean insertMobile(MobileDTO mobile) throws Exception {
		boolean result = false;
		try {
			con = DBUtils.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(
						"INSERT INTO tbl_Mobile(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale) VALUES(?,?,?,?,?,?,?)");
				pstm.setString(1, mobile.getMobileId());
				pstm.setString(2, mobile.getDescription());
				pstm.setFloat(3, mobile.getPrice());
				pstm.setString(4, mobile.getMobileName());
				pstm.setInt(5, mobile.getYearOfProduction());
				pstm.setInt(6, mobile.getQuantity());
				pstm.setInt(7, mobile.getNotSale());

				result = pstm.executeUpdate() > 0;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public boolean deleteMobile(String mobileId) throws Exception {
		boolean result = false;
		try {
			con = DBUtils.getConnection();
			if (con != null) {
				pstm = con.prepareStatement("DELETE FROM tbl_Mobile WHERE mobileId = ?");
				pstm.setString(1, mobileId);

				result = pstm.executeUpdate() > 0;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public boolean updateMobile(MobileDTO mobile) throws Exception {
		boolean checkUpdate = false;
		try {
			con = DBUtils.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(
						"UPDATE tbl_Mobile SET price = ?, description = ?, quantity = ?, notSale = ? WHERE mobileId = ?");
				pstm.setFloat(1, mobile.getPrice());
				pstm.setString(2, mobile.getDescription());
				pstm.setInt(3, mobile.getQuantity());
				pstm.setInt(4, mobile.getNotSale());
				pstm.setString(5, mobile.getMobileId());
				checkUpdate = pstm.executeUpdate() > 0 ? true : false;
			}
		} catch (Exception e) {
		} finally {
			if (pstm != null) {
				pstm.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return checkUpdate;
	}

	public static void main(String[] args) throws Exception {
		new MobileDAO().getAllMobile().stream().forEach(System.out::println);
	}

}
