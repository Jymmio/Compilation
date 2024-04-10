package sa;
import lParser.analysis.*;
import lParser.node.*;
import saParser.node.AOrExp;
import util.Type;

public class Sc2sa extends DepthFirstAdapter
{
    private SaNode returnValue;
    private Type returnType;
    private SaProg saRoot = null;

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        //System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        //System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

    public SaProg getRoot()
    {
        return this.saRoot;
    }

    //liste_dec_var liste_dec_fonc
    @Override
    public void caseAProgrammeProgramme(AProgrammeProgramme node)
    {
        SaLDecVar listeDesVariables;
        SaLDecFonc listeDesFonctions;
        inAProgrammeProgramme(node);
        node.getListDeclarationVariable().apply(this);
        listeDesVariables = (SaLDecVar) this.returnValue;
        node.getListDeclarationFunction().apply(this);
        listeDesFonctions = (SaLDecFonc) this.returnValue;
        this.returnValue = new SaProg(listeDesVariables, listeDesFonctions);
        this.saRoot = (SaProg) this.returnValue;
        outAProgrammeProgramme(node);
    }

    //expr ou expr2
    @Override
    public void caseAOuExpression(AOuExpression node) {
        inAOuExpression(node);
        node.getExpression().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getExpression2().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpOr(op1, op2);
        outAOuExpression(node);

    }

    //expr2
    @Override
    public void caseAP2Expression(AP2Expression node)
    {
        inAP2Expression(node);
        node.getExpression2().apply(this);
        outAP2Expression(node);
    }

    //expr2 et exp3
    @Override
    public void caseAEtExpression2(AEtExpression2 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAEtExpression2(node);
        node.getExpression2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpression3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAnd(op1, op2);
        outAEtExpression2(node);

    }

    //expr3
    @Override
    public void caseAP3Expression2(AP3Expression2 node)
    {
        inAP3Expression2(node);
        node.getExpression3().apply(this);
        outAP3Expression2(node);
    }

    //Expression3 eg Expression4
    @Override
    public void caseAEquExpression3(AEquExpression3 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAEquExpression3(node);
        node.getExpression3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpression4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1, op2);
        outAEquExpression3(node);

    }

    //Expression3 inf Expression4 |
    public void caseAInfExpression3(AInfExpression3 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAInfExpression3(node);
        node.getExpression3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpression4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpInf(op1, op2);
        outAInfExpression3(node);

    }

    // Expression4;
    @Override
    public void caseAP4Expression3(AP4Expression3 node)
    {
        inAP4Expression3(node);
        node.getExpression4().apply(this);
        outAP4Expression3(node);
    }

    // Expression4 plus Expression5
    @Override
    public void caseAPlusExpression4(APlusExpression4 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAPlusExpression4(node);
        node.getExpression4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpression5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
        outAPlusExpression4(node);

    }

    //Expression4 Moins Expression5
    @Override
    public void caseAMoinsExpression4(AMoinsExpression4 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAMoinsExpression4(node);
        node.getExpression4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpression5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1, op2);
        outAMoinsExpression4(node);

    }

    //Expression5;
    @Override
    public void caseAP5Expression4(AP5Expression4 node) {
        inAP5Expression4(node);
        node.getExpression5().apply(this);
        outAP5Expression4(node);
    }

    //Expression5 mult Expression6
    @Override
    public void caseAMultExpression5(AMultExpression5 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAMultExpression5(node);
        node.getExpression5().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpression6().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1, op2);
        outAMultExpression5(node);

    }

    //Expression5 div Expression6
    @Override
    public void caseADivExpression5(ADivExpression5 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inADivExpression5(node);
        node.getExpression5().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpression6().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpDiv(op1, op2);
        outADivExpression5(node);

    }

    //Expression6
    @Override
    public void caseAP6Expression5(AP6Expression5 node) {
        inAP6Expression5(node);
        node.getExpression6().apply(this);
        outAP6Expression5(node);
    }

    // Non Expression6
    @Override
    public void caseANonExpression6(ANonExpression6 node) {
        SaExp op1 = null;
        inANonExpression6(node);
        node.getExpression6().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = new SaExpNot(op1);
        outANonExpression6(node);

    }

    //Expression7
    @Override
    public void caseAP7Expression6(AP7Expression6 node) {
        inAP7Expression6(node);
        node.getExpression7().apply(this);
        outAP7Expression6(node);
    }

    //par_ou Expression par_fer
    @Override
    public void caseAParenteseExpression7(AParenteseExpression7 node)
    {
        inAParenteseExpression7(node);
        node.getExpression().apply(this);
        outAParenteseExpression7(node);

    }

    //nombre
    @Override
    public void caseANombreExpression7(ANombreExpression7 node)
    {
        int entier = 0;
        inANombreExpression7(node);
        entier = Integer.parseInt(node.getNombre().getText());
        this.returnValue = new SaExpInt(entier);
        outANombreExpression7(node);
    }

    //vrai
    @Override
    public void caseAVraiExpression7(AVraiExpression7 node)
    {
        inAVraiExpression7(node);
        node.getVrai().apply(this);
        this.returnValue= new SaExpVrai();
        outAVraiExpression7(node);
    }

    //faux
    @Override
    public void caseAFauxExpression7(AFauxExpression7 node)
    {
        inAFauxExpression7(node);
        node.getFaux().apply(this);
        this.returnValue=new SaExpFaux();
        outAFauxExpression7(node);
    }

    //var
    @Override
    public void caseAVarExpression7(AVarExpression7 node)
    {
        SaVar op1 =null;
        inAVarExpression7(node);
        node.getVar().apply(this);
        op1 = (SaVar) this.returnValue;
        this.returnValue=new SaExpVar(op1);
        outAVarExpression7(node);
    }

    // id par_ou liste_exp par_fer
    @Override
    public void caseAAfExpression7(AAfExpression7 node)
    {
        String affect = null;
        SaLExp args= null;
        inAAfExpression7(node);
        affect=node.getIdentifiant().getText();
        node.getListeExpressions().apply(this);
        args= (SaLExp) this.returnValue;
        this.returnValue=new SaExpAppel(new SaAppel(affect,args));
        outAAfExpression7(node);
    }

    //lire
    @Override
    public void caseALireExpression7(ALireExpression7 node)
    {
        inALireExpression7(node);
        node.getLire().apply(this);
        this.returnValue= new SaExpLire();
        outALireExpression7(node);
    }

    //Expression liste_exp_Next
    @Override
    public void caseAListeExListeExpressions(AListeExListeExpressions node)
    {
        SaExp tete =null;
        SaLExp queue=null;
        inAListeExListeExpressions(node);
        node.getExpression().apply(this);
        tete=(SaExp) this.returnValue;
        node.getListeExpressionsNext().apply(this);
        queue= (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(tete,queue);
        outAListeExListeExpressions(node);
    }

    //;
    @Override
    public void caseAVideListeExpressions(AVideListeExpressions node)
    {
        inAVideListeExpressions(node);
        this.returnValue = null;
        outAVideListeExpressions(node);
    }

    //virgule Expression liste_exp_Next
    @Override
    public void caseAVirguleListeExpressionsNext(AVirguleListeExpressionsNext node)
    {
        SaLExp queue =null;
        SaExp tete= null;
        inAVirguleListeExpressionsNext(node);
        node.getExpression().apply(this);
        tete= (SaExp) this.returnValue;
        node.getListeExpressionsNext().apply(this);
        queue = (SaLExp) this.returnValue;
        this.returnValue= new SaLExp(tete,queue);
        outAVirguleListeExpressionsNext(node);
    }

    //;
    @Override
    public void caseAVideListeExpressionsNext(AVideListeExpressionsNext node)
    {
        inAVideListeExpressionsNext(node);
        this.returnValue=null;
        outAVideListeExpressionsNext(node);
    }

    //var eg Expression point_ver
    @Override
    public void caseAAffectInstruction(AAffectInstruction node)
    {
        SaVar op1 =null;
        SaExp exp= null;
        inAAffectInstruction(node);
        node.getVar().apply(this);
        op1= (SaVar) this.returnValue;
        node.getExpression().apply(this);
        exp= (SaExp) this.returnValue;
        this.returnValue= new SaInstAffect(op1,exp);
        outAAffectInstruction(node);
    }

    //tq Expression faire bloc_inst
    @Override
    public void caseATantqueInstruction(ATantqueInstruction node)
    {
        SaExp exp= null;
        SaInstBloc bloc = null;
        inATantqueInstruction(node);
        node.getExpression().apply(this);
        exp = (SaExp) this.returnValue;
        node.getBlocInstructions().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue= new SaInstTantQue(exp,bloc);
        outATantqueInstruction(node);
    }

    //si Expression alors bloc_inst
    @Override
    public void caseASiInstruction(ASiInstruction node)
    {
        SaExp exp= null;
        SaInstBloc bloc = null;
        inASiInstruction(node);
        node.getExpression().apply(this);
        exp= (SaExp) this.returnValue;
        node.getBlocInstructions().apply(this);
        bloc= (SaInstBloc) this.returnValue;
        this.returnValue=new SaInstSi(exp,bloc,null);
        outASiInstruction(node);
    }

    //si Expression alors [bloc_si]:bloc_inst sinon [bloc_sinon]:bloc_inst
    @Override
    public void caseASinonInstruction(ASinonInstruction node)
    {
        SaExp exp= null;
        SaInstBloc bloc = null;
        SaInstBloc bloc2 = null;

        inASinonInstruction(node);
        node.getExpression().apply(this);
        exp= (SaExp) this.returnValue;
        node.getBlocSi().apply(this);
        bloc= (SaInstBloc) this.returnValue;
        node.getBlocSinon().apply(this);
        bloc2= (SaInstBloc) this.returnValue;
        this.returnValue= new SaInstSi(exp,bloc,bloc2);
        outASinonInstruction(node);
    }

    //id par_ou liste_exp par_fer point_ver
    @Override
    public void caseAAppelFonInstruction(AAppelFonInstruction node)
    {
        String affect =null;
        SaLExp list =null;
        inAAppelFonInstruction(node);
        affect=node.getIdentifiant().getText();
        node.getListeExpressions().apply(this);
        list= (SaLExp) this.returnValue;
        this.returnValue =  new SaAppel(affect,list);
        outAAppelFonInstruction(node);
    }

    //ecrire par_ou Expression par_fer point_ver
    @Override
    public void caseAEcrireInstruction(AEcrireInstruction node)
    {
        SaExp exp = null ;
        inAEcrireInstruction(node);
        node.getExpression().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue= new SaInstEcriture(exp);
        outAEcrireInstruction(node);
    }

    //retour Expression point_ver
    @Override
    public void caseAResultFoncInstruction(AResultFoncInstruction node)
    {
        SaExp exp= null;
        inAResultFoncInstruction(node);
        node.getExpression().apply(this);
        exp=(SaExp)this.returnValue;
        this.returnValue=new SaInstRetour(exp);
        outAResultFoncInstruction(node);
    }

    //acolade_ou liste_inst acolade_fer
    @Override
    public void caseABlocIntBlocInstructions(ABlocIntBlocInstructions node)
    {
        SaLInst list=null;
        inABlocIntBlocInstructions(node);
        node.getListeInstructions().apply(this);
        list=(SaLInst) this.returnValue;
        this.returnValue=new SaInstBloc(list);
        outABlocIntBlocInstructions(node);
    }

    //Instruction liste_Instruction
    @Override
    public void caseAListeIntListeInstructions(AListeIntListeInstructions node)
    {
        SaInst instr=null;
        SaLInst liste=null;
        inAListeIntListeInstructions(node);
        node.getInstruction().apply(this);
        instr=(SaInst) this.returnValue;
        node.getListeInstructions().apply(this);
        liste= (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(instr,liste);
        outAListeIntListeInstructions(node);
    }

    //;

    @Override
    public void caseAVideListeInstructions(AVideListeInstructions node)
    {
        inAVideListeInstructions(node);
        this.returnValue=null;
        outAVideListeInstructions(node);
    }

    // id
    @Override
    public void caseASimpleVar(ASimpleVar node)
    {
        String id;
        inASimpleVar(node);
        id=node.getIdentifiant().getText();
        this.returnValue = new SaVarSimple(id);
        outASimpleVar(node);
    }

    //id crochet_ou Expression crochet_fer
    @Override
    public void caseATableauVar(ATableauVar node)
    {
        String id=null;
        SaExp exp=null;
        inATableauVar(node);
        node.getIdentifiant().apply(this);
        id=node.getIdentifiant().getText();
        node.getExpression().apply(this);
        exp=(SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id,exp);
        outATableauVar(node);
    }

    //type id
    @Override
    public void caseADecSimpleDeclarVar(ADecSimpleDeclarVar node)
    {
        Type type;
        String id;
        inADecSimpleDeclarVar(node);
        node.getType().apply(this);
        type=this.returnType;
        id=node.getIdentifiant().getText();
        this.returnValue= new SaDecVarSimple(id,type);
        outADecSimpleDeclarVar(node);
    }

    //type id crochet_ou nombre crochet_fer
    @Override
    public void caseADecTableauDeclarVar(ADecTableauDeclarVar node)
    {
        Type type=null;
        String id=null;
        int taille;
        inADecTableauDeclarVar(node);
        node.getType().apply(this);
        type = this.returnType;
        id = node.getIdentifiant().getText();
        node.getNombre().apply(this);
        taille = Integer.parseInt(node.getNombre().getText());
        this.returnValue = new SaDecTab(id, type, taille);
        outADecTableauDeclarVar(node);
    }

    //bool
    @Override
    public void caseABoolType(ABoolType node)
    {
        Type bool=Type.BOOL;
        inABoolType(node);
        this.returnType=bool;
        outABoolType(node);
    }

    //entier
    @Override
    public void caseAEntierType(AEntierType node)
    {
        Type ent=Type.ENTIER;
        inAEntierType(node);
        this.returnType=ent;
        outAEntierType(node);
    }

    //typeopt id par_ou [parametre]:liste_dec_var par_fer [variable_interne]:liste_dec_var bloc_inst
    @Override
    public void caseADeclarationFunctionDeclarationFunction(ADeclarationFunctionDeclarationFunction node)
    {   String id=null;
        Type type;
        SaLDecVar lParameters =null;
        SaLDecVar lVarInterne=null;
        SaInst lIns=null;
        inADeclarationFunctionDeclarationFunction(node);
        node.getTypeOption().apply(this);
        type = this.returnType;
        id = node.getIdentifiant().getText();
        node.getParametre().apply(this);
        lParameters = (SaLDecVar) this.returnValue;
        node.getVariableInterne().apply(this);
        lVarInterne = (SaLDecVar) this.returnValue;
        node.getBlocInstructions().apply(this);
        lIns = (SaInst) this.returnValue;
        this.returnValue = new SaDecFonc(id, type, lParameters, lVarInterne, lIns);
        outADeclarationFunctionDeclarationFunction(node);
    }

    //type
    @Override
    public void caseATypeTypeOption(ATypeTypeOption node)
    {
        inATypeTypeOption(node);
        node.getType().apply(this);
        outATypeTypeOption(node);
    }

    //;
    @Override
    public void caseAVideTypeOption(AVideTypeOption node)
    {
        inAVideTypeOption(node);
        this.returnType = Type.NUL;
        outAVideTypeOption(node);
    }

    //declar_var liste_dec_var_Next
    @Override
    public void caseAVariableListDeclarationVariable(AVariableListDeclarationVariable node)
    {
        SaDecVar var=null;
        SaLDecVar lvar=null;
        inAVariableListDeclarationVariable(node);
        node.getDeclarVar().apply(this);
        var = (SaDecVar) this.returnValue;
        node.getListDeclarationVariableNext().apply(this);
        lvar = (SaLDecVar) this.returnValue;
        this.returnValue = new SaLDecVar(var, lvar);
        outAVariableListDeclarationVariable(node);
    }

    //;
    @Override
    public void caseAVideListDeclarationVariable(AVideListDeclarationVariable node)
    {
        inAVideListDeclarationVariable(node);
        this.returnValue = null;
        outAVideListDeclarationVariable(node);
    }

    //virgule declar_Variable List_Declaration_Variable_Next
    @Override
    public void caseAVirguleVarListDeclarationVariableNext(AVirguleVarListDeclarationVariableNext node)
    {
        SaDecVar var=null;
        SaLDecVar lvar=null;
        inAVirguleVarListDeclarationVariableNext(node);
        node.getDeclarVar().apply(this);
        var = (SaDecVar) this.returnValue;
        node.getListDeclarationVariableNext().apply(this);
        lvar = (SaLDecVar) this.returnValue;
        this.returnValue = new SaLDecVar(var, lvar);
        outAVirguleVarListDeclarationVariableNext(node);
    }

    //;
    @Override
    public void caseAVideListDeclarationVariableNext(AVideListDeclarationVariableNext node)
    {
        inAVideListDeclarationVariableNext(node);
        this.returnValue = null;
        outAVideListDeclarationVariableNext(node);
    }

    //declar_fonction List_dec_fonc
    @Override
    public void caseAListDeclarationFunctionListDeclarationFunction(AListDeclarationFunctionListDeclarationFunction node)
    {
        SaDecFonc fonc=null;
        SaLDecFonc lfonc=null;
        inAListDeclarationFunctionListDeclarationFunction(node);
        node.getDeclarationFunction().apply(this);
        fonc = (SaDecFonc) this.returnValue;
        node.getListDeclarationFunction().apply(this);
        lfonc = (SaLDecFonc) this.returnValue;
        this.returnValue = new SaLDecFonc(fonc, lfonc);
        outAListDeclarationFunctionListDeclarationFunction(node);
    }

    //;
    @Override
    public void caseAVideListDeclarationFunction(AVideListDeclarationFunction node)
    {
        inAVideListDeclarationFunction(node);
        this.returnValue=null;
        outAVideListDeclarationFunction(node);
    }


}