package com.example.poi.domain.t_share;

import java.util.Date;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/10
 */
public class TShareShiXiang {
    //basic_coding
    private String ID;
    //item_name
    private String SXNAME;
    //child_name
    private String SXZXNAME;
    //service_object
    private String TYPE;
    //statutory_time
    private String LIMITTIME;
    //basis
    private String LAWPRODUCE;
    //field_connector online_connection
    private String ISHALL;
    //statutory_time  commitment_time
    private String SFJLJB;
    //是否收费，0否，1是 charge
    private String ISCHANGE;
    private String CHARGE;
    private String LIMITDAYS;
    private String XZXK;
    private String ORIGINALDEPARTMENT;
    private String XCJJTJ;
    private String WSJJTJ;
    private String WDXS;
    private String YXXT;
    private String XTMC;
    private String ISZCYYBL;
    private String YYTJ;
    private String BLJG;
    private String JGYB;
    private String SSBM;
    private String CNBJSXSM;
    private String TSDH;
    private String FDSXDW;
    private String LIMITUNIT;
    private String SQJB;
    private String TBFW;
    private String YXQX;
    private String ISZCWLKD;
    private String ISLIMIT;
    private String LIMITNUMBER;
    private String ISLB;
    private String LBBM;
    private String SPTJ;
    private Date CREATETIME;
    private String SFCZ;
    private Integer SFJE;
    private String ISPUBLIC;
    private String ISSJZJJG;
    private String SYFW;
    private String BusinessDepartment;
    private String DEPARTMENT;
    private String areaid;
    private String createrid;
    private String ZXYTSDH;
    private String SXZXBH;

    public String getSXZXBH() {
        return SXZXBH;
    }

    public void setSXZXBH(String SXZXBH) {
        this.SXZXBH = SXZXBH;
    }

    public String getZXYTSDH() {
        return ZXYTSDH;
    }

    public void setZXYTSDH(String ZXYTSDH) {
        this.ZXYTSDH = ZXYTSDH;
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    public String getBusinessDepartment() {
        return BusinessDepartment;
    }

    public void setBusinessDepartment(String businessDepartment) {
        BusinessDepartment = businessDepartment;
    }

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSYFW() {
        return SYFW;
    }

    public void setSYFW(String SYFW) {
        this.SYFW = SYFW;
    }

    public String getISSJZJJG() {
        return ISSJZJJG;
    }

    public void setISSJZJJG(String ISSJZJJG) {
        this.ISSJZJJG = ISSJZJJG;
    }

    public String getISPUBLIC() {
        return ISPUBLIC;
    }

    public void setISPUBLIC(String ISPUBLIC) {
        this.ISPUBLIC = ISPUBLIC;
    }

    public Integer getSFJE() {
        return SFJE;
    }

    public void setSFJE(Integer SFJE) {
        this.SFJE = SFJE;
    }

    public String getSFCZ() {
        return SFCZ;
    }

    public void setSFCZ(String SFCZ) {
        this.SFCZ = SFCZ;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getSPTJ() {
        return SPTJ;
    }

    public void setSPTJ(String SPTJ) {
        this.SPTJ = SPTJ;
    }

    public String getLBBM() {
        return LBBM;
    }

    public void setLBBM(String LBBM) {
        this.LBBM = LBBM;
    }

    public String getISLB() {
        return ISLB;
    }

    public void setISLB(String ISLB) {
        this.ISLB = ISLB;
    }

    public String getLIMITNUMBER() {
        return LIMITNUMBER;
    }

    public void setLIMITNUMBER(String LIMITNUMBER) {
        this.LIMITNUMBER = LIMITNUMBER;
    }

    public String getISLIMIT() {
        return ISLIMIT;
    }

    public void setISLIMIT(String ISLIMIT) {
        this.ISLIMIT = ISLIMIT;
    }

    public String getISZCWLKD() {
        return ISZCWLKD;
    }

    public void setISZCWLKD(String ISZCWLKD) {
        this.ISZCWLKD = ISZCWLKD;
    }

    public String getYXQX() {
        return YXQX;
    }

    public void setYXQX(String ZJYXQ) {
        this.YXQX = ZJYXQ;
    }


    public String getTBFW() {
        return TBFW;
    }

    public void setTBFW(String TBFW) {
        this.TBFW = TBFW;
    }

    public String getSQJB() {
        return SQJB;
    }

    public void setSQJB(String SQJB) {
        this.SQJB = SQJB;
    }

    public String getLIMITUNIT() {
        return LIMITUNIT;
    }

    public void setLIMITUNIT(String LIMITUNIT) {
        this.LIMITUNIT = LIMITUNIT;
    }

    public String getFDSXDW() {
        return FDSXDW;
    }

    public void setFDSXDW(String FDSXDW) {
        this.FDSXDW = FDSXDW;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSXNAME() {
        return SXNAME;
    }

    public void setSXNAME(String SXNAME) {
        this.SXNAME = SXNAME;
    }

    public String getSXZXNAME() {
        return SXZXNAME;
    }

    public void setSXZXNAME(String SXZXNAME) {
        this.SXZXNAME = SXZXNAME;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getLIMITTIME() {
        return LIMITTIME;
    }

    public void setLIMITTIME(String LIMITTIME) {
        this.LIMITTIME = LIMITTIME;
    }

    public String getLAWPRODUCE() {
        return LAWPRODUCE;
    }

    public void setLAWPRODUCE(String LAWPRODUCE) {
        this.LAWPRODUCE = LAWPRODUCE;
    }

    public String getISHALL() {
        return ISHALL;
    }

    public void setISHALL(String ISHALL) {
        this.ISHALL = ISHALL;
    }

    public String getSFJLJB() {
        return SFJLJB;
    }

    public void setSFJLJB(String SFJLJB) {
        this.SFJLJB = SFJLJB;
    }

    public String getISCHANGE() {
        return ISCHANGE;
    }

    public void setISCHANGE(String ISCHANGE) {
        this.ISCHANGE = ISCHANGE;
    }

    public String getCHARGE() {
        return CHARGE;
    }

    public void setCHARGE(String CHARGE) {
        this.CHARGE = CHARGE;
    }

    public String getLIMITDAYS() {
        return LIMITDAYS;
    }

    public void setLIMITDAYS(String LIMITDAYS) {
        this.LIMITDAYS = LIMITDAYS;
    }

    public String getXZXK() {
        return XZXK;
    }

    public void setXZXK(String XZXK) {
        this.XZXK = XZXK;
    }

    public String getORIGINALDEPARTMENT() {
        return ORIGINALDEPARTMENT;
    }

    public void setORIGINALDEPARTMENT(String ORIGINALDEPARTMENT) {
        this.ORIGINALDEPARTMENT = ORIGINALDEPARTMENT;
    }

    public String getXCJJTJ() {
        return XCJJTJ;
    }

    public void setXCJJTJ(String XCJJTJ) {
        this.XCJJTJ = XCJJTJ;
    }

    public String getWSJJTJ() {
        return WSJJTJ;
    }

    public void setWSJJTJ(String WSJJTJ) {
        this.WSJJTJ = WSJJTJ;
    }

    public String getWDXS() {
        return WDXS;
    }

    public void setWDXS(String WDXS) {
        this.WDXS = WDXS;
    }

    public String getYXXT() {
        return YXXT;
    }

    public void setYXXT(String YXXT) {
        this.YXXT = YXXT;
    }

    public String getXTMC() {
        return XTMC;
    }

    public void setXTMC(String XTMC) {
        this.XTMC = XTMC;
    }

    public String getISZCYYBL() {
        return ISZCYYBL;
    }

    public void setISZCYYBL(String ISZCYYBL) {
        this.ISZCYYBL = ISZCYYBL;
    }

    public String getYYTJ() {
        return YYTJ;
    }

    public void setYYTJ(String YYTJ) {
        this.YYTJ = YYTJ;
    }

    public String getBLJG() {
        return BLJG;
    }

    public void setBLJG(String BLJG) {
        this.BLJG = BLJG;
    }

    public String getJGYB() {
        return JGYB;
    }

    public void setJGYB(String JGYB) {
        this.JGYB = JGYB;
    }

    public String getSSBM() {
        return SSBM;
    }

    public void setSSBM(String SSBM) {
        this.SSBM = SSBM;
    }

    public String getCNBJSXSM() {
        return CNBJSXSM;
    }

    public void setCNBJSXSM(String CNBJSXSM) {
        this.CNBJSXSM = CNBJSXSM;
    }

    public String getTSDH() {
        return TSDH;
    }

    public void setTSDH(String TSDH) {
        this.TSDH = TSDH;
    }

    @Override
    public String toString() {
        return "TShareShiXiang{" +
                "ID='" + ID + '\'' +
                ", SXNAME='" + SXNAME + '\'' +
                ", SXZXNAME='" + SXZXNAME + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", LIMITTIME='" + LIMITTIME + '\'' +
                ", LAWPRODUCE='" + LAWPRODUCE + '\'' +
                ", ISHALL='" + ISHALL + '\'' +
                ", SFJLJB='" + SFJLJB + '\'' +
                ", ISCHANGE='" + ISCHANGE + '\'' +
                ", CHARGE='" + CHARGE + '\'' +
                ", LIMITDAYS='" + LIMITDAYS + '\'' +
                ", XZXK='" + XZXK + '\'' +
                ", ORIGINALDEPARTMENT='" + ORIGINALDEPARTMENT + '\'' +
                ", XCJJTJ='" + XCJJTJ + '\'' +
                ", WSJJTJ='" + WSJJTJ + '\'' +
                ", WDXS='" + WDXS + '\'' +
                ", YXXT='" + YXXT + '\'' +
                ", XTMC='" + XTMC + '\'' +
                ", ISZCYYBL='" + ISZCYYBL + '\'' +
                ", YYTJ='" + YYTJ + '\'' +
                ", BLJG='" + BLJG + '\'' +
                ", JGYB='" + JGYB + '\'' +
                ", SSBM='" + SSBM + '\'' +
                ", CNBJSXSM='" + CNBJSXSM + '\'' +
                ", TSDH='" + TSDH + '\'' +
                '}';
    }
}