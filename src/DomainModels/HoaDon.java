/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author cuong
 */
public class HoaDon {
    private Integer id;
    private String ma;
    private Date ngayTao;
    private Date ngayShip;
    private Date ngayNhan;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;

    public HoaDon() {
    }

    public HoaDon(Integer id, String ma, Date ngayTao, Date ngayShip, Date ngayNhan, String tenNguoiNhan, String diaChi, String sdt) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
