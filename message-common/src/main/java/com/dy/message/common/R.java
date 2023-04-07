package com.dy.message.common;

import com.dy.message.enums.ResultMessageEnum;

/**
 * @author dingyu
 * @description 统一返回工具类
 */
public class R<T> {

    public static ResultVo success(){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(ResultMessageEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultMessageEnum.SUCCESS.getMsg());
        return resultVo;
    }

    public static ResultVo toError(){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(ResultMessageEnum.SYSTEM_ERROR.getCode());
        resultVo.setMsg(ResultMessageEnum.SYSTEM_ERROR.getMsg());
        return resultVo;
    }

    public static ResultVo toError(Integer code,String msg){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }

    public static ResultVo toError(ResultMessageEnum resultMessageEnum){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(resultMessageEnum.getCode());
        resultVo.setMsg(resultMessageEnum.getMsg());
        return resultVo;
    }

    public ResultVo success(T data){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("success");
        resultVo.setData(data);
        return resultVo;
    }


}
