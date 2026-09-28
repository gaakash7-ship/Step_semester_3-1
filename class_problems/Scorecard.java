package class_problems;

public class Scorecard {
    private boolean[] answers;
    private int answerCount;
    private final int totalQuestions;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        answers = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount < totalQuestions) {
            answers[answerCount] = correct;
            answerCount++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (answers[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}