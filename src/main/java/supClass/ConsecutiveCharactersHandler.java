package supClass;

import com.sun.deploy.util.StringUtils;
import model.ConsecutiveCharactersArray;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class ConsecutiveCharactersHandler {

    /**
     * 1.把字符串数组的数组组合成字符串
     * 2.在字符数组转化时，调用本类的抽象方法 transform
     * @param consecutiveCharactersArray
     * @return
     */
    public String combineByNonNullSeque(ConsecutiveCharactersArray consecutiveCharactersArray){

        List<String> subStrlist = consecutiveCharactersArray.subStringList.stream().map(characters -> {
            List<Character> newCharacters = transform(characters);
            return newCharacters;
        }).filter(characters -> //过滤无效的字符数组
                characters != null && characters.size() > 0
        ).map(
                seq -> {
                   return  StringUtils.join(seq.stream().map(c -> String.valueOf(c)).collect(Collectors.toList()), "");
                }
        ).collect(Collectors.toList());

        return StringUtils.join(subStrlist,"");
    }



    /**
     * 1.把字符串数组的数组组合成字符串
     * 2.在字符数组转化时，调用本类的抽象方法 transform
     * @param
     * @return 目标字符串
     */
    public String makeNewString(String srcString){
        if(srcString == null || srcString.length() < 3){
            return srcString;
        }

        // 建立  ConsecutiveCharactersArray结构
        ConsecutiveCharactersArray consecutiveCharactersArray = buildSubStringArray(srcString);

        String destString = combineByNonNullSeque(consecutiveCharactersArray);


        // 如果经过处理后，字符串的长度已经不再变化，说明不再存在相同的连续的字符串了。则直接返回处理结果，跳出递归
        if( destString.length()  >=  srcString.length()){
            return destString;
        }else{
            System.out.println("->: " +destString );
            // 结果串跟原来不变，说明已经做过一轮处理，字符串已经有变化，则再进行一轮递归处理；
            return makeNewString(destString);
        }
    }


    /**
     * 抽象方法
     * 转化字符数组的，如果无效，就返回null。
     * @param fromList
     * @return
     */

    public abstract List<Character> transform(List<Character> fromList);




    /**
     * 对字符串扫描，拆成相同字符串的数组，结构为：{aaa},{llll},{mm},{dd}}
     * @param  sourceStr 输入的字符串
     * @return ConsecutiveCharactersArray  返回的子串结构
     */
    public static ConsecutiveCharactersArray buildSubStringArray(String sourceStr){
        char lastChar = '0'; //初始化为0，不与任何子串相等

        //由相同字符列表组成的列表，例如  {{aaa}，{cc}，{dd}}
        // 同时初始化结构
        List<List<Character>> subSeqArrays = new ArrayList<>();
        subSeqArrays.add(new ArrayList<Character>());




        for(int  currentIndex = 0; currentIndex  < sourceStr.length() ;  currentIndex++){
            if(lastChar != sourceStr.charAt(currentIndex)){ //扫描到的字符串跟上一个扫描到的值不相等，就追加一个新子串,
                subSeqArrays.add(new ArrayList<>());
            }

            // 记录本次扫描的字符串内容
            lastChar = sourceStr.charAt(currentIndex);
            //新扫描的值，放在最后一个子串的后面
            subSeqArrays.get(subSeqArrays.size() -1).add(sourceStr.charAt(currentIndex) );
        }
        return new ConsecutiveCharactersArray(subSeqArrays);

    }


}
