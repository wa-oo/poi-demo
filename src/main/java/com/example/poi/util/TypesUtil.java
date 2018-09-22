package com.example.poi.util;

import com.example.poi.domain.Types;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/20
 */
public class TypesUtil {

    public static void insertTypes(Types types, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO types(department_name, item_name, administrative_confirmation, administrative_payment, administrative_reward, administrative_ruling, other, number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, types.getDepartmentName());
            ps.setString(2, types.getItemName());
            ps.setString(3, types.getAdministrativeConfirmation());
            ps.setString(4, types.getAdministrativePayment());
            ps.setString(5, types.getAdministrativeReward());
            ps.setString(6, types.getAdministrativeRuling());
            ps.setString(7, types.getOther());
            ps.setString(8, types.getNumber());
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
     * 读取excel数据
     *
     * @param path
     */
    public void readExcelToObj(String path ,Connection conn) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                System.out.println(path);
                readExcel(wb, i, 0, 0 , conn);
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取excel文件
     *
     * @param wb
     * @param sheetIndex    sheet页下标：从0开始
     * @param startReadLine 开始读取的行:从0开始
     * @param tailLine      去除最后读取的行
     */
    private void readExcel(Workbook wb, int sheetIndex, int startReadLine, int tailLine ,Connection conn) throws SQLException {
        Sheet sheet = wb.getSheetAt(sheetIndex);

        for (int i = startReadLine; i < sheet.getLastRowNum() - tailLine + 1; i++) {
            if (sheet != null) {
                Row row = sheet.getRow(i);
                List<String> list = new ArrayList<>();
                if (row == null) {
                    break;
                }
                for (Cell c : row) {
                    c.setCellType(Cell.CELL_TYPE_STRING);
                    String str2 = String.valueOf(c.getRichStringCellValue());
                    list.add(str2);
                }
                Types types = new Types();
                types.setDepartmentName(list.get(0));
                types.setItemName(list.get(1));
                if (!list.get(2).equals("")) {
                    types.setAdministrativeConfirmation("1");
                    types.setNumber("1");
                }if (!list.get(3).equals("")) {
                    types.setAdministrativePayment("2");
                    types.setNumber("2");
                }if (!list.get(4).equals("")) {
                    types.setAdministrativeReward("3");
                    types.setNumber("3");
                }if (!list.get(5).equals("")) {
                    types.setAdministrativeRuling("4");
                    types.setNumber("4");
                }if (!list.get(6).equals("")) {
                    types.setOther("5");
                    types.setNumber("5");
                }
                TypesUtil.insertTypes(types,conn);
            }
        }
    }
}