package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();
        String text = builder.toString();
        System.out.println("The text is:");
        System.out.println(text);

        Processor processor = new Processor();
        System.out.println("Words: " + processor.numberOfWords(text));
        System.out.println("Sentences: " + processor.splitToSentence(text).length);
        System.out.println("Characters: " + processor.numberOfCharacter(text));
        System.out.println("Syllables: " + processor.numberOfSyllablesInText(text));
        System.out.println("Polysyllables: " + processor.numberOfPolysyllables(text));

        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        TextHandler handler = new TextHandler();
        double score;
        switch (answer) {
            case "ARI":
                score = processor.scoreARI(text);
                handler.method(score, "Automated Readability Index");
                break;
            case "FK":
                score = processor.scoreFK(text);
                handler.method(score, "Flesch–Kincaid readability tests");
                break;
            case "SMOG":
                score = processor.scoreSMOG(text);
                handler.method(score, "Simple Measure of Gobbledygook");
                break;
            case "CL":
                score = processor.scoreCL(text);
                handler.method(score, "Coleman–Liau index");
                break;
            case "all":
                double scoreARI = processor.scoreARI(text);
                handler.method(scoreARI, "Automated Readability Index");
                double scoreFK = processor.scoreFK(text);
                handler.method(scoreFK, "Flesch–Kincaid readability tests");
                double scoreSMOG = processor.scoreSMOG(text);
                handler.method(scoreSMOG, "Simple Measure of Gobbledygook");
                double scoreCL = processor.scoreCL(text);
                handler.method(scoreCL, "Coleman–Liau index");
                break;
        }



    }


}

/*
 Processor processor = new Processor();
        System.out.println("Words: " + processor.numberOfWords(text));
        System.out.println("Sentences: " + processor.splitToSentence(text).length);
        System.out.println("Characters: " + processor.numberOfCharacter(text));





 */