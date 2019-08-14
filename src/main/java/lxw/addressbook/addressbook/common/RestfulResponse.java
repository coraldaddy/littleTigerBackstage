package lxw.addressbook.addressbook.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class RestfulResponse<T> {
    private static final long serialVersionUID = -7443304902819898146L;

    private RestfulResponse(){}

    public static final int DEFAULT_OK = 20000;

    /**
     * [M] 平台状态码
     */
    @JsonProperty("code")
    @ApiModelProperty(value = "平台状态码", example = "20000", required = true)
    private int code = DEFAULT_OK;

    private HashMap res;

    private StatusCode statusCode;

    private String serialno;

    private T pageData;

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
        this.res = new HashMap();
        this.res.put("resultCode",statusCode.code());
        this.res.put("resultMsg",statusCode.message());
    }

    public static RestfulResponse getRestfulResponse(StatusCode statusCode){
        return getRestfulResponse(statusCode,null);
    }

    public static <T> RestfulResponse<T> getRestfulResponse(StatusCode statusCode,T pageData){
        RestfulResponse<T> restfulResponse = new RestfulResponse<>();
        restfulResponse.setStatusCode(statusCode);
        if(pageData != null){
            restfulResponse.setPageData(pageData);
        }
        String serialno = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                .getHeader("X-serialno");
        restfulResponse.setSerialno(serialno);
        return restfulResponse;
    }

    public static  RestfulResponse getRestfulListResponse(StatusCode statusCode,List pageData){
    	Map map = new HashMap();
    	map.put("dataList", pageData);
    	RestfulResponse restfulResponse = new RestfulResponse();
    	restfulResponse.setStatusCode(statusCode);
    	restfulResponse.setPageData(map);
        String serialno = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                .getHeader("X-serialno");
        restfulResponse.setSerialno(serialno);
        return restfulResponse;
    }
}
