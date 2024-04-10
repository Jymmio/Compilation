/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.analysis;

import lParser.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgrammeProgramme(AProgrammeProgramme node);
    void caseAOuExpression(AOuExpression node);
    void caseAP2Expression(AP2Expression node);
    void caseAEtExpression2(AEtExpression2 node);
    void caseAP3Expression2(AP3Expression2 node);
    void caseAEquExpression3(AEquExpression3 node);
    void caseAInfExpression3(AInfExpression3 node);
    void caseAP4Expression3(AP4Expression3 node);
    void caseAPlusExpression4(APlusExpression4 node);
    void caseAMoinsExpression4(AMoinsExpression4 node);
    void caseAP5Expression4(AP5Expression4 node);
    void caseAMultExpression5(AMultExpression5 node);
    void caseADivExpression5(ADivExpression5 node);
    void caseAP6Expression5(AP6Expression5 node);
    void caseANonExpression6(ANonExpression6 node);
    void caseAP7Expression6(AP7Expression6 node);
    void caseAParenteseExpression7(AParenteseExpression7 node);
    void caseANombreExpression7(ANombreExpression7 node);
    void caseAVraiExpression7(AVraiExpression7 node);
    void caseAFauxExpression7(AFauxExpression7 node);
    void caseAVarExpression7(AVarExpression7 node);
    void caseAAfExpression7(AAfExpression7 node);
    void caseALireExpression7(ALireExpression7 node);
    void caseAListeExListeExpressions(AListeExListeExpressions node);
    void caseAVideListeExpressions(AVideListeExpressions node);
    void caseAVirguleListeExpressionsNext(AVirguleListeExpressionsNext node);
    void caseAVideListeExpressionsNext(AVideListeExpressionsNext node);
    void caseAAffectInstruction(AAffectInstruction node);
    void caseATantqueInstruction(ATantqueInstruction node);
    void caseASiInstruction(ASiInstruction node);
    void caseASinonInstruction(ASinonInstruction node);
    void caseAAppelFonInstruction(AAppelFonInstruction node);
    void caseAEcrireInstruction(AEcrireInstruction node);
    void caseAResultFoncInstruction(AResultFoncInstruction node);
    void caseABlocIntBlocInstructions(ABlocIntBlocInstructions node);
    void caseAListeIntListeInstructions(AListeIntListeInstructions node);
    void caseAVideListeInstructions(AVideListeInstructions node);
    void caseASimpleVar(ASimpleVar node);
    void caseATableauVar(ATableauVar node);
    void caseADecSimpleDeclarVar(ADecSimpleDeclarVar node);
    void caseADecTableauDeclarVar(ADecTableauDeclarVar node);
    void caseABoolType(ABoolType node);
    void caseAEntierType(AEntierType node);
    void caseADeclarationFunctionDeclarationFunction(ADeclarationFunctionDeclarationFunction node);
    void caseATypeTypeOption(ATypeTypeOption node);
    void caseAVideTypeOption(AVideTypeOption node);
    void caseAVariableListDeclarationVariable(AVariableListDeclarationVariable node);
    void caseAVideListDeclarationVariable(AVideListDeclarationVariable node);
    void caseAVirguleVarListDeclarationVariableNext(AVirguleVarListDeclarationVariableNext node);
    void caseAVideListDeclarationVariableNext(AVideListDeclarationVariableNext node);
    void caseAListDeclarationFunctionListDeclarationFunction(AListDeclarationFunctionListDeclarationFunction node);
    void caseAVideListDeclarationFunction(AVideListDeclarationFunction node);

    void caseTEspaces(TEspaces node);
    void caseTCommentaire(TCommentaire node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTLBrace(TLBrace node);
    void caseTRBrace(TRBrace node);
    void caseTLBracket(TLBracket node);
    void caseTRBracket(TRBracket node);
    void caseTPVirgule(TPVirgule node);
    void caseTVirgule(TVirgule node);
    void caseTPlus(TPlus node);
    void caseTMoins(TMoins node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTEqu(TEqu node);
    void caseTInf(TInf node);
    void caseTOu(TOu node);
    void caseTEt(TEt node);
    void caseTVrai(TVrai node);
    void caseTFaux(TFaux node);
    void caseTSi(TSi node);
    void caseTAlors(TAlors node);
    void caseTSinon(TSinon node);
    void caseTTantque(TTantque node);
    void caseTFaire(TFaire node);
    void caseTRetour(TRetour node);
    void caseTEcrire(TEcrire node);
    void caseTLire(TLire node);
    void caseTNon(TNon node);
    void caseTNombre(TNombre node);
    void caseTEntier(TEntier node);
    void caseTBool(TBool node);
    void caseTIdentifiant(TIdentifiant node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}