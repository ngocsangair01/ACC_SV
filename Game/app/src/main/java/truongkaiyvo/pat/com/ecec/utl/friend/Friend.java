package truongkaiyvo.pat.com.ecec.utl.friend;

import android.graphics.Bitmap;

public class Friend {
    private String id;
    private String ten;
    private int rank;
    private Bitmap anh;

    public Friend() {

    }

    public Friend(String id, String ten, int rank, Bitmap anh) {
        this.id = id;
        this.ten = ten;
        this.rank = rank;
        this.anh = anh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Bitmap getAnh() {
        return anh;
    }

    public void setAnh(Bitmap anh) {
        this.anh = anh;
    }
}
