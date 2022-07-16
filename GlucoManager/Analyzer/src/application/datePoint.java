package application;

import java.util.Calendar;

public class datePoint {
    private Integer level;
    private Calendar date;

        public datePoint(Integer level, Calendar date){
            this.level = level;
            this.date = date;
        }

    public Calendar getDate() {
        return date;
    }

    public Integer getLevel() {
        return level;
    }

    public String toString(){
            return ("Date Point date: " + date + " level: " + level);
    }


}
