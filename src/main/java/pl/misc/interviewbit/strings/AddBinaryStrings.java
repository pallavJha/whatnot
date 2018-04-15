package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class AddBinaryStrings {

    public String add(String str1, String str2) {
        int numberOfZerosToAdd = Math.abs(str1.length() - str2.length());
        if (numberOfZerosToAdd > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numberOfZerosToAdd; i++) {
                sb.append("0");
            }
            if (str1.length() > str2.length()) {
                sb.append(str2);
                str2 = sb.toString();
            } else {
                sb.append(str1);
                str1 = sb.toString();
            }
        }


        StringBuilder sum = new StringBuilder();
        String carry = "0";
        for (int i = str2.length() - 1; i > -1; i--) {
            String currentSum;
            if (str2.charAt(i) == '0' && str1.charAt(i) == '0') {
                currentSum = "0";
                if (carry.equals("1")) {
                    currentSum = "1";
                }
                carry = "0";
            } else if ((str2.charAt(i) == '0' && str1.charAt(i) == '1')
                    || (str2.charAt(i) == '1' && str1.charAt(i) == '0')) {
                currentSum = "1";
                if (carry.equals("1")) {
                    currentSum = "0";
                    carry = "1";
                }
            } else {
                currentSum = "0";
                if (carry.equals("1")) {
                    currentSum = "1";
                }
                carry = "1";
            }
            sum.append(currentSum);
        }
        if (carry.equals("1")) {
            sum.append("1");
        }

        return new String(sum.reverse());
    }

    public static void main(String[] args) {
        AddBinaryStrings obj = new AddBinaryStrings();
        System.out.println(obj.add("1", "1"));

    }
}
