package com.foggbrandon.tictactoe_quizapp;
import com.google.gson.annotations.Expose;
public class BoardState{
    @Expose
    private String tl;
    @Expose
    private String t;
    @Expose
    private String tr;
    @Expose
    private String l;
    @Expose
    private String m;
    @Expose
    private String r;
    @Expose
    private String bl;
    @Expose
    private String b;
    @Expose
    private String br;
    @Expose
    private String p;
    BoardState(String name, String player){
        tl = "" + name.charAt(0);
        t = "" + name.charAt(1);
        tr = "" + name.charAt(2);
        l = "" + name.charAt(3);
        m = "" + name.charAt(4);
        r = "" + name.charAt(5);
        bl = "" + name.charAt(6);
        b = "" + name.charAt(7);
        br = "" + name.charAt(8);
        p = player;
        if(tl.equals("."))
            tl = "";
        if(t.equals("."))
            t = "";
        if(tr.equals("."))
            tr = "";
        if(l.equals("."))
            l = "";
        if(m.equals("."))
            m = "";
        if(r.equals("."))
            r = "";
        if(bl.equals("."))
            bl = "";
        if(b.equals("."))
            b = "";
        if(br.equals("."))
            br = "";
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
}
