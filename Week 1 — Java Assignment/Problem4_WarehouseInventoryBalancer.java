public class Main {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length
                || sectionA.length == 0) {
            System.out.println("Arrays must have equal non-zero length");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int max = sectionA[0];
        String section = "Section A";
        int index = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "Section A";
                index = i;
            }

            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "Section B";
                index = i;
            }
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + max
                + " (" + section + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {
        int[] a = {20, 15, 30};
        int[] b = {25, 10, 30};
        analyzeInventory(a, b);
    }
}
