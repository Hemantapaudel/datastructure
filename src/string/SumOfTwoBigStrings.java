package string;

public class SumOfTwoBigStrings {

    public static void main(String[] args) {
        String number1 = "12345678901234569999999999999999";
        String number2 = "45678901234560000000989898989898989898989898989898989898989";
        int length =0;
        if(number1.length()>number2.length()){
            length = number1.length();
            int k = number2.length();
            while(k != length){
                number2 = "0"+number2;
                k++;
            }
        }else{
            length = number2.length();
            int k = number1.length();
            while(k != length){
                number1 = "0"+number1;
                k++;
            }
        }

        System.out.println(number1);
        System.out.println(number2);

        //String result = "";
        int [] result = new int [length+1];
        int carry = 0;

        char [] arr1 = number1.toCharArray();
        char [] arr2 = number2.toCharArray();

        for(int i =length-1; i >=0 ;i--){

            int sum =  arr1[i]- '0' +  arr2[i] -'0' + carry;
            carry = sum /10;

            result[i+1] = sum%10 ;
        }

        if(carry > 0){
            result[0]=carry;
        }
        System.out.println();
        for(int i : result){
            System.out.print(i);
        }

    }
}
