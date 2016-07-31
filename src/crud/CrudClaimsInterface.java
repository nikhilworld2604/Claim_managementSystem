package crud;

import entity.Claims;

public interface CrudClaimsInterface {
	
	public void createClaims();
	public void insertClaims(Claims claims);
	public void updateClaims(Claims claims);
	public void deleteClaims(Claims claims);
	public void fetchClaims();
	public Claims fetchclaimId(int claim_id);

}
