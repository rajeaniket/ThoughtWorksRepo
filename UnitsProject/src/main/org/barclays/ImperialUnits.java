package org.barclays;

public class ImperialUnits {
    private int mile;
    private int yard;
    private double foot;

    public ImperialUnits(int mile, int yard, double foot) {
        this.foot = foot;
        this.yard = yard;
        this.mile = mile;
    }

    public ImperialUnits add(ImperialUnits that){
        double foottotal = this.foot + that.foot;
        double foot = (int)foottotal % 3 + (foottotal-(int)foottotal);
        int yardtotal = this.yard + that.yard + (int)foottotal/3;
        int yard = yardtotal % 1760;
        int mile = this.mile + that.mile + yardtotal/1760;
        return new ImperialUnits(mile, yard, foot);
    }

    public ImperialUnits add(MetricUnits that) {
        return this.add(convert(that));
    }

    public ImperialUnits convert(MetricUnits that) {
        double foottotal = that.lengthInFoot();
        double foot = foottotal - (int)foottotal;
        foot = foot + ((int)foottotal)%3;
        int yardtotal = (int)foottotal/3;
        int yard = yardtotal%1760;
        int mile = yardtotal/1760;
        return new ImperialUnits(mile, yard, foot);
    }

    public int lengthInCentimeters() {
        return (int)(30*(this.foot)) + 30*(3*this.yard + 1760*3*this.mile);
    }
}