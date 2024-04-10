/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.parser;

import saParser.node.*;
import saParser.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTPo(@SuppressWarnings("unused") TPo node)
    {
        this.index = 0;
    }

    @Override
    public void caseTPf(@SuppressWarnings("unused") TPf node)
    {
        this.index = 1;
    }

    @Override
    public void caseTSaappel(@SuppressWarnings("unused") TSaappel node)
    {
        this.index = 2;
    }

    @Override
    public void caseTSadecfonc(@SuppressWarnings("unused") TSadecfonc node)
    {
        this.index = 3;
    }

    @Override
    public void caseTSadectab(@SuppressWarnings("unused") TSadectab node)
    {
        this.index = 4;
    }

    @Override
    public void caseTSadecvar(@SuppressWarnings("unused") TSadecvar node)
    {
        this.index = 5;
    }

    @Override
    public void caseTSadecvarsimple(@SuppressWarnings("unused") TSadecvarsimple node)
    {
        this.index = 6;
    }

    @Override
    public void caseTSaexpadd(@SuppressWarnings("unused") TSaexpadd node)
    {
        this.index = 7;
    }

    @Override
    public void caseTSaexpand(@SuppressWarnings("unused") TSaexpand node)
    {
        this.index = 8;
    }

    @Override
    public void caseTSaexpappel(@SuppressWarnings("unused") TSaexpappel node)
    {
        this.index = 9;
    }

    @Override
    public void caseTSaexpdiv(@SuppressWarnings("unused") TSaexpdiv node)
    {
        this.index = 10;
    }

    @Override
    public void caseTSaexpequal(@SuppressWarnings("unused") TSaexpequal node)
    {
        this.index = 11;
    }

    @Override
    public void caseTSaexpfaux(@SuppressWarnings("unused") TSaexpfaux node)
    {
        this.index = 12;
    }

    @Override
    public void caseTSaexpinf(@SuppressWarnings("unused") TSaexpinf node)
    {
        this.index = 13;
    }

    @Override
    public void caseTSaexpint(@SuppressWarnings("unused") TSaexpint node)
    {
        this.index = 14;
    }

    @Override
    public void caseTSaexplire(@SuppressWarnings("unused") TSaexplire node)
    {
        this.index = 15;
    }

    @Override
    public void caseTSaexpmult(@SuppressWarnings("unused") TSaexpmult node)
    {
        this.index = 16;
    }

    @Override
    public void caseTSaexpnot(@SuppressWarnings("unused") TSaexpnot node)
    {
        this.index = 17;
    }

    @Override
    public void caseTSaexpor(@SuppressWarnings("unused") TSaexpor node)
    {
        this.index = 18;
    }

    @Override
    public void caseTSaexpsub(@SuppressWarnings("unused") TSaexpsub node)
    {
        this.index = 19;
    }

    @Override
    public void caseTSaexpvar(@SuppressWarnings("unused") TSaexpvar node)
    {
        this.index = 20;
    }

    @Override
    public void caseTSaexpvrai(@SuppressWarnings("unused") TSaexpvrai node)
    {
        this.index = 21;
    }

    @Override
    public void caseTSainstaffect(@SuppressWarnings("unused") TSainstaffect node)
    {
        this.index = 22;
    }

    @Override
    public void caseTSainstbloc(@SuppressWarnings("unused") TSainstbloc node)
    {
        this.index = 23;
    }

    @Override
    public void caseTSainstecriture(@SuppressWarnings("unused") TSainstecriture node)
    {
        this.index = 24;
    }

    @Override
    public void caseTSainstretour(@SuppressWarnings("unused") TSainstretour node)
    {
        this.index = 25;
    }

    @Override
    public void caseTSainstsi(@SuppressWarnings("unused") TSainstsi node)
    {
        this.index = 26;
    }

    @Override
    public void caseTSainsttantque(@SuppressWarnings("unused") TSainsttantque node)
    {
        this.index = 27;
    }

    @Override
    public void caseTSaldecfonc(@SuppressWarnings("unused") TSaldecfonc node)
    {
        this.index = 28;
    }

    @Override
    public void caseTSaldecvar(@SuppressWarnings("unused") TSaldecvar node)
    {
        this.index = 29;
    }

    @Override
    public void caseTSalexp(@SuppressWarnings("unused") TSalexp node)
    {
        this.index = 30;
    }

    @Override
    public void caseTSalinst(@SuppressWarnings("unused") TSalinst node)
    {
        this.index = 31;
    }

    @Override
    public void caseTSaprog(@SuppressWarnings("unused") TSaprog node)
    {
        this.index = 32;
    }

    @Override
    public void caseTSavarindicee(@SuppressWarnings("unused") TSavarindicee node)
    {
        this.index = 33;
    }

    @Override
    public void caseTSavarsimple(@SuppressWarnings("unused") TSavarsimple node)
    {
        this.index = 34;
    }

    @Override
    public void caseTFaux(@SuppressWarnings("unused") TFaux node)
    {
        this.index = 35;
    }

    @Override
    public void caseTVrai(@SuppressWarnings("unused") TVrai node)
    {
        this.index = 36;
    }

    @Override
    public void caseTLire(@SuppressWarnings("unused") TLire node)
    {
        this.index = 37;
    }

    @Override
    public void caseTNull(@SuppressWarnings("unused") TNull node)
    {
        this.index = 38;
    }

    @Override
    public void caseTEntier(@SuppressWarnings("unused") TEntier node)
    {
        this.index = 39;
    }

    @Override
    public void caseTBool(@SuppressWarnings("unused") TBool node)
    {
        this.index = 40;
    }

    @Override
    public void caseTNul(@SuppressWarnings("unused") TNul node)
    {
        this.index = 41;
    }

    @Override
    public void caseTInteger(@SuppressWarnings("unused") TInteger node)
    {
        this.index = 42;
    }

    @Override
    public void caseTId(@SuppressWarnings("unused") TId node)
    {
        this.index = 43;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 44;
    }
}
