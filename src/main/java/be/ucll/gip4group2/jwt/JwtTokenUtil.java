package be.ucll.gip4group2.Player;

import java.io.Serializable;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY=5*60*60;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token , Claims :: getSubject);
	}
	 public Date getExpirationDateFromToken(String token) {
		  return getClaimFromToken(token, Claims :: getExpiration);
	 }
	 
	 public <T> T getClaimFromToken (String token , Function<Claims,T>claimsResolver) {
		 final Claims claims=getAllClaimsFromToken(token);
		 return claimResolver.apply(claim);
		// 
	 }
	 private Claims getAllClaimsFromToken(String token) {
		 return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	 }
	 private Boolean isTokenExpired(String token) {
		 final Date expiration=getExpirationDateFromToken(token);
		 return expiration.before(new Date());
		 
	 }
	 
	 public String generateToken(UserDetails userDetails) {
			Map<String, Object> claims = new HashMap<>();
			return doGenerateToken(claims, userDetails.getUsername());
		}
	 
	 private String doGenerateToken(Map<String, Object> claims, String subject) {

			return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
					.signWith(SignatureAlgorithm.HS512, secret).compact();
		}

		//validate token
		public Boolean validateToken(String token, UserDetails userDetails) {
			final String username = getUsernameFromToken(token);
			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
		}
   
}
