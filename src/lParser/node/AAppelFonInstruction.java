/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AAppelFonInstruction extends PInstruction
{
    private TIdentifiant _identifiant_;
    private TLPar _lPar_;
    private PListeExpressions _listeExpressions_;
    private TRPar _rPar_;
    private TPVirgule _pVirgule_;

    public AAppelFonInstruction()
    {
        // Constructor
    }

    public AAppelFonInstruction(
        @SuppressWarnings("hiding") TIdentifiant _identifiant_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PListeExpressions _listeExpressions_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") TPVirgule _pVirgule_)
    {
        // Constructor
        setIdentifiant(_identifiant_);

        setLPar(_lPar_);

        setListeExpressions(_listeExpressions_);

        setRPar(_rPar_);

        setPVirgule(_pVirgule_);

    }

    @Override
    public Object clone()
    {
        return new AAppelFonInstruction(
            cloneNode(this._identifiant_),
            cloneNode(this._lPar_),
            cloneNode(this._listeExpressions_),
            cloneNode(this._rPar_),
            cloneNode(this._pVirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAppelFonInstruction(this);
    }

    public TIdentifiant getIdentifiant()
    {
        return this._identifiant_;
    }

    public void setIdentifiant(TIdentifiant node)
    {
        if(this._identifiant_ != null)
        {
            this._identifiant_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifiant_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public PListeExpressions getListeExpressions()
    {
        return this._listeExpressions_;
    }

    public void setListeExpressions(PListeExpressions node)
    {
        if(this._listeExpressions_ != null)
        {
            this._listeExpressions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeExpressions_ = node;
    }

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
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
            + toString(this._identifiant_)
            + toString(this._lPar_)
            + toString(this._listeExpressions_)
            + toString(this._rPar_)
            + toString(this._pVirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifiant_ == child)
        {
            this._identifiant_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._listeExpressions_ == child)
        {
            this._listeExpressions_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
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
        if(this._identifiant_ == oldChild)
        {
            setIdentifiant((TIdentifiant) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._listeExpressions_ == oldChild)
        {
            setListeExpressions((PListeExpressions) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
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
