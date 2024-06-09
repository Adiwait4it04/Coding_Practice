import java.util.*;

public class asd {
    public String replaceWords(List<String> dictionary, String sentence) {
        sentence = sentence + " ";
        // Sort the dictionary by length of the root words in ascending order
        Collections.sort(dictionary, Comparator.comparingInt(String::length));
        String[] dictionaryArray = dictionary.toArray(new String[0]);
        String word = "", newword = "";
        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);
            if (character != ' ') {
                word = word + sentence.charAt(i);
            } else {
                boolean replaced = false;
                for (String s : dictionaryArray) {
                    if (word.startsWith(s)) {
                        newword = newword + s + " ";
                        word = "";
                        replaced = true;
                        break;  // Break the loop as soon as a root word is found
                    }
                }
                if (!replaced) {
                    newword = newword + word + " ";
                    word = "";
                }
            }
        }
        return newword.trim();  // Use trim() to remove the trailing space
    }

    public static void main(String[] args) {
        asd obj = new asd();
        List<String> al = new ArrayList<>();
        al.add("catt");
        al.add("cat");
        String sentence = "cattail";
        System.out.println(obj.replaceWords(al, sentence));
    }
}