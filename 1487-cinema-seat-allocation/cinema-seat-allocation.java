class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store reserved seats as bitmask for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        // Masks for the three possible blocks
        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        // Every completely unaffected row can fit 2 groups
        int answer = (n - map.size()) * 2;

        // Process only rows having reservations
        for (int mask : map.values()) {

            boolean canLeft = (mask & left) == 0;
            boolean canMiddle = (mask & middle) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                // Left and right don't overlap
                answer += 2;
            }
            else if (canLeft || canMiddle || canRight) {
                // At least one block is available
                answer += 1;
            }
        }

        return answer;
    }
}