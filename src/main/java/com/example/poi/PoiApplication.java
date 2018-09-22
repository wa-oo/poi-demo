package com.example.poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class PoiApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(PoiApplication.class, args);




        //导入到Oracle数据库中
//        List<TShareShiXiang> listOrl = new ArrayList<>();
//        try {
//            listOrl = DBUtil.selectSheeetCoding(Common.Select_Sheet_AQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < listOrl.size(); i++) {
//            try {
//                DBOrlUtil.insertSheet(CommonOrl.Insert_Sheet_SQL,listOrl.get(i));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }


    }



}
