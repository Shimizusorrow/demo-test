package com.unfrost.common.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultVO {
    private String message;
    private String code;
    private static ResultVO resultVO = null;

    public static ResultVO error() {
        if (resultVO == null) {
            resultVO = new ResultVO("登录超时,请重新登录!", "412");
        }
        return resultVO;
    }

    public ResultVO(String message, String code) {
        this.message = message;
        this.code = code;
    }
}