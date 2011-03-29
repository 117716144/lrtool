package com.base.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import com.base.core.BaseAction;
import com.base.core.action.tool.IPSeeker;
import com.base.core.util.StringUtil;
import com.base.core.util.UserAgent;

@SuppressWarnings("deprecation")
public class DisableUrlSessionFilter implements Filter {

	private static String encoding = "UTF-8"; 
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // skip non-http requests
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(!StringUtil.isEmpty(new UserAgent().checkSpider(httpRequest))){
        if (httpRequest.isRequestedSessionIdFromURL()) {
            HttpSession session = httpRequest.getSession();
            if (session != null) session.invalidate();
        }

        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
            @Override
            public String encodeRedirectUrl(String url) {
                return url;
            }

            @Override
            public String encodeRedirectURL(String url) {
                return url;
            }

            @Override
            public String encodeUrl(String url) {
                return url;
            }

            @Override
            public String encodeURL(String url) {
                return url;
            }
        };

        chain.doFilter(request, wrappedResponse);
    	}else{
    		HttpSession session = httpRequest.getSession();
    		String ipAddr = new BaseAction().getIpAddr(httpRequest);
    	    String ipLocation =IPSeeker.getInstance().getAddress(ipAddr);
    		session.setAttribute("ipAddr", ipAddr);
    		session.setAttribute("ipLocation", ipLocation);
    	}
    	chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}