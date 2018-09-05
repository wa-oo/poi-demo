package com.example.poi.controller;

import com.example.poi.domain.ApplicationMaterials;
import com.example.poi.domain.CommonProblem;
import com.example.poi.domain.InformationSheet;
import com.example.poi.domain.ProcessingProcess;
import com.example.poi.util.Common;
import com.example.poi.util.DBUtil;
import com.example.poi.util.ReadExcelUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelController {

    public static void readExcels(String filePath) throws SQLException {
        Map<String, Map> map = new HashMap<>();
        Map<String, String> informationName = new HashMap<>();
        Map<String, String> informationMap = new HashMap<>();
        Map<String, List<String>> materialsMap = new HashMap<>();
        Map<String, List<String>> problemMap = new HashMap<>();
        Map<String, List<String>> processMap = new HashMap<>();

        InformationSheet informationSheet = new InformationSheet();

        ReadExcelUtil readExcelUtil = new ReadExcelUtil();
        map = readExcelUtil.readExcelToObj(filePath);
        for (int i = 0; i < map.size(); i++) {
            informationName = (Map<String, String>) map.get("sheet" + i).get("表名");
            informationMap = (Map<String, String>) map.get("sheet" + i).get("基本信息");
            informationSheet.setTableName(informationName.get("information"));
            //基本信息
            informationSheet.setItemName(informationMap.get("事项名称"));
            informationSheet.setBasicCoding(informationMap.get("基本编码"));
            informationSheet.setChildName(informationMap.get("子项名称"));
            informationSheet.setTypeName(informationMap.get("类型名称"));
            informationSheet.setApprovalCategory(informationMap.get("审批类别"));
            informationSheet.setServiceObject(informationMap.get("服务对象"));
            informationSheet.setAdministrativeExamination(informationMap.get("行政审批主体"));
            informationSheet.setExerciseLevel(informationMap.get("行使层级"));
            informationSheet.setHandlingType(informationMap.get("办件类型"));
            informationSheet.setBusinessDepartment(informationMap.get("业务主管部门"));
            informationSheet.setImplementationDepartment(informationMap.get("实施部门"));
            informationSheet.setImplementationCoding(informationMap.get("实施编码"));
            informationSheet.setComplaintCall(informationMap.get("投诉电话"));
            informationSheet.setLocation(informationMap.get("办理地点"));
            informationSheet.setSupportHotline(informationMap.get("咨询电话"));
            informationSheet.setGeneralScope(informationMap.get("通办范围"));
            informationSheet.setStatutoryTime(informationMap.get("法定办结时限"));
            informationSheet.setCommitmentTime(informationMap.get("承诺办结时限"));
            informationSheet.setValidityPeriod(informationMap.get("有效期限"));
            informationSheet.setScope(informationMap.get("适用范围"));
            informationSheet.setDispatch(informationMap.get("办件公示"));
            informationSheet.setIntermediaryService(informationMap.get("中介服务"));
            informationSheet.setFieldConnector(informationMap.get("是否现场接件"));
            informationSheet.setSiteAccessPath(informationMap.get("现场接件途径"));
            informationSheet.setOnlineConnection(informationMap.get("是否网上接件"));
            informationSheet.setOnlineAccessPath(informationMap.get("网上接件途径"));
            informationSheet.setLogisticsExpress(informationMap.get("是否物流快递"));
            informationSheet.setExpressForm(informationMap.get("快递形式"));
            informationSheet.setSupportReservation(informationMap.get("是否支持预约"));
            informationSheet.setAppointmentRoute(informationMap.get("预约途径"));
            informationSheet.setQuantitativeRestrictions(informationMap.get("是否数量限制"));
            informationSheet.setQuantitativeNumber(informationMap.get("数量限制"));
            informationSheet.setJointOffice(informationMap.get("是否涉及联办"));
            informationSheet.setJointDepartment(informationMap.get("联办部门"));
            informationSheet.setOperatingSystem(informationMap.get("运行系统"));
            informationSheet.setSystemName(informationMap.get("系统名称"));
            informationSheet.setProcessingResults(informationMap.get("办理结果"));
            informationSheet.setResultSample(informationMap.get("结果样本"));
            //拓展信息
            informationSheet.setSettingBasis(informationMap.get("设定依据"));
            informationSheet.setCharge(informationMap.get("是否收费"));
            informationSheet.setCharges(informationMap.get("收费标准"));
            informationSheet.setChargeBasis(informationMap.get("收费依据"));
            informationSheet.setApplicationConditions(informationMap.get("申请条件"));
            informationSheet.setAuthorityDivision(informationMap.get("权限划分"));
            DBUtil.insertInformationSheet(Common.INSERT_Information_SQL, informationSheet);
            int id = DBUtil.selectId(Common.SELECT_InformationId_SQL);
            materialsMap = (Map<String, List<String>>) map.get("sheet" + i).get("申请材料");
            for (int i1 = 1; i1 < materialsMap.size(); i1++) {
                List<String> list = materialsMap.get("申请材料" + i1);
                ExcelController excelController = new ExcelController();
                if (excelController.isNotNull(list)) {
                    ApplicationMaterials applicationMaterials = new ApplicationMaterials();
                    applicationMaterials.setInformationId(id);
                    applicationMaterials.setMaterialName(list.get(1));
                    applicationMaterials.setMaterialLevel(list.get(2));
                    applicationMaterials.setMaterialProperties(list.get(3));
                    applicationMaterials.setMaterialSource(list.get(4));
                    applicationMaterials.setMaterialPreparation(list.get(5));
                    applicationMaterials.setLegalBasis(list.get(6));
                    applicationMaterials.setReviewCriteria(list.get(7));
                    applicationMaterials.setEmptyTable(list.get(8));
                    applicationMaterials.setSampleTable(list.get(9));
                    DBUtil.insertApplicationMaterials(Common.INSERT_Application_SQL, applicationMaterials);
                }
            }
            problemMap = (Map<String, List<String>>) map.get("sheet" + i).get("常见问题");
            for (int i1 = 1; i1 < problemMap.size(); i1++) {
                List<String> list = problemMap.get("常见问题" + i1);
                ExcelController excelController = new ExcelController();
                if (excelController.isNotNull(list)) {
                    CommonProblem commonProblem = new CommonProblem();
                    commonProblem.setInformationId(id);
                    commonProblem.setProblem(list.get(1));
                    commonProblem.setAnswer(list.get(2));
                    DBUtil.insertCommonProblem(Common.INSERT_Problem_SQL, commonProblem);
                }
            }
            processMap = (Map<String, List<String>>) map.get("sheet" + i).get("申请材料");
            for (int i1 = 1; i1 < processMap.size(); i1++) {
                List<String> list = processMap.get("申请材料" + i1);
                ExcelController excelController = new ExcelController();
                if (excelController.isNotNull(list)) {
                    ProcessingProcess processingProcess = new ProcessingProcess();
                    processingProcess.setInformationId(id);
                    processingProcess.setLink(list.get(1));
                    processingProcess.setStep(list.get(2));
                    processingProcess.setHandler(list.get(3));
                    processingProcess.setTimeLimit(list.get(4));
                    processingProcess.setReviewCriteria(list.get(5));
                    processingProcess.setBasis(list.get(6));
                    processingProcess.setProcessingResults(list.get(7));
                    DBUtil.insertProcessingProcess(Common.INSERT_Process_SQL, processingProcess);
                }
            }
        }
    }

    private boolean isNotNull(List<String> list){
        boolean b = false;
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals("")) {
                b = true;
                break;
            }
        }
        return b;
    }
}
