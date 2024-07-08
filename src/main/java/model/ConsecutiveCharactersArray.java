package model;


import java.util.List;

/**
 * 对字符串扫描，拆成相同字符串的数组，结构为：{aaa},{llll},{mm},{dd}}
 */
public class ConsecutiveCharactersArray {

    public final List<List<Character>> subStringList   ;
    public ConsecutiveCharactersArray(List<List<Character>> subStringList) {
        this.subStringList = subStringList;
    }
}
