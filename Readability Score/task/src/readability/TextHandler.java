package readability;

public class TextHandler {

    public void method(double score, String method) {
        System.out.printf(method + " %.2f", score);
        long answer = (long) Math.round(score);
        switcher((int) answer);
        }


    public void switcher(int answer) {
        switch ((int) answer) {
            case 1:
                System.out.println("(about 6 year olds)");
                break;
            case 2:
                System.out.println("(about 7 year olds)");
                break;
            case 3:
                System.out.println("(about 9 year olds)");
                break;
            case 4:
                System.out.println("(about 10 year olds)");
                break;
            case 5:
                System.out.println("(about 11 year olds)");
                break;
            case 6:
                System.out.println("(about 12 year olds)");
                break;
            case 7:
                System.out.println("(about 13 year olds)");
                break;
            case 8:
                System.out.println("(about 14 year olds)");
                break;
            case 9:
                System.out.println("(about 15 year olds)");
                break;
            case 10:
                System.out.println("(about 16 year olds)");
                break;
            case 11:
                System.out.println("(about 17 year olds)");
                break;
            case 12:
                System.out.println("(about 18 year olds)");
                break;
            case 13:
                System.out.println("(about 24 year olds)");
                break;
            case 14:
                System.out.println("(about 24+ year olds)");
                break;
        }
    }
}
