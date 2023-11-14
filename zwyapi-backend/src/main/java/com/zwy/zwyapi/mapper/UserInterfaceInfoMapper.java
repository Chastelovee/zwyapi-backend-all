package com.zwy.zwyapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwy.zwyapicommon.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author 10922
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-11-03 09:00:08
* @Entity com.zwy.zwyapi.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




