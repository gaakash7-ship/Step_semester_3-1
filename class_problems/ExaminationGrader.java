package class_problems;

import java.util.Scanner;

interface Question {
    double evaluate(String correctAnswer, String studentAnswer, double points);
}

class MCQ implements Question {
    public double evaluate(String correctAnswer, String studentAnswer, double points) {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TF implements Question {
    public double evaluate(String correctAnswer, String studentAnswer, double points) {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay implements Question {
    public double evaluate(String correctAnswer, String studentAnswer, double points) {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1].trim();
            String correctAnswer = parts[3].trim();
            String studentAnswer = parts[5].trim();

            String[] lastPart = parts[6].trim().split("\\s+");
            double points = Double.parseDouble(lastPart[0]);

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ();
            } else if (type.equals("TF")) {
                question = new TF();
            } else {
                question = new Essay();
            }

            double score = question.evaluate(
                    correctAnswer,
                    studentAnswer,
                    points);

            System.out.printf("%s: %.2f%n", type, score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}