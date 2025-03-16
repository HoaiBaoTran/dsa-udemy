class reverseString {
    public static void main(String[] args) {
        String name = "Luffy";
        System.out.println(myReverse(name, "", name.length()));
        System.out.println(reverse(name));
    }

    private static String myReverse(String name, String reverseName, int length) {
        // base case
        if (length == 0) {
            return reverseName;
        }
        reverseName += name.substring(length - 1);
        name = name.substring(0, length - 1);
        return myReverse(name, reverseName, length - 1);
    }

    private static String reverse(String name) {
        if (name.length() == 0) {
            return name;
        }

        return reverse(name.substring(1)) + name.charAt(0);
    }
}