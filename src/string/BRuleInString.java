package string;

public class BRuleInString {
    static char plus = '+';
    static char minus = '-';
    static char open = '(';
    static char close = ')';

    public static void main(String[] args) {


        String equation = "a+(b - c) - (d - e) - (f-g)+ (h+i)";
        equation = equation.replaceAll(" ", "");


        char[] arr = equation.toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]== close){
                continue;
            }

            if (arr[i] != open) {
                if((arr[i] == plus || arr[i]== minus) && arr[i+1] ==open){
                    continue;
                }
                result.append(arr[i]);

            } else if (arr[i] == open) {
                char previousSigh  = arr[i - 1];
                i++;

                while(arr[i] != close){
                    char ch = arr[i];
                    if(arr[i-1] == open && (ch >= 97 && ch < 122)){
                        result.append(getSign(previousSigh,'+'));
                        result.append(ch);
                    }else if((ch >= 97 && ch < 122)){
                        result.append(ch);
                    }else if(ch == plus || ch == minus){
                        result.append(getSign(previousSigh,ch));
                    }
                    i++;
                }
            }
        }
        System.out.println(result.toString());

    }


    private static char getSign(char previousSign, char currentSign) {
        if (previousSign == plus) {
            return currentSign;
        } else {
            if (currentSign == minus) {
                return plus;
            } else {
                return minus;
            }
        }


    }


}
