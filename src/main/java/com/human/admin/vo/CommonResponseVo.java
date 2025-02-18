package com.human.admin.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 삭제, 혹은 업데이트 등의 변경시 사용하는 VO
 */

@Getter
@Setter
@Builder
public class CommonResponseVo {
    private String message;
    private int status;
}
