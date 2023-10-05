class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin=celsius+273.15;
        double fah=celsius*1.80+32.00;
        double ans[]={kelvin,fah};
        return ans;
    }
}