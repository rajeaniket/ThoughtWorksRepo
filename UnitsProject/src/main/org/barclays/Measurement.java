package org.barclays;

public class Measurement {
    private int meters;
    private int centimeters;
    private int conversion;

    public int getMeters() {
        return meters;
    }

    public int getCentimeters() {
        return centimeters;
    }

    public Measurement(int meters, int centimeters, int conversion) {
        this.meters = meters;
        this.centimeters = centimeters;
        this.conversion = conversion;
    }

    public Measurement() {

    }

    public void addMaterial(Measurement that) {
        if (this.conversion == that.conversion) {

            this.meters = this.meters + that.meters + (this.centimeters + that.centimeters) / conversion;

            this.centimeters = (this.centimeters + that.centimeters) % this.conversion;
        }
    }

    public boolean compareMaterial(Measurement that) {

        if (this.conversion != that.conversion)
            return false;

        boolean flag = ((this.meters * this.conversion) + this.centimeters) ==
                ((that.meters * that.conversion) + that.centimeters);

        return flag;
    }
}