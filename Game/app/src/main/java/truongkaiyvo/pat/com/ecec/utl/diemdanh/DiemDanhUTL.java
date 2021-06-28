package truongkaiyvo.pat.com.ecec.utl.diemdanh;

public class DiemDanhUTL {
    private String id;
    private int anh;
    private int nhan;
    private int soluong;

    public DiemDanhUTL(){

    }

    public DiemDanhUTL(String id, int anh, int nhan, int soluong) {
        this.id = id;
        this.anh = anh;
        this.nhan = nhan;
        this.soluong = soluong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getNhan() {
        return nhan;
    }

    public void setNhan(int nhan) {
        this.nhan = nhan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
