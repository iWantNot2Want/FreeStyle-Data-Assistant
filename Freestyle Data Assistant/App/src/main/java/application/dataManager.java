package application;

import java.util.List;
import static java.lang.Math.toIntExact;

public class dataManager {

    private List<datePoint> dataSet;
    private Integer logsAmount;
    private Integer daysAmount;
    private double vHigh;
    private double high;
    private double inRange;
    private double low;
    private double lowRange = 4.0;
    private double highRange = 10.0;
    private double vHighRange = 14.0;

    public dataManager(){
        dataSet = fileImporter.getDataSet();
        logsAmount = dataSet.size();
        daysAmount = toIntExact(dataSet.get(logsAmount-1).getDate().getTimeInMillis() - dataSet.get(0).getDate().getTimeInMillis()/86400000);
    }


    public List<datePoint> getDataSet() {
        return dataSet;
    }

    public datePoint getDataPoint(int n){
        return dataSet.get(n);
    }

    public double getAVG(){
        Integer temp = 0;
        for(int i = 0; i < logsAmount ; i++){
            temp += dataSet.get(i).getLevel();
        }
        return temp;
    }

    public double getHBA1C(){
        return ((getAVG() + 46.7) / 28.7);
    }

    public double getTotalDeviation(){
        double output = 0;

        for(int i = 0; i < logsAmount ; i++){
            double temp = (dataSet.get(i).getLevel() - getAVG());
            temp = temp * temp;
            output+=temp;
        }

        output = output/logsAmount;
        return output;
    }


    public void setLowRange(double newRange){
        lowRange = newRange;
        fetchPercentageLow();
        fetchInRange();
    }
    public void setHighRange(double newRange){
        highRange = newRange;
        fetchPercentageHigh();
        fetchInRange();
    }
    public void setvHighRange(double newRange){
        vHighRange = newRange;
        fetchPercentageVHigh();
    }

    public void fetchPercentageLow(){
        int temp = 0;
        for (datePoint x : dataSet){
            if(x.getLevel()<=lowRange){
                temp++;
            }
        }
        low = temp/logsAmount;
    }

    public void fetchPercentageHigh(){
        int temp = 0;
        for (datePoint x : dataSet){
            if(x.getLevel()>= highRange && x.getLevel() < vHighRange){
                temp++;
            }
        }
        high = temp/logsAmount;
    }
    public void fetchPercentageVHigh(){
        int temp = 0;
        for (datePoint x : dataSet){
            if(x.getLevel() <= vHighRange){
                temp++;
            }
        }
        vHigh = temp/logsAmount;
    }

    public void fetchInRange(){
        int temp = 0;
        for (datePoint x : dataSet){
            if(x.getLevel() < highRange && x.getLevel() > lowRange){
                temp++;
            }
        }
        inRange = temp/logsAmount;
    }

    public double getLow(){return low;}
    public double getInRange(){return inRange;}
    public double getHigh() {return high;}
    public double getvHigh(){return vHigh;}
    public double getAverageReadings(){return logsAmount/daysAmount;}


}
