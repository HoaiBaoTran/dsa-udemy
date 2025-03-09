class Solution {
    public static void main(String[] args) {
        String name = "yfful mi iH";
        System.out.println(reverse(name));
    }

    public static String reverse(String name) {
        // check input
        if (name.length() < 2 || name.isEmpty()) {
            return name;
        }

        char[] nameArray = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            nameArray[i] = name.charAt(i);
        }
        String result = "";
        for (int i = nameArray.length - 1; i >= 0; i--) {
            result += nameArray[i];
        }
        return result;
    }
}