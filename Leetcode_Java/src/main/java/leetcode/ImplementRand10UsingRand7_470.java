package leetcode;


/*Implement rand11() using rand3():

public int rand11() {
        int result = 22;
        while (result >= 22) {result = 3 * 3 * (rand3() - 1) + 3 * (rand3() - 1) + (rand3() - 1);}
        return result % 11 + 1;
        }*/



public class ImplementRand10UsingRand7_470 {

    public int rand10() {
        int result = 40;
        while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
        return result % 10 + 1;
    }

    public int rand7(){
        return (int)Math.random()*7;
    }
}
