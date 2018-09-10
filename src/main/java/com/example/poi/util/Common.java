package com.example.poi.util;

public class Common {
    // connect the database
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_NAME = "plan";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String IP = "localhost";
    public static final String PORT = "3306";
//    public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME+"?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";

    // sql
    public static final String INSERT_Application_SQL = "INSERT INTO application_materials( information_id, material_name, material_level, material_properties, material_source, material_preparation, legal_basis, review_criteria, empty_table, sample_table) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_Problem_SQL = "INSERT INTO common_problem(information_id, problem, answer) VALUES ( ?, ?, ?)";
    public static final String INSERT_Information_SQL = "INSERT INTO information_sheet( table_name, item_name, basic_coding, child_name, type_name, approval_category, service_object, administrative_examination, exercise_level, handling_type, business_department, implementation_department, implementation_coding, complaint_call, location, support_hotline, general_scope, statutory_time, commitment_time, validity_period, scope, dispatch, intermediary_service, field_connector, site_access_path, online_connection, online_access_path, logistics_express, express_form, support_reservation, appointment_route, quantitative_restrictions, quantitative_number, joint_office, joint_department, operating_system, system_name, processing_results, result_sample, setting_basis, charge, charges, charge_basis, application_conditions, authority_division) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_Process_SQL = "INSERT INTO processing_process(information_id, link, step, handler, time_limit, review_criteria, basis, processing_results) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_InformationId_SQL = "select max(id) from information_sheet";

}
