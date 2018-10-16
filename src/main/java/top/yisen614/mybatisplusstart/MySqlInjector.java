package top.yisen614.mybatisplusstart;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.springframework.stereotype.Component;
import top.yisen614.mybatisplusstart.methods.DeleteAll;

import java.util.List;

@Component
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();
        //增加自定义方法
        methodList.add(new DeleteAll());
        return methodList;
    }
}