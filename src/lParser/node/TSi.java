/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class TSi extends Token
{
    public TSi()
    {
        super.setText("si");
    }

    public TSi(int line, int pos)
    {
        super.setText("si");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSi(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSi(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSi text.");
    }
}