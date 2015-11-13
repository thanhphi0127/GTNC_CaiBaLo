/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balo;

/**
 *
 * @author NguyenThanh
 */
public class Dovat{
    String  ten;
    float dongia;
    int trongluong, giatri;
    int soluongChon;					//so luong do vat chon
    int soluong;					//so luong do vat
    public Dovat(){}
    public Dovat(String ten, int trongluong, int giatri, float dongia, int soluong){
    	this.ten = ten;
    	this.trongluong = trongluong;
    	this.giatri = giatri;
    	this.dongia = dongia;
    	this.soluong = soluong;
    }
    public String getTen(){
    	return ten;
    }
    public void setTen(String ten){
    	this.ten = ten;
    }
    //Something methods
};