package com.learn.config.shiro;


import com.learn.shiro.ShiroRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mr.Yangxiufeng on 2017/6/20.
 * Time:15:43
 * ProjectName:Common-admin
 */
@Configuration
public class ShiroConfig {
    protected static final long MILLIS_PER_SECOND = 1000;
    protected static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
    protected static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

    @Bean
    public EhCacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache.xml");
        return cacheManager;
    }
    /**
     * <p>自定义Realm</p>
     * @return
     */
    @Bean
    public ShiroRealm getShiroRealm(){
        return new ShiroRealm();
    }

    /**
     * <p>自定义cookie</p>
     * @return
     */
    @Bean
    public SimpleCookie simpleCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("SHIROSESSIONID");
        return simpleCookie;
    }
    /**
     * <p>session管理器</p>
     * @return
     */
    @Bean(name = "sessionManager")
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(cacheManager());
        sessionManager.setGlobalSessionTimeout(3*MILLIS_PER_HOUR);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookie(simpleCookie());
        return sessionManager;
    }

    /**
     * <p>安全管理器</p>
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(getShiroRealm());
        manager.setCacheManager(cacheManager());
        manager.setSessionManager(defaultWebSessionManager());
        return manager;
    }
    /**
     * Shiro的过滤器链
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
      // shiroFilter.setLoginUrl("/admin/login");
        shiroFilter.setLoginUrl("/learn");
        shiroFilter.setUnauthorizedUrl("/login");
        //shiroFilter.set
        shiroFilter.setSuccessUrl("/");

        Map<String, Filter> filters = new HashMap<String, Filter>();
        filters.put("anon", new AnonymousFilter());
        filters.put("authc", new FormAuthenticationFilter());
        filters.put("logout", new LogoutFilter());
        filters.put("roles", new RolesAuthorizationFilter());
        filters.put("user", new UserFilter());
        shiroFilter.setFilters(filters);

        Map<String, String> chains = new LinkedHashMap<String, String>();
       // chains.put("/*/*", "anon");
      // chains.put("/admin/**", "anon");
        chains.put("/learn/**", "anon");
        chains.put("/admin/toLogin", "anon");
        chains.put("/admin/login", "anon");
//        /**
//         * 静态资源不拦截
//         * */
        chains.put("/front/**", "anon");
        chains.put("/adminlte/**","anon");
        chains.put("/plugins/**", "anon");
        chains.put("/common/**", "anon");
        chains.put("/css/**", "anon");
        chains.put("/img/**", "anon");
        chains.put("/js/**", "anon");
        chains.put("/summernote/**", "anon");
        chains.put("/mergely/**", "anon");
        chains.put("/back/**", "user");
        chains.put("/**","authc");
        shiroFilter.setFilterChainDefinitionMap(chains);
        return shiroFilter;
    }

    /**
     * <p>保证实现了Shiro内部lifecycle函数的bean执行</p>
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
