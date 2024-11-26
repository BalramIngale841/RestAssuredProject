package api.endpoints;

/* 
 Swagger URI --> https://petstore.swagger.io
 
 create user (post) --> https://petstore.swagger.io/v2/user
 Get user(Get) ---> https://petstore.swagger.io/v2/user/{username}
 Update user(put) ---> https://petstore.swagger.io/v2/user/{username}
 Delete user(delete)--> https://petstore.swagger.io/v2/user/{username}
 
  
 */
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//UserModel 
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";;
	public static String delete_url=base_url+"/user/{username}";

	//store module
	  //Here you will create store module URL's
	
	//Pet Module
	    //Here you will create Pet module URL's
	
	
}
