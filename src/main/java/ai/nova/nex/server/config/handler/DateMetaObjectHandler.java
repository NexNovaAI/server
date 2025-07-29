package ai.nova.nex.server.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author 小正
 * @date 2024年12月19日 10:57
 * @Description MybatisPlus自动填充
 */
public class DateMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入填充，字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("create_time", metaObject);
        Object updateTime = getFieldValByName("update_time", metaObject);
        if (createTime == null || updateTime == null) {
            Date date = new Date();
            if (createTime == null) {
                setFieldValByName("create_time", date, metaObject);
            }
            if (updateTime == null) {
                setFieldValByName("update_time", date, metaObject);
            }
        }
    }

    /**
     * 更新填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("update_time", new Date(), metaObject);
    }
}
