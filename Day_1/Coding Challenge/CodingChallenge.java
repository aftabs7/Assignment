
public class CodingChallenge {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "watermelon", "kiwi", "mango"};
        int maxLength = 0;
        
        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        System.out.println("Length of longest string: " + maxLength);
    }
}

