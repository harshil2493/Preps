public class BitOperation {
    public static void main(String[] args) {
        // 0011
        // 0010
        // 0011 OR  3
        // 0010 AND  2
        // 0001 XOR 1
        // 0 011 = 3
        // 1 100 = -4 (100 => 100-001 => 011 => 100)

        System.out.println(3 | 2);
        System.out.println(3 & 2);
        System.out.println(~3);
        System.out.println(3 ^ 2);

        int newNum = -85; //1 111 1111 1111 1111 1111 1111 1010 1011
        System.out.println(Integer.toBinaryString(newNum));

        // newNum >>> 1 =>  0111 1111 1111 1111 1111 1111 1101 0101 = 2147483605
        System.out.println(newNum >>> 1);

        // newNum >> 1 =>  1 111 1111 1111 1111 1111 1111 1101 0101
        // 111 1111 1111 1111 1111 1111 1101 0100 => 101011 => 43
        System.out.println(newNum >> 1);

        // newNum << 1 => 1 111 1111 1111 1111 1111 1111 0101 0110
        // 111 1111 1111 1111 1111 1111 0101 0101 => 10101010 => 170
        System.out.println(newNum << 1);
    }
}
