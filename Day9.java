package MarchDSA;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.SpinnerListModel;

public class Day9 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        //probl 2:
        stringComparison(s);
        //aprooch-2
        stringComparison1(s);
        //stringCharCount(s);-- exception

        stringComparison2(s);

        //problem 3: toggle case
        toggleCase(s);
          //proble 1 : check all substring possible pallindrom
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrom(s.substring(i,j+1))){
                         System.out.println(s.substring(i,j+1));
                }
            }
        }
    }

    private static void toggleCase(String s) {
      char []c = s.toCharArray();
     for(int i=0;i<s.length();i++){
        if(Character.isLowerCase(c[i])){
            c[i] = Character.toUpperCase(c[i]);
        }
        else{
           c[i] =  Character.toLowerCase(c[i]);
        }
     }
     System.out.println("The toggled string : "+Arrays.toString(c));

    }

    private static void stringComparison2(String s) {

        String cpstring=""+s.charAt(0);
        String res="";
        int c=1;

        for(int i=1;i<s.length();i++){
            if(cpstring.charAt(cpstring.length()-1) == s.charAt(i)){
                c++;
               

            }else{
                res=res+cpstring.charAt(cpstring.length()-1)+c;
                c=1;
                cpstring=cpstring+s.charAt(i);
            }
        }
        System.out.println("the count result :"+res);

    }

    private static void stringComparison1(String s) {

      String check=""+s.charAt(0);

      for(int i=1;i<s.length();i++){
        if(check.charAt(check.length()-1) != s.charAt(i)){
            check=check+s.charAt(i);
        }

      }
      System.out.println("2nd approch : "+check);
      

    }

    private static void stringCharCount(String s) {
        int c=0;
        int idx=0;
        String res="";
        while(idx <s.length()-1){
            while(s.charAt(idx) == s.charAt(idx+1)){
                      c++; 
                      idx++;
            }
            if(s.charAt(idx) != s.charAt(idx+1)){
                c++;

            }
            res=res+s.charAt(idx)+c;
            idx++;
            c=0;
             
        }
        res=res+s.charAt(idx)+1;
       
        System.out.println("The count of : "+res);
    }

    private static void stringComparison(String s) {

        int idx=0;
        String res="";
        
        while(idx <s.length()-1){
            if(s.charAt(idx)==s.charAt(idx+1) ){
                idx++;
              
            }else{
                res=res+s.charAt(idx);
                
                idx++;

            }

        }
        while(idx < s.length()){
            res=res+s.charAt(idx);
            idx++;
        }
        System.out.println("The result string "+res);
    }

    private static Boolean isPalindrom(String substring) {
        int st=0;
        int end = substring.length()-1;

        while(st < end){
            if(substring.charAt(st) != substring.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;

    }
    
}
