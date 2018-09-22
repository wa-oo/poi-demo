package com.example.poi.util;

import com.example.poi.domain.ApplicationMaterials;
import com.example.poi.domain.CommonProblem;
import com.example.poi.domain.InformationSheet;
import com.example.poi.domain.ProcessingProcess;
import com.example.poi.domain.t_share.TShareShiXiang;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {

    public static void insertApplicationMaterials(String sql, ApplicationMaterials applicationMaterials) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(applicationMaterials.getInformationId()));
            ps.setString(2, applicationMaterials.getMaterialName());
            ps.setString(3, applicationMaterials.getMaterialLevel());
            ps.setString(4, applicationMaterials.getMaterialProperties());
            ps.setString(5, applicationMaterials.getMaterialSource());
            ps.setString(6, applicationMaterials.getMaterialPreparation());
            ps.setString(7, applicationMaterials.getLegalBasis());
            ps.setString(8, applicationMaterials.getReviewCriteria());
            ps.setString(9, applicationMaterials.getEmptyTable());
            ps.setString(10, applicationMaterials.getSampleTable());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void insertCommonProblem(String sql, CommonProblem commonProblem) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(commonProblem.getInformationId()));
            ps.setString(2, commonProblem.getProblem());
            ps.setString(3, commonProblem.getAnswer());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void insertInformationSheet(String sql, InformationSheet informationSheet) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, informationSheet.getTableName());
            ps.setString(2, informationSheet.getItemName());
            ps.setString(3, informationSheet.getBasicCoding());
            ps.setString(4, informationSheet.getChildName());
            ps.setString(5, informationSheet.getTypeName());
            ps.setString(6, informationSheet.getApprovalCategory());
            ps.setString(7, informationSheet.getServiceObject());
            ps.setString(8, informationSheet.getAdministrativeExamination());
            ps.setString(9, informationSheet.getExerciseLevel());
            ps.setString(10, informationSheet.getHandlingType());
            ps.setString(11, informationSheet.getBusinessDepartment());
            ps.setString(12, informationSheet.getImplementationDepartment());
            ps.setString(13, informationSheet.getImplementationCoding());
            ps.setString(14, informationSheet.getComplaintCall());
            ps.setString(15, informationSheet.getLocation());
            ps.setString(16, informationSheet.getSupportHotline());
            ps.setString(17, informationSheet.getGeneralScope());
            ps.setString(18, informationSheet.getStatutoryTime());
            ps.setString(19, informationSheet.getCommitmentTime());
            ps.setString(20, informationSheet.getValidityPeriod());
            ps.setString(21, informationSheet.getScope());
            ps.setString(22, informationSheet.getDispatch());
            ps.setString(23, informationSheet.getIntermediaryService());
            ps.setString(24, informationSheet.getFieldConnector());
            ps.setString(25, informationSheet.getSiteAccessPath());
            ps.setString(26, informationSheet.getOnlineConnection());
            ps.setString(27, informationSheet.getOnlineAccessPath());
            ps.setString(28, informationSheet.getLogisticsExpress());
            ps.setString(29, informationSheet.getExpressForm());
            ps.setString(30, informationSheet.getSupportReservation());
            ps.setString(31, informationSheet.getAppointmentRoute());
            ps.setString(32, informationSheet.getQuantitativeRestrictions());
            ps.setString(33, informationSheet.getQuantitativeNumber());
            ps.setString(34, informationSheet.getJointOffice());
            ps.setString(35, informationSheet.getJointDepartment());
            ps.setString(36, informationSheet.getOperatingSystem());
            ps.setString(37, informationSheet.getSystemName());
            ps.setString(38, informationSheet.getProcessingResults());
            ps.setString(39, informationSheet.getResultSample());
            ps.setString(40, informationSheet.getSettingBasis());
            ps.setString(41, informationSheet.getCharge());
            ps.setString(42, informationSheet.getCharges());
            ps.setString(43, informationSheet.getChargeBasis());
            ps.setString(44, informationSheet.getApplicationConditions());
            ps.setString(45, informationSheet.getAuthorityDivision());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void insertProcessingProcess(String sql, ProcessingProcess processingProcess) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(processingProcess.getInformationId()));
            ps.setString(2, processingProcess.getLink());
            ps.setString(3, processingProcess.getStep());
            ps.setString(4, processingProcess.getHandler());
            ps.setString(5, processingProcess.getTimeLimit());
            ps.setString(6, processingProcess.getReviewCriteria());
            ps.setString(7, processingProcess.getBasis());
            ps.setString(8, processingProcess.getProcessingResults());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void insertConding(String sql, String s1, String s2, String s3, String s4, String s5) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, s3);
            ps.setString(2, s1);
            ps.setString(3, s2);
            ps.setString(4, s4);
            ps.setString(5, s5);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static Integer selectId(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = Integer.valueOf(rs.getString("max(id)"));
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
        return id;
    }

    public static String selectCode(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String string = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs == null) {
                System.out.println("没查询到");
            } else {
                while (rs.next()) {
                    string = rs.getString("code");
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

    //主表中更新code
    public static void insertCondingSheet(String sql, String s1, String s2) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    /**
     * 查找到关联的cede和id
     * @param sql
     * @return
     * @throws SQLException
     */
    public static List<String[]> selectCodeSheet(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String[]> list = new ArrayList<>();
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String[] arr = {rs.getString("id"),rs.getString("item_name")};
                list.add(arr);
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
        return list;
    }


    /**
     * 查找部门编码
     * @param
     * @return
     * @throws SQLException
     */
    public static HashMap<String, String[]> selectBuMen() throws SQLException {
        ResultSet rs = null;
        HashMap<String, String[]> ret = new HashMap<String,String[]>();
        try {
            String sql = "select deptid, name, areaid from t_sys_Dept";
            Class.forName(CommonOrl.DRIVER);
            Connection conn = DriverManager.getConnection(CommonOrl.URL, CommonOrl.USERNAME, CommonOrl.PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String deptid=rs.getString("deptid");
                String name = rs.getString("name");
                String areaid = rs.getString("areaid");
                ret.put(deptid, new String[] {name, areaid});
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    public static String selectBuMen2(String sql,String tableName, String bumenBianhao,Connection conn,PreparedStatement ps) throws SQLException {
        ResultSet rs = null;
        String bumen = null;
        try {
            Class.forName(CommonOrl.DRIVER);
            conn = DriverManager.getConnection(CommonOrl.URL, CommonOrl.USERNAME, CommonOrl.PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+bumenBianhao+"%");
            System.out.println("%"+bumenBianhao+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                bumen=rs.getString("deptid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return bumen;
    }


    /**
     * 查找部门名称
     * @param sql
     * @return
     * @throws SQLException
     */
    public static List<String> selectBuMenMing(String sql, String id,Connection conn,PreparedStatement ps) throws SQLException {
        ResultSet rs = null;
        String bumen = null;
        List<String> list = new ArrayList<>();
        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("name"));
                list.add(rs.getString("areaid"));
            }

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }




    /**
     * 查找编码数据
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public static List<TShareShiXiang> selectSheeetCoding(String sql,Connection conn,PreparedStatement ps) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        ResultSet rs = null;
        Map<String, List<TShareShiXiang>> listMap = new HashMap<>();
        List<TShareShiXiang> list = new ArrayList<>();
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int n = 0;
            while (rs.next()) {
                System.out.println(n++ +"=====");
                TShareShiXiang tShareShiXiang = new TShareShiXiang();
                String SXNAME = "";
                int SXZXNAME = 1;
//                for (int i = 0; i < rs.getRow(); i++) {

                    tShareShiXiang.setID(rs.getString("basic_coding"));
                    tShareShiXiang.setTableName(rs.getString("table_name"));
                    //有点问题
                    tShareShiXiang.setBusinessDepartment(rs.getString("business_department"));
                    tShareShiXiang.setSXNAME(rs.getString("item_name"));

                    tShareShiXiang.setSXZXNAME(rs.getString("child_name"));

                    if (rs.getString("service_object")!=null) {
                        if (rs.getString("service_object").contains("法人")) {
                            tShareShiXiang.setTYPE("C");
                        }
                        if (rs.getString("service_object").contains("自然")) {
                            tShareShiXiang.setTYPE("C");
                        }
                        if (rs.getString("service_object").contains("个人")) {
                            tShareShiXiang.setTYPE("P");
                        }
                        if (rs.getString("service_object").contains("企业")) {
                            tShareShiXiang.setTYPE("C");
                        }
                        if (rs.getString("service_object").contains("全部")) {
                            tShareShiXiang.setTYPE("A");
                        }
                        if (rs.getString("service_object").contains("单位")) {
                            tShareShiXiang.setTYPE("C");
                        }
                    } else {
                        tShareShiXiang.setTYPE("A");
                    }

                    if (rs.getString("statutory_time")!=null) {
                        if (rs.getString("statutory_time").contains("无")) {
                            tShareShiXiang.setLIMITTIME("0");
                        } else {
                            tShareShiXiang.setLIMITTIME("1");
                        }
                    } else {
                        tShareShiXiang.setLIMITTIME("0");
                    }



                    tShareShiXiang.setISHALL("1,2");

                    if (rs.getString("statutory_time")!=null) {
                        if (rs.getString("statutory_time").equals("即来即办")) {
                            tShareShiXiang.setSFJLJB("1");
                        } else {
                            tShareShiXiang.setSFJLJB("0");
                        }
                    } else {
                        tShareShiXiang.setSFJLJB("0");
                    }

                    if (rs.getString("charge")!=null) {
                        if (rs.getString("charge").contains("否") || rs.getString("charge").equals("")) {
                            tShareShiXiang.setISCHANGE("0");
                        } else {
                            tShareShiXiang.setISCHANGE("1");
                        }
                    } else {
                        tShareShiXiang.setISCHANGE("0");
                    }

                    if (rs.getString("charge") != null) {
                        tShareShiXiang.setCHARGE(rs.getString("charge"));
                    } else if (rs.getString("Charges") != null) {
                        tShareShiXiang.setCHARGE(rs.getString("charge") + "," + rs.getString("Charges"));
                    } else {
                        tShareShiXiang.setCHARGE(rs.getString("charge"));
                    }

                    if (rs.getString("commitment_time")!=null) {
                        if (rs.getString("commitment_time").equals("")) {
                            tShareShiXiang.setLIMITDAYS(null);
                        } else {
                            tShareShiXiang.setLIMITDAYS("1");
                        }
                    }else {
                        tShareShiXiang.setLIMITDAYS("1");
                    }

                    if (rs.getString("commitment_time")!=null) {
                        if (rs.getString("commitment_time").contains("工作日")) {
                            tShareShiXiang.setLIMITUNIT("G");
                        } else if (rs.getString("commitment_time").contains("自然日")) {
                            tShareShiXiang.setLIMITUNIT("Z");
                        } else {
                            tShareShiXiang.setLIMITUNIT("");
                        }
                    }else {
                        tShareShiXiang.setLIMITUNIT("");
                    }

                    if (rs.getString("statutory_time")!=null) {
                        if (rs.getString("statutory_time").contains("工作日")) {
                            tShareShiXiang.setFDSXDW("G");
                        } else if (rs.getString("statutory_time").contains("当")) {
                            tShareShiXiang.setFDSXDW("G");
                        } else if (rs.getString("statutory_time").contains("自然日")) {
                            tShareShiXiang.setFDSXDW("Z");
                        } else {
                            tShareShiXiang.setFDSXDW("");
                        }
                    }else {
                        tShareShiXiang.setFDSXDW("");
                    }



                    if (rs.getString("approval_category") != null) {
                        if (rs.getString("approval_category").equals("行政许可")) {
                            tShareShiXiang.setXZXK("1");
                        }
                        if (rs.getString("approval_category").equals("公共服务")) {
                            tShareShiXiang.setXZXK("2");
                        }
                        if (rs.getString("approval_category").equals("非行政许可")) {
                            tShareShiXiang.setXZXK("3");
                        }
                        if (rs.getString("approval_category").equals("其他事项")) {
                            tShareShiXiang.setXZXK("4");
                        }
                    } else {
                        tShareShiXiang.setXZXK("4");
                    }

                    tShareShiXiang.setORIGINALDEPARTMENT(rs.getString("administrative_examination"));
                    tShareShiXiang.setXCJJTJ(rs.getString("site_access_path"));
                    tShareShiXiang.setWSJJTJ(rs.getString("online_access_path"));
                    tShareShiXiang.setWDXS(rs.getString("express_form"));

                    if (rs.getString("operating_system")!=null) {
                        if (rs.getString("operating_system").contains("国家")) {
                            tShareShiXiang.setYXXT("1");
                        } else if (rs.getString("operating_system").contains("省")) {
                            tShareShiXiang.setYXXT("2");
                        }else if (rs.getString("operating_system").contains("市")) {
                            tShareShiXiang.setYXXT("3");
                        }else if (rs.getString("operating_system").contains("区")) {
                            tShareShiXiang.setYXXT("3");
                        }
                    } else {
                        tShareShiXiang.setYXXT("");
                    }




                    tShareShiXiang.setXTMC(rs.getString("system_name"));
                    tShareShiXiang.setXTMC(rs.getString("system_name"));

                    if (rs.getString("support_reservation")!=null) {
                        if (rs.getString("support_reservation").equals("是")) {
                            tShareShiXiang.setISZCYYBL("1");
                        } else {
                            tShareShiXiang.setISZCYYBL("0");
                        }
                    } else {
                        tShareShiXiang.setISZCYYBL("0");
                    }


                    String num1 = "";
                    String num2 = "";
                    String num3 = "";
                    if (rs.getString("appointment_route")!= null) {
                        if (rs.getString("appointment_route").contains("现场")) {
                            num1 = "1";
                        }
                        if (rs.getString("appointment_route").contains("网上")) {
                            num2 = "2";
                        }
                        if (rs.getString("appointment_route").contains("电话")) {
                            num3 = "3";
                        }
                    }

                    if (num1.equals("1") && num2.equals("2") && num3.equals("3")){
                        tShareShiXiang.setYYTJ("1,2,3");
                    }else if (num1.equals("1") && num2.equals("2")){
                        tShareShiXiang.setYYTJ("1,2");
                    }else if (num1.equals("2") && num2.equals("3")){
                        tShareShiXiang.setYYTJ("2,3");
                    }else if (num1.equals("1") && num2.equals("3")){
                        tShareShiXiang.setYYTJ("1,3");
                    }else if (num1.equals("1") ){
                        tShareShiXiang.setYYTJ("1");
                    }else if (num1.equals("2") ){
                        tShareShiXiang.setYYTJ("2");
                    }else if (num1.equals("3") ){
                        tShareShiXiang.setYYTJ("3");
                    } else {
                        tShareShiXiang.setYYTJ(null);
                    }

                if (rs.getString("processing_results")!=null) {
                    if (rs.getString("processing_results").length()>=248) {
                        tShareShiXiang.setBLJG("");
                    } else {
                        tShareShiXiang.setBLJG(rs.getString("processing_results"));
                    }
                }
//                    tShareShiXiang.setBLJG(rs.getString("result_sample"));
                    tShareShiXiang.setSSBM(rs.getString("implementation_coding"));
                    tShareShiXiang.setCNBJSXSM(rs.getString("commitment_time"));
                if (rs.getString("complaint_call")!=null) {
                    if (rs.getString("complaint_call").contains("022-")) {
                        tShareShiXiang.setTSDH(rs.getString("complaint_call"));
                    } else {
                        tShareShiXiang.setTSDH("022-"+rs.getString("complaint_call"));
                    }
                }
                    tShareShiXiang.setLAWPRODUCE(rs.getString("setting_basis"));

                    if (rs.getString("exercise_level")!= null) {
                        if (rs.getString("exercise_level").contains("国家")) {
                            tShareShiXiang.setSQJB("1");
                        } else if (rs.getString("exercise_level").contains("市")) {
                            tShareShiXiang.setSQJB("2");
                        } else if (rs.getString("exercise_level").contains("区")) {
                            tShareShiXiang.setSQJB("3");
                        } else if (rs.getString("exercise_level").contains("县")) {
                            tShareShiXiang.setSQJB("3");
                        } else if (rs.getString("exercise_level").contains("乡")) {
                            tShareShiXiang.setSQJB("4");
                        } else if (rs.getString("exercise_level").contains("村")) {
                            tShareShiXiang.setSQJB("5");
                        } else if (rs.getString("exercise_level").equals("")) {
                            tShareShiXiang.setSQJB(null);
                        } else {
                            tShareShiXiang.setSQJB(null);
                        }
                    }else {
                        tShareShiXiang.setSQJB(null);
                    }

                    if (rs.getString("general_scope")!=null) {
                        if (rs.getString("general_scope").contains("全国")) {
                            tShareShiXiang.setTBFW("1");
                        }
                        if (rs.getString("general_scope").contains("跨省")) {
                            tShareShiXiang.setTBFW("2");
                        }
                        if (rs.getString("general_scope").contains("跨区")) {
                            tShareShiXiang.setTBFW("3");
                        }
                        if (rs.getString("general_scope").contains("京津冀协同")) {
                            tShareShiXiang.setTBFW("4");
                        }
                        if (rs.getString("general_scope").contains("本级")) {
                            tShareShiXiang.setTBFW("5");
                        }
                        tShareShiXiang.setYXQX(rs.getString("validity_period"));

                        if (rs.getString("logistics_express")!=null) {
                            if (rs.getString("logistics_express").equals("是")) {
                                tShareShiXiang.setISZCWLKD("1");
                            } else {
                                tShareShiXiang.setISZCWLKD("0");
                            }
                        }else {
                            tShareShiXiang.setISZCWLKD("0");
                        }
                    }else {
                        tShareShiXiang.setISZCWLKD("0");
                    }


                    if (rs.getString("quantitative_restrictions")!=null) {
                        if (rs.getString("quantitative_restrictions").contains("是")) {
                            tShareShiXiang.setISLIMIT("1");
                        } else {
                            tShareShiXiang.setISLIMIT("0");
                        }
                    }else {
                        tShareShiXiang.setISLIMIT("0");
                    }

                    if (rs.getString("quantitative_number")!=null) {
                        tShareShiXiang.setLIMITNUMBER(rs.getString("quantitative_number"));
                    } else {
                        tShareShiXiang.setLIMITNUMBER("");
                    }



                    if (rs.getString("joint_office")!=null) {
                        if (rs.getString("joint_office").contains("是")) {
                            tShareShiXiang.setISLB("1");
                        } else if (rs.getString("joint_office").contains("否")) {
                            tShareShiXiang.setISLB("0");
                        }
                    } else {
                        tShareShiXiang.setISLB(null);
                    }
                    if (rs.getString("joint_department") !=null) {
                        if (rs.getString("joint_department").contains("无") || rs.getString("joint_department").equals("")) {
                            tShareShiXiang.setLBBM(null);
                        } else {
                            tShareShiXiang.setLBBM(rs.getString("joint_department"));
                        }
                    }else {
                        tShareShiXiang.setLBBM(null);
                    }



                    tShareShiXiang.setSPTJ(rs.getString("joint_department"));
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
//                    tShareShiXiang.setCREATETIME(df.parse(String.valueOf(date)));

                    if (rs.getString("processing_results")!=null) {
                        if (rs.getString("processing_results").equals("")) {
                            tShareShiXiang.setSFCZ("0");
                        } else {
                            tShareShiXiang.setSFCZ("1");
                        }
                    } else {
                        tShareShiXiang.setSFCZ("0");
                    }

                    if (rs.getString("charges")!=null) {
                        if (!rs.getString("charges").equals("")||rs.getString("charges").contains("物价") || rs.getString("charges").contains("无")) {
                            tShareShiXiang.setSFJE(0);
                        } else if (rs.getString("charges").equals("")){
                            tShareShiXiang.setSFJE(null);
                        }
                    } else {
                        tShareShiXiang.setSFJE(null);
                    }



                    if (rs.getString("dispatch")!=null) {
                        if (rs.getString("dispatch").equals("")) {
                            tShareShiXiang.setISPUBLIC("0");
                        } else if (rs.getString("dispatch").equals("无")){
                            tShareShiXiang.setISPUBLIC("0");
                        } else if (rs.getString("dispatch").contains("不")){
                            tShareShiXiang.setISPUBLIC("0");
                        } else {
                            tShareShiXiang.setISPUBLIC("1");
                        }
                    } else {
                        tShareShiXiang.setISPUBLIC("1");
                    }



                    if (rs.getString("intermediary_service")!=null) {
                        if (rs.getString("intermediary_service").contains("无") || rs.getString("intermediary_service").equals("")) {
                            tShareShiXiang.setISSJZJJG(null);
                        } else {
                            tShareShiXiang.setISSJZJJG(null);
                        }
                    }else {
                        tShareShiXiang.setISSJZJJG(null);
                    }



                    if (rs.getString("scope")!=null) {
                        if (rs.getString("scope").contains("全国")) {
                            tShareShiXiang.setSYFW("1");
                        } else if (rs.getString("scope").contains("全市")) {
                            tShareShiXiang.setSYFW("2");
                        } else {
                            tShareShiXiang.setSYFW(null);
                        }
                    } else {
                        tShareShiXiang.setSYFW(null);
                    }

                if (rs.getString("support_hotline")!=null) {
                    if (rs.getString("support_hotline").contains("022-")) {
                        tShareShiXiang.setZXYTSDH(rs.getString("support_hotline"));
                    } else {
                        tShareShiXiang.setZXYTSDH("022-"+rs.getString("support_hotline"));
                    }
                }

                list.add(tShareShiXiang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }


}
