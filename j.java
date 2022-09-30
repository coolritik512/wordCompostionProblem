import java.io.*;
import java.util.ArrayList;

class j {

    static int nodesize = 26;

    static class TrieNode {
        TrieNode children[];
        boolean wordend;

        TrieNode() {
            children = new TrieNode[nodesize];
            for (int i = 0; i < nodesize; i++)
                children[i] = null;

            wordend = false;
        }
    }

    static void insert(TrieNode root, String word) {
        TrieNode pCrawl = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();


            pCrawl = pCrawl.children[index];
        }
        pCrawl.wordend = true;
    }

    static boolean search(TrieNode root, String word) {
        TrieNode pCrawl = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.wordend);
    }

    static boolean compoundedword(String str, TrieNode root,int length) {
        int size = str.length();

        if (size == 0)
            return true;

        for (int i = 1; i <= size; i++) {

            if (search(root, str.substring(0, i)) && compoundedword(str.substring(i, size), root,length)){
                if(length!=str.length()) return true;
                if(size-i==0) return false;
                return true;
            }
                
        }

        return false;
    }

    public static ArrayList<String> getdata(String filename) throws IOException {

       
        File f = new File(filename);
  
        // String absolute = 
        String path = f.getAbsolutePath();

        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        ArrayList<String> arr = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            arr.add(st);
        }

        return arr;
    }

    public static void solve(String filename) throws IOException {
        

        long startTime = System.nanoTime();

        ArrayList<String> arr = getdata(filename);

        TrieNode root = new TrieNode();

        for (String s : arr)
            insert(root, s);

        String one = "";
        String two = "";
        for (String s : arr) {
            if (compoundedword(s, root,s.length())) {

                if (s.length() > one.length()) {
                    two = one;
                    one = s;
                } else if (s.length() > two.length()) {
                    two = s;
                }
            }
        }

        System.out.println("Longest Compound Word: " + one);
        System.out.println("Second Longest Compound Word: " + two);
        System.out.println("Execution Time: " + (System.nanoTime() - startTime)/1e6 + "ms");

    }

    public static void main(String[] args) throws IOException {

        String filename1 = "Input1.txt";
        solve(filename1);
        System.out.println();
        filename1 = "input2.txt";
        solve(filename1);
    }

}