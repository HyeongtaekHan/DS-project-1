import java.io.*;

public class Assignment31 {

    public static void main(String[] args) {
        String s;

        try
        {
            BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
            s = rd.readLine();
            rd.close();

            int s_len = s.length();
            char temp = '!';

            Stack oper = new Stack(s_len);
            Stack result = new Stack(s_len);

            for(int i=0;i<s_len;i++) {
                char X = s.charAt(i);
                switch(X) {
                    case '+' :
                        temp = oper.peek();
                        while(temp != '?' && temp != '(') {
                            temp = oper.pop();
                            result.push(temp);
                            temp = oper.peek();
                        }
                        oper.push('+');
                        break;

                    case '-' :
                        temp = oper.peek();
                        while(temp != '?' && temp != '(') {
                            temp = oper.pop();
                            result.push(temp);
                            temp = oper.peek();
                        }
                        oper.push('-');
                        break;

                    case '*' :
                        temp = oper.peek();
                        while(temp == '*' || temp == '/') {
                            temp = oper.pop();
                            result.push(temp);
                            temp = oper.peek();
                        }
                        oper.push('*');
                        break;

                    case '/' :
                        temp = oper.peek();
                        while(temp == '*' || temp == '/') {
                            temp = oper.pop();
                            result.push(temp);
                            temp = oper.peek();
                        }
                        oper.push('/');
                        break;

                    case '(' :
                        oper.push(X);
                        break;

                    case ')' :
                        temp = oper.pop();
                        while(temp != '(') {
                            result.push(temp);
                            temp = oper.pop();
                        }
                        break;

                    default :
                        result.push(X);
                        break;
                }
            }

            if(oper.isEmpty() == false) {
                while(oper.isEmpty() == false) {
                    temp = oper.pop();
                    result.push(temp);
                }
            }

            String postfix = "";

            for(char k = result.pop();k != '?';k = result.pop()) {
                postfix = k + postfix;
            }

            wr.write(postfix);
            wr.close();
        }
        catch (Exception e) {
            System.out.println("ERROR");
        }
    }

}
