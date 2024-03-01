/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class ASimpleExpression extends PSimpleExpression
{
    private PTerm _term_;
    private final LinkedList<PAddTerm> _addTerm_ = new LinkedList<PAddTerm>();

    public ASimpleExpression()
    {
        // Constructor
    }

    public ASimpleExpression(
        @SuppressWarnings("hiding") PTerm _term_,
        @SuppressWarnings("hiding") List<?> _addTerm_)
    {
        // Constructor
        setTerm(_term_);

        setAddTerm(_addTerm_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleExpression(
            cloneNode(this._term_),
            cloneList(this._addTerm_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleExpression(this);
    }

    public PTerm getTerm()
    {
        return this._term_;
    }

    public void setTerm(PTerm node)
    {
        if(this._term_ != null)
        {
            this._term_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._term_ = node;
    }

    public LinkedList<PAddTerm> getAddTerm()
    {
        return this._addTerm_;
    }

    public void setAddTerm(List<?> list)
    {
        for(PAddTerm e : this._addTerm_)
        {
            e.parent(null);
        }
        this._addTerm_.clear();

        for(Object obj_e : list)
        {
            PAddTerm e = (PAddTerm) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._addTerm_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._term_)
            + toString(this._addTerm_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._term_ == child)
        {
            this._term_ = null;
            return;
        }

        if(this._addTerm_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._term_ == oldChild)
        {
            setTerm((PTerm) newChild);
            return;
        }

        for(ListIterator<PAddTerm> i = this._addTerm_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PAddTerm) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
