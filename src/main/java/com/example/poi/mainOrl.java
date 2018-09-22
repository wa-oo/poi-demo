package com.example.poi;

import com.example.poi.domain.t_share.TShareShiXiang;
import com.example.poi.util.Common;
import com.example.poi.util.CommonOrl;
import com.example.poi.util.DBOrlUtil;
import com.example.poi.util.DBUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/11
 */
public class mainOrl {
    public static void main(String[] args) throws IOException, ParseException, SQLException, ClassNotFoundException {

        //获取数据暂存到本地数据库中
//        List<String> list = new ArrayList<>();
//        FileListUtil fileListUtil = new FileListUtil();
//        FileOutputStream fos1 = new FileOutputStream("D:\\导入报错.txt");
//        OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
//        PrintWriter pw1 = new PrintWriter(osw1);
//        try {
//            fileListUtil.FileList("D:\\区县公共服务办事指南", "D:\\log.txt");
//            list = fileListUtil.getList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < list.size(); i++) {
//            try {
//                boolean b = ExcelController.readExcels(list.get(i),pw1);
//            } catch (Exception e) {
//                pw1.println(list.get(i));
//                e.printStackTrace();
//            }
//        }

        //匹配cede
//        try {
//            List<String[]> idSize = DBUtil.selectCodeSheet(Common.Select_Code_Sheet_SQL);
//            int code = 10000;
//            String name = null;
//            for (int i = 0; i < idSize.size(); i++) {
//                String id = idSize.get(i)[0];
//                String str = idSize.get(i)[1];
//                if (name != null) {
//                    if (str.contains(name)) {
//                        System.out.println(code + "===" + id);
//                        DBUtil.insertCondingSheet(Common.update_Code_Sheet_SQL, "12" + code + "00100", id);
//                    } else {
//                        System.out.println(code + "===" + id);
//                        code++;
//                        DBUtil.insertCondingSheet(Common.update_Code_Sheet_SQL, "12" + code + "00100", id);
//                    }
//                } else {
//                    System.out.println(code + "===" + id);
//                    code++;
//                    DBUtil.insertCondingSheet(Common.update_Code_Sheet_SQL, "12" + code + "00100", id);
//                }
//                name = str;
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //导入orl
        List<TShareShiXiang> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        Class.forName(CommonOrl.DRIVER);
        conn = DriverManager.getConnection(CommonOrl.URL, CommonOrl.USERNAME, CommonOrl.PASSWORD);
        try {
            list = DBUtil.selectSheeetCoding(Common.Select_Sheet_AQL,conn,ps);
            System.out.println(list.size() + "list大小");
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        FileOutputStream fos1 = new FileOutputStream("D:\\主管部门为空.txt");
//        FileOutputStream fos2 = new FileOutputStream("D:\\主管编码为空.txt");
//        OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
//        OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "UTF-8");
//        PrintWriter pw1 = new PrintWriter(osw1);
//        PrintWriter pw2 = new PrintWriter(osw2);

        FileOutputStream fos1 = new FileOutputStream("D:\\无效数字.txt");
        OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
        PrintWriter pw1 = new PrintWriter(osw1);

        HashMap<String, String[]> depts = DBUtil.selectBuMen();

        int a = 1;
        String sxzxbh = null;
        int j = 1;
//        for (int i = 0; i < list.size(); i++) {
        for (int i = 0; i < 50; i++) {
            System.out.println("===" + a++ + "===");
            String tableName = list.get(i).getTableName();
            String code = list.get(i).getID();
            if (sxzxbh!=null) {
                if (sxzxbh.contains(code)) {
                    j++;
                    list.get(i).setSXZXBH("00"+j);
                } else {
                    sxzxbh = code;
                    j=1;
                    list.get(i).setSXZXBH("001");
                }
            } else {
                sxzxbh = code;
                j=1;
                list.get(i).setSXZXBH("001");
            }
            boolean found = false;
            if (list.get(i).getBusinessDepartment() != null) {
                String BusinessDepartment = list.get(i).getBusinessDepartment();
                String s1 = BusinessDepartment.replaceAll("天津市", "");
                s1 = s1.replaceAll("区", "");
                s1 = s1.replaceAll("市", "");
                s1 = s1.replaceAll("红桥", "");
                s1 = s1.replaceAll("河东", "");
                s1 = s1.replaceAll("民政局优抚处", "民政局");
                s1 = s1.replaceAll("和平区", "");
                s1 = s1.replaceAll("北辰", "");
                s1 = s1.replaceAll("和平", "");
                s1 = s1.replaceAll("（津塘路27号408室）", "");
                s1 = s1.replaceAll("蓟州", "");
                s1 = s1.replaceAll("业务主管部门单位名称", "");
                String buMen = null;

                Random random = new Random();
                list.get(i).setID("120000"+list.get(i).getID().substring(2,7)+list.get(i).getSXZXBH()+"00"+(int) ((Math.random() * 9 + 1) * 100));

                if (s1 == null) {
                    pw1.println(list.get(i).getTableName());
                } else if (!s1.equals("")) {
                    for(String k:depts.keySet() ) {
                        String[] vs = depts.get(k);
                        if(s1.equals(vs[0])) {
                            buMen = k;
                            list.get(i).setDEPARTMENT(buMen);
                            list.get(i).setBusinessDepartment(vs[0]);
                            list.get(i).setAreaid(vs[1]);
                            DBOrlUtil.insertSheet(CommonOrl.Insert_Sheet_SQL, list.get(i),conn,ps,list.get(i).getTableName(),pw1);
                            DBOrlUtil.insertPermissionMapnode(CommonOrl.Insert_permissionmapnode_SQL,list.get(i),conn);
//                            DBOrlUtil.insertVersion(CommonOrl.Insert_Version_SQL, list.get(i),conn,ps,list.get(i).getTableName(),pw1);
                            found=true;
                            break;
                        }
                    }
                } else {
                    pw1.println(list.get(i).getTableName());
                }
            }
            if(!found)
            {
                String tableNames = list.get(i).getTableName();
                if (tableNames.contains("西青区")) {
                    list.get(i).setDEPARTMENT("328626664");
                    list.get(i).setBusinessDepartment("西青区审批局");
                    list.get(i).setAreaid("120111");
                } else if (tableNames.contains("宝坻区")) {
                    list.get(i).setDEPARTMENT("MB0L05134");
                    list.get(i).setBusinessDepartment("宝坻区审批局");
                    list.get(i).setAreaid("120115");
                } else if (tableNames.contains("滨海新区")) {
                    list.get(i).setDEPARTMENT("300717847");
                    list.get(i).setBusinessDepartment("滨海新区审批局");
                    list.get(i).setAreaid("120116");
                } else if (tableNames.contains("宁河区")) {
                    list.get(i).setDEPARTMENT("MB0X9342X");
                    list.get(i).setBusinessDepartment("宁河区审批局");
                    list.get(i).setAreaid("120117");
                } else if (tableNames.contains("静海区")) {
                    list.get(i).setDEPARTMENT("663070798");
                    list.get(i).setBusinessDepartment("静海区审批局");
                    list.get(i).setAreaid("120118");
                } else if (tableNames.contains("蓟州区")) {
                    list.get(i).setDEPARTMENT("300695721");
                    list.get(i).setBusinessDepartment("蓟州区审批局");
                    list.get(i).setAreaid("120119");
                } else if (tableNames.contains("津南区")) {
                    list.get(i).setDEPARTMENT("MB0U9389X");
                    list.get(i).setBusinessDepartment("津南区审批局");
                    list.get(i).setAreaid("120112");
                } else if (tableNames.contains("高新区")) {
                    list.get(i).setDEPARTMENT("000127001");
                    list.get(i).setBusinessDepartment("高新区审批局");
                    list.get(i).setAreaid("120318");
                } else if (tableNames.contains("和平区")) {
                    list.get(i).setDEPARTMENT("797294201");
                    list.get(i).setBusinessDepartment("和平区审批局");
                    list.get(i).setAreaid("120101");
                } else if (tableNames.contains("河东区")) {
                    list.get(i).setDEPARTMENT("MB0P40013");
                    list.get(i).setBusinessDepartment("河东区审批局");
                    list.get(i).setAreaid("120102");
                } else if (tableNames.contains("河西区")) {
                    list.get(i).setDEPARTMENT("340946337");
                    list.get(i).setBusinessDepartment("河西区审批局");
                    list.get(i).setAreaid("120103");
                } else if (tableNames.contains("南开区")) {
                    list.get(i).setDEPARTMENT("356730389");
                    list.get(i).setBusinessDepartment("南开区审批局");
                    list.get(i).setAreaid("120104");
                } else if (tableNames.contains("河北区")) {
                    list.get(i).setDEPARTMENT("783308289");
                    list.get(i).setBusinessDepartment("河北区审批局");
                    list.get(i).setAreaid("120105");
                } else if (tableNames.contains("红桥区")) {
                    list.get(i).setDEPARTMENT("666116130");
                    list.get(i).setBusinessDepartment("红桥区审批局");
                    list.get(i).setAreaid("120106");
                } else if (tableNames.contains("东丽区")) {
                    list.get(i).setDEPARTMENT("328576038");
                    list.get(i).setBusinessDepartment("东丽区审批局");
                    list.get(i).setAreaid("120110");
                } else if (tableNames.contains("北辰区")) {
                    list.get(i).setDEPARTMENT("300636422");
                    list.get(i).setBusinessDepartment("北辰区审批局");
                    list.get(i).setAreaid("120113");
                } else if (tableNames.contains("武清区")) {
                    list.get(i).setDEPARTMENT("300672167");
                    list.get(i).setBusinessDepartment("武清区审批局");
                    list.get(i).setAreaid("120114");
                }


                System.out.println(list.get(i).getID());
                DBOrlUtil.insertSheet(CommonOrl.Insert_Sheet_SQL, list.get(i),conn,ps,list.get(i).getTableName(),pw1);
                DBOrlUtil.insertPermissionMapnode(CommonOrl.Insert_permissionmapnode_SQL,list.get(i),conn);
//                DBOrlUtil.insertVersion(CommonOrl.Insert_Version_SQL, list.get(i),conn,ps,list.get(i).getTableName(),pw1);
            }

        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
//        pw2.close();
        pw1.close();

    }
}
