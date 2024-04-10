/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class AIntExp extends PExp
{
    private TInteger _integer_;

    public AIntExp()
    {
        // Constructor
    }

    public AIntExp(
        @SuppressWarnings("hiding") TInteger _integer_)
    {
        // Constructor
        setInteger(_integer_);

    }

    @Override
    public Object clone()
    {
        return new AIntExp(
            cloneNode(this._integer_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIntExp(this);
    }

    public TInteger getInteger()
    {
        return this._integer_;
    }

    public void setInteger(TInteger node)
    {
        if(this._integer_ != null)
        {
            this._integer_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._integer_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._integer_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._integer_ == child)
        {
            this._integer_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._integer_ == oldChild)
        {
            setInteger((TInteger) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}