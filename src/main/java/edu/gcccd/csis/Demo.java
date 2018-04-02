package edu.gcccd.csis;

public class Demo extends SequenceSearch
{
    private static String s0 = "%sJava%s is a %sprogramming language%s created by %sJames Gosling%s from %sSun Microsystems%s " +
            "(Sun) in 1991. The target of Java is to write a program once and then run this program on multiple " +
            "operating systems. The first publicly available version of Java (Java 1.0) was released in 1995. " +
            "Sun Microsystems was acquired by the Oracle Corporation in 2010. " +
            "Oracle has now the steermanship for Java. In 2006 Sun started to make Java available under the " +
            "GNU General Public License (GPL). Oracle continues this project called %sOpenJDK.%s";

    private static String s1 = "Java is a %sprogramming language%s created by %sJames Gosling%s from %sSun Microsystems%s " +
            "(Sun) in 1991. The target of Java is to write a program once and then run this program on multiple " +
            "operating systems. The first publicly available version of Java (Java 1.0) was released in 1995. " +
            "Sun Microsystems was acquired by the Oracle Corporation in 2010. " +
            "Oracle has now the steermanship for Java. In 2006 Sun started to make Java available under the " +
            "GNU General Public License (GPL). Oracle continues this project called %sOpenJDK.%s";

    private static String s2 = "Java is a %sprogramming language%s created by %sJames Gosling%s from %sSun Microsystems%s " +
            "(Sun) in 1991. The target of Java is to write a program once and then run this program on multiple " +
            "operating systems. The first publicly available version of Java (Java 1.0) was released in 1995. " +
            "Sun Microsystems was acquired by the Oracle Corporation in 2010. " +
            "Oracle has now the steermanship for Java. In 2006 Sun started to make Java available under the " +
            "GNU General Public License (GPL). Oracle continues this project called OpenJDK.";

    private static String s3 = "%sJava%s is a programming language created by James Gosling from Sun Microsystems " +
            "(Sun) in 1991. The target of Java is to write a program once and then run this program on multiple " +
            "operating systems. The first publicly available version of Java (Java 1.0) was released in 1995. " +
            "Sun Microsystems was acquired by the Oracle Corporation in %s2010%s. " +
            "Oracle has now the steermanship for Java. In 2006 Sun started to make Java available under the " +
            "GNU General Public License (GPL). Oracle continues this project called OpenJDK.";

    private static String s4 = "Java is a programming language created by James Gosling from Sun Microsystems " +
            "(Sun) in 1991. The target of Java is to write a program once and then run this program on multiple " +
            "operating systems. The first publicly available version of Java (Java 1.0) was released in 1995. " +
            "Sun Microsystems was acquired by the Oracle Corporation in 2010. " +
            "Oracle has now the steermanship for Java. In 2006 Sun started to make Java available under the " +
            "GNU General Public License (GPL). Oracle continues this project called OpenJDK.";

    public static void main(String[] args)
    {
        final String d0 = "{{";
        final String d1 = "}}";

        String s = String.format(s4, d0, d1);
        //String[] sa = new Demo(s, d0, d1).getAllTaggedSequences();
        int len = new Demo(s, d0, d1).getAllTaggedSequences().length;
        String sa1 = new Demo(s, d0, d1).getLongestTaggedSequence();
        System.out.println(len);
    }

    public Demo(final String content, final String start, final String end) {
        super(content, start, end);
    }

    public String[] getAllTaggedSequences() {
        String[] sa = {};
        for (int i = 0; i < content.length() - endTag.length() - startTag.length() + 1; i++) {
            if (content.charAt(i) == startTag.charAt(0) && content.charAt(i + startTag.length() - 1) == startTag.charAt(startTag.length() - 1)) {
                int startString = i + startTag.length();
                for (int j = i + 1 + startTag.length(); j < content.length() - endTag.length() + 1; j++) {
                    if (content.charAt(j) == endTag.charAt(0) && content.charAt(j + endTag.length() - 1) == endTag.charAt(endTag.length() - 1)) {
                        int endString = j;
                        sa = adds(sa, content.substring(startString, endString));
                        break;
                    }
                }
            }
        }
        return sa;
    }

    public static void printArray(String[] sa)
    {
        for(int i = 0; i < sa.length; i++)
        {
            System.out.println(sa[i]);
        }
    }

    @Override
    public String getLongestTaggedSequence() {
        String[] sa = getAllTaggedSequences();
        int maxLength = 0;
        String sLongest = null;
        for(int i = 0; i < sa.length; i++)
        {
            if(sa[i].length() >= maxLength)
            {
                maxLength = sa[i].length();
                sLongest = sa[i];
            }
        }
        return sLongest;
    }

    @Override
    public String displayStringArray() {
        return null;
    }
}
