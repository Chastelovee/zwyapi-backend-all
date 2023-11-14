package com.zwy.zwyapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwy.zwyapicommon.entity.InterfaceInfo;

/**
* @author 10922
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-10-29 09:48:10
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
