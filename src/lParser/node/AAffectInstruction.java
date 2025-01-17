/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AAffectInstruction extends PInstruction
{
    private PVar _var_;
    private TEqu _equ_;
    private PExpression _expression_;
    private TPVirgule _pVirgule_;

    public AAffectInstruction()
    {
        // Constructor
    }

    public AAffectInstruction(
        @SuppressWarnings("hiding") PVar _var_,
        @SuppressWarnings("hiding") TEqu _equ_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TPVirgule _pVirgule_)
    {
        // Constructor
        setVar(_var_);

        setEqu(_equ_);

        setExpression(_expression_);

        setPVirgule(_pVirgule_);

    }

    @Override
    public Object clone()
    {
        return new AAffectInstruction(
            cloneNode(this._var_),
            cloneNode(this._equ_),
            cloneNode(this._expression_),
            cloneNode(this._pVirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAffectInstruction(this);
    }

    public PVar getVar()
    {
        return this._var_;
    }

    public void setVar(PVar node)
    {
        if(this._var_ != null)
        {
            this._var_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._var_ = node;
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

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    public TPVirgule getPVirgule()
    {
        return this._pVirgule_;
    }

    public void setPVirgule(TPVirgule node)
    {
        if(this._pVirgule_ != null)
        {
            this._pVirgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pVirgule_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._var_)
            + toString(this._equ_)
            + toString(this._expression_)
            + toString(this._pVirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._var_ == child)
        {
            this._var_ = null;
            return;
        }

        if(this._equ_ == child)
        {
            this._equ_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._pVirgule_ == child)
        {
            this._pVirgule_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._var_ == oldChild)
        {
            setVar((PVar) newChild);
            return;
        }

        if(this._equ_ == oldChild)
        {
            setEqu((TEqu) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._pVirgule_ == oldChild)
        {
            setPVirgule((TPVirgule) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
