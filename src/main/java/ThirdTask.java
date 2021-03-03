import java.util.ArrayList;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> commands = getCommands(scanner);
        ArrayList<String> ip = getIPs(scanner);
        ip.forEach(a ->System.out.println(getAnswer(a,commands)));
    }
    public static ArrayList<String> getCommands(Scanner scanner){
        ArrayList<String> commands = new ArrayList<>();
        int commandAmount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < commandAmount; i++) {
            commands.add(scanner.nextLine());
        }
        return commands;
    }
    public static ArrayList<String> getIPs(Scanner scanner){
        ArrayList<String> ip = new ArrayList<>();
        int ipAmount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < ipAmount; i++) {
            ip.add(scanner.nextLine());
        }
        return ip;
    }
    public static String getAnswer (String ip, ArrayList<String> commands){
        String answer = "GRANTED";
        boolean ruleIsTriggered;
        for(String command : commands) {
            String[] commandArray = command.split(" from ");
            if (commandArray[1].contains("/")) {
                String[] range = WorkWithIP.networkToRange(commandArray[1]);
                //В строке ниже проверяется находится ли ip адресс в диапазоне сети
                ruleIsTriggered = WorkWithIP.BinaryIPToLong(range[0]) < WorkWithIP.BinaryIPToLong(WorkWithIP.ipToBinary(ip)) && WorkWithIP.BinaryIPToLong(WorkWithIP.ipToBinary(ip)) < WorkWithIP.BinaryIPToLong(range[1]);
            } else {
                ruleIsTriggered = ip.equals(commandArray[1]);
            }
            if (ruleIsTriggered) {
                if (commandArray[0].equals("deny")){
                    answer = "DENIED";}
                break;
            }
        }
        return answer;
    }

}
