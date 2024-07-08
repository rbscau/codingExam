package stage2;

import com.sun.deploy.util.StringUtils;
import supClass.ConsecutiveCharactersHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsecutiveCharactersArrayChanger extends ConsecutiveCharactersHandler {

    /**
     * 重写字符串转换方法
     * @param fromList
     * @return
     */
    @Override
    public List<Character> transform(List<Character> fromList) {
        if (fromList != null && fromList.size() < 3) {
            return fromList;
        }
        if (fromList.size() >= 3) {
            List<Character> toList = new ArrayList<>();
            if(fromList.get(0) == 'a'){
                //如果是重复的a  则清掉
            }else{
                toList = new ArrayList<>();
                int charNumb = (int) (fromList.get(0));
                charNumb = charNumb -1;
                toList.add((char) charNumb);
            }
            System.out.print  ("   , " + StringUtils.join(fromList.stream().map(s -> String.valueOf(s) ).collect(Collectors.toList()), "") +" is replace by " + StringUtils.join(toList.stream().map(s -> String.valueOf(s) ).collect(Collectors.toList()), "") + "  ");

            return toList;
        }
        return null;
    }
}
