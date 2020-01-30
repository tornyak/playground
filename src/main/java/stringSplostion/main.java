package stringSplostion;

//Given a non-empty string like "Code" return a string like "CCoCodCode".
public class main {
    public static void main(String[] args) {
        String s = "Code";
        String output;
        output = recursive(s, s.length() - 1);
        System.out.println(output);
    }

    private static String recursive(String s, int index) {
        if (index == 0) return s;
        s = recursive(s.substring(0, s.length() - 1), s.length() - 1) + s;
        return s;
    }

/*
    public String stringSplosion(String str) {
        String result = "";
        // On each iteration, add the substring of the chars 0..i
        for (int i = 0; i < str.length(); i++) {
            result = result + str.substring(0, i + 1);
        }
        return result;
    }
*/
}
