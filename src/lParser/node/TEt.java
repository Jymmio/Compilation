/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class TEt extends Token
{
    public TEt()
    {
        super.setText("&");
    }

    public TEt(int line, int pos)
    {
        super.setText("&");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TEt(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEt(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TEt text.");
    }
}
