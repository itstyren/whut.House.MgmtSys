package com.computerdesign.whutHouseMgmt.filter;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author wanhaoran
 * @date 2018年3月6日 下午3:09:31
 * 
 */

//
//public class HandleCORSRequest {
//	@OPTIONS
//	@Path("/*")
//	public Response handleCORSRequest(@HeaderParam("Access-Control-Request-Method") final String requestMethods,
//	        @HeaderParam("Access-Control-Request-Headers") final String requestHeaders) throws Exception {
//	    Response.ResponseBuilder builder = Response.ok();
//	    if (requestHeaders != null)
//	        builder.header("Access-Control-Allow-Headers", requestHeaders);
//	    if (requestMethods != null)
//	        builder.header("Access-Control-Allow-Methods", requestMethods);
//	    return builder.build();
//	}
//}
