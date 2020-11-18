package chapter2;

public class TowersOfHanoii{

    static void performTOIOperation(int n, String sourceRod,String destRod ,String auxRod){
        if(n <= 1){
            System.out.println("Disk 1 moved from " + sourceRod + " to the " + destRod);
            return;
        }
        performTOIOperation(n-1, sourceRod, auxRod, destRod);
        System.out.println("Disk "+n+" moved from " + sourceRod + " to the " + destRod);
        performTOIOperation(n-1,auxRod, destRod, sourceRod);
    }
    
    public static void main(String args[]){
        TowersOfHanoii towersOfHanoii = new TowersOfHanoii();
        towersOfHanoii.performTOIOperation(10,"A","C","B");
    }
}

//https://www.geeksforgeeks.org/java-program-for-tower-of-hanoi/
