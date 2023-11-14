package com.zwy.zwyapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwy.zwyapi.common.ErrorCode;
import com.zwy.zwyapi.exception.BusinessException;
import com.zwy.zwyapi.exception.ThrowUtils;
import com.zwy.zwyapi.mapper.InterfaceInfoMapper;
import com.zwy.zwyapi.service.InterfaceInfoService;
import com.zwy.zwyapicommon.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author 10922
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-10-29 09:48:10
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        String method = interfaceInfo.getMethod();

        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name, url, method), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 256) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
        if (StringUtils.isNotBlank(description) && description.length() > 256) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "描述过长");
        }
        if (StringUtils.isNotBlank(url) && url.length() > 512) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口地址过长");
        }
        if (StringUtils.isNotBlank(requestHeader) && requestHeader.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求头过长");
        }
        if (StringUtils.isNotBlank(responseHeader) && responseHeader.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "响应头过长");
        }
        if (StringUtils.isNotBlank(method) && method.length() > 256) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求类型过长");
        }
    }
}




