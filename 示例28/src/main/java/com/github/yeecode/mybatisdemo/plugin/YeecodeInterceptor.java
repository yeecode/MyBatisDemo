package com.github.yeecode.mybatisdemo.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.List;
import java.util.Properties;


@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class YeecodeInterceptor implements Interceptor {
    private String info;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行原有方法
        Object result = invocation.proceed();
        // 打印原方法输出结果的数目
        System.out.println(info + ":" + ((List) result).size());
        // 返回原有结果
        return result;
    }

    @Override
    public void setProperties(Properties properties) {
        // 为拦截器设置属性
        info = properties.get("preInfo").toString();
    }
}
