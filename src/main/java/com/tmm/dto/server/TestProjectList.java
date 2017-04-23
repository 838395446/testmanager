package com.tmm.dto.server;

import com.tmm.domain.TestProject;

import java.util.List;

/**
 * Created by Captain Wang on 17/4/23.
 */
public class TestProjectList {

    private Integer caseTotal;

    private List<TestProject> testProjects;

    public TestProjectList(List<TestProject> testProjects) {
        this.testProjects = testProjects;
    }

    public TestProjectList() {

    }

    public List<TestProject> getTestProjects() {
        return testProjects;
    }

    public void setTestProjects(List<TestProject> testProjects) {
        this.testProjects = testProjects;
    }

    public Integer getCaseTotal() {
        return caseTotal;
    }

    public void setCaseTotals(Integer caseTotal) {
        this.caseTotal = caseTotal;
    }
}
