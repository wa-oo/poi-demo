package com.example.poi.domain;

public class ProcessingProcess {
    private Integer id;
    private Integer informationId;
    private String link;//环节
    private String step;//步骤
    private String handler;//办理人
    private String timeLimit;//办理时限
    private String reviewCriteria;//审查标准
    private String basis;//依据
    private String processingResults;// 办理结果

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getReviewCriteria() {
        return reviewCriteria;
    }

    public void setReviewCriteria(String reviewCriteria) {
        this.reviewCriteria = reviewCriteria;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getProcessingResults() {
        return processingResults;
    }

    public void setProcessingResults(String processingResults) {
        this.processingResults = processingResults;
    }
}
