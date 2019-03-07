package com.scott.entity;

/**
 * @CLASSNAME :JsonResult
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/7 0007  16:00
 * @Version :V1.0
 * @Status : 编写
 **/
public class JsonResult {
    private String status = null;
    private Object result = null;

//    get   set

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
