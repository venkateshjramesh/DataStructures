package javacollections;

public class StringOperations {

    public static void main(String args[]){
        String s = "...stuff...";

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
}
