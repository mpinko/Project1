package edu.gcccd.csis;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    public String[] getAllTaggedSequences()
    {
        String[] sa = {};
        String tmpContent = content;
        for (int i = 0; i < tmpContent.length(); i++)
        {
            if (tmpContent.indexOf(startTag) == i)
            {
                int startString = i + startTag.length();
                for (int j = startString + 1 ; j < tmpContent.length(); j++)
                {
                    int endString = tmpContent.indexOf(endTag, startString + 1);
                    int nextStart = tmpContent.indexOf(startTag, startString + 1);
                    if(nextStart == j && !startTag.equals(endTag))
                    {
                        tmpContent = tmpContent.substring(j + startTag.length(), tmpContent.length());
                        i = 0;
                        break;
                    }
                    else if (endString == j)
                    {
                        sa = adds(sa, tmpContent.substring(startString, j));
                        tmpContent = tmpContent.substring(j + endTag.length(), tmpContent.length());
                        i = 0;
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
    //from presentable
    public String displayStringArray() {
        String[] sa = getAllTaggedSequences();
        String s = "";
        for(int i = 0; i < sa.length; i++)
        {
            s += sa[i] + " : " + sa[i].length() + "\n";
        }
        return s;
    }

    @Override
    public String toString() {
        String noStartTags = content.replace(startTag, "");
        String noTags = noStartTags.replace(endTag, "");
        return noTags;
    }

}
