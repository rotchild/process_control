package com.project.cx.processcontrol_jx.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/7 0007.
 */
/*      id
        caseNo
        licenseno
        case_state
        ticket_state
        isRead
        assessorNo
        investigatorNo
        case_from
        caseTime
        outTime
        appointTime
        createtime
        accept_time
        finishtime
        outNumber
        reporter
        reporterPhone
        reporter1
        reporterPhone1
        vehicleBrand
        car_role
        riskstate
        risktype
        assessor_name

        assessor_mobile
        assess_address
        assess_amount
        risklevel
        ticket_tag
        expect_amount
        reparations
        lianTime
        assessTime
        ticket_amount
        ticket_name
        cooperative_name
        should_ticket_amount
        should_ticket_garage
        real_ticket_garage
        real_ticket_time
        assess_id
        county_id
        AuthorityContent
        group_id*/
public class TaskDS extends BaseTask implements Serializable {
    @SerializedName("id")
    String id;

    @SerializedName("caseNo")
    String caseNo;

    @SerializedName("licenseno")
    String licenseno;

    @SerializedName("case_state")
    String case_state;

    @SerializedName("ticket_state")
    String ticket_state;

    @SerializedName("isRead")
    String isRead;

    @SerializedName("assessorNo")
    String assessorNo;

    @SerializedName("investigatorNo")
    String investigatorNo;

    @SerializedName("case_from")
    String case_from;

    @SerializedName("caseTime")
    String caseTime;

    @SerializedName("outTime")
    String outTime;

    @SerializedName("appointTime")
    String appointTime;

    @SerializedName("createtime")
    String createtime;

    @SerializedName("accept_time")
    String accept_time;

    @SerializedName("finishtime")
    String finishtime;

    @SerializedName("outNumber")
    String outNumber;

    @SerializedName("reporter")
    String reporter;

    @SerializedName("reporterPhone")
    String reporterPhone;

    @SerializedName("reporter1")
    String reporter1;

    @SerializedName("vehicleBrand")
    String vehicleBrand;

    @SerializedName("car_role")
    String car_role;

    @SerializedName("riskstate")
    String riskstate;

    @SerializedName("risktype")
    String risktype;

    @SerializedName("assessor_name")
    String assessor_name;

    @SerializedName("assessor_mobile")
    String assessor_mobile;

    @SerializedName("assess_address")
    String assess_address;

    @SerializedName("assess_amount")
    String assess_amount;

    @SerializedName("risklevel")
    String risklevel;

    @SerializedName("ticket_tag")
    String ticket_tag;

    @SerializedName("expect_amount")
    String expect_amount;

    @SerializedName("reparations")
    String reparations;

    @SerializedName("lianTime")
    String lianTime;

    @SerializedName("assessTime")
    String assessTime;

    @SerializedName("ticket_amount")
    String ticket_amount;

    @SerializedName("ticket_name")
    String ticket_name;

    @SerializedName("cooperative_name")
    String cooperative_name;

    @SerializedName("should_ticket_amount")
    String should_ticket_amount;

    @SerializedName("should_ticket_garage")
    String should_ticket_garage;

    @SerializedName("real_ticket_garage")
    String real_ticket_garage;

    @SerializedName("real_ticket_time")
    String real_ticket_time;

    @SerializedName("assess_id")
    String assess_id;

    @SerializedName("county_id")
    String county_id;

    @SerializedName("AuthorityContent")
    String AuthorityContent;

    @SerializedName("group_id")
    String group_id;

    public String getLicenseno() {
        return licenseno;
    }

    public void setLicenseno(String licenseno) {
        this.licenseno = licenseno;
    }

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

    public String getTicket_state() {
        return ticket_state;
    }

    public void setTicket_state(String ticket_state) {
        this.ticket_state = ticket_state;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getAssessorNo() {
        return assessorNo;
    }

    public void setAssessorNo(String assessorNo) {
        this.assessorNo = assessorNo;
    }

    public String getInvestigatorNo() {
        return investigatorNo;
    }

    public void setInvestigatorNo(String investigatorNo) {
        this.investigatorNo = investigatorNo;
    }

    public String getCase_from() {
        return case_from;
    }

    public void setCase_from(String case_from) {
        this.case_from = case_from;
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

    public String getAccept_time() {
        return accept_time;
    }

    public void setAccept_time(String accept_time) {
        this.accept_time = accept_time;
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

    public String getReporter1() {
        return reporter1;
    }

    public void setReporter1(String reporter1) {
        this.reporter1 = reporter1;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
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

    public String getAssessor_name() {
        return assessor_name;
    }

    public void setAssessor_name(String assessor_name) {
        this.assessor_name = assessor_name;
    }

    public String getAssessor_mobile() {
        return assessor_mobile;
    }

    public void setAssessor_mobile(String assessor_mobile) {
        this.assessor_mobile = assessor_mobile;
    }

    public String getAssess_address() {
        return assess_address;
    }

    public void setAssess_address(String assess_address) {
        this.assess_address = assess_address;
    }

    public String getAssess_amount() {
        return assess_amount;
    }

    public void setAssess_amount(String assess_amount) {
        this.assess_amount = assess_amount;
    }

    public String getRisklevel() {
        return risklevel;
    }

    public void setRisklevel(String risklevel) {
        this.risklevel = risklevel;
    }

    public String getTicket_tag() {
        return ticket_tag;
    }

    public void setTicket_tag(String ticket_tag) {
        this.ticket_tag = ticket_tag;
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

    public String getLianTime() {
        return lianTime;
    }

    public void setLianTime(String lianTime) {
        this.lianTime = lianTime;
    }

    public String getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(String assessTime) {
        this.assessTime = assessTime;
    }

    public String getTicket_amount() {
        return ticket_amount;
    }

    public void setTicket_amount(String ticket_amount) {
        this.ticket_amount = ticket_amount;
    }

    public String getTicket_name() {
        return ticket_name;
    }

    public void setTicket_name(String ticket_name) {
        this.ticket_name = ticket_name;
    }

    public String getCooperative_name() {
        return cooperative_name;
    }

    public void setCooperative_name(String cooperative_name) {
        this.cooperative_name = cooperative_name;
    }

    public String getShould_ticket_amount() {
        return should_ticket_amount;
    }

    public void setShould_ticket_amount(String should_ticket_amount) {
        this.should_ticket_amount = should_ticket_amount;
    }

    public String getShould_ticket_garage() {
        return should_ticket_garage;
    }

    public void setShould_ticket_garage(String should_ticket_garage) {
        this.should_ticket_garage = should_ticket_garage;
    }

    public String getReal_ticket_garage() {
        return real_ticket_garage;
    }

    public void setReal_ticket_garage(String real_ticket_garage) {
        this.real_ticket_garage = real_ticket_garage;
    }

    public String getReal_ticket_time() {
        return real_ticket_time;
    }

    public void setReal_ticket_time(String real_ticket_time) {
        this.real_ticket_time = real_ticket_time;
    }

    public String getAssess_id() {
        return assess_id;
    }

    public void setAssess_id(String assess_id) {
        this.assess_id = assess_id;
    }

    public String getCounty_id() {
        return county_id;
    }

    public void setCounty_id(String county_id) {
        this.county_id = county_id;
    }

    public String getAuthorityContent() {
        return AuthorityContent;
    }

    public void setAuthorityContent(String authorityContent) {
        AuthorityContent = authorityContent;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String toString(){
        return  "TaskCK{"+"id='"+id+'\''+
                ",caseNo='"+caseNo+'\''+
                "}";
    }
}
