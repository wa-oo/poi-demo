package com.example.poi.util;

import com.example.poi.domain.t_share.TShareShiXiang;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/11
 */
public class DBOrlUtil {

    public static String selectOne(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String string = null;
        try {
            Class.forName(CommonOrl.DRIVER);
            conn = DriverManager.getConnection(CommonOrl.URL, CommonOrl.USERNAME, CommonOrl.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs == null) {
                System.out.println("没查询到");
            } else {
                while (rs.next()) {
                    string = rs.getString("ID");
                    System.out.println(string);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return string;
    }

    /**
     * 插入到主数据库中
     *
     * @param sql
     * @param tShareShiXiang
     * @throws SQLException
     */
    public static void insertSheet(String sql, TShareShiXiang tShareShiXiang ,Connection conn,PreparedStatement sss,String path,PrintWriter pw1) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        System.out.println("开始插入");
        PreparedStatement ps = conn.prepareStatement(sql);

        try {

            ps.setString(1, tShareShiXiang.getID());
            ps.setString(2, tShareShiXiang.getSXNAME());
            ps.setString(3, tShareShiXiang.getSXZXNAME());
            ps.setString(4, tShareShiXiang.getTYPE());
            ps.setString(5, tShareShiXiang.getLIMITTIME());
            ps.setString(6, tShareShiXiang.getLAWPRODUCE());
            ps.setString(7, tShareShiXiang.getISHALL());
            ps.setString(8, tShareShiXiang.getSFJLJB());
            ps.setString(9, tShareShiXiang.getISCHANGE());
            ps.setString(10, tShareShiXiang.getCHARGE());
            if (tShareShiXiang.getLIMITDAYS()!=null) {
                ps.setInt(11, Integer.valueOf(tShareShiXiang.getLIMITDAYS()));
            } else {
                ps.setString(11, null);
            }

            ps.setString(12, tShareShiXiang.getXZXK());
            ps.setString(13, tShareShiXiang.getORIGINALDEPARTMENT());
            ps.setString(14, tShareShiXiang.getXCJJTJ());
            ps.setString(15, tShareShiXiang.getWSJJTJ());
            ps.setString(16, tShareShiXiang.getWDXS());
            ps.setString(17, tShareShiXiang.getYXXT());
            ps.setString(18, tShareShiXiang.getXTMC());
            ps.setString(19, tShareShiXiang.getISZCYYBL());
            ps.setString(20, tShareShiXiang.getYYTJ());

            if (tShareShiXiang.getBLJG()!=null) {
                if (tShareShiXiang.getBLJG().length()>0) {
                    if (tShareShiXiang.getBLJG().length() > 125) {
                        ps.setString(21, null);
                    } else {
                        ps.setString(21, tShareShiXiang.getBLJG().trim());
                    }
                }else {
                    ps.setString(21, tShareShiXiang.getBLJG().trim());
                }
            } else {
                ps.setString(21, null);
            }


            ps.setString(22, tShareShiXiang.getJGYB());
            ps.setString(23, null);
            ps.setString(24, tShareShiXiang.getCNBJSXSM());
            ps.setString(25, null);
            ps.setString(26, tShareShiXiang.getFDSXDW());
            ps.setInt(27, 1);
            ps.setString(28, tShareShiXiang.getLIMITUNIT());
            ps.setString(29, "1");
            ps.setString(30, tShareShiXiang.getSQJB());
            ps.setString(31, tShareShiXiang.getTBFW());
            ps.setString(32, tShareShiXiang.getYXQX());
            ps.setString(33, tShareShiXiang.getISZCWLKD());
            ps.setString(34, tShareShiXiang.getISLIMIT());
            ps.setString(35, tShareShiXiang.getLIMITNUMBER());
            ps.setString(36, tShareShiXiang.getISLB());
            ps.setString(37, tShareShiXiang.getLBBM());
            ps.setString(38, tShareShiXiang.getSPTJ());

            //时间
            ps.setTimestamp(39, new Timestamp(System.currentTimeMillis()));
            ps.setString(40, tShareShiXiang.getSFCZ());

            if (tShareShiXiang.getISCHANGE()!=null) {
                if (Integer.valueOf(tShareShiXiang.getISCHANGE())==0){
                    ps.setInt(41,0);
                }else {
                    ps.setInt(41, Integer.valueOf(tShareShiXiang.getISCHANGE()));
                }
            } else {
                ps.setString(41, null);
            }

            ps.setString(42, "工作日 上午：9:00 至 12:00 下午：13:30 至 17:00");
            ps.setString(43, "C");
            ps.setString(44, "0");
            ps.setString(45, tShareShiXiang.getISPUBLIC());
            ps.setString(46, null);
            ps.setString(47, null);
            ps.setString(48, "1");
            ps.setString(49, "0");
            ps.setString(50, "0");
            ps.setString(51, null);
            ps.setString(52, tShareShiXiang.getISSJZJJG());
            ps.setString(53, tShareShiXiang.getSYFW());
            ps.setString(54, null);
            ps.setString(55, null);
            ps.setString(56, tShareShiXiang.getID().substring(2,7));

            ps.setString(57, tShareShiXiang.getSXZXBH());

            ps.setString(58, tShareShiXiang.getDEPARTMENT());
            //
            ps.setString(59, "012345678");
            ps.setString(60, "exp");
            ps.setString(61, tShareShiXiang.getZXYTSDH());
            ps.setString(62, null);
            ps.setString(63, "101");
            ps.setString(64, null);
            ps.setString(65, null);
            ps.setString(66, null);
            ps.setString(67, null);
            ps.setString(68, null);
            ps.setString(69, tShareShiXiang.getAreaid());
            ps.setString(70, tShareShiXiang.getBusinessDepartment());
            ps.setString(71, null);
            ps.setString(72, "2");
            ps.setString(73, tShareShiXiang.getDEPARTMENT());
            ps.setString(74, tShareShiXiang.getSXZXBH());
            if (tShareShiXiang.getSXZXNAME()!=null) {
                ps.setString(75, tShareShiXiang.getSXZXNAME());
            } else {
                ps.setString(75, null);
            }


            System.out.println("开始execute()");
            ps.execute();
            conn.commit();
            System.out.println("插入成功");
        } catch (Exception e) {
            pw1.println(path+"==="+e.getMessage());
            e.printStackTrace();
        } finally {
            if (ps!=null){
                ps.close();
            }
        }
    }

    public static void insertVersion(String sql, TShareShiXiang tShareShiXiang ,Connection conn,PreparedStatement sss,String path,PrintWriter pw1) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            ps.setString(1, tShareShiXiang.getID());
            ps.setString(2, tShareShiXiang.getSXNAME());
            ps.setString(3, tShareShiXiang.getSXZXNAME());
            ps.setString(4, tShareShiXiang.getTYPE());
            ps.setString(5, tShareShiXiang.getLIMITTIME());
            ps.setString(6, tShareShiXiang.getLAWPRODUCE());
            ps.setString(7, tShareShiXiang.getISHALL());
            ps.setString(8, tShareShiXiang.getSFJLJB());
            ps.setString(9, tShareShiXiang.getISCHANGE());
            ps.setString(10, tShareShiXiang.getCHARGE());
            if (tShareShiXiang.getLIMITDAYS()!=null) {
                ps.setInt(11, Integer.valueOf(tShareShiXiang.getLIMITDAYS()));
            } else {
                ps.setString(11, null);
            }

            ps.setString(12, "2");
//            ps.setString(12, tShareShiXiang.getXZXK());
            ps.setString(13, tShareShiXiang.getORIGINALDEPARTMENT());
            ps.setString(14, tShareShiXiang.getXCJJTJ());
            ps.setString(15, tShareShiXiang.getWSJJTJ());
            ps.setString(16, tShareShiXiang.getWDXS());
            ps.setString(17, tShareShiXiang.getYXXT());
            ps.setString(18, tShareShiXiang.getXTMC());
            ps.setString(19, tShareShiXiang.getISZCYYBL());
            ps.setString(20, tShareShiXiang.getYYTJ());

            if (tShareShiXiang.getBLJG()!=null) {
                if (tShareShiXiang.getBLJG().length()>0) {
                    if (tShareShiXiang.getBLJG().length() > 125) {
                        ps.setString(21, null);
                    } else {
                        ps.setString(21, tShareShiXiang.getBLJG().trim());
                    }
                }else {
                    ps.setString(21, tShareShiXiang.getBLJG().trim());
                }
            } else {
                ps.setString(21, null);
            }

            ps.setString(22, tShareShiXiang.getJGYB());
            ps.setString(23, null);
            ps.setString(24, tShareShiXiang.getCNBJSXSM());
            ps.setString(25, null);
            ps.setString(26, tShareShiXiang.getFDSXDW());
            ps.setInt(27, 1);
            ps.setString(28, tShareShiXiang.getLIMITUNIT());
            ps.setString(29, "1");
            ps.setString(30, tShareShiXiang.getSQJB());
            ps.setString(31, tShareShiXiang.getTBFW());
            ps.setString(32, tShareShiXiang.getYXQX());
            ps.setString(33, tShareShiXiang.getISZCWLKD());
            ps.setString(34, tShareShiXiang.getISLIMIT());
            ps.setString(35, tShareShiXiang.getLIMITNUMBER());
            ps.setString(36, tShareShiXiang.getISLB());
            ps.setString(37, tShareShiXiang.getLBBM());
            ps.setString(38, tShareShiXiang.getSPTJ());

            //时间
            ps.setTimestamp(39, new Timestamp(System.currentTimeMillis()));
            ps.setString(40, tShareShiXiang.getSFCZ());

            if (tShareShiXiang.getISCHANGE()!=null) {
                if (Integer.valueOf(tShareShiXiang.getISCHANGE())==0){
                    ps.setInt(41,0);
                }else {
                    ps.setInt(41, Integer.valueOf(tShareShiXiang.getISCHANGE()));
                }
            } else {
                ps.setString(41, null);
            }

            ps.setString(42, "工作日 上午：9:00 至 12:00 下午：13:30 至 17:00");
            ps.setString(43, "C");
            ps.setString(44, "0");
            ps.setString(45, tShareShiXiang.getISPUBLIC());
            ps.setString(46, null);
            ps.setString(47, null);
            ps.setString(48, "1");
            ps.setString(49, "0");
            ps.setString(50, "0");
            ps.setString(51, tShareShiXiang.getISSJZJJG());
            ps.setString(52, tShareShiXiang.getSYFW());
            ps.setString(53, null);
            ps.setString(54, tShareShiXiang.getID().substring(2,7));
            ps.setString(55, "001");
            ps.setString(56, tShareShiXiang.getDEPARTMENT());
            ps.setString(57, tShareShiXiang.getBusinessDepartment());
            ps.setString(58, "exp");

            System.out.println("开始execute()");
            ps.execute();
            conn.commit();
            System.out.println("插入成功");
        } catch (Exception e) {
            pw1.println(path+"==="+e.getMessage());
            e.printStackTrace();
        } finally {
            if (ps!=null){
                ps.close();
            }
        }
    }

    public static void insertPermissionMapnode(String sql,TShareShiXiang tShareShiXiang,Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            Date date = new Date();
            ps.setString(1, sdf.format(date));
            ps.setString(2,tShareShiXiang.getID());
            ps.setString(3,"受理");
            ps.setString(4,"0");
            ps.setString(5,"1");
            ps.setString(6,"C");
            ps.setString(7,"0");
            ps.setString(8,"0");
            ps.setString(9,"1");
            ps.setString(10,"exp");
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }

        }
    }

    /**
     * 查找是否有重复ID
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public static Integer selectID(String sql,String ID) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try {
            Class.forName(CommonOrl.DRIVER);
            conn = DriverManager.getConnection(CommonOrl.URL, CommonOrl.USERNAME, CommonOrl.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1,ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = Integer.valueOf(rs.getString("count(*)"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return count;
    }
}
