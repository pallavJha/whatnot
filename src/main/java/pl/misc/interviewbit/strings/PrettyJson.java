package pl.misc.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * @author Pallav Jha
 * @since 15/4/18
 * <pre class="highlight">
 * <code>
 * Input :
 * {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
 * Output :
 * {
 * A:"B",
 * C:
 * {
 * D:"E",
 * F:
 * {
 * G:"H",
 * I:"J"
 * }
 * }
 * }
 * </code>
 * </pre>
 */
public class PrettyJson {

    public int currentIndex = 0;

    public ArrayList<String> prettyJSON(String json) {
        StringBuilder sb = new StringBuilder();
        int tabCount = 0;
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) == '{' || json.charAt(i) == '[') {
                sb.append("\n");
                for (int j = 0 ; j < tabCount; j++) {
                    sb.append("\t");
                }
                tabCount++;
                sb.append(json.charAt(i));
                sb.append("\n");
                for (int j = 0 ; j < tabCount; j++) {
                    sb.append("\t");
                }
            }
            else if (json.charAt(i) == ',') {
                sb.append(",");
                sb.append("\n");
                for (int j = 0 ; j < tabCount; j++) {
                    sb.append("\t");
                }
            }
            else if (json.charAt(i) == '}'  || json.charAt(i) == ']') {
                sb.append("\n");
                tabCount--;
                for (int j = 0 ; j < tabCount; j++) {
                    sb.append("\t");
                }
                sb.append(json.charAt(i));
            } else {
                sb.append(json.charAt(i));
            }
        }
        String formattedJson = sb.toString();
        String[] arr = formattedJson.split("\n");
        return Arrays.stream(arr)
                .filter(i -> !"".equals(i.trim()))
                .collect(Collectors.toCollection(ArrayList::new));

    }




    public Object prettyJSONAnotherSolution(String json) {
        if (json.charAt(currentIndex) == '{') {
            LinkedHashMap<String, Object> currentMap = new LinkedHashMap<>();
            String currentParent = Character.toString(json.charAt(currentIndex + 1));
            currentMap.put(currentParent, null);
            for (int i = currentIndex + 2; i < json.length(); i++) {
                if (json.charAt(i) == ':') {
                    currentIndex = i + 1;
                    currentMap.put(currentParent, prettyJSONAnotherSolution(json));
                    i = currentIndex + 1;
                }
                if (json.charAt(i) == ',') {
                    currentParent = Character.toString(json.charAt(i + 1));
                    currentMap.put(currentParent, null);
                }
                if (json.charAt(i) == '}') {
                    currentIndex = i;
                    return currentMap;
                }
            }

        } else if (json.charAt(currentIndex) == '\"') {
            String value = null;
            for (int i = currentIndex + 1; i < json.length(); i++) {
                if (json.charAt(i) == '\"') {
                    value = json.substring(currentIndex, i + 1);
                    currentIndex = i;
                    break;
                }
            }
            return value;
        }
        return null;
    }

    public static void main(String[] args) {
        String json = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        json = json.replaceAll("\\s", "");
        PrettyJson obj = new PrettyJson();
        System.out.println(obj.prettyJSON(json).toString().replaceAll("=", ":"));

        json = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
        json = json.replaceAll("\\s", "");
        System.out.println(obj.prettyJSON(json).toString().replaceAll("=", ":"));
    }
}
