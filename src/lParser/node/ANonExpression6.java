/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ANonExpression6 extends PExpression6
{
    private TNon _non_;
    private PExpression6 _expression6_;

    public ANonExpression6()
    {
        // Constructor
    }

    public ANonExpression6(
        @SuppressWarnings("hiding") TNon _non_,
        @SuppressWarnings("hiding") PExpression6 _expression6_)
    {
        // Constructor
        setNon(_non_);

        setExpression6(_expression6_);

    }

    @Override
    public Object clone()
    {
        return new ANonExpression6(
            cloneNode(this._non_),
            cloneNode(this._expression6_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANonExpression6(this);
    }

    public TNon getNon()
    {
        return this._non_;
    }

    public void setNon(TNon node)
    {
        if(this._non_ != null)
        {
            this._non_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._non_ = node;
    }

    public PExpression6 getExpression6()
    {
        return this._expression6_;
    }

    public void setExpression6(PExpression6 node)
    {
        if(this._expression6_ != null)
        {
            this._expression6_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression6_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._non_)
            + toString(this._expression6_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._non_ == child)
        {
            this._non_ = null;
            return;
        }

        if(this._expression6_ == child)
        {
            this._expression6_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._non_ == oldChild)
        {
            setNon((TNon) newChild);
            return;
        }

        if(this._expression6_ == oldChild)
        {
            setExpression6((PExpression6) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}