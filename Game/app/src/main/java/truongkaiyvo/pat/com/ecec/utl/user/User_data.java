package truongkaiyvo.pat.com.ecec.utl.user;

public class User_data {
    private Integer accountId;
    private String username;
    private String password;
    private String avt;
    private String idFigure;
    private int gold;
    private int diamond;
    private int rankPoint;
    private String friend;
    private String history;
    private String rank;
    private String nameInGame;

    public User_data(Integer accountId, String username, String password, String avt, String idFigure, int gold, int diamond, int rankPoint, String friend, String history, String rank, String nameInGame) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.avt = avt;
        this.idFigure = idFigure;
        this.gold = gold;
        this.diamond = diamond;
        this.rankPoint = rankPoint;
        this.friend = friend;
        this.history = history;
        this.rank = rank;
        this.nameInGame = nameInGame;
    }

    public User_data() {
        this.accountId = 0;
        this.username = "null";
        this.password = "null";
        this.avt = "null";
        this.idFigure = "+";
        this.gold = 5000;
        this.diamond = 500;
        this.rankPoint = 0;
        this.friend = "null";
        this.history = "null";
        this.rank = "Chưa có";
        this.nameInGame = "<Emty>";
    }


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getIdFigure() {
        return idFigure;
    }

    public void setIdFigure(String idFigure) {
        this.idFigure = idFigure;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int getRankPoint() {
        return rankPoint;
    }

    public void setRankPoint(int rankPoint) {
        this.rankPoint = rankPoint;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getNameInGame() {
        return nameInGame;
    }

    public void setNameInGame(String nameInGame) {
        this.nameInGame = nameInGame;
    }
}
