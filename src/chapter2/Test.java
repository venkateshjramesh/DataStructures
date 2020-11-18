package chapter2;

public class Test{
    
    public void towersOfHanoii(int numOfDisks, String sourceRod, String auxRod, String destRod){
        if(numOfDisks <= 1){
            System.out.println(numOfDisks + " moved from " + sourceRod +" to "+ destRod);
            return;
        }
        towersOfHanoii((numOfDisks - 1), sourceRod,  destRod, auxRod);
        System.out.println(numOfDisks + " moved from " + sourceRod +" to "+ destRod);
        towersOfHanoii((numOfDisks - 1), auxRod, sourceRod, destRod);
        
        
    }
    
    public static void main(String args[]){
        Test test = new Test();
        test.towersOfHanoii(10,"A","B","C");
        
    }
}
