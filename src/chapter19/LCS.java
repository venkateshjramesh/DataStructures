package chapter19;

public class LCS {

  // recursive solution with no memoization, very costly as many problems are solved repeatedly
  public static String getLCSRecursive(String X, String Y){
    int x1 = X.length();
    int y1 = Y.length();

    if(x1==0 || y1==0){
      return "";
    }
    if(X.charAt(0)==Y.charAt(0)){
      return X.charAt(0)+getLCSRecursive(X.substring(1,x1),Y.substring(1,y1));
    }
    else{
      String s1 = getLCSRecursive(X,Y.substring(1,y1));
      String s2 = getLCSRecursive(X.substring(1,x1),Y);
      return s1.length()>s2.length()?s1:s2;
    }

  }

  public static String getLCSMemoization(String X, String Y){
    int x1 = X.length();
    int y1 = Y.length();

    // Since we will be using 0,0 as base case
    /*
    * i.e res[1][1] - means selecting first element in X(index 0) and first element in Y(index 0)
    * lly res[3][2] - means selecting third element in X(index 2) and second element in Y(index 1)
    * */
    int[][] res = new int[x1+1][y1+1];
    for(int i=0;i<x1;i++){
      for(int j=0;j<y1;j++){
        if(X.charAt(i)==Y.charAt(j)){
          // since index is starting from zero, but the matrix index signifies index in string with starting from 1
          // This means selecting both of them
          res[i+1][j+1] = 1 + res[i][j];
        }
        else{
          // case 1: Hold on to the i+1 th char in X (index i) and go for next char in Y(j+2) (index j+1)
          // case 2: Go for next char in X and hold on to j+1 th char in Y
          res[i+1][j+1] =  Math.max(res[i][j+1],res[i+1][j]);
        }
        System.out.print(" " + res[i+1][j+1]);
      }
      System.out.println("");
    }

    StringBuilder resString = new StringBuilder();

    int i=x1; int j=y1;
    while(i >0 && j>0){
      if(res[i-1][j] == res[i][j]) {
        i--;
      }
      else if(res[i][j-1] ==  res[i][j]) {
        j--;
      }
      else{
        resString.append(X.charAt(i-1));
        i--;
        j--;
      }

    }

    return resString.reverse().toString();
  }


  public static void main(String[] args){
    String X = "ABCD";
    String Y = "EAFB";
//    String res = getLCSRecursive(X,Y);
    String res = getLCSMemoization(X,Y);
    System.out.println("X : " + X + " Y: " + Y + " res : " + res);
  }
}
