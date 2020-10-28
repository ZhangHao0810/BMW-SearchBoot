package com.zhanghao.searchboot.model;

import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class Information{


  /****/

  private Long id;


  /**新闻来源**/

  private String infoSrc;


  /**新闻内容**/

  private String infoText;


  /**新闻图片链接**/

  private String infoImage;


  /**新闻跳转url**/

  private String infoUrl;


  /**标题md5值，校验防止相同新闻误插入**/

  private String singleTag;


  /**发布时间**/

  private String time;


  /**创建时间**/

  private Date createTime;


  /**最后更新时间**/

  private Date updateTime;


  /**是否可用：0否 1是**/

  private Integer isEnabled;


  /**是否删除：0否 1是**/

  private Integer isDeleted;




  public void setId(Long id) { 
  }


  public Long getId() { 
  }


  public void setInfoSrc(String infoSrc) { 
  }


  public String getInfoSrc() { 
  }


  public void setInfoText(String infoText) { 
  }


  public String getInfoText() { 
  }


  public void setInfoImage(String infoImage) { 
  }


  public String getInfoImage() { 
  }


  public void setInfoUrl(String infoUrl) { 
  }


  public String getInfoUrl() { 
  }


  public void setSingleTag(String singleTag) { 
  }


  public String getSingleTag() { 
  }


  public void setTime(String time) { 
  }


  public String getTime() { 
  }


  public void setCreateTime(Date createTime) { 
  }


  public Date getCreateTime() { 
  }


  public void setUpdateTime(Date updateTime) { 
  }


  public Date getUpdateTime() { 
  }


  public void setIsEnabled(Integer isEnabled) { 
  }


  public Integer getIsEnabled() { 
  }


  public void setIsDeleted(Integer isDeleted) { 
  }


  public Integer getIsDeleted() { 
  }

}