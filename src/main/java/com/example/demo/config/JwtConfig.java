package com.example.demo.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.PO.UserPO;
import com.example.demo.utils.JwtConfigConstant;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Component
@Data
@Log4j
public class JwtConfig {

	/**
	 * 密钥
	 */
	private String secret;
	/**
	 * 过期时间,单位秒
	 */
	private long expire;

	public JwtConfig(){
		this.secret = JwtConfigConstant.SECRET;
		this.expire = JwtConfigConstant.EXPIRE;
	}


	/**
	 * 签发jwt
	 *
	 * @param userPo 当前登录用户
	 * @return jwt
	 */
	public String createJwt(UserPO userPo) {
		LocalDateTime nowDateTime = LocalDateTime.now(ZoneId.systemDefault());
		Date expireDate = new Date(nowDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() + expire * 1000);
		String jwt = JWT.create()
			.withClaim("userId", userPo.getId())

			.withExpiresAt(expireDate)
			.withIssuedAt(new Date())
			.sign(Algorithm.HMAC256(secret));
		return jwt;
	}

	/**
	 * 解析jwt
	 *
	 * @param token jwt
	 * @return payload
	 */
	public Map<String, Claim> parseJwt(String token) {
		try {
			// 解析token
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
			DecodedJWT jwt = verifier.verify(token);
			// 判断该token是否有效
			Map<String, Claim> claims = jwt.getClaims();
			String userId = claims.get("userId").asString();
			return claims;
		} catch (TokenExpiredException e) {
			LocalDateTime expireTime = LocalDateTime.ofInstant(e.getExpiredOn(), ZoneId.systemDefault());
			log.info("[JwtConfig.parseJwt] jwt expired time 过期，过期时间:" + expireTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA)) +
				" exception msg: " + e.getLocalizedMessage());
 			return null;
 		} catch (JWTVerificationException | IllegalArgumentException e) {
			// 解析错误 或者 token有误

			log.error("[JwtConfig.parseJwt] jwt 解析错误, msg: " + e.getLocalizedMessage());
			return null;
		}
	}

}
