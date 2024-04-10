/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AListeIntListeInstructions extends PListeInstructions
{
    private PInstruction _instruction_;
    private PListeInstructions _listeInstructions_;

    public AListeIntListeInstructions()
    {
        // Constructor
    }

    public AListeIntListeInstructions(
        @SuppressWarnings("hiding") PInstruction _instruction_,
        @SuppressWarnings("hiding") PListeInstructions _listeInstructions_)
    {
        // Constructor
        setInstruction(_instruction_);

        setListeInstructions(_listeInstructions_);

    }

    @Override
    public Object clone()
    {
        return new AListeIntListeInstructions(
            cloneNode(this._instruction_),
            cloneNode(this._listeInstructions_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListeIntListeInstructions(this);
    }

    public PInstruction getInstruction()
    {
        return this._instruction_;
    }

    public void setInstruction(PInstruction node)
    {
        if(this._instruction_ != null)
        {
            this._instruction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instruction_ = node;
    }

    public PListeInstructions getListeInstructions()
    {
        return this._listeInstructions_;
    }

    public void setListeInstructions(PListeInstructions node)
    {
        if(this._listeInstructions_ != null)
        {
            this._listeInstructions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeInstructions_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._instruction_)
            + toString(this._listeInstructions_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._instruction_ == child)
        {
            this._instruction_ = null;
            return;
        }

        if(this._listeInstructions_ == child)
        {
            this._listeInstructions_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._instruction_ == oldChild)
        {
            setInstruction((PInstruction) newChild);
            return;
        }

        if(this._listeInstructions_ == oldChild)
        {
            setListeInstructions((PListeInstructions) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}