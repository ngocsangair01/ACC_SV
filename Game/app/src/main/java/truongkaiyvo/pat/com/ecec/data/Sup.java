package truongkaiyvo.pat.com.ecec.data;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopTuong;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoBoTro;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoDa;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoTuong;
import truongkaiyvo.pat.com.ecec.utl.user.Gifcode_user;
import truongkaiyvo.pat.com.ecec.utl.user.User_data;

public class Sup {
    public  static String url_sua_diamond = "https://api-game-naruto-dattebayo.herokuapp.com/api/accounts/update" ;
    public static User_data user_data = new User_data();
    public static Gifcode_user gifcodeUser = new Gifcode_user("NEWUSER01",500,5000,false);
    public static ArrayList<TuiDoBoTro> tuiDoBoTros = new ArrayList<>();
    public static ArrayList<TuiDoTuong> tuiDoTuongs = new ArrayList<>();
    public static ArrayList<TuiDoTuong> chonTuongs = new ArrayList<>();
    public static ArrayList<TuiDoBoTro> chonBotros = new ArrayList<>();
    public static ArrayList<TuiDoTuong> daChonTuongs = new ArrayList<>();
    public static ArrayList<TuiDoBoTro> daChonBoTros = new ArrayList<>();
    public static ArrayList<TuiDoDa> tuiDoDas = new ArrayList<TuiDoDa>();
    public static int daugi,sansangchua,capmay=1,d_mau_may,d_mau_acc;
    public static List<String> stringList = new ArrayList<>();
    public static ArrayList<TuiDoTuong> dau_tuiDoTuongs = new ArrayList<>();
    public static ArrayList<TuiDoBoTro> dau_tuiDoBoTros = new ArrayList<>();

    public static void khoitaotran(){
        chonTuongs = new ArrayList<>();
        chonBotros = new ArrayList<>();
        chonTuongs.clear();
        chonBotros.clear();
        {
            Sup.taotuong();
            String str = Sup.user_data.getIdFigure();//ten_tuong+ten_tuong+
            String tmp="";
            for (int i=0;i< str.length();i++){
                if (str.charAt(i) == '+'){
                    aa:for (TuiDoTuong j : Sup.tuiDoTuongs){
                        if (tmp.compareTo(j.getId())==0){
                            Sup.chonTuongs.add(j);
                            break aa;
                        }
                    }
                    tmp="";
                }
                else
                    tmp+=str.charAt(i);
            }
        }
        {
            Sup.taotuibotro();
            String str = Sup.user_data.getIdFigure();//ten_tuong+ten_tuong+
            String tmp="";
            for (int i=0;i< str.length();i++){
                if (str.charAt(i) == '+'){
                    aa:for (TuiDoBoTro j : Sup.tuiDoBoTros){
                        if (tmp.compareTo(j.getId())==0){
                            Sup.chonBotros.add(j);
                            break aa;
                        }
                    }
                    tmp="";
                }
                else
                    tmp+=str.charAt(i);
            }
        }
        daChonTuongs = new ArrayList<>();
        daChonBoTros = new ArrayList<>();
    }
    public static void taoda(){
        tuiDoDas.add(new TuiDoDa("da_01","Bí kíp kỹ năng", R.mipmap.da_02,1500,150,"Dùng để nâng cấp tường"));
        tuiDoDas.add(new TuiDoDa("da_02","Bí kíp bổ trợ",R.mipmap.da_01,1500,150,"Dùng để nâng cấp bổ trợ"));
    }
    public static void taotuong(){
        tuiDoTuongs.clear();
        tuiDoTuongs = new ArrayList<>();
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_01", "Asuma",R.mipmap.sin_asuma,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_01", "Asuma",R.mipmap.sin_akatsuchi_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_02", "Bruto",R.mipmap.sin_asuma_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_03", "Jraiya",R.mipmap.sin_bee_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_04", "Kurrosuchi",R.mipmap.sin_boruto_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_05", "Zabuza",R.mipmap.sin_danzo_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_05", "Bruto",R.mipmap.sin_darui_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_06", "Jraiya",R.mipmap.sin_deidara_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_07", "Kurrosuchi",R.mipmap.sin_haku_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_08", "Zabuza",R.mipmap.sin_hiruzen_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_09", "Asuma",R.mipmap.sin_jraiya_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_10", "Bruto",R.mipmap.sin_jugo_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_11", "Jraiya",R.mipmap.sin_kakashi_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_12", "Kurrosuchi",R.mipmap.sin_kisame_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_13", "Zabuza",R.mipmap.sin_konohamaru_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_14", "Asuma",R.mipmap.sin_korosuchi_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_15", "Bruto",R.mipmap.sin_korosuki_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_16", "Jraiya",R.mipmap.sin_mirai_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_17", "Kurrosuchi",R.mipmap.sin_orochimaru_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_18", "Zabuza",R.mipmap.sin_rand_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_19", "Asuma",R.mipmap.sin_shy_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_20", "Jraiya",R.mipmap.sin_suigetsu_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_21", "Kurrosuchi",R.mipmap.sin_temari_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_22", "Zabuza",R.mipmap.sin_yamato_1,1200,120,5,4,"[Tướng sịn]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_sin_23", "Asuma",R.mipmap.sin_zabuza_1,1200,120,5,4,"[Tướng sịn]\n"));

//      ==================================  Thường =====================================

        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_01", "Asuma",R.mipmap.thuong_akatsuchi_1,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_02", "Asuma",R.mipmap.thuong_akatsuchi_2,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_03", "Asuma",R.mipmap.thuong_akatsuchi_3,600,60,3,2,"[Tướng thường]\n"));

        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_04", "Asuma",R.mipmap.thuong_darui_1,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_05", "Asuma",R.mipmap.thuong_darui_2,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_06", "Asuma",R.mipmap.thuong_darui_3,600,60,3,2,"[Tướng thường]\n"));

        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_07", "Asuma",R.mipmap.thuong_kakashi_1,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_08", "Asuma",R.mipmap.thuong_kakashi_2,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_09", "Asuma",R.mipmap.thuong_kakashi_3,600,60,3,2,"[Tướng thường]\n"));

        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_10", "Asuma",R.mipmap.thuong_danzo_1,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_11", "Asuma",R.mipmap.thuong_danzo_2,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_12", "Asuma",R.mipmap.thuong_danzo_3,600,60,3,2,"[Tướng thường]\n"));

        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_13", "Asuma",R.mipmap.thuong_zabuza_1,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_14", "Asuma",R.mipmap.thuong_zabuza_2,600,60,3,2,"[Tướng thường]\n"));
        tuiDoTuongs.add(new TuiDoTuong("tuong_thuong_15", "Asuma",R.mipmap.thuong_zabuza_3,600,60,3,2,"[Tướng thường]\n"));
    }
    public static void taotuibotro(){
        tuiDoBoTros.clear();
        tuiDoBoTros = new ArrayList<>();
        tuiDoBoTros.add(new TuiDoBoTro("botro_01","Cứu trợ từ Rin", R.mipmap.botro_rin,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_02","Cứu trợ từ Sakura",R.mipmap.botro_sakura,800,80,"BUFF_HP_all_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_03","Cứu trợ từ Tsunade",R.mipmap.botro_tsunade,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_04","Cứu trợ từ Bát vĩ",R.mipmap.botro_nhatvi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_05","Cứu trợ từ Bát vĩ",R.mipmap.botro_nhivi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_06","Cứu trợ từ Bát vĩ",R.mipmap.botro_tamvi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_07","Cứu trợ từ Bát vĩ",R.mipmap.botro_tuvi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_08","Cứu trợ từ Bát vĩ",R.mipmap.botro_nguvi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_09","Cứu trợ từ Bát vĩ",R.mipmap.botro_lucvi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_10","Cứu trợ từ Bát vĩ",R.mipmap.botro_thatvi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_11","Cứu trợ từ Bát vĩ",R.mipmap.botro_batvi,800,80,"BUFF_HP_1_2",""));
        tuiDoBoTros.add(new TuiDoBoTro("botro_12","Cứu trợ từ Bát vĩ",R.mipmap.botro_cuuvi,800,80,"BUFF_HP_1_2",""));
    }
}
