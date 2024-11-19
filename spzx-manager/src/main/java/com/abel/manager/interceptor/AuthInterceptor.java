package com.abel.manager.interceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.abel.manager.service.SysUserService;
import com.abel.model.common.Result;
import com.abel.model.common.ResultCodeEnum;
import com.abel.model.utils.ContextUtil;
import com.abel.model.vo.system.UserInfoVo;
import com.alibaba.fastjson2.JSON;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final SysUserService sysUserService;
    private final RedisTemplate<String, String> redisTemplate;

    public AuthInterceptor(SysUserService sysUserService, RedisTemplate<String, String> redisTemplate) {
        this.sysUserService = sysUserService;
        this.redisTemplate = redisTemplate;
    }

    @SuppressWarnings("null")
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        ContextUtil.removeUser();
    }

    private void writeErrorResponse(HttpServletResponse response, ResultCodeEnum resultCode) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(JSON.toJSONString(Result.build(null, resultCode)));
    }

    @SuppressWarnings("null")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // preflight request
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        // 获取请求头中的token
        String authorization = request.getHeader("Authorization");
        if (!StringUtils.hasText(authorization)) {
            writeErrorResponse(response, ResultCodeEnum.NOT_LOGIN);
            return false;
        }
        String token = authorization.substring(7);

        // 获取用户信息并放入上下文
        UserInfoVo userInfo = sysUserService.getUserInfo(token);
        ContextUtil.setUser(userInfo);

        // 刷新token时长
        redisTemplate.expire("login:token:" + token, 30, TimeUnit.MINUTES);

        // 放行
        return true;
    }

}
