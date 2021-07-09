package chapter11;

public class OrderedLinearSearch {

    public int getSearchIndex(int[] a,int data){
        for(int i=0; i < a.length ; i++){
            if(a[i] == data)
                return i;
            else if(a[i] >  data){
                return -1;
            }
        }
        return  -1;
    }


    public static void main(String args[]){
        OrderedLinearSearch orderedLinearSearch = new OrderedLinearSearch();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(orderedLinearSearch.getSearchIndex(a,8));
    }

}
