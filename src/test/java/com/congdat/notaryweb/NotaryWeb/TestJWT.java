package com.congdat.notaryweb.NotaryWeb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

public class TestJWT {
		@Test
		public void gen_jwt() {
				// Joda
				// username - or id
				// roles = []

				Claims claims = Jwts.claims();
				claims.put("roles", "blah, blah");
				claims.put("username", "hahaha");		String xx = Jwts.builder()
												.setClaims(claims)
												.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512, "WWWW").compact();

				System.out.println(xx);
		}

}
