import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WorkWithIPTest {
    @Test
    public void networkToRangeShouldWork(){
        String[] stringArray = WorkWithIP.networkToRange("192.168.0.0/16");
        String[] ExpectedStringArray = new String[2];
        ExpectedStringArray[0] = "11000000.10101000.00000000.00000000";
        ExpectedStringArray[1] = "11000000.10101000.11111111.11111111";
        Assert.assertArrayEquals(ExpectedStringArray,stringArray);
    }
    @Test
    public void BinaryIPToLongShouldReturnZero(){
        long number = WorkWithIP.BinaryIPToLong("00000000.00000000.00000000.00000000");
        long ExpectedNumber = 0;
        Assert.assertEquals(ExpectedNumber,number);
    }
    @Test
    public void BinaryIPToLongShouldWork(){
        long number = WorkWithIP.BinaryIPToLong("11100000.00000111.11000000.11100000");
        long ExpectedNumber = 3758604512l;
        Assert.assertEquals(ExpectedNumber,number);
    }
    @Test
    public void ipToBinaryShouldWork(){
        String string = WorkWithIP.ipToBinary("192.168.0.1");
        String ExpectedString = "11000000.10101000.00000000.00000001";
        Assert.assertEquals(ExpectedString,string);
    }
}
