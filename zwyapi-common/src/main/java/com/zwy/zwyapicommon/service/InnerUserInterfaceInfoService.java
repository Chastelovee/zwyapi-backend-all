package com.zwy.zwyapicommon.service;

import com.zwy.zwyapicommon.entity.UserInterfaceInfo;


/**
* 针对表 user_interface_info 的数据库操作 Service
*/
public interface InnerUserInterfaceInfoService{
    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
