package withoutString;

/*
Given two strings, base and remove, return a version of the base string
where all instances of the remove string have been removed (not case sensitive).
You may assume that the remove string is length 1 or more.
Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".

withoutString("Hello there", "llo") → "He there"
withoutString("Hello there", "e") → "Hllo thr"
withoutString("Hello there", "x") → "Hello there"
*/

public class WithoutString {

    /*
    //Vanja
    public static String withoutString(String base, String remove) {
        String result = "";
        int removeLen = remove.length();
        int baseLen = base.length();

        for(int i = 0; i < baseLen;) {
            int end = i + removeLen;
            if(end <= baseLen && base.substring(i, end).equalsIgnoreCase(remove)) {
                i += removeLen;
                continue;
            }
            result += base.charAt(i++);
        }
        return result;
    }
    */

    //Tamara
    public static String withoutString(String base, String remove) {
        int lastIndex=-1;
        String result=base;
        boolean found=false;

        do {
            lastIndex=result.toLowerCase().indexOf(remove.toLowerCase(),lastIndex+1);
            if (lastIndex>=0) {
                    found=true;
                result=result.substring(0,lastIndex)+result.substring(lastIndex+remove.length());
                //e.g. covering of removal "llo" in: Hellollo there
                lastIndex--;
            }
            else found=false;
        }
        while (found);
        return result;
    }


}
