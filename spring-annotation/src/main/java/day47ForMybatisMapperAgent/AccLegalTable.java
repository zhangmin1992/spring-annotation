package day47ForMybatisMapperAgent;

import java.util.Date;

public class AccLegalTable {
    private Integer id;
 
    private Date holidayDate;

    private String activityName;

    public AccLegalTable(Date holidayDate, String activityName) {
        this.holidayDate = holidayDate;
        this.activityName = activityName;
    }
    
    public AccLegalTable(Integer id, Date holidayDate, String activityName) {
        this.id = id;
        this.holidayDate = holidayDate;
        this.activityName = activityName;
    }

    public AccLegalTable() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    
}