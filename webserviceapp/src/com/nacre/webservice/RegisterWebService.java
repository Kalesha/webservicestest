package com.nacre.webservice;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.server.internal.JsonWithPaddingInterceptor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/ws")
public class RegisterWebService {

	@Path("/register_user_post")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	//@QueryParam("callback")
	//@JSONP
	public Response registerUserPost(String user) {
		System.out.println(user);
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(user);// parsing received string
														// to JSON object
		JsonObject jsonObject = element.getAsJsonObject();  
		System.out.println("User Name: " + jsonObject.get("userName"));
		System.out.println("Password:" + jsonObject.get("userPassword"));
		ArrayList<String> list = new ArrayList<String>();// ArrayList which
															// returnsdata
		list.add("Hi");
		list.add("Hi Welcome");
		list.add("Hi Welcome to JQUERY");
		list.add("Hi Welcome to mobile");
		list.add("Hi Welcome to mobile JQUERY");
		list.add("Hi Welcome to mobile JQUERY Element one");
		list.add("Hi Welcome to mobile JQUERY Element two");
		list.add("Hi Welcome to mobile JQUERY Element three");
		list.add("Hi Welcome to mobile JQUERY Test one");
		list.add("Hi Welcome to mobile JQUERY Test test two");
		// return response
		ResponseBuilder responseBuilder = Response.status(200).entity(
				new Gson().toJson(list.subList(0, (int) (Math.random() * 10))));
		responseBuilder.header("Access-Control-Allow-Origin", "*");
		// response.addHeader();
		return responseBuilder.build();// converting
		// random
		// sublist to
		// JSON
	}

	@Path("json_test")
	public JsonWithPaddingInterceptor testJsonP() {
		ArrayList<String> list = new ArrayList<String>();// ArrayList which
		/*
		 * // returnsdata list.add("Hi"); list.add("Hi Welcome");
		 * list.add("Hi Welcome to JQUERY"); list.add("Hi Welcome to mobile");
		 * list.add("Hi Welcome to mobile JQUERY");
		 * list.add("Hi Welcome to mobile JQUERY Element one");
		 * list.add("Hi Welcome to mobile JQUERY Element two");
		 * list.add("Hi Welcome to mobile JQUERY Element three");
		 * list.add("Hi Welcome to mobile JQUERY Test one");
		 * list.add("Hi Welcome to mobile JQUERY Test test two");
		 * 
		 * return new JsonWithPaddingInterceptor(new
		 * GenericEntity<List<String>>(list){}, ""));
		 */
		return null;
	}

	@GET
	@Path("/get")
//	@JSONP(queryParam = "callback")
	@Produces({ "application/x-javascript" })
	public Response getAllTestData(@QueryParam("callback") String callback) {
		System.out.println(callback);
		ArrayList<String> list = new ArrayList<String>();// ArrayList which
		list.add("Hi");
		list.add("Hi Welcome");
		list.add("Hi Welcome to JQUERY");
		list.add("Hi Welcome to mobile");
		list.add("Hi Welcome to mobile JQUERY");
		list.add("Hi Welcome to mobile JQUERY Element one");
		list.add("Hi Welcome to mobile JQUERY Element two");
		// do many things here
		ResponseBuilder responseBuilder = Response.status(200).entity(
				new Gson().toJson(list.subList(0, (int) (Math.random() * 10))));
		// response.addHeader();
		return responseBuilder.build();

	}

}
