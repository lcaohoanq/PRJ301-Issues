/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
import pe.dtos.ComesticDTO;
import pe.utils.DBUtils;

/**
 *
 * @author leyen
 */
public class ComesticDAO {

    public boolean insert(ComesticDTO comestic) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT [dbo].[tblComestic] ([id], [name], [description], [price], size, [status]) VALUES (?, ?, ?, ?, ?, 1)";

                pstm = con.prepareStatement(sql);
                pstm.setNString(1, comestic.getId());
                pstm.setNString(2, comestic.getName());
                pstm.setNString(3, comestic.getDescription());
                pstm.setFloat(4, comestic.getPrice());
                pstm.setNString(5, comestic.getSize());

                check = pstm.executeUpdate() > 0;
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
        return check;
    }

    public boolean update(ComesticDTO comestic) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "update [tblComestic] set name=?, description=?, price=?, size=? where id=?";

                pstm = con.prepareStatement(sql);

                pstm.setString(1, comestic.getName());
                pstm.setString(2, comestic.getDescription());
                pstm.setFloat(3, comestic.getPrice());
                pstm.setString(4, comestic.getSize());
                pstm.setString(5, comestic.getId());

                check = pstm.executeUpdate() > 0;
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
        return check;
    }

    public boolean delete(String id) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "delete from [tblComestic] where id = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);

                rs = stm.executeUpdate();
                if (rs > 0) {
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String name) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select name from tblComestic where name = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);

                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public List<ComesticDTO> getComestics(String search, String from, String to) throws SQLException {
        List<ComesticDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select * from tblComestic ";
               
                    sql += " where name like ?";
             
                if(!from.isEmpty()){
                     sql += " and price > " + from;
                    
                }
                  if(!to.isEmpty()){
                     sql += " and price < " + to;
                   
                }
                   stm = con.prepareStatement(sql);
                                 
                    stm.setString(1,"%" + search + "%");
             
                    

                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new ComesticDTO(rs.getString("id"),
                            rs.getString("name"), rs.getString("description"),
                            rs.getFloat("price"), rs.getString("size")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        try{
            if(new ComesticDAO().insert(new ComesticDTO("C-008", "Tôi là bánh quy", "bánh quy siêu ngon", 10, "XXL"))){
                System.out.println("Insert success");
            }else{
                System.out.println("Insert fail");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
