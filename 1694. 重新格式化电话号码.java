class Solution {
    public String reformatNumber(String number) {
        number = number.replaceAll(" ", "");
        number = number.replaceAll("-", "");
        int len = number.length();
        StringBuilder str = new StringBuilder("");
        int pt = 0;
        while (len > 0) {
            if (len > 4) {
                str.append(number.substring(pt, pt + 3) + "-");
                pt += 3;
                len -= 3;
            } else {
                if (len == 4) {
                    str.append(number.substring(pt, pt + 2));
                    str.append("-");
                    str.append(number.substring(pt + 2, pt + 4));
                } else {
                    str.append(number.substring(pt, pt + len));
                }
                break;
            }
        }
        return str.toString();
    }
}