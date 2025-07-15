 public static String fill(String st) {
        System.out.println("b4" + st.length());

        for (int i = 0; i < 26; i++) {
            if (st.trim().length() < i) {
                st += "+";
            }
        }

        System.out.println("a4" + st.length());
        return st;
    }
