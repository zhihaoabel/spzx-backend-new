package com.abel.manager.service.impl;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.abel.model.vo.system.CaptchaVo;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

@Service
@Slf4j
public class CaptchaService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String CAPTCHA_PREFIX = "login:captcha:";
    private static final long CAPTCHA_EXPIRE = 5; // 5分钟过期

    /**
     * 生成验证码
     */
    public CaptchaVo generateCaptcha() {
        // 生成验证码
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40);

        // 获取验证码文本和图片
        String code = captcha.getCode();
        String imageBase64 = captcha.getImageBase64();

        // 生成uuid作为key
        String uuid = IdUtil.simpleUUID();

        // 将验证码存入Redis
        redisTemplate.opsForValue().set(
                CAPTCHA_PREFIX + uuid,
                code,
                CAPTCHA_EXPIRE,
                TimeUnit.MINUTES
        );

        log.info("生成验证码, uuid: {}, code: {}", uuid, code);

        // 返回验证码信息（不包含验证码文本）
        return new CaptchaVo(uuid, imageBase64);
    }

    /**
     * 验证验证码
     */
    public boolean validateCaptcha(String uuid, String code) {
        if (StrUtil.hasBlank(uuid, code)) {
            return false;
        }

        // 从Redis获取验证码
        String key = CAPTCHA_PREFIX + uuid;
        String correctCode = redisTemplate.opsForValue().get(key);

        // 验证后立即删除验证码
        redisTemplate.delete(key);

        // 验证码已过期或不正确
        if (StrUtil.isEmpty(correctCode)) {
            return false;
        }

        // 验证码比对（忽略大小写）
        return StrUtil.equalsIgnoreCase(code, correctCode);
    }
}
