/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class ASi2Inst extends PInst
{
    private TPo _po_;
    private TSainstsi _sainstsi_;
    private PExp _exp_;
    private PInst _alors_;
    private TNull _null_;
    private TPf _pf_;

    public ASi2Inst()
    {
        // Constructor
    }

    public ASi2Inst(
        @SuppressWarnings("hiding") TPo _po_,
        @SuppressWarnings("hiding") TSainstsi _sainstsi_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") PInst _alors_,
        @SuppressWarnings("hiding") TNull _null_,
        @SuppressWarnings("hiding") TPf _pf_)
    {
        // Constructor
        setPo(_po_);

        setSainstsi(_sainstsi_);

        setExp(_exp_);

        setAlors(_alors_);

        setNull(_null_);

        setPf(_pf_);

    }

    @Override
    public Object clone()
    {
        return new ASi2Inst(
            cloneNode(this._po_),
            cloneNode(this._sainstsi_),
            cloneNode(this._exp_),
            cloneNode(this._alors_),
            cloneNode(this._null_),
            cloneNode(this._pf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASi2Inst(this);
    }

    public TPo getPo()
    {
        return this._po_;
    }

    public void setPo(TPo node)
    {
        if(this._po_ != null)
        {
            this._po_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._po_ = node;
    }

    public TSainstsi getSainstsi()
    {
        return this._sainstsi_;
    }

    public void setSainstsi(TSainstsi node)
    {
        if(this._sainstsi_ != null)
        {
            this._sainstsi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sainstsi_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public PInst getAlors()
    {
        return this._alors_;
    }

    public void setAlors(PInst node)
    {
        if(this._alors_ != null)
        {
            this._alors_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._alors_ = node;
    }

    public TNull getNull()
    {
        return this._null_;
    }

    public void setNull(TNull node)
    {
        if(this._null_ != null)
        {
            this._null_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._null_ = node;
    }

    public TPf getPf()
    {
        return this._pf_;
    }

    public void setPf(TPf node)
    {
        if(this._pf_ != null)
        {
            this._pf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._po_)
            + toString(this._sainstsi_)
            + toString(this._exp_)
            + toString(this._alors_)
            + toString(this._null_)
            + toString(this._pf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._po_ == child)
        {
            this._po_ = null;
            return;
        }

        if(this._sainstsi_ == child)
        {
            this._sainstsi_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._alors_ == child)
        {
            this._alors_ = null;
            return;
        }

        if(this._null_ == child)
        {
            this._null_ = null;
            return;
        }

        if(this._pf_ == child)
        {
            this._pf_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._po_ == oldChild)
        {
            setPo((TPo) newChild);
            return;
        }

        if(this._sainstsi_ == oldChild)
        {
            setSainstsi((TSainstsi) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._alors_ == oldChild)
        {
            setAlors((PInst) newChild);
            return;
        }

        if(this._null_ == oldChild)
        {
            setNull((TNull) newChild);
            return;
        }

        if(this._pf_ == oldChild)
        {
            setPf((TPf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}