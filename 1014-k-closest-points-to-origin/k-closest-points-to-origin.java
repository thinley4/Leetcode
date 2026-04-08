class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        // store value and index
        int[][] valIdx = new int[len][2];
        for(int i=0; i<len; i++) {
            int value = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            valIdx[i][0] = value; // store value at index 0
            valIdx[i][1] = i; // store index at second index
        }

        // sort on the basis of value
        Arrays.sort(valIdx, (a, b) -> a[0] - b[0]);
        // based on k return array
        int[][] res = new int[k][2];

        for(int i=0; i<k; i++) {
            int indexValue = valIdx[i][1];
            res[i] = points[indexValue];
        }

        return res;
    }
}