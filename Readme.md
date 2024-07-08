# Stage 1
For a given string that only contains alphabet characters a-z, if 3 or more consecutive
characters are identical, remove them from the string. Repeat this process until
there is no more than 3 identical characters sitting besides each other.
Example:
Input: aabcccbbad
Output:
-> aabbbad
-> aaad
-> d
# Stage 2 - advanced requirement
Instead of removing the consecutively identical characters, replace them with a
single character that comes before it alphabetically.
Example:
ccc -> b
bbb -> a
Input: abcccbad
Output:
-> abbbad, ccc is replaced by b
-> aaad, bbb is replaced by a
-> d



解题：
Java 8+

第一题,执行：stage1.MainClass.main()


第二题，执行
stage2.MainClass.main()



### 程序结构说明：
#### class  model.ConsecutiveCharactersArray  
定义了把字符串按照相邻相同字符切分的字符数组，

####  class  supClass.ConsecutiveCharactersHandler  定义了3个方法：

##### 方法1： supClass.ConsecutiveCharactersHandler.combineByNonNullSeque  
把源字符串构造成model.ConsecutiveCharactersArray 的数组结构
##### 方法2： supClass.ConsecutiveCharactersHandler.makeNewString
调用方法1，把源字符串构建成目标字符串
##### 方法3： supClass.ConsecutiveCharactersHandler.transform
抽象方法，分别被stage1.ConsecutiveCharactersArrayCleaner  和 stage2.ConsecutiveCharactersArrayChanger
覆盖。产生两种不同的重复字符处理逻辑，去除或者替换为字符排序的上一个字符。
