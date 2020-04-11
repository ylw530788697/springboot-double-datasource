package com.evan.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author evanYang
 * @version 1.0
 * @date 04/11/2020 10:03
 */
@Data
@ApiModel
public class UserSaveReq implements Serializable {
    @NotEmpty(message = "用户名字不能为空")
    @ApiModelProperty(value = "姓名")
    private String user;

    @ApiModelProperty(value = "手机号码")
    @NotBlank(message = "手机号不能为空")
    private String phone;
}
