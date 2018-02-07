package com.project.cx.processcontrol_jx.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class TaskCK implements Serializable {
    @SerializedName("id")
    String id;

    @SerializedName("caseNo")
    String caseNo;

    @SerializedName("case_state")
    String case_state;

    @SerializedName("caseTime")
    String caseTime;

    @SerializedName("outTime")
    String outTime;

    @SerializedName("appointTime")
    String appointTime;

    @SerializedName("createtime")
    String createtime;

    @SerializedName("finishtime")
    String finishtime;

    @SerializedName("outNumber")
    String outNumber;

    @SerializedName("reporter")
    String reporter;

    @SerializedName("reporterPhone")
    String reporterPhone;

    @SerializedName("licenseno")
    String licenseno;


    @SerializedName("vehicleBrand")
    String vehicleBrand;


    @SerializedName("thirdlicenseno")
    String thirdlicenseno;


    @SerializedName("investigatorNo")
    String investigatorNo;


    @SerializedName("car_role")
    String car_role;


    @SerializedName("riskstate")
    String riskstate;


    @SerializedName("risktype")
    String risktype;


    @SerializedName("risklevel")
    String risklevel;


    @SerializedName("hurt_state")
    String hurt_state;


    @SerializedName("lian_state")
    String lian_state;


    @SerializedName("isRead")
    String isRead;


    @SerializedName("lianTime")
    String lianTime;


    @SerializedName("expect_amount")
    String expect_amount;

    @SerializedName("reparations")
    String reparations;


    @SerializedName("isAppoint")
    String isAppoint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCase_state() {
        return case_state;
    }

    public void setCase_state(String case_state) {
        this.case_state = case_state;
    }

    public String getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(String caseTime) {
        this.caseTime = caseTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(String outNumber) {
        this.outNumber = outNumber;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReporterPhone() {
        return reporterPhone;
    }

    public void setReporterPhone(String reporterPhone) {
        this.reporterPhone = reporterPhone;
    }

    public String getLicenseno() {
        return licenseno;
    }

    public void setLicenseno(String licenseno) {
        this.licenseno = licenseno;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getThirdlicenseno() {
        return thirdlicenseno;
    }

    public void setThirdlicenseno(String thirdlicenseno) {
        this.thirdlicenseno = thirdlicenseno;
    }

    public String getInvestigatorNo() {
        return investigatorNo;
    }

    public void setInvestigatorNo(String investigatorNo) {
        this.investigatorNo = investigatorNo;
    }

    public String getCar_role() {
        return car_role;
    }

    public void setCar_role(String car_role) {
        this.car_role = car_role;
    }

    public String getRiskstate() {
        return riskstate;
    }

    public void setRiskstate(String riskstate) {
        this.riskstate = riskstate;
    }

    public String getRisktype() {
        return risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype;
    }

    public String getRisklevel() {
        return risklevel;
    }

    public void setRisklevel(String risklevel) {
        this.risklevel = risklevel;
    }

    public String getHurt_state() {
        return hurt_state;
    }

    public void setHurt_state(String hurt_state) {
        this.hurt_state = hurt_state;
    }

    public String getLian_state() {
        return lian_state;
    }

    public void setLian_state(String lian_state) {
        this.lian_state = lian_state;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getLianTime() {
        return lianTime;
    }

    public void setLianTime(String lianTime) {
        this.lianTime = lianTime;
    }

    public String getExpect_amount() {
        return expect_amount;
    }

    public void setExpect_amount(String expect_amount) {
        this.expect_amount = expect_amount;
    }

    public String getReparations() {
        return reparations;
    }

    public void setReparations(String reparations) {
        this.reparations = reparations;
    }

    public String getIsAppoint() {
        return isAppoint;
    }

    public void setIsAppoint(String isAppoint) {
        this.isAppoint = isAppoint;
    }

    public String toString(){
        return  "TaskCK{"+"id='"+id+'\''+
                ",caseNo='"+caseNo+'\''+
                "}";
    }
}
