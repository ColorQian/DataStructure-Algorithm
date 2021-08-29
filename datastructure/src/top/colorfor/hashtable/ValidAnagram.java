package top.colorfor.hashtable;


public class ValidAnagram {

    public boolean validAnagram(String s,String t){

        char[] charS = s.toCharArray();
        char[] CharT = t.toCharArray();
        boolean flag = true;
        int[] records = new int[26];

        for (char c : charS) {
            records[c-'a']++;
        }

        for (char c : CharT) {
            records[c-'a']--;
        }

        for (int record : records) {
            if (record != 0){
                flag = false;
            }
        }

        return flag;

    }

    //---------main---------

    public static void main(String[] args) {
        ValidAnagram test = new ValidAnagram();
        boolean b = test.validAnagram("hello", "ollhe");

        System.out.println(b);

        //System.out.println('c'-'a');

    }
}
