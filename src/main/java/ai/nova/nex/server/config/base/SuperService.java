package ai.nova.nex.server.config.base;

import ai.nova.nex.server.lock.DistributedLock;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 小正
 * @date 2025年07月29日 15:50
 * @Description service接口父类
 */
public interface SuperService<T> extends IService<T> {
    /**
     * 幂等性新增记录
     * 例子如下：
     * String username = sysUser.getUsername();
     * boolean result = super.saveIdempotency(sysUser, lock
     *                 , LOCK_KEY_USERNAME+username
     *                 , new QueryWrapper<SysUser>().eq("username", username));
     *
     * @param entity       实体对象
     * @param locker       锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    boolean saveIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper, String msg) throws Exception;

    boolean saveIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper) throws Exception;

    /**
     * 幂等性新增或更新记录
     * 例子如下：
     * String username = sysUser.getUsername();
     * boolean result = super.saveOrUpdateIdempotency(sysUser, lock
     *                 , LOCK_KEY_USERNAME+username
     *                 , new QueryWrapper<SysUser>().eq("username", username));
     *
     * @param entity       实体对象
     * @param locker       锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    boolean saveOrUpdateIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper, String msg) throws Exception;

    boolean saveOrUpdateIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper) throws Exception;
}
