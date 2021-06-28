package truongkaiyvo.pat.com.ecec.utl.tuido;

public class TuiDoTuong {
    private String id;
    private String name;
    private int anh;
    private int gia_vang;
    private int gia_kc;
    private int atk;
    private int def;
    private String mota;


    public TuiDoTuong(){

    }

    public TuiDoTuong(String id, String name, int anh, int gia_vang, int gia_kc, int atk, int def, String mota) {
        this.id = id;
        this.name = name;
        this.anh = anh;
        this.gia_vang = gia_vang;
        this.gia_kc = gia_kc;
        this.atk = atk;
        this.def = def;
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

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
