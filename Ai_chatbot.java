
import java.util.*;

void main(){

    Scanner sc = new Scanner(System.in);
    StringBuilder s = new StringBuilder();
    String name = "guest";
    s.append(" ");
    String input;
    String[] process;
    System.out.println("Official Website");
    System.out.println("Enter 'bye' to exit.");
    while (true){
        s.append("Bot: ");
        System.out.println("you : ");
        input = sc.nextLine();
        input = input.toLowerCase();
        if(input.contains("my name")||input.contains("i am")){
            process = input.split(" ");
            for( int i = 0 ; i < process.length; i++){
                if(process[i].equals("name")||process[i].equals("am")){
                    if(process[i+1].equals("is")){
                        i++;
                    }
                    i++;
                    name = process[i];
                    break;
                }
            }
            s.append("hi ,"+ name);
        }
        else{
            System.out.println("Bot: sorry i did not understand your question. if issue persist pleas contact support team.");
            s.setLength(0);
            s.append("\n");
        }
        System.out.println(s);
        s.setLength(0);
    }
    sc.close();
}
