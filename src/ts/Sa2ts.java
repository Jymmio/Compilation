

package ts;
import sa.*;
import util.Type;
import util.Error;

public class Sa2ts extends SaDepthFirstVisitor<Void> {
    enum Context {
        LOCAL,
        GLOBAL,
        PARAM
    }

    private Ts tableGlobale;
    private Ts tableLocaleCourante;
    private Context context;

    public Ts getTableGlobale(){return this.tableGlobale;}

    public Sa2ts()
    {
        tableGlobale = new Ts();
        tableLocaleCourante = null;
        context = Context.GLOBAL;
    }

    public void defaultIn(SaNode node)
    {
        // System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node)
    {
        // System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

    public Void visit(SaDecVar node) throws ErrorException {
        String s = node.getNom();
        Type type = node.getType();
        TsItemVar variable;
        switch(context) {
            case GLOBAL :
                if (tableGlobale.getVar(s) != null) {
                    throw new ErrorException(Error.TS, Error.TS.message());
                }
               variable = tableGlobale.addVar(s, type);
                node.setTsItem(variable);
                break;
            case PARAM :
                if (tableLocaleCourante.getVar(s) != null
                        || tableGlobale.getVar(s) != null)
                    throw new ErrorException(Error.TS, Error.TS.message());
               variable = tableLocaleCourante.addParam(s, type);
                node.setTsItem(variable);
                break;
            case LOCAL :
                // if (tableGlobale.getVar(s) != null)
                // System.out.println("Il existe une variable globale portant ce nom");
                if (tableLocaleCourante.getVar(s) != null)
                    throw new ErrorException(Error.TS, Error.TS.message());
               variable = tableLocaleCourante.addVar(s, type);
                node.setTsItem(variable);
                break;
        }
        return null;
    }

    public Void visit(SaDecTab node) throws ErrorException {
        String s = node.getNom();
        Type type = node.getType();
        int taille = node.getTaille();
        switch(context) {
            case GLOBAL : 
                if (tableGlobale.getVar(s) != null)
                    throw new ErrorException(Error.TS, Error.TS.message());
                node.tsItem = tableGlobale.addTab(s, type, taille);
                break;
            case PARAM, LOCAL : throw new ErrorException(Error.TYPE, Error.TYPE.message());
        }
        return null;
    }

    public Void visit(SaDecFonc node) throws Exception {
        this.context = Context.GLOBAL;
        String s = node.getNom();
        Type retType = node.getTypeRetour();
        int argumentsAmount = node.getParametres() == null ? 0 : node.getParametres().length();
        switch (context) {
            case GLOBAL :
                if (tableGlobale.getFct(s) != null)
                    throw new ErrorException(Error.TS, Error.TS.message());
                this.tableLocaleCourante = new Ts();
                node.tsItem = tableGlobale.addFct(s, retType, argumentsAmount, tableLocaleCourante, node);
                break;
            case PARAM, LOCAL : throw new ErrorException(Error.TYPE, Error.TYPE.message());
        }

        if(node.getParametres() != null) {
            this.context = Context.PARAM;
            node.getParametres().accept(this);
        }
        if(node.getVariable() != null) {
            this.context = Context.LOCAL;
            node.getVariable().accept(this);
        }
        if(node.getCorps() != null){
            this.context = Context.LOCAL;
            node.getCorps().accept(this);
        }
        this.context = Context.GLOBAL;
        return null;
    }

    public Void visit(SaVarSimple node) throws ErrorException {
        String s = node.getNom();
        switch (context) {
            case GLOBAL, PARAM :
                    throw new ErrorException(Error.TYPE, Error.TYPE.message());
            case LOCAL :
                if (tableLocaleCourante.getVar(s) != null)
                    node.tsItem = (TsItemVarSimple) tableLocaleCourante.getVar(s);
                else if (tableGlobale.getVar(s) != null)
                    node.tsItem = (TsItemVarSimple) tableGlobale.getVar(s);
                else
                    throw new ErrorException(Error.TS, Error.TS.message());
                break;
        }
        return null;
    }

    public Void visit(SaVarIndicee node) throws Exception {
        String s = node.getNom();
        switch (context) {
            case GLOBAL, PARAM :
                    throw new ErrorException(Error.TYPE, Error.TYPE.message());
            case LOCAL :
                if (tableLocaleCourante.getVar(s) != null)
                    node.tsItem = tableLocaleCourante.getVar(s);
                else if (tableGlobale.getVar(s) != null)
                    node.tsItem = tableGlobale.getVar(s);
                else
                    throw new ErrorException(Error.TS, Error.TS.message());
                break;
        }
        node.getIndice().accept(this);
        return null;
    }

    public Void visit(SaAppel node) throws Exception {
        String s = node.getNom();
        int argumentsAmount = node.getArguments() == null ? 0 : node.getArguments().length();
        switch (context) {
            case GLOBAL, PARAM :
                    throw new ErrorException(Error.TYPE, Error.TYPE.message());
            case LOCAL :
                if (tableGlobale.getFct(s) == null)
                    throw new ErrorException(Error.TS, Error.TS.message());
                if (tableGlobale.getFct(s).getNbArgs() != argumentsAmount)
                    throw new ErrorException(Error.TS, Error.TS.message());

                node.tsItem = tableGlobale.getFct(s);
                break;
        }
        if(node.getArguments() != null)
            node.getArguments().accept(this);
        return null;
    }
}