package com.example.demo.entity.PO;


import com.example.demo.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author zhangjingqi
 * @data 2023/05/04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPO {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private GenderEnum gender;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 地区
     */
    private String region;

    /**
     * 简介
     */
    private String intro;

    /**
     * 用户生日
     */
    private LocalDate birthday;

    /**
     * 用户头像url
     */
    private String avatar;

    /**
     * 该行数据创建时间
     */
    private Long createdAt;

    /**
     * 该行数据修改时间
     */
    private Long updatedAt;

    public String getGender() {
        return Optional.ofNullable(this.gender).map(GenderEnum::getValue).orElse(null);
    }

    public void setGender(String gender) {
        this.gender = GenderEnum.getTypeByValue(gender);
    }
}
