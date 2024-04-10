/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class AFauxExp extends PExp
{
    private TFaux _faux_;

    public AFauxExp()
    {
        // Constructor
    }

    public AFauxExp(
        @SuppressWarnings("hiding") TFaux _faux_)
    {
        // Constructor
        setFaux(_faux_);

    }

    @Override
    public Object clone()
    {
        return new AFauxExp(
            cloneNode(this._faux_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFauxExp(this);
    }

    public TFaux getFaux()
    {
        return this._faux_;
    }

    public void setFaux(TFaux node)
    {
        if(this._faux_ != null)
        {
            this._faux_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._faux_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._faux_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._faux_ == child)
        {
            this._faux_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._faux_ == oldChild)
        {
            setFaux((TFaux) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
