/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ATantqueInstruction extends PInstruction
{
    private TTantque _tantque_;
    private PExpression _expression_;
    private TFaire _faire_;
    private PBlocInstructions _blocInstructions_;

    public ATantqueInstruction()
    {
        // Constructor
    }

    public ATantqueInstruction(
        @SuppressWarnings("hiding") TTantque _tantque_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TFaire _faire_,
        @SuppressWarnings("hiding") PBlocInstructions _blocInstructions_)
    {
        // Constructor
        setTantque(_tantque_);

        setExpression(_expression_);

        setFaire(_faire_);

        setBlocInstructions(_blocInstructions_);

    }

    @Override
    public Object clone()
    {
        return new ATantqueInstruction(
            cloneNode(this._tantque_),
            cloneNode(this._expression_),
            cloneNode(this._faire_),
            cloneNode(this._blocInstructions_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATantqueInstruction(this);
    }

    public TTantque getTantque()
    {
        return this._tantque_;
    }

    public void setTantque(TTantque node)
    {
        if(this._tantque_ != null)
        {
            this._tantque_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tantque_ = node;
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

    public TFaire getFaire()
    {
        return this._faire_;
    }

    public void setFaire(TFaire node)
    {
        if(this._faire_ != null)
        {
            this._faire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._faire_ = node;
    }

    public PBlocInstructions getBlocInstructions()
    {
        return this._blocInstructions_;
    }

    public void setBlocInstructions(PBlocInstructions node)
    {
        if(this._blocInstructions_ != null)
        {
            this._blocInstructions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._blocInstructions_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tantque_)
            + toString(this._expression_)
            + toString(this._faire_)
            + toString(this._blocInstructions_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tantque_ == child)
        {
            this._tantque_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._faire_ == child)
        {
            this._faire_ = null;
            return;
        }

        if(this._blocInstructions_ == child)
        {
            this._blocInstructions_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tantque_ == oldChild)
        {
            setTantque((TTantque) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._faire_ == oldChild)
        {
            setFaire((TFaire) newChild);
            return;
        }

        if(this._blocInstructions_ == oldChild)
        {
            setBlocInstructions((PBlocInstructions) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}