package basics.maths;

public class LcmOfNumbers {
//    public int GCD(int n1, int n2) {
//        int maxNumber = 1;
//
//        for (int i = 2; i < Math.min(n1, n2); i++) {
//            if (n1 % i == 0 && n2 % i == 0) {
//                maxNumber = i;
//            }
//        }
//
//        return maxNumber;
//    }
//
//    public int LCM(int n1, int n2) {
//        return (n1 * n2) / GCD(n1, n2);
//    }

    public int LCMBrute(int n1, int n2) {
        int i = 1;
        int maxNumber = Math.max(n1, n2);

        do {
            int multiple = i * maxNumber;

            if (multiple % n1 == 0 && multiple % n2 == 0) {
                return multiple;
            }

            i = i + 1;
        } while (true);
    }
}
