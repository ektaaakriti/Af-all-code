package itsm_connection;
import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONObject;
import okhttp3.*;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

public class Cal2Itsm {

			
		static String postitemreq(String url, String json,String apikey) throws IOException {
			OkHttpClient client = new OkHttpClient();
			System.out.println("in post "+url+" and is "+json);
			String respstr = "";
        	final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
	        RequestBody body = RequestBody.create(JSON, json);
	        JsonParser parse = new JsonParser(); 
	        RequestBody formBody = new FormBody.Builder()
	                .add("input_data", json)
	                .build();
	       Request request = new Request.Builder().url(url).post(formBody).addHeader("authtoken", apikey).
	        		build();
	       
	        try (Response response = client.newCall(request).execute()) {
	        	//System.out.println("repsone isn post is "+response.body().string());
	        	respstr = response.body().string();
	        	System.out.println("respstr"+respstr);
	        	
	            
	        } catch(Exception e) {
	        	System.out.println("expcetion is "+e.getMessage());
	        	
	        }
	        return respstr;
		}
		static String Uppostitemreq(String url, String json,String apikey) throws IOException {
			OkHttpClient client = new OkHttpClient();
			System.out.println("in post "+url+" and is "+json);
			String respstr = "";
        	final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
	        RequestBody body = RequestBody.create(JSON, json);
	        JsonParser parse = new JsonParser(); 
	        RequestBody formBody = new FormBody.Builder()
	                .add("input_data", json)
	                .build();
	      
	        Request request = new Request.Builder().url(url).put(formBody).addHeader("authtoken", apikey).
	        		build();
	        try (Response response = client.newCall(request).execute()) {
	        
	        	//System.out.println("repsone isn post is "+response.body().string());
	        	respstr = response.body().string();
	        	System.out.println("respstr"+respstr);
	        	
	            
	        } catch(Exception e) {
	        	System.out.println("expcetion is "+e.getMessage());
	        	
	        }
	        return respstr;
		}

		public static int onResponse(String response) throws IOException {
			int id = 0;
		     try {
		    	 System.out.println("in response is"+response);
		    	 JSONObject jsonObject = new JSONObject(response);
				    
				    JSONObject problem  = jsonObject.getJSONObject("problem");
				      id = Integer.parseInt(problem.getString("id")) ; 
				     //return id;
		     } catch (Exception e) {
		       e.printStackTrace();
		     }
		     return id;
		   }
		 static int onResponse1(String response) throws IOException {
			int id = 0;
		     try {
		    	 System.out.println("in response is"+response);
		    	JSONObject jsonObject = new JSONObject(response);
				  //JSONArray jsonObject=new JSONArray(response) ; 
				   JSONObject request  = jsonObject.getJSONObject("request");
				  //JSONArray request  = jsonObject.JSONArray("request");
				    id = Integer.parseInt(request.optString("id")) ;
				     //return id;
		     } catch (Exception e) {
		       e.printStackTrace();
		     }
		     return id;
		   }
		 static String AssignToreq(String url, String json,String apikey) throws IOException {
				OkHttpClient client = new OkHttpClient();
				System.out.println("in post "+url+" and is "+json);
				String respstr = "";
	        	final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
		        RequestBody body = RequestBody.create(JSON, json);
		        JsonParser parse = new JsonParser(); 
		        RequestBody formBody = new FormBody.Builder()
		                .add("input_data", json)
		                .build();
		       Request request = new Request.Builder().url(url).put(formBody).addHeader("authtoken", apikey).
		        		build();
		        
		        try (Response response = client.newCall(request).execute()) {
		        	//System.out.println("repsone isn post is "+response.body().string());
		        	respstr = response.body().string();
		        	System.out.println("respstr"+respstr);
		        	
		            
		        } catch(Exception e) {
		        	System.out.println("expcetion is "+e.getMessage());
		        	
		        }
		        return respstr;
			}
	public static void main(String[] args) {

	  try {
		Input_data input_data1 = new Input_data();
		problem problem = new problem();
		problem.setTitle("Problem by code");
		input_data1.setProblem(problem);		
		//String jsonstr ="{\"problem\":{\"title\":\"Problem by code\"}}" ;
		String jsonstr =new Gson().toJson(input_data1);		
		String url1 = "http://182.75.176.109:443/api/v3/problems";
        String authValue = "B409855E-B758-4F7D-817B-73BB92A997CD";
        String urlParameters  = "input_date="+jsonstr;
        String response = postitemreq(url1,jsonstr,authValue);
        int problemid = onResponse(response);
        System.out.println("problem id is"+problemid);
	
} catch (MalformedURLException e) {

	e.printStackTrace();

} catch (IOException e) {

	e.printStackTrace();

}


}
}


