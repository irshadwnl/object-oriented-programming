
// Program to Check Palindrome String


public class PalindromeChecker {
    private String text;
    PalindromeChecker(String text){
        this.text=text;
    }

    boolean checkPalindrome(String text){
        String rev="";
        for(int i=text.length()-1;i>=0;i--){
            rev+=text.charAt(i);
        }

        return rev.equals(text)?true:false;
    }

    void display(){
        System.out.println(checkPalindrome(text));
    }
    public static void main(String[] args) {
        PalindromeChecker p=new PalindromeChecker("liril");
        p.display();
    }
}
