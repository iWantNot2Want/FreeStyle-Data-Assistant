package application;

import java.io.File;
import java.util.*;

public class fileImporter {
    private static List<datePoint> dataSet = new ArrayList<datePoint>();


    public void readCSV(String fileName) throws Exception{

        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter(",");

        sc.next();
        sc.next();

        while (sc.hasNext()){
            String[] line = sc.nextLine().split(",");

            //Data forming
            String rawDateString = line[2];
            String[] halfDate = rawDateString.split(" ");
            String[] date = halfDate[0].split("-");
            String[] time = halfDate[1].split(":");

            //Making Calendar n Level variables
            Calendar dateCalendar = Calendar.getInstance();
            dateCalendar.set(Integer.valueOf(date[0]),Integer.valueOf(date[1]),Integer.valueOf(date[2]),Integer.valueOf(time[0]),Integer.valueOf(time[1]));
            Integer level = Integer.valueOf(line[4]);

            //Adding the data from this line to the array
            dataSet.add(new datePoint(level,dateCalendar));
        }
    }

    public static List<datePoint> getDataSet() {
        return dataSet;
    }
}
