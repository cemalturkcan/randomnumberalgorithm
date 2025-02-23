
public class Main {
    public static void main(String[] args) {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);

        int[] randomNums = new int[100];
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = random.nextInt();
        }

        int randomIndex = random.nextInt(0, randomNums.length);

        int[] copyList = new int[randomNums.length - 1];
        for (int i = 0, j = 0; i < randomNums.length; i++) {
            if (i == randomIndex) {
                System.out.println("Missing number: " + randomNums[i]);
                continue;
            }
            copyList[j++] = randomNums[i];
        }

        long startTime = System.nanoTime();
        System.out.println("Slow Res: " + findMissingNumberSlow(randomNums, copyList));
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.println("Fast Res: " + findMissingNumberFast(randomNums, copyList));
        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");
    }

    public static int findMissingNumberSlow(int[] mainList, int[] copyList) {
        for (int k : mainList) {
            boolean found = false;
            for (int i : copyList) {
                if (k == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return k;
            }
        }
        return -1;
    }

    public static int findMissingNumberFast(int[] mainList, int[] copyList) {
        int result = 0;
        int minLength = copyList.length;

        for (int i = 0; i < minLength; i++) {
            result ^= mainList[i];
            result ^= copyList[i];
        }

        for (int i = minLength; i < mainList.length; i++) {
            result ^= mainList[i];
        }
        return result;
    }

}