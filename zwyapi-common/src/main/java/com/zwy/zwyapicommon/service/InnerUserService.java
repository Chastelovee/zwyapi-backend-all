package com.zwy.zwyapicommon.service;

import com.zwy.zwyapicommon.entity.User;

/**
 * 针对表 user 的数据库操作 Service
 */
public interface InnerUserService{

    /**
     * 在数据库中查找是否已分配给用户密钥
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
