/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AP7Expression6 extends PExpression6
{
    private PExpression7 _expression7_;

    public AP7Expression6()
    {
        // Constructor
    }

    public AP7Expression6(
        @SuppressWarnings("hiding") PExpression7 _expression7_)
    {
        // Constructor
        setExpression7(_expression7_);

    }

    @Override
    public Object clone()
    {
        return new AP7Expression6(
            cloneNode(this._expression7_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP7Expression6(this);
    }

    public PExpression7 getExpression7()
    {
        return this._expression7_;
    }

    public void setExpression7(PExpression7 node)
    {
        if(this._expression7_ != null)
        {
            this._expression7_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression7_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression7_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression7_ == child)
        {
            this._expression7_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression7_ == oldChild)
        {
            setExpression7((PExpression7) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}