/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.*;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author cuong
 */
public class ChiTietSPRepository implements IChiTietSPRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[ChiTietSP] ( IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) values (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ChiTietSP set IdSP=?, IdNsx=?, IdMauSac=?, IdDongSP=?, NamBH=?, MoTa=?, SoLuongTon=?, GiaNhap=?, GiaBan=? where Id=?";
    final String DELETE_SQL = "DELETE FROM [dbo].[ChiTietSP] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM ChiTietSP";
    private List<ChiTietSP> _list;
    private List<ChiTietSP> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _list.add(new ChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getBigDecimal(9), rs.getBigDecimal(10)));
          }
          return _list;
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
    }

    @Override
    public List<ChiTietSP> findALL() {
        _list = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietSP save(ChiTietSP x) {
        DBConnection.Excute(INSERT_SQL, x.getSanPham(),x.getNxs(),x.getMauSac(),x.getDongSP(),x.getNamBH(),x.getMoTa(),x.getSoLuongTon(),x.getGiaNhap(),x.getGiaBan());
        return x;
    }

    @Override
    public ChiTietSP update(ChiTietSP x) {
        DBConnection.Excute(UPDATE_SQL, x.getSanPham(),x.getNxs(),x.getMauSac(),x.getDongSP(),x.getNamBH(),x.getMoTa(),x.getSoLuongTon(),x.getGiaNhap(),x.getGiaBan(),x.getId());
        return x;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }

}
