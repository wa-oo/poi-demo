package com.example.poi.util;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/11
 */
public class CommonOrl {

    // connect the database
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DB_NAME = "orcl";
    public static final String USERNAME = "tianjin_sxgl";
//    public static final String USERNAME = "tjzwfw";
    public static final String PASSWORD = "12345678";
//    public static final String PASSWORD = "tjzwfw";
    public static final String IP = "172.16.200.76";
//    public static final String IP = "192.168.1.130";
    public static final String PORT = "1521";

    public static final String URL = "jdbc:oracle:thin:@172.16.200.76:1521:orcl";
//    public static final String URL = "jdbc:oracle:thin:@192.168.1.130:1521:orcl";

    public static final String Select_Code_SQL = "select * FROM T_SHARE_BASEPERMISSIONITEM where id ='010002100300'";
    public static final String Select_ID_SQL = "select count(*) from T_SHARE_BASEPERMISSIONITEM where id=?";
    public static final String Select_BuMen_SQL = "select deptid from t_sys_Dept  where name like ? ";
    public static final String Select_BuMenMingChen_SQL = "select name,areaid from t_sys_Dept t where deptid = ? ";
    public static final String Insert_Sheet_SQL = "INSERT INTO T_SHARE_PERMISSIONITEM (ID,SXNAME,SXZXNAME,TYPE,LIMITTIME,LAWPRODUCE,ISHALL,SFJLJB,ISCHANGE,CHARGE,LIMITDAYS,XZXK,ORIGINALDEPARTMENT,XCJJTJ,WSJJTJ,WDXS,YXXT,XTMC,ISZCYYBL,YYTJ,BLJG,JGYB,SSBM,CNBJSXSM,TSDH,FDSXDW,VERSION,LIMITUNIT,STATUS,SQJB,TBFW,YXQX,ISZCWLKD,ISLIMIT,LIMITNUMBER,ISLB,LBBM,SPTJ,CREATETIME,SFCZ,SFJE,BLSJ,CHANGETYPE,EXCHANGE,ISPUBLIC,SFKCJSP,SFKBMSP,SXXZ,SFYS,SFWSSB,EXEWSDT,ISSJZJJG,SYFW,IS_HP,SLTBCX,SXBH,SXZXBH,DEPARTMENT,SPJDJG,createrid,ZXYTSDH,BID,BLX,SXSSBM ,QLXF,SHOW_COUNT,SECTION,JGDEPT,GGAREAID,GGDEPTNAME, YYSPPHONE,bldd,GGDEPTID,TEMPSXZXBH,TEMPSXZXNAME)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String Insert_permissionmapnode_SQL = "INSERT INTO t_sys_permissionmapnode (ID,PID,nodename,type,ordernum,CHANGETYPE,EXCHANGE,VERSION,STATUS,BID) VALUES (?,?,?,?,?,?,?,?,?,?)";
    public static final String Insert_Version_SQL = "INSERT INTO T_SHARE_PERMISSIONITEM_VERSION (ID,SXNAME,SXZXNAME,TYPE,LIMITTIME,LAWPRODUCE,ISHALL,SFJLJB,ISCHANGE,CHARGE,LIMITDAYS,XZXK,ORIGINALDEPARTMENT,XCJJTJ,WSJJTJ,WDXS,YXXT,XTMC,ISZCYYBL,YYTJ,BLJG,JGYB,SSBM,CNBJSXSM,TSDH,FDSXDW,VERSION,LIMITUNIT,STATUS,SQJB,TBFW,YXQX,ISZCWLKD,ISLIMIT,LIMITNUMBER,ISLB,LBBM,SPTJ,CREATETIME,SFCZ,SFJE,BLSJ,CHANGETYPE,EXCHANGE,ISPUBLIC,SFKCJSP,SFKBMSP,SXXZ,SFYS,SFWSSB,ISSJZJJG,SYFW,IS_HP,SXBH,SXZXBH,DEPARTMENT,SPJDJG,createrid )VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
