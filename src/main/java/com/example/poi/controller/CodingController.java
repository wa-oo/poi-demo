package com.example.poi.controller;

import com.alibaba.fastjson.JSONException;
import com.example.poi.util.Common;
import com.example.poi.util.DBUtil;
import com.example.poi.util.ReadExcelUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/10
 */
public class CodingController {

    ReadExcelUtil readExcelUtil = new ReadExcelUtil();

    /**
     * 读取excel数据
     * @param path
     */
    public static Map<String, List<String>> readExcelToObj(String path) {
        Workbook wb = null;
        Map<String, List<String>> listMap = new HashMap<>();
        try {
            wb = WorkbookFactory.create(new File(path));
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                System.out.println(path);
                listMap = readCoding(wb, i, 0, 0);
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return listMap;
    }

    public static boolean readConding(String filePath) throws SQLException {
        Map<String, List<String>> listMap = new HashMap<>();
        listMap = readExcelToObj(filePath);
        String name = listMap.get("事项编码"+0).get(1);
        System.out.println(name);
        for (int i = 0; i < listMap.size(); i++) {
            String s3 = null;
            if (listMap.get("事项编码"+i).size()==6){
                System.out.println(listMap.get("事项编码"+i));
                String s4 = listMap.get("事项编码"+i).get(1);
                if (!s4.equals("")){
                    String s1 = listMap.get("事项编码"+i).get(2);
                    String s2 = listMap.get("事项编码"+i).get(3);
                    s3 = listMap.get("事项编码"+i).get(5);
                    if (s3.length() == 12) {
                        DBUtil.insertConding(Common.INSERT_Conding_SQL,s1,s2,s3,s4,name);
                        System.out.println("插入成功");
                    }
                }

            }
        }

        return true;
    }


    List<String> list = new ArrayList<>();
    private static Map<String, List<String>> readCoding(Workbook wb, int sheetIndex, int startReadLine, int tailLine) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Map<String,String> map = new HashMap<>();
        Map<String, List<String>> listMap = new HashMap<>();
        for(int i=startReadLine; i<sheet.getLastRowNum()-tailLine+1; i++) {
            Row row = sheet.getRow(i);
            List<String> listStr = new ArrayList<>();
            for(Cell c : row) {
                boolean isMerge =ReadExcelUtil.isMergedRegion(sheet, i, c.getColumnIndex());
                if(isMerge) {
                    if(c!=null){
                        //获取数字类型的value
                        c.setCellType(Cell.CELL_TYPE_STRING);
                        String str1 = ReadExcelUtil.getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
                        listStr.add(str1);
                    }
                } else {
                    if(c!=null){
                        //获取数字类型的value
                        c.setCellType(Cell.CELL_TYPE_STRING);
                        String str2 = String.valueOf(c.getRichStringCellValue());
                        listStr.add(str2);
                    }
                }
            }
            listMap.put("事项编码"+i,listStr);
        }
        return listMap;
    }
    public void readCodingController(String filePath) throws SQLException {
        ReadExcelUtil readExcelUtil = new ReadExcelUtil();
        Map<String, List<String>> listMap = new HashMap<>();
        listMap = readExcelToObj(filePath);
        for (int i = 0; i < listMap.size(); i++) {

        }
    }
}
