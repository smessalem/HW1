public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int minSteps = m.length; // initialize minSteps to the maximum possible steps (the number of rows in the matrix)
        
        if (i== j) {
            return 0; // If the starting and ending positions are the same, no steps are needed
        }
        
        for (int l=0; l<m[0].length; l++) {
            int element = m[l][j];
            if (element == 1) {
                int path = findShortestPath(m, i, l) + 1;
                if (path < minSteps) {
                    minSteps = path;
                }
            }
        }
        if (minSteps < m.length) {
            return minSteps;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}