package com.example.poi.domain;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/20
 */
public class Types {
    private String departmentName;
    private String itemName;
    private String administrativeConfirmation;
    private String administrativePayment;
    private String administrativeReward;
    private String administrativeRuling;
    private String other;
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Types{" +
                "departmentName='" + departmentName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", administrativeConfirmation='" + administrativeConfirmation + '\'' +
                ", administrativePayment='" + administrativePayment + '\'' +
                ", administrativeReward='" + administrativeReward + '\'' +
                ", administrativeRuling='" + administrativeRuling + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAdministrativeConfirmation() {
        return administrativeConfirmation;
    }

    public void setAdministrativeConfirmation(String administrativeConfirmation) {
        this.administrativeConfirmation = administrativeConfirmation;
    }

    public String getAdministrativePayment() {
        return administrativePayment;
    }

    public void setAdministrativePayment(String administrativePayment) {
        this.administrativePayment = administrativePayment;
    }

    public String getAdministrativeReward() {
        return administrativeReward;
    }

    public void setAdministrativeReward(String administrativeReward) {
        this.administrativeReward = administrativeReward;
    }

    public String getAdministrativeRuling() {
        return administrativeRuling;
    }

    public void setAdministrativeRuling(String administrativeRuling) {
        this.administrativeRuling = administrativeRuling;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
