/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class ASubExp extends PExp
{
    private TPo _po_;
    private TSaexpsub _saexpsub_;
    private PExp _op1_;
    private PExp _op2_;
    private TPf _pf_;

    public ASubExp()
    {
        // Constructor
    }

    public ASubExp(
        @SuppressWarnings("hiding") TPo _po_,
        @SuppressWarnings("hiding") TSaexpsub _saexpsub_,
        @SuppressWarnings("hiding") PExp _op1_,
        @SuppressWarnings("hiding") PExp _op2_,
        @SuppressWarnings("hiding") TPf _pf_)
    {
        // Constructor
        setPo(_po_);

        setSaexpsub(_saexpsub_);

        setOp1(_op1_);

        setOp2(_op2_);

        setPf(_pf_);

    }

    @Override
    public Object clone()
    {
        return new ASubExp(
            cloneNode(this._po_),
            cloneNode(this._saexpsub_),
            cloneNode(this._op1_),
            cloneNode(this._op2_),
            cloneNode(this._pf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASubExp(this);
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

    public TSaexpsub getSaexpsub()
    {
        return this._saexpsub_;
    }

    public void setSaexpsub(TSaexpsub node)
    {
        if(this._saexpsub_ != null)
        {
            this._saexpsub_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._saexpsub_ = node;
    }

    public PExp getOp1()
    {
        return this._op1_;
    }

    public void setOp1(PExp node)
    {
        if(this._op1_ != null)
        {
            this._op1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._op1_ = node;
    }

    public PExp getOp2()
    {
        return this._op2_;
    }

    public void setOp2(PExp node)
    {
        if(this._op2_ != null)
        {
            this._op2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._op2_ = node;
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
            + toString(this._saexpsub_)
            + toString(this._op1_)
            + toString(this._op2_)
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

        if(this._saexpsub_ == child)
        {
            this._saexpsub_ = null;
            return;
        }

        if(this._op1_ == child)
        {
            this._op1_ = null;
            return;
        }

        if(this._op2_ == child)
        {
            this._op2_ = null;
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

        if(this._saexpsub_ == oldChild)
        {
            setSaexpsub((TSaexpsub) newChild);
            return;
        }

        if(this._op1_ == oldChild)
        {
            setOp1((PExp) newChild);
            return;
        }

        if(this._op2_ == oldChild)
        {
            setOp2((PExp) newChild);
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
