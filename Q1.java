import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] votes = new int[10];
        for (int i = 0; i < n; i++) {
            int vote = scanner.nextInt();
            votes[vote - 1]++;
        }
        int maxVotes = votes[0], minVotes = votes[0];
        for (int i = 1; i < 10; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
            }
            if (votes[i] < minVotes) {
                minVotes = votes[i];
            }
        }
        System.out.println(maxVotes - minVotes);
    }
}