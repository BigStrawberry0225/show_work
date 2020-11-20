//package com.codercm.bk.interceptor;
//
//import com.codercm.bk.pojo.User;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//

//Interceptor 即拦截器，在 Springboot 我们可以直接继承拦截器的接口，
// 然后实现 preHandle 方法。preHandle 方法里的代码会在访问需要拦截的页面时执行
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        String contextPath = session.getServletContext().getContextPath();
//        String[] requireAuthPages = new String[]{
//                "index",
//        };
//
//        String uri = request.getRequestURI();
//
//        uri = StringUtils.remove(uri, contextPath+"/");
//        String page = uri;
//
//        if(begingWith(page, requireAuthPages)){
//            User user = (User) session.getAttribute("user");
//            if(user==null) {
//                response.sendRedirect("login");
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean begingWith(String page, String[] requiredAuthPages) {
//        boolean result = false;
//        for (String requiredAuthPage : requiredAuthPages) {
//            if(StringUtils.startsWith(page, requiredAuthPage)) {
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }
//}
