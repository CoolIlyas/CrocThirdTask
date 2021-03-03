import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class ThirdTaskTest {
    @Test
    public void getCommandsShouldWork(){
        Scanner scanner = new Scanner("4\n" +
            "allow from 10.0.0.1\n" +
            "deny from 10.0.0.0/8\n" +
            "allow from 192.168.0.0/16\n" +
            "deny from 192.168.0.1");
        ArrayList<String> commands = ThirdTask.getCommands(scanner);
        ArrayList<String> commandsExpected = new ArrayList<String>();
        commandsExpected.add("allow from 10.0.0.1");
        commandsExpected.add("deny from 10.0.0.0/8");
        commandsExpected.add("allow from 192.168.0.0/16");
        commandsExpected.add("deny from 192.168.0.1");
        Assert.assertEquals(commandsExpected,commands);
    }
    @Test
    public void getIPsShouldWork(){
        Scanner scanner = new Scanner("5\n" +
            "10.0.0.1\n" +
            "10.0.0.2\n" +
            "194.85.160.133\n" +
            "192.168.0.1\n" +
            "192.168.0.2");
        ArrayList<String> ip = ThirdTask.getIPs(scanner);
        ArrayList<String> ipsExpected = new ArrayList<String>();
        ipsExpected.add("10.0.0.1");
        ipsExpected.add("10.0.0.2");
        ipsExpected.add("194.85.160.133");
        ipsExpected.add("192.168.0.1");
        ipsExpected.add("192.168.0.2");
        Assert.assertEquals(ipsExpected,ip);
    }
    @Test
    public void getAnswerShouldWork1(){
        ArrayList<String> answers = new ArrayList<String>();
        Scanner scanner = new Scanner("4\n" +
                "allow from 10.0.0.1\n" +
                "deny from 10.0.0.0/8\n" +
                "allow from 192.168.0.0/16\n" +
                "deny from 192.168.0.1\n" +
                "5\n" +
                "10.0.0.1\n" +
                "10.0.0.2\n" +
                "194.85.160.133\n" +
                "192.168.0.1\n" +
                "192.168.0.2");
        ArrayList<String> commands = ThirdTask.getCommands(scanner);
        ArrayList<String> ip = ThirdTask.getIPs(scanner);
        ip.forEach(a ->answers.add(ThirdTask.getAnswer(a,commands)));
        ArrayList<String> ExpectedAnswers = new ArrayList<String>();
        ExpectedAnswers.add("GRANTED");
        ExpectedAnswers.add("DENIED");
        ExpectedAnswers.add("GRANTED");
        ExpectedAnswers.add("GRANTED");
        ExpectedAnswers.add("GRANTED");
        Assert.assertEquals(ExpectedAnswers,answers);
    }
    @Test
    public void getAnswerShouldWork2(){
        ArrayList<String> answers = new ArrayList<String>();
        Scanner scanner = new Scanner("3\n" +
                "deny from 0.241.41.44/1\n" +
                "allow from 203.7.8.87\n" +
                "deny from 16.235.251.191/2\n" +
                "4\n" +
                "91.105.11.109\n" +
                "192.142.187.43\n" +
                "98.156.48.62\n" +
                "237.206.31.250");
        ArrayList<String> commands = ThirdTask.getCommands(scanner);
        ArrayList<String> ip = ThirdTask.getIPs(scanner);
        ip.forEach(a ->answers.add(ThirdTask.getAnswer(a,commands)));
        ArrayList<String> ExpectedAnswers = new ArrayList<String>();
        ExpectedAnswers.add("DENIED");
        ExpectedAnswers.add("GRANTED");
        ExpectedAnswers.add("DENIED");
        ExpectedAnswers.add("GRANTED");
        Assert.assertEquals(ExpectedAnswers,answers);
    }
}
