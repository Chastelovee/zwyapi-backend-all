package com.zwy.zwyapi.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwy.zwyapi.common.ErrorCode;
import com.zwy.zwyapi.exception.BusinessException;
import com.zwy.zwyapi.exception.ThrowUtils;
import com.zwy.zwyapi.mapper.UserInterfaceInfoMapper;
import com.zwy.zwyapi.service.UserInterfaceInfoService;
import com.zwy.zwyapicommon.entity.UserInterfaceInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
* @author 10922
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-11-03 09:00:08
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();

        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(ObjectUtils.anyNull(id, userId, interfaceInfoId, totalNum, leftNum), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (ObjectUtil.isNotNull(id) && id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "id不存在");
        }
        if (ObjectUtil.isNotNull(userId) && userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        if (ObjectUtil.isNotNull(interfaceInfoId) && interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口不存在");
        }
        if (ObjectUtil.isNotNull(totalNum) && totalNum < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "总调用次数不能小于0");
        }
        if (ObjectUtil.isNotNull(leftNum) && leftNum < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId <= 0 || userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // todo 可以想办法做的更安全，比如分布式锁、事务
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.gt("leftNum", 0);
        updateWrapper.setSql("totalNum = totalNum + 1, leftNum = leftNum - 1");
        return this.update(updateWrapper);
    }
}




