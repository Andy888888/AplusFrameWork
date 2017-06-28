package com.centa.aplusframework.model.litepaldo;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by yanwenqiang on 2017/6/28.
 * <p>
 * 描述:房源列表浏览纪录
 */
public class PropertySearchHistoryDo extends DataSupport {
    private String propertyName;

    // unique:唯一的
    @Column(unique = true, defaultValue = "unknown")
    private String propertyKeyId;

    // nullable:是否可为空
    @Column(nullable = false)
    private Date browseTime;

    // ignore:忽略，保存时将不会存储，且不会创建该列
    @Column(ignore = true)
    private String doorNumber;

    // TODO: 2017/6/28 以下为LitePal的新特性介绍, more: https://github.com/LitePalFramework/LitePal
//  ============等同于下面的sql语句============
//    CREATE TABLE propertySearchHistoryDo (
//            id integer primary key autoincrement,
//            propertyKeyId text unique default 'unknown',
//            propertyName text,
//            browseTime text
//    );

//  ============支持异步保存============
//    private void savePropertyBrowseHistory() {
//        PropertySearchHistoryDo history = new PropertySearchHistoryDo();
//        history.setPropertyKeyId("www");
//        history.setPropertyName("丽都大都会");
//        history.setDoorNumber("0808");
//        history.setBrowseTime(new Date());
//        history.saveAsync().listen(new SaveCallback() {
//            @Override
//            public void onFinish(boolean success) {
//
//            }
//        });
//    }

//  ============多个数据库============
//    If your app needs multiple databases, LitePal support it completely. You can create as many
//    databases as you want at runtime. For example:

//    LitePalDB litePalDB = new LitePalDB("demo2", 1);
//    litePalDB.addClassName(Singer.class.getName());
//    litePalDB.addClassName(Album.class.getName());
//    litePalDB.addClassName(Song.class.getName());
//    LitePal.use(litePalDB);

//  ============历史更新的主要内容============
//    1.5.1 --> 所有的crud（增删改查）支持异步／修复bug
//    1.4.1 --> 修复bug
//    1.4.0 --> 支持多个database
//    1.3.2 --> 优化提高 find，add 速度
//    1.3.1 --> 支持二进制数据，提高查询速度
//    1.3.1 --> 添加注解，修复bug

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyKeyId() {
        return propertyKeyId;
    }

    public void setPropertyKeyId(String propertyKeyId) {
        this.propertyKeyId = propertyKeyId;
    }

    public Date getBrowseTime() {
        return browseTime;
    }

    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }
}
