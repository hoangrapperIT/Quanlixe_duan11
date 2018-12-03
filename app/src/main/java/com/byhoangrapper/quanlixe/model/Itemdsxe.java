package com.byhoangrapper.quanlixe.model;

public class Itemdsxe {
    public int id;
    public String maxe;
    public String tenloaixe;
    public String mausac;
    public String gia;
    public String soluongcon;

    public Itemdsxe(String maxe,String tenloaixe,String mausac,String gia,String soluongcon){

        this.maxe=maxe;
        this.tenloaixe=tenloaixe;
        this.mausac=mausac;
        this.gia=gia;
        this.soluongcon=soluongcon;

    }
    public Itemdsxe(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenloaixe() {
        return tenloaixe;
    }

    public void setTenloaixe(String tenloaixe) {
        this.tenloaixe = tenloaixe;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSoluongcon() {
        return soluongcon;
    }

    public void setSoluongcon(String soluongcon) {
        this.soluongcon = soluongcon;
    }
}
