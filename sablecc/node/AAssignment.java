/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AAssignment extends PAssignment
{
    private TIdentifier _identifier_;
    private TEqu _equ_;
    private PFirstNameOrInt _firstNameOrInt_;
    private PCalc _calc_;
    private PSecondNameOrInt _secondNameOrInt_;

    public AAssignment()
    {
        // Constructor
    }

    public AAssignment(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") TEqu _equ_,
        @SuppressWarnings("hiding") PFirstNameOrInt _firstNameOrInt_,
        @SuppressWarnings("hiding") PCalc _calc_,
        @SuppressWarnings("hiding") PSecondNameOrInt _secondNameOrInt_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setEqu(_equ_);

        setFirstNameOrInt(_firstNameOrInt_);

        setCalc(_calc_);

        setSecondNameOrInt(_secondNameOrInt_);

    }

    @Override
    public Object clone()
    {
        return new AAssignment(
            cloneNode(this._identifier_),
            cloneNode(this._equ_),
            cloneNode(this._firstNameOrInt_),
            cloneNode(this._calc_),
            cloneNode(this._secondNameOrInt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignment(this);
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
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

    public PFirstNameOrInt getFirstNameOrInt()
    {
        return this._firstNameOrInt_;
    }

    public void setFirstNameOrInt(PFirstNameOrInt node)
    {
        if(this._firstNameOrInt_ != null)
        {
            this._firstNameOrInt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._firstNameOrInt_ = node;
    }

    public PCalc getCalc()
    {
        return this._calc_;
    }

    public void setCalc(PCalc node)
    {
        if(this._calc_ != null)
        {
            this._calc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._calc_ = node;
    }

    public PSecondNameOrInt getSecondNameOrInt()
    {
        return this._secondNameOrInt_;
    }

    public void setSecondNameOrInt(PSecondNameOrInt node)
    {
        if(this._secondNameOrInt_ != null)
        {
            this._secondNameOrInt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._secondNameOrInt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._equ_)
            + toString(this._firstNameOrInt_)
            + toString(this._calc_)
            + toString(this._secondNameOrInt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._equ_ == child)
        {
            this._equ_ = null;
            return;
        }

        if(this._firstNameOrInt_ == child)
        {
            this._firstNameOrInt_ = null;
            return;
        }

        if(this._calc_ == child)
        {
            this._calc_ = null;
            return;
        }

        if(this._secondNameOrInt_ == child)
        {
            this._secondNameOrInt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._equ_ == oldChild)
        {
            setEqu((TEqu) newChild);
            return;
        }

        if(this._firstNameOrInt_ == oldChild)
        {
            setFirstNameOrInt((PFirstNameOrInt) newChild);
            return;
        }

        if(this._calc_ == oldChild)
        {
            setCalc((PCalc) newChild);
            return;
        }

        if(this._secondNameOrInt_ == oldChild)
        {
            setSecondNameOrInt((PSecondNameOrInt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}