package readability;

import java.util.Arrays;

public class Processor {


    public String[] splitToSentence(String text) {
        return text.split("[//.//?!]");
    }

    public int numberOfWords(String text) {
        String[] sentences = splitToSentence(text);
        int length = 0;
        for (String s : sentences) {
            length += s.trim().replaceAll(",", "").split(" ").length;
        }
        return length;
    }

    public int numberOfCharacter(String text) {
        return text.replaceAll("[\\\n\\\t ]", "").length();
    }

    public int numberOfSyllablesInText(String text) {
        String[] sentences = splitToSentence(text);
        int answer = 0;
        for (String s : sentences) {
            for (String word : s.trim().replaceAll(",", "").split(" ")) {
                answer += numberOfSyllables(word);
            }
        }
        return answer;
    }

    public int numberOfPolysyllables(String text) {
        int answer = 0;
        String[] sentences = splitToSentence(text);
        for (String s : sentences) {
            for (String word : s.trim().replaceAll(",", "").split(" ")) {
                if (numberOfSyllables(word) > 2) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public int numberOfSyllables(String word) {
        char[] array = word.toCharArray();
        if (array.length <= 2) {
            return 1;
        } else {
            int answer = 0;
            if (isVowel(array[0])) {
                answer++;
            }
            for (int i = 1; i < array.length; i++) {
                if (isVowel(array[i]) && !isVowel(array[i - 1])) {
                    answer++;
                }
            }
            if (array[array.length - 1] == 'e') {
                answer --;
            }
            if (answer != 0) {
                return answer;
            } else {
                return 1;
            }
        }

    }

    public boolean isVowel(char c) {
        char[] array = {'a', 'i', 'o', 'e', 'u', 'y', 'A', 'I', 'O', 'E', 'U', 'Y'};
        boolean answer = false;
        for (char el : array) {
            if (el == c) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    public double scoreARI(String text) {
        int numberOfWords = numberOfWords(text);
        int numberOfSentences = splitToSentence(text).length;
        int numberOfCharacter = numberOfCharacter(text);
        return 4.71 * numberOfCharacter / numberOfWords + 0.5 * numberOfWords / numberOfSentences - 21.43;
    }

    public double scoreFK(String text) {
        int numberOfWords = numberOfWords(text);
        int numberOfSentences = splitToSentence(text).length;
        int numberOfSyllables = numberOfSyllablesInText(text);
        return 0.39 * numberOfWords / numberOfSentences + 11.8 * numberOfSyllables / numberOfWords - 15.59;
    }

    public double scoreSMOG(String text) {
        int numberOfSentences = splitToSentence(text).length;
        int numberOfPolysyllables = numberOfPolysyllables(text);
        return 1.043 * Math.sqrt(numberOfPolysyllables * 30 / numberOfSentences) + 3.1291;
    }

    public double scoreCL(String text) {
        int numberOfWords = numberOfWords(text);
        int numberOfSentences = splitToSentence(text).length;
        int numberOfCharacter = numberOfCharacter(text);
        return 0.0588 * numberOfCharacter / numberOfWords * 100 - 0.296 * numberOfSentences / numberOfWords * 100 - 15.8;
    }
}
