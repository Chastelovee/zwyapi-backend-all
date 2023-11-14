package com.zwy.zwyapicommon.service;

import com.zwy.zwyapicommon.entity.InterfaceInfo;

/**
* 针对表 interface_info 的数据库操作 Service
*/
public interface InnerInterfaceInfoService{
    /**
     * 在数据库中查找接口是否存在
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);

}
