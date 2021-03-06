package com.revature.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    // never let anyone know your secret
    private static final String secret ="super secret string noone else should ever have";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    // put in the paramets that you want to be in the body of your jwe,
    public static String generate(String username, String password){

        // builder design pattern
        String token = JWT.create()
                .withClaim("username", username) // add data to the payload
                .withClaim("password", password)
                .sign(algorithm); // this will generate a signture based off of those claims

        return  token;
    }

    public static DecodedJWT isValidJWT(String token){
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            return  jwt;
    }
	
}