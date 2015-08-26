package org.barclays.Length;

public abstract class MetricUnits {
    public abstract double convertToBase();

    public abstract double convertFromBase(double value);

    public abstract MetricUnits makeUnit(double value);

    public MetricUnits add(MetricUnits that) {
        return this.makeUnit(this.convertFromBase(this.convertToBase() + that.convertToBase()));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MetricUnits) {
            MetricUnits that = (MetricUnits) obj;
            if(this.convertToBase() == that.convertToBase())
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
