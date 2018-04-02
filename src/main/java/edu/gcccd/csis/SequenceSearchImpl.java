package edu.gcccd.csis;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    @Override
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

    @Override
    public String toString() {
        return null;
    }

}