package edu.gcccd.csis;

public class SequenceSearchImpl extends SequenceSearch {

	public SequenceSearchImpl(final String content, final String start,
			final String end) {
		super(content, start, end);
	}

	@Override
	public String[] getAllTaggedSequences() {
		String[] sa = {};
		String tmpContent = content;
		boolean found = false;
		do {
			found = false;
			for (int i = 0; i < tmpContent.length() - endTag.length() - startTag.length() + 1; i++) 
			{
				if (tmpContent.charAt(i) == startTag.charAt(0) && tmpContent.charAt(i + startTag.length() - 1) == startTag.charAt(startTag.length() - 1)) 
				{
					int startString = i + startTag.length();
					for (int j = i + 1 + startTag.length(); j < tmpContent.length() - endTag.length() + 1; j++) 
					{
						if (tmpContent.charAt(j) == endTag.charAt(0) && tmpContent.charAt(j + endTag.length() - 1) == endTag.charAt(endTag.length() - 1)) 
						{
							int endString = j;
							sa = adds(sa, tmpContent.substring(startString, endString));
							tmpContent = tmpContent.substring(endString+2, tmpContent.length());
							found = true;
							break;
						}
					}
				}
			}
		} while (!found);
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
    	String[] sa = getAllTaggedSequences();
    	String s = "";
        for(int i = 0; i < sa.length; i++)
        {
        	s += " " + sa[i];
        }
        return s;
    }

    @Override
    public String toString() {
    	String[] sa = getAllTaggedSequences();
    	String s = "";
    	for(int i = 0; i < sa.length; i++)
    	{
    		s+= " " + sa[i];
    	}
        return s;
    }

}

