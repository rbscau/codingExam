package stage2;

import stage1.ConsecutiveCharactersArrayCleaner;
import supClass.ConsecutiveCharactersHandler;

public class MainClass {

    public static void main(String[] args) {
        String srcStr =  " abcccbad";


        ConsecutiveCharactersHandler consecutiveCharactersHandler
                = new ConsecutiveCharactersArrayChanger();

        System.out.println("input: " + srcStr );

        String destString  =  consecutiveCharactersHandler.makeNewString(srcStr);

        // System.out.println(srcStr + " -> " + destString);


    }
}
