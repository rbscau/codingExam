package stage1;

import com.sun.deploy.util.StringUtils;
import model.ConsecutiveCharactersArray;
import supClass.ConsecutiveCharactersHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class ConsecutiveCharactersArrayCleaner extends ConsecutiveCharactersHandler {


    /**
     * 重写字符串转换方法
     * @param fromList
     * @return
     */
    @Override
    public List<Character> transform(List<Character> fromList) {

        if(fromList != null && fromList.size() < 3){
            return fromList;
        }

        //如果子串数量大于3，类似于{a,a,a},则返回空串，表示无效
        return null;
    }
}
