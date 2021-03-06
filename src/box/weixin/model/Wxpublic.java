package box.weixin.model;

import java.util.Date;

public class Wxpublic {
	String sogouUrl;
	
	public String getSogouUrl() {
		return sogouUrl;
	}

	public void setSogouUrl(String sogouUrl) {
		this.sogouUrl = sogouUrl;
	}

	public String toString(){
		return this.getWxname()+",微信:"+this.getWxhao();
	}
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.id
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.wxname
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private String wxname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.wxhao
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private String wxhao;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.openid
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.wpdesc
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private String wpdesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.viewcount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Integer viewcount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.zancount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Integer zancount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.topcount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Integer topcount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.imgurl
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private String imgurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.type
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.status
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.crdate
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Date crdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxpublic.udate
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    private Date udate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.id
     *
     * @return the value of wxpublic.id
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.id
     *
     * @param id the value for wxpublic.id
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.wxname
     *
     * @return the value of wxpublic.wxname
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public String getWxname() {
        return wxname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.wxname
     *
     * @param wxname the value for wxpublic.wxname
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setWxname(String wxname) {
        this.wxname = wxname == null ? null : wxname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.wxhao
     *
     * @return the value of wxpublic.wxhao
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public String getWxhao() {
        return wxhao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.wxhao
     *
     * @param wxhao the value for wxpublic.wxhao
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setWxhao(String wxhao) {
        this.wxhao = wxhao == null ? null : wxhao.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.openid
     *
     * @return the value of wxpublic.openid
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.openid
     *
     * @param openid the value for wxpublic.openid
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.wpdesc
     *
     * @return the value of wxpublic.wpdesc
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public String getWpdesc() {
        return wpdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.wpdesc
     *
     * @param wpdesc the value for wxpublic.wpdesc
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setWpdesc(String wpdesc) {
        this.wpdesc = wpdesc == null ? null : wpdesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.viewcount
     *
     * @return the value of wxpublic.viewcount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Integer getViewcount() {
        return viewcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.viewcount
     *
     * @param viewcount the value for wxpublic.viewcount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.zancount
     *
     * @return the value of wxpublic.zancount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Integer getZancount() {
        return zancount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.zancount
     *
     * @param zancount the value for wxpublic.zancount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setZancount(Integer zancount) {
        this.zancount = zancount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.topcount
     *
     * @return the value of wxpublic.topcount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Integer getTopcount() {
        return topcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.topcount
     *
     * @param topcount the value for wxpublic.topcount
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setTopcount(Integer topcount) {
        this.topcount = topcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.imgurl
     *
     * @return the value of wxpublic.imgurl
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.imgurl
     *
     * @param imgurl the value for wxpublic.imgurl
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.type
     *
     * @return the value of wxpublic.type
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.type
     *
     * @param type the value for wxpublic.type
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.status
     *
     * @return the value of wxpublic.status
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.status
     *
     * @param status the value for wxpublic.status
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.crdate
     *
     * @return the value of wxpublic.crdate
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Date getCrdate() {
        return crdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.crdate
     *
     * @param crdate the value for wxpublic.crdate
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setCrdate(Date crdate) {
        this.crdate = crdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxpublic.udate
     *
     * @return the value of wxpublic.udate
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public Date getUdate() {
        return udate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxpublic.udate
     *
     * @param udate the value for wxpublic.udate
     *
     * @mbggenerated Sat Mar 28 12:07:11 CST 2015
     */
    public void setUdate(Date udate) {
        this.udate = udate;
    }
}