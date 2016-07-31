package crud;
import entity.Policy;

public interface CrudPolicyInterface {
	
		public void createPolicy();
		public void insertPolicy(Policy policy);
		public void updatePolicy(Policy policy);
		public void deletePolicy(Policy policy);
		
}
