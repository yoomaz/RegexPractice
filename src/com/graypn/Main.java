package com.graypn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        test01();

//        test02();

//        test03();

//        test04();

//        test05();

//        test06();

//        test07();

//        test08();

//        test09();

//        test10();

//        test11();

//        test12();

//        test13();

//        test14();

//        test15();

//        test16();

//        test17();

//        test18();

        test00();
    }
    /**
     * +
     * 一次或者多次
     */
    private static void test00() {
        String pattern = "[1-9][*]";

        String str01 = "2[a]";
        String str02 = "snoow";
        String str03 = "snw";

        System.out.println(Pattern.matches(pattern, str01));
//        System.out.println(Pattern.matches(pattern, str02));
//        System.out.println(Pattern.matches(pattern, str03));

    }

    /**
     * +
     * 一次或者多次
     */
    private static void test01() {
        String pattern = "sno+w";

        String str01 = "snow";
        String str02 = "snoow";
        String str03 = "snw";

        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));

    }

    /**
     * *
     * 零次或者多次
     */
    private static void test02() {
        String pattern = "sno*w";

        String str01 = "snow";
        String str02 = "snoow";
        String str03 = "snw";

        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));

    }

    /**
     * \ 转义
     * 只匹配 sno*w ，java 里面用 \ 转义需要用两个 \\
     */
    private static void test03() {
        String pattern = "sno\\*w";

        String str01 = "snow";
        String str02 = "sno*w";

        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));

    }

    /**
     * ？
     * 零次或者一次
     */
    private static void test04() {
        String pattern = "sno?w";

        String str01 = "snow";  // true
        String str02 = "snoow"; // false
        String str03 = "snw";   // true


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * [n-m]
     * 数字范围
     */
    private static void test05() {
        String pattern = "[1-9][0-9]*";

        String str01 = "1";  // true
        String str02 = "01"; // false
        String str03 = "110";   // true


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * {n}
     * 重复 n 次
     */
    private static void test06() {
        String pattern = "sno{2}w";

        String str01 = "snow";  // true
        String str02 = "snoow"; // false
        String str03 = "snw";   // false


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * {n,}
     * 重复至少 n 次
     */
    private static void test07() {
        String pattern = "sno{2,}w";

        String str01 = "snow";  // true
        String str02 = "snoow"; // false
        String str03 = "snoooow";   // true


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * {n,m}
     * 重复至少 n 次, 最多 m 次
     */
    private static void test08() {
        String pattern = "sno{2,3}w";

        String str01 = "snow";  // true
        String str02 = "snoow"; // false
        String str03 = "snooow";   // false
        String str04 = "snoooow";   // false


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
        System.out.println(Pattern.matches(pattern, str04));
    }

    /**
     * \b
     * 代表单词的开头或结尾，也就是单词的分界处，它只匹配一个位置
     */
    private static void test09() {
        String pattern = "\\bhi\\b";

        String str01 = "hi";  // true
        String str02 = "him"; // false
        String str03 = "history";   // false


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * .
     * .是另一个元字符，匹配除了换行符以外的任意字符
     * <p>
     * 这里 .* 匹配任意多个字符
     */
    private static void test10() {
        String pattern = "hi.*";

        String str01 = "hi";  // true
        String str02 = "him"; // false
        String str03 = "history";   // false


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * \d
     * \d 匹配任何一个数字
     * <p>
     * 0\d\d-\d\d\d\d\d\d\d
     * 0\d{2}-\d{7}
     */
    private static void test11() {
        String pattern01 = "0\\d\\d-\\d\\d\\d\\d\\d\\d\\d";
        String pattern02 = "0\\d{2}-\\d{7}";

        String str01 = "010-3693377";  // true
        String str02 = "010-36933779"; // false

        System.out.println(Pattern.matches(pattern01, str01));
        System.out.println(Pattern.matches(pattern01, str02));

        System.out.println(Pattern.matches(pattern02, str01));
        System.out.println(Pattern.matches(pattern02, str02));
    }

    /**
     * \w
     * 匹配字母或数字或下划线，等价于 [A-Za-z0-9_]，不能匹配汉字
     */
    private static void test12() {
        String pattern = "\\w{2}";

        String str01 = "是是";  // false
        String str02 = "h2"; // true
        String str03 = "hia"; // false


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * [] 字符集合
     * [0-9] 代表数字 0-9的任何一个数字
     * [abc] 代表字母 abc 中的一个字符
     * [a-z] 代表字母 abc...z 中的一个字符
     * [!?] 代表符号 !? 中的一个符号
     * [A-Za-z0-9] 可以把所有字符拼接起来供选择，中间不带空格
     */
    private static void test13() {
        String pattern01 = "[0-9]{2}";
        String pattern02 = "[a-z]{2}";
        String pattern03 = "[A-Za-z0-9]{3}";

        String str01 = "10";  // true
        String str02 = "ab"; // true
        String str03 = "aA1"; // true


        System.out.println(Pattern.matches(pattern01, str01));
        System.out.println(Pattern.matches(pattern02, str02));
        System.out.println(Pattern.matches(pattern03, str03));
    }

    /**
     * |
     * 分歧条件，相当于或者
     */
    private static void test14() {
        String pattern = "\\d{2}|\\d{3}";

        String str01 = "1";  // false
        String str02 = "12"; // true
        String str03 = "123"; // true


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * ()
     * 分组，把一段内容当做一个整体
     */
    private static void test15() {
        String pattern = "(666){1,2}";

        String str01 = "66";  // false
        String str02 = "666"; // true
        String str03 = "666666"; // true


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
    }

    /**
     * \D ：匹配任意非数字的字符，同理还有 \W ，即原来的字母大写就变成了相反的意思
     * [^x] ：匹配除了x以外的任意字符
     * [^abcd]：匹配除了 abcd 这几个字母以外的任意字符
     * 反义
     */
    private static void test16() {
        String pattern01 = "\\D*"; // 每一位都不能是数字
        String pattern02 = "[^abcd]";

        String str01 = "aaa";  // true
        String str02 = "66a6"; // false

        String str03 = "a"; // false
        String str04 = "e"; // true


        System.out.println(Pattern.matches(pattern01, str01));
        System.out.println(Pattern.matches(pattern01, str02));

        System.out.println(Pattern.matches(pattern02, str03));
        System.out.println(Pattern.matches(pattern02, str04));
    }

    /**
     * *? 匹配任意字符，但是尽可能的少
     * 像前面的 * + {n,} {n,m} {n} 都是贪婪的，会尽量去匹配更多
     * <p>
     * 例如 aabab , a.*b 匹配 aabbab； a.*?b 匹配 aab 和 ab
     * （为什么第一个匹配是aab（第一到第三个字符）而不是ab（第二到第三个字符）？简单地说，因为正则表达式有另一条规则，比懒惰／贪婪规则的优先级更高：最先开始的匹配拥有最高的优先权）
     * <p>
     * 贪婪与懒惰
     */
    private static void test17() {
        String pattern = "a.*?b"; // 每一位都不能是数字

        String str01 = "aabab";  // true

        // 打印所有匹配到的结果
        Pattern pt = Pattern.compile(pattern);
        Matcher matcher = pt.matcher(str01);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println(Pattern.matches(pattern, str01));
    }

    private static void test18() {
        String pattern = "^[\\u4e00-\\u9fa5a-zA-Z0-9]{1,8}$";

        String str01 = "aaa";  // true
        String str02 = "66a6"; // false
        String str03 = "Aa6"; // false
        String str04 = "安安A6a撒a巨大"; // true


        System.out.println(Pattern.matches(pattern, str01));
        System.out.println(Pattern.matches(pattern, str02));
        System.out.println(Pattern.matches(pattern, str03));
        System.out.println(Pattern.matches(pattern, str04));
    }


}
