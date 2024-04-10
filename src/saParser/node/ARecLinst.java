/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class ARecLinst extends PLinst
{
    private TPo _po_;
    private TSalinst _salinst_;
    private PInst _inst_;
    private PLinst _linst_;
    private TPf _pf_;

    public ARecLinst()
    {
        // Constructor
    }

    public ARecLinst(
        @SuppressWarnings("hiding") TPo _po_,
        @SuppressWarnings("hiding") TSalinst _salinst_,
        @SuppressWarnings("hiding") PInst _inst_,
        @SuppressWarnings("hiding") PLinst _linst_,
        @SuppressWarnings("hiding") TPf _pf_)
    {
        // Constructor
        setPo(_po_);

        setSalinst(_salinst_);

        setInst(_inst_);

        setLinst(_linst_);

        setPf(_pf_);

    }

    @Override
    public Object clone()
    {
        return new ARecLinst(
            cloneNode(this._po_),
            cloneNode(this._salinst_),
            cloneNode(this._inst_),
            cloneNode(this._linst_),
            cloneNode(this._pf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARecLinst(this);
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

    public TSalinst getSalinst()
    {
        return this._salinst_;
    }

    public void setSalinst(TSalinst node)
    {
        if(this._salinst_ != null)
        {
            this._salinst_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._salinst_ = node;
    }

    public PInst getInst()
    {
        return this._inst_;
    }

    public void setInst(PInst node)
    {
        if(this._inst_ != null)
        {
            this._inst_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._inst_ = node;
    }

    public PLinst getLinst()
    {
        return this._linst_;
    }

    public void setLinst(PLinst node)
    {
        if(this._linst_ != null)
        {
            this._linst_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._linst_ = node;
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
            + toString(this._salinst_)
            + toString(this._inst_)
            + toString(this._linst_)
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

        if(this._salinst_ == child)
        {
            this._salinst_ = null;
            return;
        }

        if(this._inst_ == child)
        {
            this._inst_ = null;
            return;
        }

        if(this._linst_ == child)
        {
            this._linst_ = null;
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

        if(this._salinst_ == oldChild)
        {
            setSalinst((TSalinst) newChild);
            return;
        }

        if(this._inst_ == oldChild)
        {
            setInst((PInst) newChild);
            return;
        }

        if(this._linst_ == oldChild)
        {
            setLinst((PLinst) newChild);
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