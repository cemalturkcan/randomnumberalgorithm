public class Random {
    private long seed;

    public Random(long seed) {
        this.seed = seed;
    }

    public int nextInt() {
        seed = (seed * 1664525L + 1013904223L) & 0xFFFFFFFFL;
        return (int) seed;
    }

    public int nextInt(int min, int max) {
        int range = max - min;
        int value = nextInt() & Integer.MAX_VALUE;
        return min + (value % range);
    }

}
