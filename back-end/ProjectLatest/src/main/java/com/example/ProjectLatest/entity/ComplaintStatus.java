package com.example.ProjectLatest.entity;

public enum ComplaintStatus {
        CREATED("created"),ASSIGNED("assigned"),INPROGRESS("inprogress"),COMPLETED("completed"),CLOSED("closed");
        String complaintStatus;
        ComplaintStatus(String complaintStatus)
        {
            this.complaintStatus = complaintStatus;
        }
        public String toString()
        {
            return complaintStatus;
        }
}
