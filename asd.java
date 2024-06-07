class asd {
    public String replaceWords(String dictionary[], String sentence) {
        String word = "", newword = "";
        int c=0;
        for (int i = 0; i < sentence.length(); i++) {
            c=0;
            char character = sentence.charAt(i);
            if (character != ' ') {
                word = word + sentence.charAt(i);
            } else {
                for (int j = 0; j < dictionary.length; j++) {
                    String s = dictionary[j];
                    if (word.contains(s)) {
                        newword = newword + dictionary[j] + " ";
                        System.out.println(newword);
                        word="";
                        c++;
                    }
                }
                if(c==0)
                {
                    newword = newword + word + " ";
                    System.out.println(newword);
                    word="";
                }
            }
        }
        return newword;
    }

    public static void main(String[] args) {
        asd obj = new asd();
        String[] arr1 = { "cat", "bat", "rat" };
        String sentence = "the cattle was rattled by the battery ";
        System.out.println(obj.replaceWords(arr1, sentence));
    }
}