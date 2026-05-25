
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
        else if(input.contains("offer")){
            s.append("\n\twe offer electronic gadgets , mobiles, laptop , dresses, furniture and many more things you can visit our official website to know more.");
        }
        else if(input.contains("order")){
            s.append("\n\tTo order you have to first login and the add it to cart and then you can place order .");

        }
        else if(input.contains("damaged")){
            s.append("\n\tif you get any damaged product we offer 7 days return policy so you can return it, just place return request on you login. ");

        }else if(input.contains("price")){
            s.append("\n\tto know the prices of product you have to visit our official website.");
        }
        else if(input.contains("contact")||input.contains("support")){
            s.append("\n\tif you are having any more problems you can call on customer support :9865324578 .\nThank you.");
        }
        else if(input.contains("bye")){
            System.out.println("exiting...");
            break;
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
