/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AVirguleListeExpressionsNext extends PListeExpressionsNext
{
    private TVirgule _virgule_;
    private PExpression _expression_;
    private PListeExpressionsNext _listeExpressionsNext_;

    public AVirguleListeExpressionsNext()
    {
        // Constructor
    }

    public AVirguleListeExpressionsNext(
        @SuppressWarnings("hiding") TVirgule _virgule_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") PListeExpressionsNext _listeExpressionsNext_)
    {
        // Constructor
        setVirgule(_virgule_);

        setExpression(_expression_);

        setListeExpressionsNext(_listeExpressionsNext_);

    }

    @Override
    public Object clone()
    {
        return new AVirguleListeExpressionsNext(
            cloneNode(this._virgule_),
            cloneNode(this._expression_),
            cloneNode(this._listeExpressionsNext_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVirguleListeExpressionsNext(this);
    }

    public TVirgule getVirgule()
    {
        return this._virgule_;
    }

    public void setVirgule(TVirgule node)
    {
        if(this._virgule_ != null)
        {
            this._virgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._virgule_ = node;
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

    public PListeExpressionsNext getListeExpressionsNext()
    {
        return this._listeExpressionsNext_;
    }

    public void setListeExpressionsNext(PListeExpressionsNext node)
    {
        if(this._listeExpressionsNext_ != null)
        {
            this._listeExpressionsNext_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeExpressionsNext_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._virgule_)
            + toString(this._expression_)
            + toString(this._listeExpressionsNext_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._virgule_ == child)
        {
            this._virgule_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._listeExpressionsNext_ == child)
        {
            this._listeExpressionsNext_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._virgule_ == oldChild)
        {
            setVirgule((TVirgule) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._listeExpressionsNext_ == oldChild)
        {
            setListeExpressionsNext((PListeExpressionsNext) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}