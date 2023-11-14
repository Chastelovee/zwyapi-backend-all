package com.zwy.zwyapi.model.vo;

import com.zwy.zwyapicommon.entity.InterfaceInfo;
import lombok.Data;

/**
 * 接口信息封装视图
 */
@Data
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

}
