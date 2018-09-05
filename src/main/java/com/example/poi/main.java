package com.example.poi;

import com.example.poi.controller.ExcelController;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        if (args.length > 1)
            ExcelController.readExcels(args[1]);
    }
}
