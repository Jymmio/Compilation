/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ATableauType extends PType
{
    private PArray _array_;

    public ATableauType()
    {
        // Constructor
    }

    public ATableauType(
        @SuppressWarnings("hiding") PArray _array_)
    {
        // Constructor
        setArray(_array_);

    }

    @Override
    public Object clone()
    {
        return new ATableauType(
            cloneNode(this._array_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATableauType(this);
    }

    public PArray getArray()
    {
        return this._array_;
    }

    public void setArray(PArray node)
    {
        if(this._array_ != null)
        {
            this._array_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._array_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._array_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._array_ == child)
        {
            this._array_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._array_ == oldChild)
        {
            setArray((PArray) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
