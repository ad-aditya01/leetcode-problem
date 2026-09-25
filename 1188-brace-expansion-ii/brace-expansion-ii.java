import java.util.*;

class Solution {
    private String expression;
    private int index;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;

        List<String> answer = new ArrayList<>(parse());
        Collections.sort(answer);

        return answer;
    }

    private Set<String> parse() {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (index < expression.length()
                && expression.charAt(index) != '}') {

            char ch = expression.charAt(index);

            if (ch == ',') {
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                index++;
            } else {
                Set<String> next = new HashSet<>();

                if (ch == '{') {
                    index++;       // Skip opening brace
                    next = parse();
                    index++;       // Skip closing brace
                } else {
                    next.add(String.valueOf(ch));
                    index++;
                }

                current = concatenate(current, next);
            }
        }

        result.addAll(current);
        return result;
    }

    private Set<String> concatenate(Set<String> left,
                                    Set<String> right) {
        Set<String> combined = new HashSet<>();

        for (String a : left) {
            for (String b : right) {
                combined.add(a + b);
            }
        }

        return combined;
    }
}