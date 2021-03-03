public class WorkWithIP {
    public static String[] networkToRange (String network) {
        String[] newNetwork = network.split("/");
        String[] answer = new String[2];
        newNetwork[0] = ipToBinary(newNetwork[0]);
        String[] helper = new String[2];
        try {
            helper[0] = newNetwork[0].substring(0, Integer.parseInt(newNetwork[1]) + Integer.parseInt(newNetwork[1]) / 8);
            helper[1] = newNetwork[0].substring(Integer.parseInt(newNetwork[1]) + Integer.parseInt(newNetwork[1]) / 8);
            answer[0] = helper[0].concat(helper[1].replaceAll("1", "0"));
            answer[1] = helper[0].concat(helper[1].replaceAll("0", "1"));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Битов в маске больше 32");
        }
        return answer;
    }
    public static Long BinaryIPToLong(String dottedIP) {
        String[] addrArray = dottedIP.split("\\.");
        long num = 0;
        for (int i=0;i<addrArray.length;i++) {
            int power = 3-i;
            num += (Integer.parseInt(addrArray[i], 2) % 256) * Math.pow(256,power);
        }
        return num;
    }
    public static String ipToBinary(String dottedIP) {
        String[] arrayhelper = dottedIP.split("\\.");
        arrayhelper[0] = Integer.toBinaryString(Integer.parseInt(arrayhelper[0]));
        while (arrayhelper[0].length() <8) {
            arrayhelper[0] = "0".concat(arrayhelper[0]);
        }
        String answer = arrayhelper[0];
        for (int i = 1; i < arrayhelper.length; i++) {
            arrayhelper[i] = Integer.toBinaryString(Integer.parseInt(arrayhelper[i]));
            while (arrayhelper[i].length() <8) {
                arrayhelper[i] = "0".concat(arrayhelper[i]);
            }
            answer = answer.concat("." + arrayhelper[i]);
        }
        return answer;
    }
}
