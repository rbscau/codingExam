package stage1;

import supClass.ConsecutiveCharactersHandler;

public class MainClass {

    public static void main(String[] args) {
        String srcStr =  "aabcccbbad";


        ConsecutiveCharactersHandler consecutiveCharactersHandler
                = new ConsecutiveCharactersArrayCleaner();

        System.out.println("input: " + srcStr );

        String destString  =  consecutiveCharactersHandler.makeNewString(srcStr);

        // System.out.println(srcStr + " -> " + destString);


    }
}
