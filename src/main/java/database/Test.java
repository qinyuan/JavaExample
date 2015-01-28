package database;

import java.sql.Clob;

public class Test {

    private Integer testId;
    private String testName;
    private Object testXml;

    public Integer getTestId() {
        return testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestXml(Object testXml) {
        this.testXml = testXml;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Object getTestXml() {
        return testXml;
    }
}
