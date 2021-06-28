package truongkaiyvo.pat.com.ecec.utl.user;

public class Gifcode_user {
    private String magif;
    private int diamond;
    private int gold;
    private boolean dungchua;

    public Gifcode_user() {

    }

    public Gifcode_user(String magif, int diamond, int gold, boolean dungchua) {
        this.magif = magif;
        this.diamond = diamond;
        this.gold = gold;
        this.dungchua = dungchua;
    }

    public String getMagif() {
        return magif;
    }

    public void setMagif(String magif) {
        this.magif = magif;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isDungchua() {
        return dungchua;
    }

    public void setDungchua(boolean dungchua) {
        this.dungchua = dungchua;
    }
}
