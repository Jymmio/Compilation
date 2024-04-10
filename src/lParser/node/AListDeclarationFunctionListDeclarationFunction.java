/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AListDeclarationFunctionListDeclarationFunction extends PListDeclarationFunction
{
    private PDeclarationFunction _declarationFunction_;
    private PListDeclarationFunction _listDeclarationFunction_;

    public AListDeclarationFunctionListDeclarationFunction()
    {
        // Constructor
    }

    public AListDeclarationFunctionListDeclarationFunction(
        @SuppressWarnings("hiding") PDeclarationFunction _declarationFunction_,
        @SuppressWarnings("hiding") PListDeclarationFunction _listDeclarationFunction_)
    {
        // Constructor
        setDeclarationFunction(_declarationFunction_);

        setListDeclarationFunction(_listDeclarationFunction_);

    }

    @Override
    public Object clone()
    {
        return new AListDeclarationFunctionListDeclarationFunction(
            cloneNode(this._declarationFunction_),
            cloneNode(this._listDeclarationFunction_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListDeclarationFunctionListDeclarationFunction(this);
    }

    public PDeclarationFunction getDeclarationFunction()
    {
        return this._declarationFunction_;
    }

    public void setDeclarationFunction(PDeclarationFunction node)
    {
        if(this._declarationFunction_ != null)
        {
            this._declarationFunction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._declarationFunction_ = node;
    }

    public PListDeclarationFunction getListDeclarationFunction()
    {
        return this._listDeclarationFunction_;
    }

    public void setListDeclarationFunction(PListDeclarationFunction node)
    {
        if(this._listDeclarationFunction_ != null)
        {
            this._listDeclarationFunction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listDeclarationFunction_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._declarationFunction_)
            + toString(this._listDeclarationFunction_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._declarationFunction_ == child)
        {
            this._declarationFunction_ = null;
            return;
        }

        if(this._listDeclarationFunction_ == child)
        {
            this._listDeclarationFunction_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._declarationFunction_ == oldChild)
        {
            setDeclarationFunction((PDeclarationFunction) newChild);
            return;
        }

        if(this._listDeclarationFunction_ == oldChild)
        {
            setListDeclarationFunction((PListDeclarationFunction) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
