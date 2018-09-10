package com.example.poi.controller;

import com.alibaba.fastjson.JSONException;
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
    public  Map<String, List<String>> readExcelToObj(String path) {
        Workbook wb = null;
        Map<String, List<String>> listMap = new HashMap<>();
        try {
            wb = WorkbookFactory.create(new File(path));
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                System.out.println(path);
                listMap.put(String.valueOf(i),(readCoding(wb, i, 0, 0)));

            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return listMap;
    }

    private List<String> readCoding(Workbook wb, int sheetIndex, int startReadLine, int tailLine) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        List<String> list = new ArrayList<>();
        for(int i=startReadLine; i<sheet.getLastRowNum()-tailLine+1; i++) {
            Row row = sheet.getRow(i);
            for(Cell c : row) {
                boolean isMerge =ReadExcelUtil.isMergedRegion(sheet, i, c.getColumnIndex());
                if(isMerge) {
                    if(c!=null){
                        //获取数字类型的value
                        c.setCellType(Cell.CELL_TYPE_STRING);
                        String str1 = ReadExcelUtil.getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
                        list.add(str1);
                    }
                } else {
                    if(c!=null){
                        //获取数字类型的value
                        c.setCellType(Cell.CELL_TYPE_STRING);
                        String str2 = String.valueOf(c.getRichStringCellValue());
                        list.add(str2);
                    }
                }

            }
        }
        System.out.println(list);
        return list;
    }

    public void readCodingController(String filePath) throws SQLException {
        ReadExcelUtil readExcelUtil = new ReadExcelUtil();
        Map<String, List<String>> listMap = new HashMap<>();
        listMap = readExcelToObj(filePath);
        for (int i = 0; i < listMap.size(); i++) {

        }
    }
}
