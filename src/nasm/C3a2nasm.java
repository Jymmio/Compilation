

package nasm;

import c3a.*;
import ts.*;

import java.util.List;
import java.util.Objects;

import static nasm.Nasm.*;

public class C3a2nasm implements C3aVisitor <NasmOperand> {
    private C3a c3a;
    private Nasm nasm;
    private Ts tableGlobale;
    private TsItemFct currentFct;
    private NasmRegister esp;
    private NasmRegister ebp;


    public C3a2nasm(C3a c3a, Ts tableGlobale){
        this.c3a = c3a;
        nasm = new Nasm(tableGlobale);
        nasm.setTempCounter(c3a.getTempCounter());

        this.tableGlobale = tableGlobale;
        this.currentFct = null;
        esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);

        ebp = nasm.newRegister();
        ebp.colorRegister(REG_EBP);
    }

    public Nasm getNasm(){return nasm;}


    public NasmOperand visit(C3a c3a){
        List<C3aInst> instructionsList = c3a.listeInst;
        for (C3aInst c3aInst : instructionsList) {
            c3aInst.accept(this);
        }
        return null;
    }

    public NasmOperand visit(C3aInstAdd inst){
        NasmOperand label=(inst.label!=null)? inst.label.accept(this): null;
        NasmOperand op1=inst.op1.accept(this);
        NasmOperand op2=inst.op2.accept(this);
        NasmOperand dest= inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label,dest,op1,""));
        nasm.ajouteInst(new NasmAdd(null,dest,op2, ""));
        return null; }

    public NasmOperand visit(C3aInstCall inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);
        nasm.ajouteInst(new NasmSub(label, esp, new NasmConstant(4), "allocation mémoire pour la valeur de retour"));

        NasmOperand address = inst.op1.accept(this);
        nasm.ajouteInst(new NasmCall(null, address, ""));

        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmPop(null, result, "récupération de la valeur de retour"));

        TsItemFct fct = tableGlobale.getFct(address.toString());
        int nbArgs = fct.getNbArgs();
        if (!Objects.equals(fct.identif, "main") && nbArgs != 0) nasm.ajouteInst(new NasmAdd(null, esp, new NasmConstant(nbArgs * 4), "désallocation des arguments"));
        return null;
    }

    private int nbLocals(TsItemFct fct) {
        Ts tableLocale = tableGlobale.getTableLocale(fct.identif);
        return tableLocale.variables.size() - fct.getNbArgs();
    }

    public NasmOperand visit(C3aInstFBegin inst){
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(REG_EBP);
        nasm.ajouteInst(new NasmPush(new NasmLabel(inst.val.identif), ebp,  "sauvegarde la valeur de ebp"));

        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);
        nasm.ajouteInst(new NasmMov(null,ebp,esp,"nouvelle valeur de ebp"));

        push(REG_EAX, "sauvegarde de eax");
        push(Nasm.REG_EBX, "sauvegarde de ebx");
        push(Nasm.REG_ECX, "sauvegarde de ecx");
        push(Nasm.REG_EDX, "sauvegarde de edx");


        currentFct = tableGlobale.getFct(inst.val.identif);
        int nbLocals = nbLocals(currentFct);
        nasm.ajouteInst(new NasmSub(null, esp, new NasmConstant(4 * nbLocals), "allocation des variables locales"));

        return null;
    }
    public NasmOperand visit(C3aInst inst){
        inst.accept(this);
        return null;
    }

    public NasmOperand visit(C3aInstJumpIfLess inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        if (!(op1 instanceof NasmRegister) && !(op1 instanceof NasmAddress)) {
            NasmRegister temp = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, temp, op1, "JumpIfLess 1"));
            nasm.ajouteInst(new NasmCmp(null, temp, op2, "on passe par un registre temporaire"));
            nasm.ajouteInst(new NasmJl(null, new NasmLabel("l" + inst.result.toString()), "JumpIfLess 2"));
        } else {
            nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfLess 1"));
            nasm.ajouteInst(new NasmJl(null, new NasmLabel("l" + inst.result.toString()), "JumpIfLess 2"));
        }
        return null;    }

    public NasmOperand visit(C3aInstMult inst){
        NasmOperand label = (inst.label!=null)? inst.label.accept(this): null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, op1,""));
        nasm.ajouteInst(new NasmMul(null, dest, op2, ""));
        return null;
    }

    public NasmOperand visit(C3aInstRead inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(REG_EAX);
        nasm.ajouteInst(new NasmMov(label, eax, new NasmLabel("sinput"), ""));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("readline"), ""));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("atoi"), ""));
        nasm.ajouteInst(new NasmMov(null, nasm.newRegister(), eax, ""));
        return null;
    }

    public NasmOperand visit(C3aInstSub inst){
        NasmOperand label = (inst.label!=null)? inst.label.accept(this): null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, op1,""));
        nasm.ajouteInst(new NasmSub(null, dest, op2, ""));
        return null;
    }

    public NasmOperand visit(C3aInstAffect inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, result, op1, "Affect"));
        return null;
    }

    public NasmOperand visit(C3aInstDiv inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        NasmRegister edx = nasm.newRegister();
        edx.colorRegister(Nasm.REG_EDX);
        NasmConstant zero = new NasmConstant(0);
        nasm.ajouteInst(new NasmMov(label, edx, zero,"mise à 0 des bits de poids fort du dividende"));

        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(REG_EAX);
        NasmRegister temp = nasm.newRegister();
        nasm.ajouteInst(new NasmMov(null, eax, op1, "affectation des bits de poids faible du dividende"));
        nasm.ajouteInst(new NasmMov(null, temp, op2, ""));
        nasm.ajouteInst(new NasmDiv(null, temp, ""));

        edx = nasm.newRegister();
        edx.colorRegister(Nasm.REG_EDX);
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(null, edx, edx, "rend explicite l'utilisation de edx pour ne pas que sa valeur soit modifiée"));
        nasm.ajouteInst(new NasmMov(null, result, eax, ""));
        return null;
    }

    public NasmOperand visit(C3aInstFEnd inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);
        int nbLocals = nbLocals(currentFct);
        nasm.ajouteInst(new NasmAdd(label, esp, new NasmConstant(nbLocals * 4), "désallocation des variables locales"));
        pop(Nasm.REG_EDX, "restaure edx");
        pop(Nasm.REG_ECX, "restaure ecx");
        pop(Nasm.REG_EBX, "restaure ebx");
        pop(REG_EAX, "restaure eax");
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(REG_EBP);
        nasm.ajouteInst(new NasmPop(null, ebp, "restaure la valeur de ebp"));
        nasm.ajouteInst(new NasmRet(null, ""));
        return null;
    }

    public NasmOperand visit(C3aInstJumpIfEqual inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        if (!(op1 instanceof NasmRegister) && !(op1 instanceof NasmAddress)) {
            NasmRegister temp = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, temp, op1, "JumpIfEqual 1"));
            nasm.ajouteInst(new NasmCmp(null, temp, op2, "on passe par un registre temporaire"));
            nasm.ajouteInst(new NasmJe(null, new NasmLabel("l" + inst.result.toString()), "JumpIfEqual 2"));
        } else {
            nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfEqual 1"));
            nasm.ajouteInst(new NasmJe(null, new NasmLabel("l" + inst.result.toString()), "JumpIfEqual 2"));
        }
        return null;
    }
    public NasmOperand visit(C3aInstJumpIfNotEqual inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        if (!(op1 instanceof NasmRegister) && !(op1 instanceof NasmAddress)) {
            NasmRegister temp = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, temp, op1, "jumpIfNotEqual 1"));
            nasm.ajouteInst(new NasmCmp(null, temp, op2, "on passe par un registre temporaire"));
            nasm.ajouteInst(new NasmJne(null, new NasmLabel("l" + inst.result.toString()), "jumpIfNotEqual 2"));
        } else {
            nasm.ajouteInst(new NasmCmp(label, op1, op2, "jumpIfNotEqual 1"));
            nasm.ajouteInst(new NasmJne(null, new NasmLabel("l" + inst.result.toString()), "jumpIfNotEqual 2"));
        }
        return null;
    }
    public NasmOperand visit(C3aInstJump inst){
        nasm.ajouteInst(new NasmJmp(null, new NasmLabel("l" + inst.result.toString()), "Jump"));
        return null;
    }
    public NasmOperand visit(C3aInstParam inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        nasm.ajouteInst(new NasmPush(label, op1, "Param"));
        return null;
    }

    public NasmOperand visit(C3aInstReturn inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(REG_EBP);
        if (tableGlobale.getVar(op1.toString()) != null || currentFct.getTable().getVar(op1.toString()) !=null) {
            NasmRegister temp = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, temp, op1, "ecriture de la valeur de retour"));
            NasmExpPlus plus = new NasmExpPlus(ebp, new NasmConstant(8));
            NasmAddress retAddress = new NasmAddress(plus, NasmSize.DWORD);
            nasm.ajouteInst(new NasmMov(null, retAddress, temp, "on passe par un registre temporaire"));
        } else {
            NasmExpPlus plus = new NasmExpPlus(ebp, new NasmConstant(8));
            NasmAddress retAddress = new NasmAddress(plus, NasmSize.DWORD);
            nasm.ajouteInst(new NasmMov(null, retAddress, op1, "ecriture de la valeur de retour"));
        }
        return null;
    }
    public NasmOperand visit(C3aInstWrite inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(REG_EAX);
        NasmOperand op1 = inst.op1.accept(this);
        nasm.ajouteInst(new NasmMov(label, eax, op1, "Write 1"));

        NasmOperand address = new NasmLabel("iprintLF");
        nasm.ajouteInst(new NasmCall(null, address, "Write 2"));
        return null;
    }

    public NasmOperand visit(C3aInstStop inst){
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(REG_EAX);
        NasmRegister ebx = nasm.newRegister();
        ebx.colorRegister(Nasm.REG_EBX);
        nasm.ajouteInst(new NasmMov(label, ebx, new NasmConstant(0), " valeur de retour du programme"));
        nasm.ajouteInst(new NasmMov(null, eax, new NasmConstant(1), " code de sortie"));
        nasm.ajouteInst(new NasmInt(null, ""));
        return null;
    }

    public NasmOperand visit(C3aConstant oper){
        return new NasmConstant(oper.val);
    }

    public NasmOperand visit(C3aBooleanConstant oper){
        return new NasmConstant(oper.val ? 1 : 0);
    }

    public NasmOperand visit(C3aLabel oper){
        return new NasmLabel("l" + oper.toString());
    }

    public NasmOperand visit(C3aTemp oper){
        return new NasmRegister(oper.num);
    }

    public NasmOperand visit(C3aVar oper){
        TsItemVar loc = currentFct.table.getVar(oper.item.identif);
        TsItemVar glob = tableGlobale.getVar(oper.item.identif);

        NasmAddress address;
        if (loc != null) {
            if (!loc.isParam) {
                NasmRegister ebp = nasm.newRegister();
                ebp.colorRegister(REG_EBP);
                NasmConstant offset = new NasmConstant(4 + loc.getAdresse());
                NasmExpMinus minus = new NasmExpMinus(ebp, offset);
                address = new NasmAddress(minus, NasmSize.DWORD);
            } else {
                NasmRegister ebp = nasm.newRegister();
                ebp.colorRegister(REG_EBP);
                NasmConstant offset = new NasmConstant(8 + 4 * currentFct.getNbArgs() - loc.getAdresse());
                NasmExpPlus plus = new NasmExpPlus(ebp, offset);
                address = new NasmAddress(plus, NasmSize.DWORD);
            }
        }
        else {
            if (oper.index != null) {
                NasmRegister temp = nasm.newRegister();
                NasmOperand index = oper.index.accept(this);
                NasmRegister ebp = nasm.newRegister();
                ebp.colorRegister(REG_EBP);
                nasm.ajouteInst(new NasmMov(null, temp, index, ""));
                nasm.ajouteInst(new NasmMul(null, temp, new NasmConstant(4), ""));
                NasmExpPlus plus = new NasmExpPlus(new NasmLabel(glob.identif), temp);
                address = new NasmAddress(plus, NasmSize.DWORD);
            } else {
                address = new NasmAddress(new NasmLabel(glob.identif), NasmSize.DWORD);
            }
        }
        return address;
    }
    public NasmOperand visit(C3aFunction oper){
        return new NasmLabel(oper.val.identif);
    }

    private void push(int regNum, String sentence) {
        NasmRegister register = nasm.newRegister();
        register.colorRegister(regNum);
        nasm.ajouteInst(new NasmPush(null,register, sentence));
    }
    private void pop(int regNum, String comment) {
        NasmRegister reg = nasm.newRegister();
        reg.colorRegister(regNum);
        nasm.ajouteInst(new NasmPop(null, reg,  comment));
    }
}