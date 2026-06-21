class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int[] freq = new int[100001];

        for (int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        for (int price = 1; price <= 100000; price++) {

            if (freq[price] == 0) continue;

            int canBuy = Math.min(freq[price], coins / price);

            count += canBuy;
            coins -= canBuy * price;

            if (coins < price) {
                break;
            }
        }

        return count;
    }
}