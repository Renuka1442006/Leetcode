class Solution {
    public boolean canAliceWin(int n) {
        int subtract = 10;
        boolean aliceTurn = true;

        while (n >= subtract) {
            n -= subtract;
            subtract--;

            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}