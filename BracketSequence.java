import java.util.Map;
import java.util.Stack;

/*Необходимо определить, является ли последовательность скобок в строке правильной.
Существует 3 вида скобок (), [], {} - из них мы составляем последовательно вида:
"()[]{}" -> true,

"()" -> true,
"}]{[" -> false,
"(]" -> false.
Определить, какая из этих последовательность правильная - каждая открытая скобка должна закрывать скобкой того же вида.
Для решения необходимо использовать Stack и Map. */

public class BracketSequence {

    public static void main(String[] args) {
        String input = "{}";

        if (CheckBracket(input)) {
            System.out.println("Row is right");
        } else {
            System.out.println("Row is not right");
        }

    }

    private static boolean CheckBracket(String str) {   //долго сидел и гуглил что возвращет тот или иной метод.
        Stack<Character> steck = new Stack<>();
        Map<Character, Character> Brackets = Map.of('(', ')',
                '[', ']',
                '{', '}');

        if (str.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentSimbol = str.charAt(i);    
            if (Brackets.containsKey(currentSimbol)) {
                steck.push(currentSimbol);
            } else {
                if (steck.isEmpty() || Brackets.get(steck.peek()) != currentSimbol) {    // еле еле понял, пока не листочке все не прогнал сидел тупил.
                    return false;                                                        // хотя 100% наши опытные программисты которые со мной в группе поняли все быстро.
                }                                                                        // а я отстал так недели на 2. 
                steck.pop();
            }
        }
       return steck.isEmpty();
    }
}