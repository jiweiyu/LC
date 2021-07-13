package leetcode;

public class DesignParkingSystem_1603 {
    int[] park;
    public DesignParkingSystem_1603(int big, int medium, int small) {
        park = new int[3];
        park[0] = big;
        park[1] = medium;
        park[2] = small;
    }

    public boolean addCar(int carType) {
        if(park[carType-1]>0) {
            park[carType-1]--;
            return true;
        }
        return false;
    }
}
