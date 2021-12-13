package chap06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    private String answer;
    public BaseballGame(String answer) {
        char[] charArr = answer.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char ch : charArr) {
            set.add(ch);
        }
        if(set.size()!=3) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        this.answer=answer;
    }

    public Score guess(String s) {
        char[] answerArr = answer.toCharArray();
        char[] guessArr = s.toCharArray();
        int strikes = 0;
        for (int i=0; i<3; i++) {
            if(answerArr[i]==guessArr[i]) {
                strikes++;
            }
        }
        int balls = 0;
        for (int i=0; i<3; i++) {
            if(Arrays.binarySearch(answerArr, guessArr[i])>=0) {
                balls++;
            }
        }
        balls -= strikes;
        return new Score(strikes, balls);
    }
}
