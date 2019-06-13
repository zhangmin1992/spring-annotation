package day45ForMyvatisSource.entity;

import java.util.Date;

public class AccTable2 {
    private Integer id;

    private Date holidayDate;

    private String activityName;
    
    private String activityName2;

    public AccTable2(Date holidayDate, String activityName) {
        this.holidayDate = holidayDate;
        this.activityName = activityName;
    }
    
    public AccTable2(Integer id, Date holidayDate, String activityName) {
        this.id = id;
        this.holidayDate = holidayDate;
        this.activityName = activityName;
    }

    public AccTable2() {
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

	public String getActivityName2() {
		return activityName2;
	}

	public void setActivityName2(String activityName2) {
		this.activityName2 = activityName2;
	}
    
}