package info;

import java.util.Date;

public class ApplicationForLeave {
    private String id;
    private String number;
    private String name;
    private Date date;
    private String reason;
    private int dayNum; //请假天数
    private int status;


    public ApplicationForLeave() {
    }



    public ApplicationForLeave(String id, String number, String name, Date date, String reason, int dayNum, int status) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.date = date;
        this.reason = reason;
        this.dayNum = dayNum;
        this.status = status;
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
