/* This file was generated by SableCC (http://www.sablecc.org/). */

package c3aParser.node;

import c3aParser.analysis.*;

@SuppressWarnings("nls")
public final class ASubInst extends PInst
{
    private PSub _sub_;

    public ASubInst()
    {
        // Constructor
    }

    public ASubInst(
        @SuppressWarnings("hiding") PSub _sub_)
    {
        // Constructor
        setSub(_sub_);

    }

    @Override
    public Object clone()
    {
        return new ASubInst(
            cloneNode(this._sub_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASubInst(this);
    }

    public PSub getSub()
    {
        return this._sub_;
    }

    public void setSub(PSub node)
    {
        if(this._sub_ != null)
        {
            this._sub_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sub_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sub_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sub_ == child)
        {
            this._sub_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sub_ == oldChild)
        {
            setSub((PSub) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}