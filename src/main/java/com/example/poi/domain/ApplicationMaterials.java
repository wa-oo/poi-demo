package com.example.poi.domain;

public class ApplicationMaterials {
    private Integer id;
    private Integer informationId;
    private String materialName;//材料名称
    private String materialLevel;//材料位阶
    private String materialProperties;//材料属性
    private String materialSource;//材料来源
    private String materialPreparation;//材料准备要点
    private String legalBasis;//法定依据
    private String reviewCriteria;//审查标准
    private String emptyTable;//空表
    private String sampleTable;///样表

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialLevel() {
        return materialLevel;
    }

    public void setMaterialLevel(String materialLevel) {
        this.materialLevel = materialLevel;
    }

    public String getMaterialProperties() {
        return materialProperties;
    }

    public void setMaterialProperties(String materialProperties) {
        this.materialProperties = materialProperties;
    }

    public String getMaterialSource() {
        return materialSource;
    }

    public void setMaterialSource(String materialSource) {
        this.materialSource = materialSource;
    }

    public String getMaterialPreparation() {
        return materialPreparation;
    }

    public void setMaterialPreparation(String materialPreparation) {
        this.materialPreparation = materialPreparation;
    }

    public String getLegalBasis() {
        return legalBasis;
    }

    public void setLegalBasis(String legalBasis) {
        this.legalBasis = legalBasis;
    }

    public String getReviewCriteria() {
        return reviewCriteria;
    }

    public void setReviewCriteria(String reviewCriteria) {
        this.reviewCriteria = reviewCriteria;
    }

    public String getEmptyTable() {
        return emptyTable;
    }

    public void setEmptyTable(String emptyTable) {
        this.emptyTable = emptyTable;
    }

    public String getSampleTable() {
        return sampleTable;
    }

    public void setSampleTable(String sampleTable) {
        this.sampleTable = sampleTable;
    }
}
