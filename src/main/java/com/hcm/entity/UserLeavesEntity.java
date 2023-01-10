package com.hcm.entity;

import com.hcm.enums.LeaveType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserLeaves")
public class UserLeavesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ul_id")
    private Long id;

    @Column(name = "ul_ui_id")
    private Long userId;

    @Column(name = "ul_type")
    private LeaveType leaveType;

    @Column(name = "ul_count")
    private Long noOfLeaves;

    @Column(name = "ul_reason")
    private String reason;

    @Column(name = "ul_document")
    private String documentLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public Long getNoOfLeaves() {
        return noOfLeaves;
    }

    public void setNoOfLeaves(Long noOfLeaves) {
        this.noOfLeaves = noOfLeaves;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDocumentLink() {
        return documentLink;
    }

    public void setDocumentLink(String documentLink) {
        this.documentLink = documentLink;
    }
}
