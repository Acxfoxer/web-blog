package com.lee.onstage.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt工具类
 * @author lei
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtils {
    /**
     * 加密密钥
     */
    private static String secret;
    /**
     * 过期时间
     */
    private  static Long expiration;

    /**
     * 生成token
     * @param userName 传入用户名
     * @return 返回结果
     */
    private static String generateToken(String userName){
        return Jwts.builder()
                //jwt 头部信息
                .signWith(SignatureAlgorithm.HS512, secret)
                .setIssuer("lei") //对应payload iss节点签发人
                .setSubject(userName)
                .setAudience("client")
                .setIssuedAt(new Date()) //生效时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }
    /**
     * 从token中获取用户名
     * @param token
     * @return
     */
    public static  String getUserNameFromToken(String token){
        return getTokenBody(token).getSubject();
    }

    /**
     *  是否已过期
     * @param token
     * @return
     */
    private static  boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 获取token的payload
     * @param token 生成的token
     * @return 返回claims
     */
    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    /**
     * 验证token
     */
    private static void verifyJWTToken(String token) throws Exception{

    }
}
