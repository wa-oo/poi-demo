package com.example.poi.util;

import com.alibaba.fastjson.JSONException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReadExcelUtil {

    /**
     * 读取excel数据
     * @param path
     */
    public  Map<String, Map> readExcelToObj(String path) {
        Workbook wb = null;
        Map<String, Map> map = new HashMap<>();
        try {
            wb = WorkbookFactory.create(new File(path));
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                map.put("sheet"+i,(readExcel(wb, i, 0, 0)));
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 读取excel文件
     * @param wb
     * @param sheetIndex sheet页下标：从0开始
     * @param startReadLine 开始读取的行:从0开始
     * @param tailLine 去除最后读取的行
     */
    private Map<String, Map> readExcel(Workbook wb, int sheetIndex, int startReadLine, int tailLine) throws JSONException {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Map<String, String> informationName = new HashMap<>();
        Map<String, String> informationMap = new HashMap<>();
        Map<String, List<String>> materialsMap = new HashMap<>();
        Map<String, List<String>> problemMap = new HashMap<>();
        Map<String, List<String>> processMap = new HashMap<>();
        Map<String, Map> map = new HashMap<>();
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        for(int i=startReadLine; i<sheet.getLastRowNum()-tailLine+1; i++) {
            Row row = sheet.getRow(i);
            List<String> list = new ArrayList<>();
            String string = null;
            for(Cell c : row) {
                boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
                //判断是否具有合并单元格
                if(isMerge) {
                    String str1 = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
                    if (string!=null && string.equals(str1)) {

                    } else {
                        string = str1;
                        list.add(string);
                    }
                }else {
                    String str2 = String.valueOf(c.getRichStringCellValue());
                    list.add(str2);
                }
            }
            if (i==0) {
                informationName.put("information",string);
            }
            if ( i<21 && i>1 ){
                if (list.size()==4) {
                    informationMap.put(list.get(0),list.get(1));
                    informationMap.put(list.get(2),list.get(3));
                } else if (list.size()==3) {
                        informationMap.put(list.get(0),list.get(1));
                        informationMap.put(list.get(2),"");
                }

            }
            if (i > 21 && i < 28) {
                if (list.size()==2) {
                    informationMap.put(list.get(0),list.get(1));
                } else if (list.size()==1) {
                    informationMap.put(list.get(0),"");
                }
            }
            if (list.get(0).equals("申请材料") || string.equals("申请材料")) {
                materialsMap.put("申请材料"+a1,list);
                a1++;
            }
            if (list.get(0).equals("办理流程")|| string.equals("办理流程")) {
                processMap.put("办理流程"+a2,list);
                a2++;
            }
            if (list.get(0).equals("常见问题")|| string.equals("常见问题")) {
                problemMap.put("常见问题"+a3,list);
                a3++;
            }
        }
        map.put("表名",informationName);
        map.put("基本信息",informationMap);
        map.put("申请材料",materialsMap);
        map.put("办理流程",processMap);
        map.put("常见问题",problemMap);
        return map;
    }
    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public  String getMergedRegionValue(Sheet sheet ,int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){

                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }
    /**
     * 判断合并了行
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private boolean isMergedRow(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row == firstRow && row == lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 判断sheet页中是否含有合并单元格
     * @param sheet
     * @return
     */
    private boolean hasMerged(Sheet sheet) {
        return sheet.getNumMergedRegions() > 0 ? true : false;
    }

    /**
     * 合并单元格
     * @param sheet
     * @param firstRow 开始行
     * @param lastRow 结束行
     * @param firstCol 开始列
     * @param lastCol 结束列
     */
    private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public String getCellValue(Cell cell){

        if(cell == null) {
            return "";
        }

        if(cell.getCellType() == Cell.CELL_TYPE_STRING){

            return cell.getStringCellValue();

        }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){

            return String.valueOf(cell.getBooleanCellValue());

        }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){

            return cell.getCellFormula() ;

        }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){

            return String.valueOf(cell.getNumericCellValue());

        }
        return "";
    }
}

