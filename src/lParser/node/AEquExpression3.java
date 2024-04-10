/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AEquExpression3 extends PExpression3
{
    private PExpression3 _expression3_;
    private TEqu _equ_;
    private PExpression4 _expression4_;

    public AEquExpression3()
    {
        // Constructor
    }

    public AEquExpression3(
        @SuppressWarnings("hiding") PExpression3 _expression3_,
        @SuppressWarnings("hiding") TEqu _equ_,
        @SuppressWarnings("hiding") PExpression4 _expression4_)
    {
        // Constructor
        setExpression3(_expression3_);

        setEqu(_equ_);

        setExpression4(_expression4_);

    }

    @Override
    public Object clone()
    {
        return new AEquExpression3(
            cloneNode(this._expression3_),
            cloneNode(this._equ_),
            cloneNode(this._expression4_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEquExpression3(this);
    }

    public PExpression3 getExpression3()
    {
        return this._expression3_;
    }

    public void setExpression3(PExpression3 node)
    {
        if(this._expression3_ != null)
        {
            this._expression3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression3_ = node;
    }

    public TEqu getEqu()
    {
        return this._equ_;
    }

    public void setEqu(TEqu node)
    {
        if(this._equ_ != null)
        {
            this._equ_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equ_ = node;
    }

    public PExpression4 getExpression4()
    {
        return this._expression4_;
    }

    public void setExpression4(PExpression4 node)
    {
        if(this._expression4_ != null)
        {
            this._expression4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression4_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression3_)
            + toString(this._equ_)
            + toString(this._expression4_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression3_ == child)
        {
            this._expression3_ = null;
            return;
        }

        if(this._equ_ == child)
        {
            this._equ_ = null;
            return;
        }

        if(this._expression4_ == child)
        {
            this._expression4_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression3_ == oldChild)
        {
            setExpression3((PExpression3) newChild);
            return;
        }

        if(this._equ_ == oldChild)
        {
            setEqu((TEqu) newChild);
            return;
        }

        if(this._expression4_ == oldChild)
        {
            setExpression4((PExpression4) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}