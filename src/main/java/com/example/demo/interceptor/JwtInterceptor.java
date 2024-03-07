package com.example.demo.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.example.demo.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        System.out.println("----------------------------");
        System.out.println(request.getMethod() );
        if ("OPTIONS".equals(request.getMethod()) ){
            //
            response.getWriter().write("随便");
            return true;
        }
        // 检查是否需要拦截
        if (shouldIntercept(requestURI) == false) {
            // 直接返回 true，绕过拦截器
            return true;
        }
        String token = request.getHeader("Authorization");
        if (isNotBlank(token) && token.startsWith("Bearer ")) {
            token = token.substring(7);
            System.out.println("token:" + token.toString());
            Map<String, Claim> claims = jwtConfig.parseJwt(token);
            System.out.println("userId"+claims.get("userId").asString());
            if (claims != null) {
                // 解析出用户信息，并将其设置到请求对象中，以便后续的控制器方法可以使用它
                request.setAttribute("userId", claims.get("userId").asString());
                return true;
            }
        }
        // 没有找到 JWT 令牌，或者 JWT 令牌无效，拒绝访问
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }

    private boolean shouldIntercept(String requestURI) {
        // 在这里编写判断逻辑，决定是否拦截该请求
        // 返回 true 表示需要拦截，false 表示不拦截
        // 你可以根据请求的路径、请求方法、用户角色等条件来进行判断
        // 如果需要拦截，执行 JWT 令牌验证等逻辑，并将用户信息设置到请求对象中

//        return false; // 示例：默认不拦截
        return true;
    }

    private boolean isNotBlank(String str) {
        return str != null && !str.isEmpty() && !str.trim().isEmpty();
    }

}