package day50ForMybatisCache;

import java.io.Serializable;
import java.util.Date;

/**
 * When configured copyOnRead or copyOnWrite, a Store will only accept Serializable values
 */
public class AccEncache implements Serializable {
    private Integer id;

    private Date holidayDate;

    private String activityName;

    public AccEncache(Integer id, Date holidayDate) {
        this.id = id;
        this.holidayDate = holidayDate;
    }

    public AccEncache(Integer id, Date holidayDate, String activityName) {
        this.id = id;
        this.holidayDate = holidayDate;
        this.activityName = activityName;
    }

    public AccEncache() {
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