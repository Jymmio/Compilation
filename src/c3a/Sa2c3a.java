package c3a;
import jdk.jshell.spi.ExecutionControlProvider;
import ts.*;
import sa.*;


public class Sa2c3a extends SaDepthFirstVisitor <C3aOperand> {
    private C3a c3a;
    int indentation;
    private Ts tableGlobale;
    public C3a getC3a(){return this.c3a;}

    public Sa2c3a(SaNode root, Ts tableGlobale){
        c3a = new C3a();
        this.tableGlobale = tableGlobale;
        C3aTemp result = c3a.newTemp();
        C3aFunction fct = new C3aFunction(tableGlobale.getFct("main"));
        c3a.ajouteInst(new C3aInstCall(fct, result, ""));
        c3a.ajouteInst(new C3aInstStop(result, ""));
        indentation = 0;
    }

    public void defaultIn(SaNode node)
    {
        for(int i = 0; i < indentation; i++){System.out.print(" ");}
        indentation++;
        System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node)
    {
        indentation--;
        for(int i = 0; i < indentation; i++){System.out.print(" ");}
        System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

    // EXP -> op2 EXP EXP
    public C3aOperand visit(SaExpAdd node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstAdd(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpInt node) {
        defaultIn(node);
        C3aConstant result = new C3aConstant(node.getVal());
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpVrai node) {
        defaultIn(node);
        C3aConstant result = new C3aConstant(1);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpFaux node) {
        defaultIn(node);
        C3aConstant result = new C3aConstant(0);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpVar node) throws Exception {
        defaultIn(node);
        C3aVar result = (C3aVar) node.getVar().accept(this);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaVarSimple node) {
        defaultIn(node);
        C3aVar result = new C3aVar(node.getTsItem(), null);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaVarIndicee node) throws Exception {
        defaultIn(node);
        C3aOperand position = node.getIndice().accept(this);
        C3aVar result = new C3aVar(node.getTsItem(), position);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpLire node) throws Exception {
        defaultIn(node);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstRead(result, ""));
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpSub node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstSub(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpMult node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstMult(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpDiv node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstDiv(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpAnd node) throws Exception
    {
        defaultIn(node);
        C3aLabel next = c3a.newAutoLabel();
        C3aLabel l0 = c3a.newAutoLabel();
        C3aOperand result = c3a.newTemp();

        C3aOperand op1 = node.getOp1().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, c3a.False, l0,""));
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op2, c3a.False, l0,""));
        c3a.ajouteInst(new C3aInstAffect(c3a.True, result, ""));

        c3a.ajouteInst(new C3aInstJump(next, ""));
        c3a.addLabelToNextInst(l0);
        c3a.ajouteInst(new C3aInstAffect(c3a.False, result, ""));
        c3a.addLabelToNextInst(next);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpOr node) throws Exception
    {
        defaultIn(node);
        C3aLabel next = c3a.newAutoLabel();
        C3aLabel l0 = c3a.newAutoLabel();
        C3aOperand result = c3a.newTemp();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1, c3a.False, l0,""));
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op2, c3a.False, l0,""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, result, ""));

        c3a.ajouteInst(new C3aInstJump(next,""));
        c3a.addLabelToNextInst(l0);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, result, ""));
        c3a.addLabelToNextInst(next);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpNot node) throws Exception {
        C3aOperand result = c3a.newTemp();
        C3aLabel next = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, result, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, c3a.False, next, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, result, ""));
        c3a.addLabelToNextInst(next);
        return result;
    }

    public C3aOperand visit(SaExpInf node) throws  Exception {
        defaultIn(node);
        C3aLabel next = c3a.newAutoLabel();
        C3aOperand result = c3a.newTemp();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, result,""));
        c3a.ajouteInst(new C3aInstJumpIfLess(op1, op2, next, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, result,""));
        c3a.addLabelToNextInst(next);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaExpEqual node) throws Exception {
        defaultIn(node);
        C3aOperand result = c3a.newTemp();
        C3aLabel next = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, result, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, op2, next, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, result, ""));
        c3a.addLabelToNextInst(next);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaInstAffect node) throws Exception {
        defaultIn(node);
        C3aVar result = (C3aVar) node.getLhs().accept(this);
        C3aOperand op1 = node.getRhs().accept(this);
        c3a.ajouteInst(new C3aInstAffect(op1, result, ""));
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaInstTantQue node) throws Exception {
        defaultIn(node);
        C3aLabel x = c3a.newAutoLabel();
        C3aLabel next = c3a.newAutoLabel();
        c3a.addLabelToNextInst(x);
        C3aOperand result = node.getTest().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(result, c3a.False, next,""));
        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(x, ""));
        c3a.addLabelToNextInst(next);
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaInstSi node) throws Exception {
        defaultIn(node);
        C3aLabel l0 = c3a.newAutoLabel();
        C3aLabel next = c3a.newAutoLabel();
        C3aOperand result = node.getTest().accept(this);
        if (node.getSinon() != null) {
            c3a.ajouteInst(new C3aInstJumpIfEqual(result, c3a.False, l0, ""));
            node.getAlors().accept(this);
            c3a.ajouteInst(new C3aInstJump(next, ""));
            c3a.addLabelToNextInst(l0);
            node.getSinon().accept(this);
            c3a.addLabelToNextInst(next);
        }
        else {
            c3a.ajouteInst(new C3aInstJumpIfEqual(result, c3a.False, next, ""));
            node.getAlors().accept(this);
            c3a.addLabelToNextInst(next);
        }
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaInstEcriture node) throws Exception {
        defaultIn(node);
        C3aOperand result = node.getArg().accept(this);
        c3a.ajouteInst(new C3aInstWrite(result, ""));
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaDecFonc node) throws Exception {
        defaultIn(node);
        c3a.ajouteInst(new C3aInstFBegin(node.tsItem, "entree fonction"));
        if(node.getParametres() != null) {
            node.getParametres().accept(this);
        }
        if(node.getVariable() != null) node.getVariable().accept(this);
        if(node.getCorps() != null) node.getCorps().accept(this);
        c3a.ajouteInst(new C3aInstFEnd(""));
        defaultOut(node);
        return null;
    }

    @Override
    public C3aOperand visit(SaExpAppel node) throws Exception {
        defaultIn(node);
        C3aOperand result = node.getVal().accept(this);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaAppel node) throws Exception {
        defaultIn(node);
        SaLExp arguments = node.getArguments();
        C3aOperand result = c3a.newTemp();
        while (arguments != null) {
            C3aOperand op1 = arguments.getTete().accept(this);
            c3a.ajouteInst(new C3aInstParam(op1, ""));
            arguments = arguments.getQueue();
        }
        C3aFunction op1 = new C3aFunction(tableGlobale.getFct(node.getNom()));
        c3a.ajouteInst(new C3aInstCall(op1, result, ""));
        defaultOut(node);
        return result;
    }

    public C3aOperand visit(SaInstRetour node) throws Exception {
        defaultIn(node);
        C3aOperand result = node.getVal().accept(this);
        c3a.ajouteInst(new C3aInstReturn(result, ""));
        c3a.ajouteInst(new C3aInstFEnd(""));
        defaultOut(node);
        return result;
    }
}