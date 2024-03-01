/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AIfStatementStatement extends PStatement
{
    private PIfStatement _ifStatement_;

    public AIfStatementStatement()
    {
        // Constructor
    }

    public AIfStatementStatement(
        @SuppressWarnings("hiding") PIfStatement _ifStatement_)
    {
        // Constructor
        setIfStatement(_ifStatement_);

    }

    @Override
    public Object clone()
    {
        return new AIfStatementStatement(
            cloneNode(this._ifStatement_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfStatementStatement(this);
    }

    public PIfStatement getIfStatement()
    {
        return this._ifStatement_;
    }

    public void setIfStatement(PIfStatement node)
    {
        if(this._ifStatement_ != null)
        {
            this._ifStatement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ifStatement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ifStatement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ifStatement_ == child)
        {
            this._ifStatement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ifStatement_ == oldChild)
        {
            setIfStatement((PIfStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}