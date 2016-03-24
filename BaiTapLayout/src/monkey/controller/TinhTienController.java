/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.controller;


import java.util.ArrayList;
import java.util.List;
import monkey.model.TinhTien;

/**
 *
 * @author Administrator
 */
public class TinhTienController {
    
    public TinhTien themTinhTien (String ma, int soLuong, float giaBan, float tongTien, float chietKhau, String tenSP)
    {
        TinhTien tinh = new TinhTien(ma, soLuong, giaBan, tongTien, chietKhau, tenSP);
        return tinh;
        //Cộng tiền hàng/ chiết khấu in/ giảm trừ/phí thu thêm/tổng giá trị thành tiền
    }
}
