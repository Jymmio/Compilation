/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ALireExpression7 extends PExpression7
{
    private TLire _lire_;

    public ALireExpression7()
    {
        // Constructor
    }

    public ALireExpression7(
        @SuppressWarnings("hiding") TLire _lire_)
    {
        // Constructor
        setLire(_lire_);

    }

    @Override
    public Object clone()
    {
        return new ALireExpression7(
            cloneNode(this._lire_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALireExpression7(this);
    }

    public TLire getLire()
    {
        return this._lire_;
    }

    public void setLire(TLire node)
    {
        if(this._lire_ != null)
        {
            this._lire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lire_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lire_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lire_ == child)
        {
            this._lire_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lire_ == oldChild)
        {
            setLire((TLire) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
