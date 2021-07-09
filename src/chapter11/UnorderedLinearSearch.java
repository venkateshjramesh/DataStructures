package chapter11;

public class UnorderedLinearSearch {

    public int getSearchIndex(int[] a,int data){
        for(int i=0; i < a.length ; i++){
            if(a[i] == data)
                return i;
        }
        return  -1;
    }


    public static void main(String args[]){
        UnorderedLinearSearch unorderedLinearSearch = new UnorderedLinearSearch();
        int[] a = new int[]{4,7,3,8,1,9};
        System.out.println(unorderedLinearSearch.getSearchIndex(a,8));
    }

}
