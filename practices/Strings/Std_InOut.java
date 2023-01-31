import java.util.*;

public class Std_InOut {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> tokens = new ArrayList<>();
        String line;
//read multiple line console input into arraylist
        while (input.hasNextLine()) {
            line=input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            tokens.add(line);
        }
        for (String token : tokens) {
            System.out.print(token);
            System.out.print("\n");
        }
        input.close();
    }
}

