package com.example.poi;

import com.example.poi.controller.CodingController;
import com.example.poi.util.FileListUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {

        //D盘下的file文件夹的目录
        String filepath = null;
//        //File类型可以是文件也可以是文件夹
//        File file = new File(filepath);
//        //将该目录下的所有文件放置在一个File类型的数组中
//        File[] fileList = file.listFiles();
        List<String> list = new ArrayList<>();

        FileListUtil fileListUtil = new FileListUtil();

        CodingController codingController = new CodingController();
        codingController.readExcelToObj("D:\\王涛\\天津一网通办\\公共服务事项编码。\\市内六区\\河北部门.xlsx");

        try {
            fileListUtil.FileList("D:\\attachment\\区县公共服务办事指南\\河北区","D:\\log.txt");
            list = fileListUtil.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //新建一个文件夹集合
//        List<File> wjjList = new ArrayList<File>();
//        for (int i = 0; i < fileList.length; i++) {
//            //判断是否为文件夹
//            if (fileList[i].isDirectory()) {
//                wjjList .add(fileList[i]);
//                file = new File(String.valueOf(wjjList.get(i)));
//            }
//        }

//        for (int i = 0; i < list.size(); i++) {
////            System.out.println(list.get(i));
//            try {
//                boolean b = ExcelController.readExcels(list.get(i));
//                PrintStream mytxt=new PrintStream("D:\\log.txt");
//                PrintStream out=System.out;
//                fileListUtil.OutWrite(list.get(i));
//                System.setOut(mytxt);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }


    }

}
