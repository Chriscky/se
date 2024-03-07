package com.example.demo.utils;

import com.example.demo.constant.HttpConstants;
import com.example.demo.constant.StatusCode;
import com.example.demo.exception.UserClientException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Log4j
@Component
public class JWTUtils {
    @Autowired
    private HttpServletRequest request;

    public void checkUserIdOfJWT(Integer userId){
        if (!Objects.equals(request.getAttribute(HttpConstants.USER_ID_OF_JWT), userId)) {
            log.warn("用户通过修改参数中的userId试图访问他人资源，用户id： "+userId);
            throw new UserClientException(StatusCode.MODIFIED_USERID.getKey(), StatusCode.MODIFIED_USERID.getValue());
        }
    }

    public Integer getUserId(){
        return (Integer)(request.getAttribute(HttpConstants.USER_ID_OF_JWT));
    }

}
