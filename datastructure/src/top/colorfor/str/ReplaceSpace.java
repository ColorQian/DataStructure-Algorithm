package top.colorfor.str;

public class ReplaceSpace {

    public  String replace(String s){
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()){
            if (" ".equals(String.valueOf(c))){  //String.valueOf() 将char转为String
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace rs = new ReplaceSpace();

        String str = rs.replace("we are happy");

        System.out.println(str);



    }
}
