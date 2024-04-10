/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class ANullType extends PType
{
    private TNul _nul_;

    public ANullType()
    {
        // Constructor
    }

    public ANullType(
        @SuppressWarnings("hiding") TNul _nul_)
    {
        // Constructor
        setNul(_nul_);

    }

    @Override
    public Object clone()
    {
        return new ANullType(
            cloneNode(this._nul_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANullType(this);
    }

    public TNul getNul()
    {
        return this._nul_;
    }

    public void setNul(TNul node)
    {
        if(this._nul_ != null)
        {
            this._nul_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nul_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._nul_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._nul_ == child)
        {
            this._nul_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._nul_ == oldChild)
        {
            setNul((TNul) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}