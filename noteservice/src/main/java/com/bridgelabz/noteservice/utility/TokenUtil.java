package com.bridgelabz.noteservice.utility;

import javax.xml.bind.DatatypeConverter;

import com.auth0.jwt.exceptions.JWTCreationException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtil 
{
	//@Autowired
	//private static TokenInfo tokenInfo; 
	
	public static final String TOKEN_SECRET = "s4T2zOIWHMM1sxq";
	
	public static String createToken(Long id)
	{
//			try 
//			{
//				// to set algorithm
//				Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//	
//				// payload
//				String token = JWT.create().withClaim("userId", id).sign(algorithm);
//				return token;
//			}
//			catch (JWTCreationException exception) 
//			{
//				exception.printStackTrace();
//			
//			}
//			return null;
		
		try {
			//tokenInfo.setUserid(id);
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
			JwtBuilder builder = Jwts.builder().setId(String.valueOf(id))
			//.setExpiration(new Date (System.currentTimeMillis()+( 180 * 1000)))
			.signWith(signatureAlgorithm, DatatypeConverter.parseString(TOKEN_SECRET));
			//System.out.println("token = "+builder.compact());
			//System.out.println("tome nano = "+(System.currentTimeMillis() + ( 180 * 1000)));
			//System.out.println("tome nano = "+(new Date(System.currentTimeMillis() + (180 * 1000))));
			//System.out.println("time namo "+new Date (System.currentTimeMillis()));
		//	tokenInfo.setToken(builder.compact());
			return builder.compact();
			
			} catch (JWTCreationException e) {
	
				e.printStackTrace();
				return null;
			}
			}
	
	
	public static Long decodeToken(String token)
	{
//		  Long userid;
//	      Verification verification=JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
//	      JWTVerifier jwtverifier=verification.build();     
//	      DecodedJWT decodedjwt=jwtverifier.verify(token);
//	      Claim claim=decodedjwt.getClaim("userId");
//	      userid=claim.asLong();  
//	    //  System.out.println(userid);
//	      return userid;
		try {
		Claims claim =  Jwts.parser().setSigningKey(DatatypeConverter.parseString(TOKEN_SECRET)).parseClaimsJws(token).getBody();
		//System.out.println(claim.getId());
		return Long.parseLong(claim.getId());
		
		} 
		catch (Exception e) 
		{
		e.printStackTrace();
		}
		return (long) 0;

	}
}
