package day46ForMybatisLog4jPrintSql.entity;

import java.util.Date;

public class AccTable {
    private Integer id;

    private Date holidayDate;

    private String activityName;
    
//    private String myTuoFengName;

    public AccTable(Date holidayDate, String activityName) {
        this.holidayDate = holidayDate;
        this.activityName = activityName;
    }
    
    public AccTable(Integer id, Date holidayDate, String activityName) {
        this.id = id;
        this.holidayDate = holidayDate;
        this.activityName = activityName;
    }

    public AccTable() {
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

//	public String getMyTuoFengName() {
//		return myTuoFengName;
//	}
//
//	public void setMyTuoFengName(String myTuoFengName) {
//		this.myTuoFengName = myTuoFengName;
//	}
    
}