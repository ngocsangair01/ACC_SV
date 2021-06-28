package truongkaiyvo.pat.com.ecec.utl.tuido;

public class TuiDoBoTro {
    private String id;
    private String name;
    private int anh;
    private int gia_vang;
    private int gia_kc;
    private String thuoctinh;
    private String mota;

    public TuiDoBoTro(){

    }

    public TuiDoBoTro(String id, String name, int anh, int gia_vang, int gia_kc, String thuoctinh, String mota) {
        this.id = id;
        this.name = name;
        this.anh = anh;
        this.gia_vang = gia_vang;
        this.gia_kc = gia_kc;
        this.thuoctinh = thuoctinh;
        this.mota = mota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getGia_vang() {
        return gia_vang;
    }

    public void setGia_vang(int gia_vang) {
        this.gia_vang = gia_vang;
    }

    public int getGia_kc() {
        return gia_kc;
    }

    public void setGia_kc(int gia_kc) {
        this.gia_kc = gia_kc;
    }

    public String getThuoctinh() {
        return thuoctinh;
    }

    public void setThuoctinh(String thuoctinh) {
        this.thuoctinh = thuoctinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

