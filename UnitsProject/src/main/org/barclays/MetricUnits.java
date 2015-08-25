package org.barclays;

public class MetricUnits {
    private int kilometer;
    private int meter;
    private int centimeter;

    public MetricUnits(int kilometer, int meter, int centimeter) {
        this.kilometer = kilometer;
        this.meter = meter;
        this.centimeter = centimeter;
    }

    public MetricUnits add(MetricUnits that) {
        int centimetertotal = this.centimeter + that.centimeter;
        int centimeter = centimetertotal % 100;
        int metertotal = this.meter + that.meter + centimetertotal/100;
        int meter = metertotal % 1000;
        int kilometer = this.kilometer + that.kilometer + metertotal/1000;
        return new MetricUnits(kilometer, meter, centimeter);
    }

    public MetricUnits add(ImperialUnits that){
        return this.add(convert(that));
    }

    public MetricUnits convert(ImperialUnits that) {
        int centimetertotal = that.lengthInCentimeters();
        int kilometer = centimetertotal/100000;
        centimetertotal -= kilometer*100000;
        int meter = centimetertotal/100;
        int centimeter = centimetertotal%100;
        return new MetricUnits(kilometer, meter, centimeter);
    }

    public double lengthInFoot() {
        return (this.kilometer*100000 + this.meter*100 + this.centimeter)/30;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof MetricUnits) {
            MetricUnits that = (MetricUnits) object;
        }
        return true;
    }
}