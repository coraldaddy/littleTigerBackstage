package lxw.addressbook.addressbook.common;

import com.google.common.collect.ImmutableMap;


public enum StatusCode  {

    SERVER_EXCEPTION(10001,"服务器异常，请稍后再试"),

    ACQUIRE_SUCCESS(10002,"获取成功"),//小程序获取openId成功
    USER_NOT_REGISTERED(10003,"用户未注册"),
    USER_IS_REGISTERED(10004,"用户已注册"),
    ADD_SUCCESS(10005,"添加成功"),
    ADD_FALL(10006,"添加失败"),
    SELECT_SUCCESS(10007,"查询成功"),
    SELECT_FALL(10008,"查询失败"),
    UPDATE_SUCCESS(10009,"修改成功"),
    UPDATE_FALL(10010,"修改失败")
    ;
    private final int code;

    private final String message;

    private static final ImmutableMap<Integer, StatusCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, StatusCode> builder = ImmutableMap.builder();
        for (StatusCode statusCode : values()) {
            builder.put(statusCode.code(), statusCode);
        }
        CACHE = builder.build();
    }

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static StatusCode valueOfCode(int code) {
        final StatusCode status = CACHE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}