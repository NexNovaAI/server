package ai.nova.nex.server.config.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author 小正
 * @date 2025年07月29日 15:51
 * @Description service实现父类
 */
public class ISuperService <M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T>{
}
