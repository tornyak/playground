package util;

public class Bits {

    /**
     * Extract and return value of i-th bit in the num
     * @param num number to get bit from
     * @param i position between 0 and 31 starting from right
     * @return 1 if bit is set, 0 otherwise
     */
    public static int get(int num, int i) {
        if(i < 0 || i > 31) {
            throw new IllegalArgumentException("i out of range [0, 31], i=" + i);
        }
        return (num >>> i) & 1;
    }

    /**
     * Set i-th bit and return value of number
     * @param num number to set bit in
     * @param i position between 0 and 31 starting from right
     * @return number num with i-th bit set
     */
    public static int set(int num, int i) {
        if(i < 0 || i > 31) {
            throw new IllegalArgumentException("i out of range [0, 31], i=" + i);
        }
        return num | (1 << i);
    }
}
