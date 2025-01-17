/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AResultFoncInstruction extends PInstruction
{
    private TRetour _retour_;
    private PExpression _expression_;
    private TPVirgule _pVirgule_;

    public AResultFoncInstruction()
    {
        // Constructor
    }

    public AResultFoncInstruction(
        @SuppressWarnings("hiding") TRetour _retour_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TPVirgule _pVirgule_)
    {
        // Constructor
        setRetour(_retour_);

        setExpression(_expression_);

        setPVirgule(_pVirgule_);

    }

    @Override
    public Object clone()
    {
        return new AResultFoncInstruction(
            cloneNode(this._retour_),
            cloneNode(this._expression_),
            cloneNode(this._pVirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAResultFoncInstruction(this);
    }

    public TRetour getRetour()
    {
        return this._retour_;
    }

    public void setRetour(TRetour node)
    {
        if(this._retour_ != null)
        {
            this._retour_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._retour_ = node;
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
            + toString(this._retour_)
            + toString(this._expression_)
            + toString(this._pVirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._retour_ == child)
        {
            this._retour_ = null;
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
        if(this._retour_ == oldChild)
        {
            setRetour((TRetour) newChild);
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
