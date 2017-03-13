
public class FitnessCalc {

    static byte[] solution = new byte[128];

    // Set solution with byte array
    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    // set solution using string of binary
    public static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];
        // Loop through each character of our string and save it in our solution
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character); //turns character into a byte and saves in solution at index i
            } else {
                solution[i] = 0;
            }
        }
    }

    // Calculate individuals' fitness by comparing it to our candidate solution
    public static int getFitness(Individual individual) {
        int fitness = 0;
        // Loop through our individuals genes and compare them to our candidates
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }
    
    // Get maximum fitness; basically solution
    static int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }
}