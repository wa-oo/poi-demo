package com.example.poi.util;

import com.example.poi.domain.ApplicationMaterials;
import com.example.poi.domain.CommonProblem;
import com.example.poi.domain.InformationSheet;
import com.example.poi.domain.ProcessingProcess;

import java.sql.*;

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
            while(rs.next()){
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
}
