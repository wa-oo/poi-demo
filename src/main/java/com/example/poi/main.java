package com.example.poi;

import java.io.*;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException, FileNotFoundException, UnsupportedEncodingException {

        //D盘下的file文件夹的目录里的基本编码文件
//        List<String> list = new ArrayList<>();
//        FileListUtil fileListUtil = new FileListUtil();
//        try {
//            fileListUtil.FileList("D:\\王涛\\天津一网通办\\公共服务事项编码。", "D:\\log.txt");
//            list = fileListUtil.getList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < list.size(); i++) {
//            CodingController.readConding(list.get(i));
//        }

//        FileOutputStream fos1 = new FileOutputStream("D:\\Hello.txt");
//        FileOutputStream fos2 = new FileOutputStream("D:\\Hello.txt");
//        OutputStreamWriter osw1 = new OutputStreamWriter(fos1,"UTF-8");
//        OutputStreamWriter osw2 = new OutputStreamWriter(fos2,"UTF-8");
//        PrintWriter pw1 = new PrintWriter(osw1);
//        PrintWriter pw2 = new PrintWriter(osw2);
//
//        for (int i = 0; i < 10; i++) {
//
//
//            pw2.println("Hello World");
//
//        }
//        pw2.close();
//
//    }


        for (int i = 0; i < 50; i++) {
            System.out.println((int) ((Math.random() * 9 + 1) * 100));
        }


    }

}
