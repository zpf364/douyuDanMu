package com.pufang.DyDanMu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/

@Entity
public class DanMu {

//{nn=新街口玄彬, col=2, bnn=集团军, level=19, cst=1539395285927, brid=74960, fl=7, el=, bl=7, type=chatmsg, rid=74960, ct=2, uid=13956313, txt=别刷直播时长了，不显示的, ifs=1, sahf=0, ic=avanew@Sface@S201612@S20@S01@S8cef869c2fe9f6fbc467dff255f438d9, hc=c7fe250e7fc4bc29c4165df08d0dae94, cid=3b49cbd78ea3489ff93f170000000000, lk=}

    @Id
    @GeneratedValue
    private long id;
    /**
     *  昵称
     */
    private String nn;
    /**
     * 牌子
     */
    private String bnn;
    /**
     * 等级
     */
    private short level;
    /**
     * 消息时间
     */
    private Date cst;
    /**
     * 消息类型
     */
    private String type;
    /**
     * 房间id
     */
    private int rid;
    /**
     * 用户id
     */
    private long uid;
    /**
     * 发言内容
     */
    private String txt;
    /**
     * 消息唯一id
     */
    private String cid;
    private short fl;
    private short ifs;
    //private short el;
    private short ct;
    /**
     * 牌子等级
     */
    private short bl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }

    public String getBnn() {
        return bnn;
    }

    public void setBnn(String bnn) {
        this.bnn = bnn;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public Date getCst() {
        return cst;
    }

    public void setCst(Date cst) {
        this.cst = cst;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public short getFl() {
        return fl;
    }

    public void setFl(short fl) {
        this.fl = fl;
    }

    public short getIfs() {
        return ifs;
    }

    public void setIfs(short ifs) {
        this.ifs = ifs;
    }

    //public short getEl() {
    //    return el;
    //}
    //
    //public void setEl(short el) {
    //    this.el = el;
    //}

    public short getCt() {
        return ct;
    }

    public void setCt(short ct) {
        this.ct = ct;
    }

    public short getBl() {
        return bl;
    }

    public void setBl(short bl) {
        this.bl = bl;
    }
}
